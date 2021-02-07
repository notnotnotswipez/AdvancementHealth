package me.swipez.advancementhealth;

import org.bukkit.plugin.java.JavaPlugin;

public final class Advancementhealth extends JavaPlugin {
    public boolean gamestarted = false;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AdvancementTrigger(this), this);
        getCommand("advchallenge").setExecutor(new StartGame(this));
        getCommand("advchallenge").setTabCompleter(new TabCompleter());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
