package com.github.manintime.FactoryMod;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import com.github.manintime.*;

public class FactoryManager {
	FactoryMod plugin; //The plugin object
	
	public static FactoryManager facMan;
	
	public FactoryManager (FactoryMod plugin){
		this.plugin = plugin;
		FactoryManager.facMan = this;
		initialiseFactories();
		
	}
	
	Private void initialiseFactories(){
		Listener factoryListener = new FactoryListener(facMan);
		plugin.getServer().getPluginManager().registerEvents(factoryListener, plugin);
		
	}
}
