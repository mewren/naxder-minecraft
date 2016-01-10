package com.naxder.naxdermod.items;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;

public class ItemModaxe extends ItemAxe  {

	public ItemModaxe(String unlocalizedName, ToolMaterial material) {
	    super(material);
	    this.setUnlocalizedName(unlocalizedName);
	    this.setCreativeTab(ModItems.tabMyMod);
	    //System.out.println("I set material with damage: " + material.getDamageVsEntity() + " to " + unlocalizedName);
	    
	    System.out.println("getStrVsBlock" + this.getStrVsBlock(null, Blocks.brick_block));
	}

}
