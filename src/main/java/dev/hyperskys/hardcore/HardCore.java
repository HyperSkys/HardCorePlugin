package dev.hyperskys.hardcore;

import dev.hyperskys.hardcore.commands.AliveCMD;
import dev.hyperskys.hardcore.commands.Info;
import dev.hyperskys.hardcore.commands.ReviveCommand;
import dev.hyperskys.hardcore.commands.StartCMD;
import dev.hyperskys.hardcore.events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class HardCore extends JavaPlugin {

    public ArrayList<Player> dead_players = new ArrayList<>();
    public ArrayList<Player> alive_players = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);
        Bukkit.getWorld("world_nether").setDifficulty(Difficulty.HARD);
        Bukkit.getWorld("world_the_end").setDifficulty(Difficulty.HARD);
        Bukkit.setDefaultGameMode(GameMode.SURVIVAL);


        // Commands
        getServer().getPluginCommand("info").setExecutor(new Info(this));
        getServer().getPluginCommand("revive").setExecutor(new ReviveCommand(this));
        getServer().getPluginCommand("hcstart").setExecutor(new StartCMD(this));
        getServer().getPluginCommand("alive").setExecutor(new AliveCMD(this));
        // Events
        getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerChatEvent(this), this);
        getServer().getPluginManager().registerEvents(new JoinMessage(this), this);
        getServer().getPluginManager().registerEvents(new LeaveMessage(this), this);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
