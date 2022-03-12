package de.kyleonaut.clickablemessage.api;

import de.kyleonaut.clickablemessage.ClickableMessagePlugin;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author kyleonaut
 */
public class ClickableMessageApiImpl implements ClickableMessageApi {
    public void sendMessage(Player player, TextComponent textComponent, Consumer<Player> p) {
        final UUID uuid = UUID.randomUUID();
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, uuid.toString()));
        player.spigot().sendMessage(textComponent);
        ClickableMessagePlugin.getPlugin(ClickableMessagePlugin.class).getClickableMessageService().addAction(uuid, p);
    }

    public TextComponent getText(TextComponent textComponent, Consumer<Player> p) {
        final UUID uuid = UUID.randomUUID();
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, uuid.toString()));
        ClickableMessagePlugin.getPlugin(ClickableMessagePlugin.class).getClickableMessageService().addAction(uuid, p);
        return textComponent;
    }
}
