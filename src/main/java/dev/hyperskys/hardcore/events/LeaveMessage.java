package dev.hyperskys.hardcore.events;

import dev.hyperskys.hardcore.HardCore;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveMessage implements Listener {
    HardCore plugin;
    public LeaveMessage(HardCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', ""));
    }
}
