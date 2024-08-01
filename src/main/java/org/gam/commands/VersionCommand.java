package org.gam.commands;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class VersionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("Version " + ChatColor.GOLD + "1.0.0" + ChatColor.YELLOW + "ERSTER FULL RELEASE");
            return true;
        }
        return false;
    }

}
