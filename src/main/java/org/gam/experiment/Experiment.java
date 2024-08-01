package org.gam.experiment;

import org.gam.Listener.DamageListener;
import org.gam.Listener.JoinListener;
import org.gam.Listener.BlockListener;
import org.gam.Listener.GameModeListener;
import org.gam.commands.EnderChestCommand;
import org.gam.anderes.TablistCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.gam.commands.*;
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

        // Register GameModeListener with config toggle
        if (getConfig().getBoolean("send-gamemode-change-message")) {
            pluginManager.registerEvents(new GameModeListener(), this);
        }

        // Register EnderChestCommand with config toggle
        if (getConfig().getBoolean("enable-enderchest-command")) {
            this.getCommand("ec").setExecutor(new EnderChestCommand());
        }


        // Register TablistCommand with config toggle
        if (getConfig().getBoolean("enable-tablist-header-footer")) {
            this.getCommand("tablist").setExecutor(new TablistCommand(this));
        }

        this.getCommand("ping").setExecutor(new ping());
        this.getCommand("gamexperiment").setExecutor(new gamexperiment());

        if (getConfig().getBoolean("heal-command-enabled")) {
            this.getCommand("heal").setExecutor(new HealCommand(this));
        }

        if (getConfig().getBoolean("sethome-command-enabled")) {
            SetHomeCommand setHomeCommand = new SetHomeCommand(this);
            this.getCommand("sethome").setExecutor(setHomeCommand);
            if (getConfig().getBoolean("home-command-enabled")) {
                this.getCommand("home").setExecutor(new HomeCommand(setHomeCommand, this));
            }
        }

        getLogger().info(ChatColor.RED + "GAM-TEST" + ChatColor.GRAY + " wurde aktiviert!");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "GAM-TEST" + ChatColor.GRAY + " wurde deaktiviert!");
    }
}


