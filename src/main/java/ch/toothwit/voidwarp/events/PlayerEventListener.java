package ch.toothwit.voidwarp.events;


import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import ch.toothwit.voidwarp.main.Settings; 

public class PlayerEventListener implements Listener {
	@EventHandler
    public void onWeatherChange(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER) {
            Player p = (Player)event.getEntity();
            p.teleport(Settings.get().getWarpLocation());
        }
    }
}
