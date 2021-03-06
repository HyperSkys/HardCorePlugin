package dev.hyperskys.hardcore.events;

import dev.hyperskys.hardcore.HardCore;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerChatEvent implements Listener {

    HardCore plugin;
    public PlayerChatEvent(HardCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerChat(org.bukkit.event.player.AsyncPlayerChatEvent e){

        // Player variable
        Player player = e.getPlayer();

        // Checks if the player is in the dead player arraylist and if they are it won't allow them to chat
        if(plugin.dead_players.contains(player)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can't send chat messages while being dead!");
        }

    }


}
