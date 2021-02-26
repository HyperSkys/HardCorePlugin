package dev.hyperskys.hardcore;

import dev.hyperskys.hardcore.commands.Info;
import dev.hyperskys.hardcore.commands.ReviveCommand;
import dev.hyperskys.hardcore.events.DeathEvent;
import dev.hyperskys.hardcore.events.PlayerChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class HardCore extends JavaPlugin {

    public ArrayList<Player> dead_players = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);
        Bukkit.getWorld("world_nether").setDifficulty(Difficulty.HARD);
        Bukkit.getWorld("world_the_end").setDifficulty(Difficulty.HARD);

        // Commands
        getServer().getPluginCommand("info").setExecutor(new Info(this));
        getServer().getPluginCommand("revive").setExecutor(new ReviveCommand(this));
        // Events
        getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerChatEvent(this), this);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
