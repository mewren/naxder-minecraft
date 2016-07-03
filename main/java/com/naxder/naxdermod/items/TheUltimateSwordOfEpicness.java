package com.naxder.naxdermod.items;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.naxder.naxdermod.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class TheUltimateSwordOfEpicness extends ItemSword {

	private static final float efficiencyOnProperMaterial = 20;

	private static Set effectiveAgainst = Sets.newHashSet(new Block[] {
			Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel,
			Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland,
			Blocks.soul_sand, Blocks.mycelium, Blocks.planks, Blocks.bookshelf,
			Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin,
			Blocks.lit_pumpkin, Blocks.activator_rail, Blocks.coal_ore,
			Blocks.cobblestone, Blocks.detector_rail, Blocks.diamond_block,
			Blocks.diamond_ore, Blocks.double_stone_slab, Blocks.golden_rail,
			Blocks.gold_block, Blocks.gold_ore, Blocks.ice, Blocks.iron_block,
			Blocks.iron_ore, Blocks.lapis_block, Blocks.lapis_ore,
			Blocks.lit_redstone_ore, Blocks.mossy_cobblestone,
			Blocks.netherrack, Blocks.packed_ice, Blocks.rail,
			Blocks.redstone_ore, Blocks.sandstone, Blocks.red_sandstone,
			Blocks.stone, Blocks.stone_slab, Blocks.bedrock ,ModBlocks.tutorial_ore});

	protected TheUltimateSwordOfEpicness(String unlocalizedName,
			ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
	}

	public TheUltimateSwordOfEpicness(ToolMaterial material) {
		super(material);
	}

	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("pickaxe", "spade", "axe", "sword");
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		
		return effectiveAgainst.contains(block) ? true : super
				.canHarvestBlock(block);
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block) {
		
		//harvest bedrock slowly
//		if(block == Blocks.bedrock) {
//			return 5f;
//		}
//		
		if (block.getMaterial() == Material.wood
				|| block.getMaterial() == Material.vine
				|| block.getMaterial() == Material.plants)
			return this.efficiencyOnProperMaterial;
		
		if(block == ModBlocks.tutorial_ore || block == Blocks.bedrock) {
			return (this.efficiencyOnProperMaterial * 8);
		}
		
		return effectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial
				: super.getStrVsBlock(stack, block);
	}

}
