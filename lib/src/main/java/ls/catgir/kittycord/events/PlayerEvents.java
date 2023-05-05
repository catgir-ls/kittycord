package ls.catgir.kittycord.events;

import org.bukkit.event.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEvents implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
    }
}