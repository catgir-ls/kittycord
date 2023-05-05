package ls.catgir.kittycord;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.configuration.file.FileConfiguration;

import ls.catgir.kittycord.utils.WebhookManager;
import ls.catgir.kittycord.listeners.*;

public class KittyCord extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();    
        
        PluginManager pluginManager = Bukkit.getPluginManager();
        
        pluginManager.registerEvents(new MessageListener(), this);
        pluginManager.registerEvents(new DeathListener(), this);
        pluginManager.registerEvents(new ConnectionListener(), this);

        WebhookManager.init(
            config.getLong("webhook.id"),
            config.getString("webhook.token")
        );
    }
}