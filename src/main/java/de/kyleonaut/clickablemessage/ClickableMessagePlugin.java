package de.kyleonaut.clickablemessage;

import de.kyleonaut.clickablemessage.listener.PlayerMessageListener;
import de.kyleonaut.clickablemessage.service.ClickableMessageService;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * @author kyleonaut
 */
public class ClickableMessagePlugin extends JavaPlugin {
    @Getter
    private ClickableMessageService clickableMessageService;

    @Override
    public void onEnable() {
        this.clickableMessageService = new ClickableMessageService(new HashMap<>());
        Bukkit.getPluginManager().registerEvents(new PlayerMessageListener(this.clickableMessageService), this);
    }
}
