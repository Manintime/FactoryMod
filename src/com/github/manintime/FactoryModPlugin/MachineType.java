package com.github.manintime.FactoryModPlugin;

import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;

public interface MachineType {
	/**
	 * Retrieve the name of this type of machine.
	 * @return The name of this type of machine
	 */
	public String getName();
	
	/**
	 * Returns whether the materials to construct this machine exist in the inventory.
	 * @return whether the inventory contains the materials to construct this machine type.
	 */
	public boolean containsConstructionMaterials(Inventory inventory);
	
	public Machine construct(Block centralBlock, Block inventoryBlock, Block furnaceBlock);
}
