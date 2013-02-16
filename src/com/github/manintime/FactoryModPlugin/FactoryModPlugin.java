package com.github.manintime.FactoryModPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import com.github.manintime.*;

public final class FactoryModPlugin extends JavaPlugin{
	FactoryManager manager;
	
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
