package com.naxder.naxdermod.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static Block tutorialBlock;


	
	public static void createBlocks() {
	    GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorial_block"), "tutorial_block").setLightLevel(1.0f);
	}



	public static void placeHelloWorld() {
		// TODO Auto-generated method stub
		Block b = GameRegistry.findBlock("x", "x");

		
	}

//	public static void createBlocks() {
//	    GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorial_block").setLightLevel(1.0f), "tutorial_block");
//	}
}
