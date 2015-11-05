package ch.toothwit.voidwarp.main;

import org.bukkit.Location; 

public class Settings { 
	private static Settings instance;
	private Location warpLoc;
	
	public static Settings get() {
		if(instance == null) {
			instance = new Settings();
		}
		return instance; 
	}
	
	public Settings() { 
		this.warpLoc = VoidWarp.get().getServer().getWorld("lobby").getSpawnLocation();  
	} 
	
	public Location getWarpLocation() {
		return this.warpLoc; 
	} 
}
