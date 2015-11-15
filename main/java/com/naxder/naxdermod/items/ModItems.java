package com.naxder.naxdermod.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tutorial.generic.Main;

public final class ModItems {

	public static Item tutorialItem;
	public static Item tutorialPickaxe;
	public static Item tutorialHelmet;
	public static Item tutorialChestplate;
	public static Item tutorialLeggings;
	public static Item tutorialBoots;
	
	// public static ToolMaterial TUTORIAL =
	// EnumHelper.addToolMaterial("TUTORIAL", harvestLevel, durability,
	// miningSpeed, damageVsEntities, enchantability);
	public static ToolMaterial TOOL_MATERIAL = EnumHelper.addToolMaterial(
			"TUTORIAL", 2, 2000, 10.0f, 25.0f, 10);

	// material for our armor
	public static ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial(
			"ARMOR_MATERIAL", Main.MODID + ":tutorial", 40, new int[] { 4, 8,
					6, 4 }, 20);

	public static void createItems() {

		// /give @p naxder_mod:tutorial_item

		// create tutorial item
		GameRegistry.registerItem(
				tutorialItem = new BasicItem("tutorial_item"), "tutorial_item");

		// create tutorial pickaxe
		GameRegistry.registerItem(tutorialPickaxe = new ItemModPickaxe(
				"crystal_pickaxe", TOOL_MATERIAL), "crystal_pickaxe");

		// GameRegistry.registerItem(tutorialPickaxe = new
		// ItemModPickaxe("tutorial_pickaxe", TUTORIAL), "tutorial_pickaxe");

		//this is the helmet
		GameRegistry.registerItem(tutorialHelmet = new ItemModArmor(
				"tutorial_helmet",     ARMOR_MATERIAL, 1, 0), "tutorial_helmet");
		
		//this is the chestplate
		GameRegistry.registerItem(tutorialChestplate = new ItemModArmor(
				"tutorial_chestplate", ARMOR_MATERIAL, 1, 1), "tutorial_chestplate");
		
		//this is the leggings
		GameRegistry.registerItem(tutorialLeggings = new ItemModArmor(
				"tutorial_leggings",   ARMOR_MATERIAL, 2, 2), "tutorial_leggings");
		
		//this is the boots
		GameRegistry.registerItem(tutorialBoots = new ItemModArmor(
				"tutorial_boots",      ARMOR_MATERIAL, 1, 3), "tutorial_boots");

	}
}
