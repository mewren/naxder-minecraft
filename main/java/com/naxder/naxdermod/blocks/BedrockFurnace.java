package com.naxder.naxdermod.blocks;

import com.naxder.naxdermod.items.ModItems;

import net.minecraft.block.BlockFurnace;

public class BedrockFurnace extends BlockFurnace {

	public BedrockFurnace(boolean isBurning) {
		super(isBurning);
		
		//this.setBlockUnbreakable();
		this.setCreativeTab(ModItems.tabMyMod); 
        this.setHarvestLevel("pickaxe", 4);
		
	}

}
