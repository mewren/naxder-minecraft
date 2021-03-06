package com.naxder.naxdermod.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tutorial.generic.Main;

public final class ModItems {
	public static Item tutorialaxe;
	public static Item tutorialItem;
	public static Item crystal;
	public static Item tutorialPickaxe;
	public static Item tutorialHelmet;
	public static Item tutorialChestplate;
	public static Item tutorialLeggings;
	public static Item tutorialBoots;
	public static Item tutorialChocolate;
	public static Item rangerHelmet;
	public static Item rangerChestplate;
	public static Item rangerLeggings;
	public static Item rangerBoots;
	public static Item clearGlass;
	public static Item theUltimateSwordOfEpicness;
	public static Item woodHelmet;
	public static Item woodChestplate;
	public static Item woodLeggings;
	public static Item woodlBoots;
	
	// public static ToolMaterial TUTORIAL =
	// EnumHelper.addToolMaterial("TUTORIAL", harvestLevel, durability,
	// miningSpeed, damageVsEntities, enchantability);
	public static ToolMaterial TOOL_MATERIAL = EnumHelper.addToolMaterial(
			"TUTORIAL", 2, 2000, 10.0f, 25.0f, 10);

	public static ToolMaterial EPIC_SWORD_MATERIAL = EnumHelper.addToolMaterial("EPIC_SWORD_MATERIAL", 4, 20000, 20.0f, 246.0f, 50);

//	public static ToolMaterial EPIC_SWORD_MATERIAL = EnumHelper.addToolMaterial("EPIC_SWORD_MATERIAL", 3, 1561, 12.0f, 4.0f, 22);
			
	// material for our armor
	public static ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial(
			"ARMOR_MATERIAL", Main.MODID + ":tutorial", 40, new int[] { 4, 8,
					6, 4 }, 20);
	
	public static ArmorMaterial WOOD_ARMOUR_MATERIAL = EnumHelper.addArmorMaterial("WOOD_ARMOUR_MATERIAL",  Main.MODID + ":wood", 7, new int[]{1, 3, 2, 1}, 10);

	
	// our own creative tab
	public static final CreativeTabs tabMyMod = new CreativeTabs("myMod") {
		@Override
		public Item getTabIconItem() {
			return tutorialPickaxe;
		}
	};

	public static void createItems() {

		// /give @p naxder_mod:tutorial_item

		// create tutorial item
		GameRegistry.registerItem(
				tutorialItem = new BasicItem("tutorial_item"), "tutorial_item");

		// another item
		GameRegistry
				.registerItem(crystal = new BasicItem("crystal"), "crystal");

		// clear glass
		GameRegistry.registerItem(clearGlass = new BasicItem("clear_glass"),
				"clear_glass");

		// create tutorial pickaxe
		GameRegistry.registerItem(tutorialPickaxe = new ItemModPickaxe(
				"crystal_pickaxe", TOOL_MATERIAL), "crystal_pickaxe");
		// create tutorial axe
		GameRegistry.registerItem(tutorialaxe = new ItemModaxe("crystal_axe",
				TOOL_MATERIAL), "crystal_axe");

		// GameRegistry.registerItem(tutorialPickaxe = new
		// ItemModPickaxe("tutorial_pickaxe", TUTORIAL), "tutorial_pickaxe");

		// this is the helmet
		GameRegistry.registerItem(tutorialHelmet = new ItemModArmor(
				"tutorial_helmet", ARMOR_MATERIAL, 1, 0), "tutorial_helmet");

		// this is the chestplate
		GameRegistry.registerItem(tutorialChestplate = new ItemModArmor(
				"tutorial_chestplate", ARMOR_MATERIAL, 1, 1),
				"tutorial_chestplate");

		// this is the leggings
		GameRegistry
				.registerItem(tutorialLeggings = new ItemModArmor(
						"tutorial_leggings", ARMOR_MATERIAL, 2, 2),
						"tutorial_leggings");

		// this is the boots
		GameRegistry.registerItem(tutorialBoots = new ItemModArmor(
				"tutorial_boots", ARMOR_MATERIAL, 1, 3), "tutorial_boots");

		// this is the ranger's helmet
		GameRegistry.registerItem(rangerHelmet = new ItemModArmor(
				"ranger_helmet", ARMOR_MATERIAL, 1, 0), "ranger_helmet");

		// this is the ranger's chestplate
		GameRegistry
				.registerItem(rangerChestplate = new ItemModArmor(
						"ranger_chestplate", ARMOR_MATERIAL, 1, 1),
						"ranger_chestplate");

		// this is the ranger's leggings
		GameRegistry.registerItem(rangerLeggings = new ItemModArmor(
				"ranger_leggings", ARMOR_MATERIAL, 2, 2), "ranger_leggings");

		// this is the ranger's boots
		GameRegistry.registerItem(rangerBoots = new ItemModArmor(
				"ranger_boots", ARMOR_MATERIAL, 1, 3), "ranger_boots");

		// ranger's

		// this is the food

		GameRegistry.registerItem(tutorialChocolate = new ItemModFood(
				"tutorial_chocolate", 2, 0.2f, false, new PotionEffect(
						Potion.moveSpeed.id, 1200, 1), new PotionEffect(
						Potion.jump.id, 600, 0), new PotionEffect(
						Potion.regeneration.id, 200, 1)).setAlwaysEdible(),
				"tutorial_chocolate");

		GameRegistry.registerItem(
				theUltimateSwordOfEpicness = new TheUltimateSwordOfEpicness(
						"theUltimateSwordOfEpicness", EPIC_SWORD_MATERIAL),
				"theUltimateSwordOfEpicness");
		
		
		GameRegistry.registerItem(woodHelmet = new ItemModArmor("wood_helmet", WOOD_ARMOUR_MATERIAL, 1, 0), "wood_helmet");
		GameRegistry.registerItem(woodChestplate = new ItemModArmor("wood_chestplate", WOOD_ARMOUR_MATERIAL, 1, 1), "wood_chestplate");
		GameRegistry.registerItem(woodLeggings = new ItemModArmor("wood_leggings", WOOD_ARMOUR_MATERIAL, 2, 2), "wood_leggings");
		GameRegistry.registerItem(woodlBoots = new ItemModArmor("wood_boots", WOOD_ARMOUR_MATERIAL, 1, 3), "wood_boots"); 
		
		//change bedrock to not be unbreakable
		
		//Block obsidian = (Block)Block.blockRegistry.getObject(new ResourceLocation("obsidian"));
		
		Block bedrock = (Block)Block.blockRegistry.getObject(new ResourceLocation("bedrock"));
		if(bedrock!=null) {
			bedrock.setHardness(1);
			IBlockState blockState = null;
			bedrock.setHarvestLevel("sword", 4, blockState);
			
		}
//		 Block bedrockBlock = GameRegistry.findBlock("minecraft", "bedrock");
//		 if(bedrockBlock!=null) {
//			 bedrockBlock.setHardness(123);
//		 }
		 
	}
}
