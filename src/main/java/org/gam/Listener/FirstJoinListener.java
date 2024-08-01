package org.gam.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstJoinListener implements Listener {

    private final JavaPlugin plugin;

    public FirstJoinListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().hasPlayedBefore()) {
            String message = plugin.getConfig().getString("first-join-message", "&aWelcome &b%player% &ato the server for the first time!");
            message = message.replace("%player%", event.getPlayer().getName());
            event.getPlayer().sendMessage(message);
        }
    }
}
