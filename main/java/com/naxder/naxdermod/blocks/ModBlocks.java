package com.naxder.naxdermod.blocks;

import com.naxder.naxdermod.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static Block tutorialBlock;
	public static ModBlockOre tutorial_ore;


	
	public static void createBlocks() {
		
		//glowing blue block
	    GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorial_block"), "tutorial_block").setLightLevel(1.0f);
	    
		//block with ore
	    GameRegistry.registerBlock(tutorial_ore = new ModBlockOre("tutorial_ore", Material.rock, ModItems.crystal, 2, 9), "tutorial_ore");

	}



	public static void placeHelloWorld() {
		// TODO Auto-generated method stub
		Block b = GameRegistry.findBlock("x", "x");

		
	}

//	public static void createBlocks() {
//	    GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorial_block").setLightLevel(1.0f), "tutorial_block");
//	}
}
