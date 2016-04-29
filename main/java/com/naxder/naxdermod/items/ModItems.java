package com.naxder.naxdermod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
	
	// public static ToolMaterial TUTORIAL =
	// EnumHelper.addToolMaterial("TUTORIAL", harvestLevel, durability,
	// miningSpeed, damageVsEntities, enchantability);
	public static ToolMaterial TOOL_MATERIAL = EnumHelper.addToolMaterial("TUTORIAL", 2, 2000, 10.0f, 25.0f, 10);
	
	// material for our armor
	public static ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ARMOR_MATERIAL", Main.MODID + ":tutorial",
			40, new int[] { 4, 8, 6, 4 }, 20);

	//our own creative tab
	public static final CreativeTabs tabMyMod = new CreativeTabs("myMod") {
	    @Override public Item getTabIconItem() {
	        return tutorialPickaxe;
	    }
	};
	
	public static void createItems() {

		// /give @p naxder_mod:tutorial_item

		// create tutorial item
		GameRegistry.registerItem(tutorialItem = new BasicItem("tutorial_item"), "tutorial_item");

		//another item
		GameRegistry.registerItem(crystal = new BasicItem("crystal"), "crystal");
		
		// create tutorial pickaxe
		GameRegistry.registerItem(tutorialPickaxe = new ItemModPickaxe("crystal_pickaxe", TOOL_MATERIAL),
				"crystal_pickaxe");
		// create tutorial axe
				GameRegistry.registerItem(tutorialaxe = new ItemModaxe("crystal_axe", TOOL_MATERIAL),
						"crystal_axe");

		// GameRegistry.registerItem(tutorialPickaxe = new
		// ItemModPickaxe("tutorial_pickaxe", TUTORIAL), "tutorial_pickaxe");

		// this is the helmet
		GameRegistry.registerItem(tutorialHelmet = new ItemModArmor("tutorial_helmet", ARMOR_MATERIAL, 1, 0),
				"tutorial_helmet");

		// this is the chestplate
		GameRegistry.registerItem(tutorialChestplate = new ItemModArmor("tutorial_chestplate", ARMOR_MATERIAL, 1, 1),
				"tutorial_chestplate");

		// this is the leggings
		GameRegistry.registerItem(tutorialLeggings = new ItemModArmor("tutorial_leggings", ARMOR_MATERIAL, 2, 2),
				"tutorial_leggings");

		// this is the boots
		GameRegistry.registerItem(tutorialBoots = new ItemModArmor("tutorial_boots", ARMOR_MATERIAL, 1, 3),
				"tutorial_boots");
		
		
		
		// this is the ranger's helmet
				GameRegistry.registerItem(rangerHelmet = new ItemModArmor("ranger_helmet", ARMOR_MATERIAL, 1, 0),
						"ranger_helmet");

				// this is the ranger's chestplate
				GameRegistry.registerItem(rangerChestplate = new ItemModArmor("ranger_chestplate", ARMOR_MATERIAL, 1, 1),
						"ranger_chestplate");

				// this is the ranger's leggings
				GameRegistry.registerItem(rangerLeggings = new ItemModArmor("ranger_leggings", ARMOR_MATERIAL, 2, 2),
						"ranger_leggings");

				// this is the ranger's boots
				GameRegistry.registerItem(rangerBoots = new ItemModArmor("ranger_boots", ARMOR_MATERIAL, 1, 3),
						"ranger_boots");
		
		
		//ranger's
		

		// this is the food

		GameRegistry
				.registerItem(
						tutorialChocolate = new ItemModFood("tutorial_chocolate", 2, 0.2f, false,
								new PotionEffect(Potion.moveSpeed.id, 1200, 1),
								new PotionEffect(Potion.jump.id, 600, 0),
								new PotionEffect(Potion.regeneration.id, 200, 1)).setAlwaysEdible(),
						"tutorial_chocolate");

	}
}
