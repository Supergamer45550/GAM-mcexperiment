package org.gam.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class HealCommand implements CommandExecutor {
    private final Plugin plugin;

    public HealCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!plugin.getConfig().getBoolean("heal-command-enabled")) {
            sender.sendMessage("Der Heal-Command ist zurzeit deaktiviert");
            return false;
        }

        if (args.length == 1) {
            Player target = sender.getServer().getPlayer(args[0]);
            if (target != null) {
                target.setHealth(target.getMaxHealth());
                target.setFoodLevel(20);
                sender.sendMessage(target.getName() + " wurde geheilt!");
                return true;
            } else {
                sender.sendMessage("Player not found!");
                return false;
            }
        } else {
            sender.sendMessage("Usage: /heal <player>");
            return false;
        }
    }
}
