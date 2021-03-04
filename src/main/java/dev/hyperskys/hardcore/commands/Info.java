package dev.hyperskys.hardcore.commands;

import dev.hyperskys.hardcore.HardCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Info implements CommandExecutor {

    HardCore plugin;
    public Info(HardCore plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&ePlugin developed by &fHyperSkys"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eFor any issues please add me on discord &fMcDonald's#0001"));
        p.sendMessage("");
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eThanks for download this on &7&lGitHub"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eTo support this plugin donate on the donation link"));
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"));

        return false;
    }
}
