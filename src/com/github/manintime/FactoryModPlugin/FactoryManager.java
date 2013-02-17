package com.github.manintime.FactoryModPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.ContainerBlock;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import com.github.manintime.*;

public class FactoryManager {
	private List<Listener> listeners;
	private Map<MachineType, Manager> managers;
	
	FactoryModPlugin plugin; //The plugin object
	
	public FactoryManager (FactoryModPlugin plugin){
		this.plugin = plugin;
		initialiseFactories();
		
		managers = new HashMap<MachineType, Manager>();
		
		
	}
	
	private void initialiseFactories(){
		Listener factoryListener = new FactoryListener(this);
		plugin.getServer().getPluginManager().registerEvents(factoryListener, plugin);
		
	}
	
	public void registerManager(MachineType type, Manager manager) {
		managers.put(type, manager);
	}
	
	public boolean tryCreateFactory(Block centralBlock, Block inventoryBlock, Block furnaceBlock) {
		assert(inventoryBlock instanceof InventoryHolder);
		Inventory creationInventory = ((InventoryHolder) inventoryBlock).getInventory(); 
				
		for (Entry<MachineType, Manager> pair : managers.entrySet()) {
			MachineType type = pair.getKey();
			if (type.containsConstructionMaterials(creationInventory)) {
				Manager manager = pair.getValue();
				manager.createMachine(type, centralBlock, inventoryBlock, furnaceBlock);
				return true;
			}
		}
		return false;
	}
	
	
}
