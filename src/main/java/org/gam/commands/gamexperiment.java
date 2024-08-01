package org.gam.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamexperiment implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("Es hat spaß gemacht, ein sinnvoller" + ChatColor.GOLD + " Command" + ChatColor.WHITE + " zu sein." + " \n"  + "Ich werde in der nächsten version nähmlich entfernt");
            return true;
        }
        return false;
    }
}
