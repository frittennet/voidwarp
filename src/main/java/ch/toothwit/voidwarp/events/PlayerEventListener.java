package ch.toothwit.voidwarp.events;


import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import ch.toothwit.voidwarp.main.Settings; 

public class PlayerEventListener implements Listener {
	
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) { 
        if (event.getEntityType() == EntityType.PLAYER && event.getCause() == EntityDamageEvent.DamageCause.VOID) {
            Player p = (Player)event.getEntity(); 
            Location l = Settings.get().getWarpLocation(); 
            l.add(0.5, 0.5, 0.5); 
            p.teleport(l); 
        }
    } 
    
}
