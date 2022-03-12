package de.kyleonaut.clickablemessage.api;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.function.Consumer;

/**
 * @author kyleonaut
 */
public interface ClickableMessageApi {

    static ClickableMessageApi getAPI() {
        return new ClickableMessageApiImpl();
    }

    /**
     * Send a TextComponent to the player.
     * With the consumer you can react individually to a click.
     * You can still edit the content after calling the method.
     * However, you must not change the ClickAction.
     *
     * @param player        The player who is to receive the message
     * @param p             The Consumer with the player who clicked
     * @param textComponent The message that the player should receive
     */
    void sendMessage(Player player, TextComponent textComponent, Consumer<Player> p);

    /**
     * Create a TextComponent with a consumer.
     * With the consumer you can react individually to a click.
     * You can still edit the content after calling the method.
     * However, you must not change the ClickAction.
     *
     * @param p             The Consumer with the player who clicked
     * @param textComponent The message that the player should receive
     * @return Returns the TextComponent with the updated ClickAction
     */
    TextComponent getText(TextComponent textComponent, Consumer<Player> p);
}
