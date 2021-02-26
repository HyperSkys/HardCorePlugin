package dev.hyperskys.hardcore.events;

import dev.hyperskys.hardcore.HardCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
    HardCore plugin;
    public DeathEvent(HardCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        player.setGameMode(GameMode.SPECTATOR);
        player.setPlayerWeather(WeatherType.CLEAR);
        player.hidePlayer(plugin, player);
        plugin.dead_players.add(player);


        Bukkit.broadcastMessage(ChatColor.RED + player.getDisplayName() + ChatColor.RED + " has died and can no longer play!");
        e.setDeathMessage("");
    }


}
