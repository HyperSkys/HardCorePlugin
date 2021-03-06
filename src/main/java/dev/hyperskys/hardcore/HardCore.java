package dev.hyperskys.hardcore;

import dev.hyperskys.hardcore.commands.*;
import dev.hyperskys.hardcore.events.*;
import dev.hyperskys.hardcore.files.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.command.defaults.ReloadCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class HardCore extends JavaPlugin {

    // Boolean for starting hardcore
    public boolean start; // TODO Finished this but found issues so had to revert coming is Hotfix 2.3 :(

    // Arraylist
    public ArrayList<Player> dead_players = new ArrayList<>();
    public ArrayList<Player> alive_players = new ArrayList<>();

    @Override
    public void onEnable() {

        //Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Config.setup();
        Config.save();

        // Setting difficulty and setting default gamemode
        Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);
        Bukkit.getWorld("world_nether").setDifficulty(Difficulty.HARD);
        Bukkit.getWorld("world_the_end").setDifficulty(Difficulty.HARD);
        Bukkit.setDefaultGameMode(GameMode.SURVIVAL);

        // Cannot have hardcore enabled
        if(Bukkit.isHardcore()) {
            System.out.println(ChatColor.RED + "ERROR! You cannot have hardcore enabled!");
            Bukkit.getServer().shutdown();
        }

        // Checks render distance
        if ((Bukkit.getViewDistance() >= 10)) {
            System.out.println(ChatColor.RED + "WARNING! It is suggested to use 10 render distance or below to not cause server lag!");
            System.out.println(ChatColor.RED + "This is only a warning do not be afraid.");
        }


        // Commands
            getServer().getPluginCommand("info").setExecutor(new Info(this));
        getServer().getPluginCommand("revive").setExecutor(new ReviveCommand(this));
        getServer().getPluginCommand("hcstart").setExecutor(new StartCMD(this));
        getServer().getPluginCommand("alive").setExecutor(new AliveCMD(this));
        getServer().getPluginCommand("hcstop").setExecutor(new EndCommand(this));
        getCommand("hcreload").setExecutor(new HcReload(this));

        // Events
        getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerChatEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveEvent(this), this);
        getServer().getPluginManager().registerEvents(new DeathEvent$(this), this);
    }
}
