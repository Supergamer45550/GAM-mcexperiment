package org.gam.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class SetHomeCommand implements CommandExecutor {
    private final Map<String, Location> homes = new HashMap<>();
    private final Plugin plugin;

    public SetHomeCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!plugin.getConfig().getBoolean("sethome-command-enabled")) {
            sender.sendMessage("The sethome command is currently disabled.");
            return false;
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;
            homes.put(player.getName(), player.getLocation());
            player.sendMessage("Home set!");
            return true;
        } else {
            sender.sendMessage("This command can only be used by players.");
            return false;
        }
    }

    public Location getHome(String playerName) {
        return homes.get(playerName);
    }
}
