package org.gam.experiment;

import org.gam.Listener.DamageListener;
import org.gam.Listener.JoinListener;
import org.gam.Listener.BlockListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.gam.commands.HealCommand;
import org.gam.commands.ping;
import org.gam.commands.testcommand;
import org.bukkit.ChatColor;

public final class Experiment extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();


        boolean isDamageListenerEnabled = getConfig().getBoolean("damage-listener-enabled");


        if (isDamageListenerEnabled) {
            getServer().getPluginManager().registerEvents(new DamageListener(), this);
        }


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new BlockListener(), this);


        this.getCommand("testcommand").setExecutor(new testcommand());
        this.getCommand("ping").setExecutor(new ping());


        if (getConfig().getBoolean("heal-command-enabled")) {
            this.getCommand("heal").setExecutor(new HealCommand(this));
        }

        getLogger().info(ChatColor.RED + "GAM-TEST" + ChatColor.GRAY + " wurde aktiviert!");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "GAM-TEST" + ChatColor.GRAY + " wurde deaktiviert!");
    }
}

