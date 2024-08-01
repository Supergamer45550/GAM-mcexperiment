package org.gam.experiment;

import org.gam.Listener.DamageListener;
import org.gam.Listener.JoinListener;
import org.gam.Listener.BlockListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.gam.commands.ping;
import org.gam.commands.testcommand;
import org.bukkit.ChatColor;


public final class Experiment extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Load the config value
        boolean isDamageListenerEnabled = getConfig().getBoolean("damage-listener-enabled");

        // Register the damage listener if enabled
        if (isDamageListenerEnabled) {
            getServer().getPluginManager().registerEvents(new DamageListener(), this);
        }

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents((Listener)new JoinListener(), (Plugin)this);
        pluginManager.registerEvents((Listener)new BlockListener(), (Plugin)this);
        this.getCommand("testcommand").setExecutor(new testcommand());
        this.getCommand("ping").setExecutor(new ping());
        getLogger().info(ChatColor.RED  + "GAM-TEST" + ChatColor.GRAY + " wurde aktiviert!");

    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED  + "GAM-TEST" + ChatColor.GRAY + " wurde deaktiviert!");
    }
}
