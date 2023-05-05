package ls.catgir.kittycord.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;

import ls.catgir.kittycord.utils.WebhookManager;

public class DeathListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerDeath(PlayerDeathEvent event) {
        WebhookManager.sendDeathMessage(event.getDeathMessage());
    }
}