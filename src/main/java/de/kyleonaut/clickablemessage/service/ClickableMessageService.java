package de.kyleonaut.clickablemessage.service;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author kyleonaut
 */
@RequiredArgsConstructor
public class ClickableMessageService {
    private final Map<UUID, Consumer<Player>> actions;

    public Consumer<Player> getAction(UUID uuid) {
        if (this.actions.containsKey(uuid)) {
            return this.actions.get(uuid);
        }
        return null;
    }

    public void addAction(UUID uuid, Consumer<Player> consumer) {
        this.actions.put(uuid, consumer);
    }

    public void removeAction(UUID uuid) {
        this.actions.remove(uuid);
    }
}
