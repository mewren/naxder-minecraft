package com.naxder.naxdermod.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.naxder.naxdermod.blocks.ModBlocks;
import com.naxder.naxdermod.items.ModItems;

public final class ModCrafting {

	public static void initCrafting() {
		// shaped recipe
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tutorialBlock),
				new Object[] { "##", "##", '#', ModItems.tutorialItem });

		// shapeless recipe
		GameRegistry
				.addShapelessRecipe(new ItemStack(ModItems.tutorialItem),
						new Object[] { Items.redstone,
								new ItemStack(Items.dye, 1, 4) });

		// smelting recipe
		GameRegistry.addSmelting(Items.diamond, new ItemStack(
				ModItems.tutorialItem), 1.0F);

		// shaped recipe for pickaxe
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialPickaxe),
				new Object[] { "###", " I ", " I ", '#', ModItems.crystal, 'I',
						Items.stick });
		// shaped recipe for axe
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialaxe),
				new Object[] { "## ", "#I ", " I ", '#', ModItems.crystal, 'I',
						Items.stick });

		// GameRegistry.addRecipe(new ItemStack(Items.iron_pickaxe), new
		// Object[] {"###", " I ", " I ", '#', Items.iron_ingot, 'I',
		// Items.stick});

		// metal recipe
		// GameRegistry.addRecipe(new ItemStack(ModItems.tutorialPickaxe), new
		// Object[] {" # ", " I ", " J ", '#', Items.gold_ingot, 'I',
		// Items.iron_ingot, 'J', Items.brick});

		// shaped recipe for Armor
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialHelmet),
				new Object[] { "   ", "###", "# #", '#', ModItems.crystal });
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialChestplate),
				new Object[] { "# #", "###", "###", '#', ModItems.crystal });
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialLeggings),
				new Object[] { "###", "# #", "# #", '#', ModItems.crystal });
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialBoots),
				new Object[] { "   ", "# #", "# #", '#', ModItems.crystal });

	}

}
