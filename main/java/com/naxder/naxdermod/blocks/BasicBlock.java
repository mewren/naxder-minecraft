package com.naxder.naxdermod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.naxder.naxdermod.items.ModItems;

public class BasicBlock extends Block {
	
	public BasicBlock(String unlocalizedName, Material material,
			float hardness, float resistance) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		//this.setCreativeTab(CreativeTabs.tabBlock);
		this.setCreativeTab(ModItems.tabMyMod);
		this.setHardness(hardness);
		this.setResistance(resistance);
		
		this.setBlockUnbreakable();
	}

	public BasicBlock(String unlocalizedName, float hardness, float resistance) {
		this(unlocalizedName, Material.rock, hardness, resistance);
	}

	public BasicBlock(String unlocalizedName) {
		this(unlocalizedName, 2.0f, 10.0f);
	}
	
	
	
}
