package it.n1ckcode.insanelisteners;

import it.n1ckcode.insanelisteners.commands.MainCommand;
import it.n1ckcode.insanelisteners.listeners.PlayerListener;
import it.n1ckcode.insanelisteners.managers.FileManager;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class InsaneListeners extends JavaPlugin {

    @Getter
    private static InsaneListeners instance;

    @Getter
    private static FileManager fileManager;

    @Override
    public void onEnable() {
       instance = this;
       getLogger().info("*****************************");
       getLogger().info("InsaneListeners v1.0 | @onEnable");
       getLogger().info("*****************************");
       InsaneListeners.fileManager = new FileManager(InsaneListeners.instance);
       loadCommands();
       loadListeners();
    }

    private void loadCommands() {
        getCommand("insanelisteners").setExecutor(new MainCommand());
    }
    private void loadListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
