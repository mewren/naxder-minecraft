package com.naxder.naxdermod.client.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import tutorial.generic.Main;

import com.naxder.naxdermod.blocks.ModBlocks;

public final class BlockRenderRegister {
	
	public static String modid = Main.MODID;
	
	public static void reg(Block block) {
		System.out.println("registering "+ block.getUnlocalizedName());
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
	
    public static void registerBlockRenderer() {
    	reg(ModBlocks.tutorialBlock);
    	reg(ModBlocks.tutorial_ore);
    	reg(ModBlocks.clearGlassBlock);
    }
}
