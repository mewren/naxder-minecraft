package com.naxder.naxdermod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import tutorial.generic.Main;

public final class ItemRenderRegister {

	public static String modid = Main.MODID;

	public static void reg(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
    public static void registerItemRenderer() {
    	reg(ModItems.tutorialItem);
    	reg(ModItems.tutorialPickaxe);
    	reg(ModItems.tutorialaxe);
    	reg(ModItems.tutorialBoots);
    	reg(ModItems.tutorialChestplate);
    	reg(ModItems.tutorialHelmet);
    	reg(ModItems.tutorialLeggings);
    	reg(ModItems.tutorialChocolate);
    	
    	reg(ModItems.crystal);
    }
    
}