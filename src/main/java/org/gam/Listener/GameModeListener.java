package org.gam.Listener;

import io.papermc.paper.event.player.AsyncChatCommandDecorateEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class GameModeListener implements Listener {

    @EventHandler
    public void onGameModeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        String newGameMode = event.getNewGameMode().toString();
        String message = "[" + ChatColor.YELLOW + "Gamemode" + ChatColor.WHITE + "] " + ChatColor.GOLD + player.getName() + ChatColor.WHITE + " has changed their game mode to " + ChatColor.GREEN + newGameMode;

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.hasPermission("myplugin.moderator")) {
                onlinePlayer.sendMessage(message);
            }
        }
    }
}

