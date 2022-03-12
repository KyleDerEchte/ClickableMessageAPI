package de.kyleonaut.clickablemessage.listener;

import de.kyleonaut.clickablemessage.service.ClickableMessageService;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author kyleonaut
 */
@RequiredArgsConstructor
public class PlayerMessageListener implements Listener {
    private final ClickableMessageService clickableMessageService;

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerMessage(AsyncPlayerChatEvent event) {
        if (event.getMessage().matches("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}")) {
            try {
                final UUID uuid = UUID.fromString(event.getMessage());
                final Consumer<Player> action = this.clickableMessageService.getAction(uuid);
                if (action == null) {
                    return;
                }
                action.accept(event.getPlayer());
                event.setCancelled(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
