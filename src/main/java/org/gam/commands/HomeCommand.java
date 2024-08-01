package org.gam.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HomeCommand implements CommandExecutor {
    private final SetHomeCommand setHomeCommand;
    private final Plugin plugin;
    private final Map<UUID, Long> cooldowns = new HashMap<>();

    public HomeCommand(SetHomeCommand setHomeCommand, Plugin plugin) {
        this.setHomeCommand = setHomeCommand;
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!plugin.getConfig().getBoolean("home-command-enabled")) {
            sender.sendMessage("The home command is currently disabled.");
            return false;
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;
            UUID playerId = player.getUniqueId();
            long currentTime = System.currentTimeMillis();

            if (cooldowns.containsKey(playerId) && (currentTime - cooldowns.get(playerId)) < 5000) {
                player.sendMessage("You must wait before using this command again.");
                return false;
            }

            Location home = setHomeCommand.getHome(player.getName());
            if (home != null) {
                player.sendMessage("Du wirst in 5 Sekunden teleportiert");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.teleport(home);
                        player.sendMessage("Teleported to home!");
                    }
                }.runTaskLater(plugin, 100);

                cooldowns.put(playerId, currentTime);
                return true;
            } else {
                player.sendMessage("Du hast dein home noch nicht gesetzt");
                return false;
            }
        } else {
            sender.sendMessage("This command can only be used by players.");
            return false;
        }
    }
}
