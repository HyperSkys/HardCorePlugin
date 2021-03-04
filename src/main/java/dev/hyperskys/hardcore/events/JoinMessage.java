package dev.hyperskys.hardcore.events;

import dev.hyperskys.hardcore.HardCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {

    HardCore plugin;
    public JoinMessage(HardCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', ""));
    }





}
