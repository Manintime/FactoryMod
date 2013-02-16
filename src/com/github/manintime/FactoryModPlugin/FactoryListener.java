package com.github.manintime.FactoryModPlugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;
import com.github.manintime.FactoryModPlugin.FactoryManager;



public class FactoryListener implements Listener{

	FactoryManager factoryMan;
	
	// Constructor
	public FactoryListener(FactoryManager factoryMan)
	{
		this.factoryMan = factoryMan;
	}
	
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void factoryMake(BlockPlaceEvent event) {
        Block placedBlock = event.getBlockPlaced();
        Material type = placedBlock.getType();
		Player player = event.getPlayer();
		Material inHand = player.getItemInHand().getType();
		Location placedLoc = placedBlock.getLocation();
				
		if(type.getId()==22) {
        player.sendMessage("You placed a Lapis Block!");	
        Location northLocation = northLoc(placedLoc);
        Location southLocation = southLoc(placedLoc);
        Location eastLocation = eastLoc(placedLoc);
        Location westLocation = westLoc(placedLoc);
        
        Block northBlock = northLocation.getBlock();
        Block southBlock = southLocation.getBlock();
        Block eastBlock = eastLocation.getBlock();
        Block westBlock = westLocation.getBlock();
        
        Material northType = northBlock.getType();
        Material southType = southBlock.getType();
        Material eastType = eastBlock.getType();
        Material westType = westBlock.getType();
        
               
        if(northType.getId()== 61 || northType.getId()== 62)  {
        	player.sendMessage("Furnace detected North");
        	if(southType.getId()== 54) {
        		player.sendMessage("Correct placement, checking chest for factory foundations");
        		        	}
        }
        
        if(westType.getId()== 61 || westType.getId() == 62)  {
        	player.sendMessage("Furnace detected West");
        	if(eastType.getId()== 54) {
        		player.sendMessage("Correct placement, checking chest for factory foundations");
        	}
		}
            
        if(southType.getId()== 61 || southType.getId()== 62)  {
            	player.sendMessage("Furnace detected South");
            	if(northType.getId()== 54) {
            		player.sendMessage("Correct placement, checking chest for factory foundations");
            		        	}
        }        
        
        if(eastType.getId()== 61 || eastType.getId()== 62)  {
             	player.sendMessage("Furnace detected East");
               	if(westType.getId()== 54) {
              		player.sendMessage("Correct placement, checking chest for factory foundations");
                      	}
        } 
            
                
		}
	}
	
			
		public Location westLoc (Location loc) {
			Location newLoc = loc.clone();
			newLoc.add(-1,0,0);
			return newLoc;
		}
		public Location eastLoc (Location loc) {
			Location newLoc = loc.clone();
			newLoc.add(1,0,0);
			return newLoc;
		}
		public Location northLoc (Location loc) {
			/*
			Location newLoc = new Location (loc.getWorld(), loc.getX(), loc.getY(), loc.getZ() - 1);
			return newLoc;
			*/
			
			Location newLoc = loc.clone();
			newLoc.add(0,0,-1);
			return newLoc;
		}
		public Location southLoc (Location loc) {
			Location newLoc = loc.clone();
			newLoc.add(0,0,1);
			return newLoc;
		}
		public Location downLoc (Location loc) {
			Location newLoc = loc.clone();
			newLoc.add(0,-1,0);
			return newLoc;
		}
		public Location upLoc (Location loc) {
			Location newLoc = loc.clone();
			newLoc.add(0,1,0);
			return newLoc;
		}	
		
    
}
