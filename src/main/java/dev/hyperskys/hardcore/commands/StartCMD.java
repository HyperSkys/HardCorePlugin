package dev.hyperskys.hardcore.commands;

import dev.hyperskys.hardcore.HardCore;
import dev.hyperskys.hardcore.files.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class StartCMD implements CommandExecutor {

    HardCore plugin;

    public StartCMD(HardCore plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Player variable
        Player p = (Player) sender;

        // Gets all online players and checks if there OP
            for (Player a : Bukkit.getOnlinePlayers()) {
                if (p.isOp()) {
                    // Sends a message that the hardcore started and adds players the arraylist ALIVE and removes players for arraylist DEAD
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Config.get().getString("prefix") + "&fHardcore has started make sure not to die!"));
                    plugin.alive_players.add(a);
                    plugin.dead_players.remove(a);
                    a.teleport(Bukkit.getWorld("world").getSpawnLocation());
                    a.setGameMode(GameMode.SURVIVAL);
                    Inventory inv = a.getInventory();
                    inv.clear();
                    a.setHealth(20);
                    plugin.start = true;
                } else {
                    p.sendMessage(ChatColor.RED + "No permission.");
                }

                return true;
            }
            return true;
        }

}