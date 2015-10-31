package ch.toothwit.voidwarp.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class Settings {
	private FileConfiguration config;
	private static Settings instance;
	private Location warpLoc;
	
	public static Settings get() {
		if(instance == null) {
			instance = new Settings();
		}
		return instance;
	}
	
	public Settings() {
		VoidWarp.get().saveDefaultConfig(); 
		this.config = VoidWarp.get().getConfig();
		this.warpLoc = getLocation("warpLocation");
	}
	
	public void setWarpLocation(Location location) {
		warpLoc = location;
		setLocation("warpLocation", location);
	}
	
	public Location getWarpLocation() {
		return warpLoc;
	}
	
	public void setLocation(String path, Location location) {
		Settings.get().config.set(path, location.toString());
		saveConfig();
	}
	
	public void saveConfig() {
		
		File gameConfig = new File(VoidWarp.get().getDataFolder() + "/" + "config.yml");
		try {
			config.save(gameConfig);
		} catch (IOException e) {
			Bukkit.getLogger().warning("Could not save config");
		}
	} 
	
	public Location getLocation(String path) {
		String s = Settings.get().config.getString(path);
		String[] split = s.split(" ");
		Location l = new Location(VoidWarp.get().getServer().getWorld(split[0]), 
				Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));
		return l;
	}
}
