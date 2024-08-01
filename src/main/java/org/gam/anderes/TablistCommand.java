package org.gam.anderes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TablistCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public TablistCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        String header = plugin.getConfig().getString("tablist-header", "Welcome to the Server!");
        String footer = plugin.getConfig().getString("tablist-footer", "Enjoy your stay!");

        player.setPlayerListHeaderFooter(header, footer);
        return true;
    }
}
