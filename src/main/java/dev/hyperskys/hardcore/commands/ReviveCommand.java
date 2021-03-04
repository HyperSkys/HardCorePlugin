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
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lHARDCORE &7| &fYou have just revived &e"+t.getDisplayName()));
                        t.teleport(Bukkit.getWorld("world").getSpawnLocation());
                        t.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.get().getString("prefix") + t.getDisplayName()+" &fwas just revived by &e"+p.getDisplayName()));
                        plugin.dead_players.remove(t);
                        plugin.alive_players.add(t);
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
