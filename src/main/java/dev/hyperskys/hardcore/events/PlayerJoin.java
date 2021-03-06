package dev.hyperskys.hardcore.events;

import dev.hyperskys.hardcore.HardCore;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    HardCore plugin;
    public PlayerJoin(HardCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e) {

        // Player variable
        Player player = e.getPlayer();

        // Checking if the Hardcore has started

            // If the player is in survival it'll check if there in any arraylist
            if (player.getGameMode() == GameMode.SURVIVAL) {
                if (!plugin.dead_players.contains(player)) {
                    if (!plugin.dead_players.contains(player)) {
                        plugin.alive_players.add(player);
                    }
                }
            }
            // If the player is in spectator it'll check if there in any arraylist
            if (player.getGameMode() == GameMode.SPECTATOR) {
                if (!plugin.alive_players.contains(player)) {
                    if (!plugin.dead_players.contains(player)) {
                        plugin.dead_players.add(player);
                    }
                }
            }
            // If the player is in adventure it'll check if there in any arraylist
            if (player.getGameMode() == GameMode.ADVENTURE) {
                if (!plugin.dead_players.contains(player)) {
                    if (!plugin.alive_players.contains(player)) {
                        plugin.alive_players.add(player);
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou logged in while in &eadventure &amode your gamemode has been updated to &esurvival!"));
                    }
                }
            }
            // If the player is in creative it'll check if there in any arraylist
            if (player.getGameMode() == GameMode.CREATIVE) {
                if (!plugin.dead_players.contains(player)) {
                    if (!plugin.alive_players.contains(player)) {
                        plugin.alive_players.add(player);
                    }
                }
            }

        }
    }
