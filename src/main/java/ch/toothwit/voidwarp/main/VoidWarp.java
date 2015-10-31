package ch.toothwit.voidwarp.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import ch.toothwit.voidwarp.events.PlayerEventListener;

public class VoidWarp extends JavaPlugin {
	
	private static VoidWarp instance;
	
	public static VoidWarp get(){
		return instance;
	}
	
	@Override
    public void onDisable() {
        super.onDisable();
        getLogger().info(this.getName() + "disabled successfully!");
    }

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) { 
		if (command.getName().equalsIgnoreCase("setWarpLoc") && sender.isOp()) { 
			Settings.get().setWarpLocation(((Entity)sender).getLocation());

		}
		return false; 
	}

	
    @Override
    public void onEnable() {
    	instance = this;
    	
        super.onEnable();
        getServer().getPluginManager().registerEvents(new PlayerEventListener(), this);

        

        getLogger().info(this.getName() + "enabled successfully!");
    }
}
