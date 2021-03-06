package dev.hyperskys.hardcore.commands;

import dev.hyperskys.hardcore.HardCore;
import dev.hyperskys.hardcore.files.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HcReload implements CommandExecutor {

    HardCore plugin;
    public HcReload(HardCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.isOp()) {
            Config.reload();
            sender.sendMessage(ChatColor.GREEN + "Config was reloaded successfully!");
        } else {
            sender.sendMessage(ChatColor.RED + "No permission.");
        }

        return true;
    }
}
