package dev.hyperskys.hardcore.commands;

import dev.hyperskys.hardcore.HardCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReviveCommand implements CommandExecutor {
    HardCore plugin;
    public ReviveCommand(HardCore plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (plugin.dead_players.contains(p)) {
            if (p.isOp()) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Usage: /revive [PLAYER]");
                } else {
                    Player t = Bukkit.getPlayerExact(args[0]);
                    if (t instanceof Player) {
                        p.sendMessage(ChatColor.AQUA + "You have just revived " + ChatColor.DARK_AQUA + t.getDisplayName());
                        t.teleport(Bukkit.getWorld("World").getSpawnLocation());
                        t.setGameMode(GameMode.SURVIVAL);
                        Bukkit.broadcastMessage(ChatColor.DARK_AQUA + t.getDisplayName() + ChatColor.AQUA + " has just been revived by " + ChatColor.DARK_AQUA + p.getDisplayName());
                        plugin.dead_players.remove(t);
                    } else {
                        p.sendMessage(ChatColor.RED + "That player does not exist!");
                    }
                }

                return true;

            } else {
                p.sendMessage(ChatColor.RED + "No permission.");
            }

            return true;
        } else {
            p.sendMessage(ChatColor.RED + "That player is not dead.");
        }
        return false;
    }}
