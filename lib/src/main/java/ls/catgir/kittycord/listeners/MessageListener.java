package ls.catgir.kittycord.listeners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ls.catgir.kittycord.utils.WebhookManager;


public class MessageListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        if (event.isCancelled())
			return;

        WebhookManager.sendChatMessage(event.getPlayer(), event.getMessage());
    }
}