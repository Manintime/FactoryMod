package com.github.manintime.FactoryModPlugin.machines;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.github.manintime.FactoryModPlugin.InteractionResponse;
import com.github.manintime.FactoryModPlugin.Machine;
import com.github.manintime.FactoryModPlugin.MachineType;

public class ExampleMachine implements Machine {
	Block centralBlock;
	Block inventoryBlock;
	Block furnaceBlock;
	
	public ExampleMachine(Block centralBlock, Block inventoryBlock,
			Block furnaceBlock) {
		this.centralBlock = centralBlock;
		this.inventoryBlock = inventoryBlock;
		this.furnaceBlock = furnaceBlock;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy(ItemStack item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InteractionResponse togglePower() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MachineType getType() {
		return getExampleMachineType();
	}

	@Override
	public Location getLocation() {
		return centralBlock.getLocation();
	}
	
	/* Machine type - static to class */
	
	private static MachineType machineType;
	
	public static MachineType getExampleMachineType() {
		return machineType;
	}
	
	static {
		machineType = new MachineType() {
			@Override
			public String getName() {
				return "Example Machine";
			}

			@Override
			public boolean containsConstructionMaterials(Inventory inventory) {
				// TODO Auto-generated method stub
				return inventory.containsAtLeast(new ItemStack(Material.IRON_BLOCK), 10);
			}

			@Override
			public Machine construct(Block centralBlock, Block inventoryBlock,
					Block furnaceBlock) {
				return new ExampleMachine(centralBlock, inventoryBlock, furnaceBlock);
			}
		};
	}

}
