package org.gam.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class DamageListener implements Listener {
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            double damage = event.getDamage();
            double heartsLost = damage / 2;
            String message = "[" + ChatColor.YELLOW + "Damage" + ChatColor.WHITE + "] " + ChatColor.GOLD + player.getName() + ChatColor.WHITE + " hat " + ChatColor.DARK_RED + heartsLost + ChatColor.WHITE + " herzen verloren";
            Bukkit.broadcastMessage(message);
        }
    }
}
