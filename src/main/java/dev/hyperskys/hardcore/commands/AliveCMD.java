package dev.hyperskys.hardcore.commands;

import dev.hyperskys.hardcore.HardCore;
import dev.hyperskys.hardcore.files.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AliveCMD implements CommandExecutor {

    HardCore plugin;
    public AliveCMD(HardCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (p.isOp()) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Usage: /alive {player}");
            } else {
                Player t = Bukkit.getPlayerExact(args[0]);
                if (t instanceof Player) {
                    if (plugin.dead_players.contains(p)) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.get().getString("prefix") + Config.get().getString("player-dead").replace("$player", p.getName())));
                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.get().getString("prefix") + Config.get().getString("player-alive").replace("$player", p.getName())));
                    }
                }
            }
        } else {
            p.sendMessage(ChatColor.RED + "No permission.");
        }


        return true;
    }
}
