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
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lINFO &8&l➼ &fPlugin developed by &bHyperSkys"));


        return false;
    }
}
