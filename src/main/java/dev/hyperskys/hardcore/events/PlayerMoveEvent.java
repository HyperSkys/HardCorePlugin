package dev.hyperskys.hardcore.events;


import dev.hyperskys.hardcore.HardCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class PlayerMoveEvent implements Listener {

    HardCore plugin;
    public PlayerMoveEvent(HardCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerMove(org.bukkit.event.player.PlayerMoveEvent e) {
        Player player = e.getPlayer();
            if (plugin.dead_players.contains(player)) {
                e.setCancelled(true);
                player.teleport(player);
            }
        }
    }