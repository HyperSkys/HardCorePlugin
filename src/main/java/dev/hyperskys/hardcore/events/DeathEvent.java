package dev.hyperskys.hardcore.events;

import dev.hyperskys.hardcore.HardCore;
import dev.hyperskys.hardcore.files.Config;
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

        // Player variable
        Player player = e.getEntity();

        // Stuff that it does after you die
        player.setGameMode(GameMode.SPECTATOR);
        player.setPlayerWeather(WeatherType.CLEAR);
        player.hidePlayer(plugin, player);
        player.setPlayerListName("");
        plugin.dead_players.add(player);
        plugin.alive_players.remove(player);

        // Basic broadcast after someone dies
        Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&', Config.get().getString("prefix") + "&e"+player.getDisplayName()+" &fhas just died and can no longer play!")));
    }


}
