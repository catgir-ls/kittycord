
package ls.catgir.kittycord.utils;

import org.bukkit.entity.Player;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.send.AllowedMentions;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;

public class WebhookManager {
    private static WebhookClient client = null;
    private static AllowedMentions allowedMentions = null;

    public static void init(long id, String token) {
        WebhookManager.client = WebhookClient.withId(id, token);
        WebhookManager.allowedMentions = new AllowedMentions()
            .withParseEveryone(false)
            .withParseRoles(false);
    }

    public static void sendChatMessage(Player player, String content) {
        WebhookManager.client.send(
            new WebhookMessageBuilder()
                .setAllowedMentions(WebhookManager.allowedMentions)
                .setContent(content)
                .setUsername(player.getName())
                .setAvatarUrl(String.format(
                    "https://api.mineatar.io/face/%s",
                    player.getUniqueId()
                ))
                .build()
        );
    }

    public static void sendConnectionMessage(Player player, boolean isLeave) {
        WebhookManager.client.send(
            String.format("%s has %s the game",
                player.getName(),
                isLeave ? "left" : "joined"
            )
        );
    } 

    public static void sendDeathMessage(String message) {
        WebhookManager.client.send(message);
    }
}
