package dev.hyperskys.hardcore.events;

import dev.hyperskys.hardcore.HardCore;
import dev.hyperskys.hardcore.files.Config;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent$ implements Listener {

    HardCore plugin;
    public DeathEvent$(HardCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Config.get().getString("death-message").replace("$player", p.getDisplayName())));
    }

}
