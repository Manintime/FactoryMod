package com.github.manintime.FactoryMod;

import org.bukkit.plugin.java.JavaPlugin;
import com.github.manintime.*;

public final class FactoryMod extends JavaPlugin{
	 @Override
	    public void onEnable(){
			getLogger().info("onEnable has been invoked!");
			manager = new FactoryManager(this);	   
	 }
	 
	    @Override
	    public void onDisable() {
	    	getLogger().info("onDisable has been invoked!");
	    }
}
