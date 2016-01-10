package com.naxder.naxdermod.items;

import net.minecraft.item.ItemPickaxe;

public class ItemModPickaxe extends ItemPickaxe {

	public ItemModPickaxe(String unlocalizedName, ToolMaterial material) {
	    super(material);
	    this.setUnlocalizedName(unlocalizedName);
	    this.setCreativeTab(ModItems.tabMyMod);
	    //System.out.println("I set material with damage: " + material.getDamageVsEntity() + " to " + unlocalizedName);
	}

}
