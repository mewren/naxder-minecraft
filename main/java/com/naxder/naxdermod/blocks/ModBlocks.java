package com.naxder.naxdermod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.naxder.naxdermod.items.ModItems;

public final class ModBlocks {

	public static Block tutorialBlock;
	public static ModBlockOre tutorial_ore;
	public static Block clearGlassBlock;


	
	public static void createBlocks() {
		
		//glowing blue block
	    GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorial_block"), "tutorial_block").setLightLevel(1.0f);
	    
		//block with ore
	    GameRegistry.registerBlock(tutorial_ore = new ModBlockOre("tutorial_ore", Material.rock, ModItems.crystal, 2, 9), "tutorial_ore");

	    //clear glass block - shiny!
	    GameRegistry.registerBlock(clearGlassBlock = new BlockGlass(Material.glass, false), "clear_glass_block");
	    clearGlassBlock.setHardness(0.3f);
	    clearGlassBlock.setStepSound(Block.soundTypeGlass);
	    clearGlassBlock.setUnlocalizedName("clear_glass_block");
//	    GameRegistry.registerBlock(clearGlassBlock = new BasicBlock("clear_glass_block"), "clear_glass_block").setLightLevel(0.0f);

	}



	public static void placeHelloWorld() {
		// TODO Auto-generated method stub
		Block b = GameRegistry.findBlock("x", "x");

		
	}

//	public static void createBlocks() {
//	    GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorial_block").setLightLevel(1.0f), "tutorial_block");
//	}
}
