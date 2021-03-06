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

public class EndCommand implements CommandExecutor {

    HardCore plugin;
    public EndCommand(HardCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

            for (Player a : Bukkit.getOnlinePlayers()) {
                if (p.isOp()) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Config.get().getString("prefix") + Config.get().getString("hardcore-end").replace("$player", p.getName())));
                    plugin.alive_players.remove(a);
                    plugin.dead_players.remove(a);
                    a.teleport(Bukkit.getWorld("world").getSpawnLocation());
                    a.setGameMode(GameMode.SPECTATOR);
                    Inventory inv = a.getInventory();
                    inv.clear();
                    a.setHealth(20);
                } else {
                    p.sendMessage(ChatColor.RED + "No permission.");
                }
            }
        return true;
    }

    }
