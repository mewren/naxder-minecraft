package com.naxder.naxdermod.entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import tutorial.generic.Main;

import com.naxder.naxdermod.entity.passive.EntityBroom;

///summon naxder_mod.Broom


public final class ModEntities {

	private static int modEntityID = 0;

	public ModEntities() {
		// TODO Auto-generated constructor stub
	}

	public static void createEntities() {
		// TODO Auto-generated method stub

		//registerModEntityWithEgg(EntityBroom.class, "Broom", 0x3F5505, 0x4E6414);

	}

	public static void registerModEntityWithEgg(Class parEntityClass,
			String parEntityName, int parEggColor, int parEggSpotsColor) {
		EntityRegistry.registerModEntity(parEntityClass, parEntityName,
				++modEntityID, Main.instance, 80, 3, false);
		
		System.out.println("JJJJJJ" + parEntityName);
		
		// registerSpawnEgg(parEntityName, parEggColor, parEggSpotsColor);

		// Item itemSpawnEgg = new ItemMonsterPlacer("Broom", 0xE18519,
		// 0x000000)
		//
		// .setUnlocalizedName("spawn_egg_" + parEntityName.toLowerCase())
		//
		// .setTextureName("wildanimals:spawn_egg");
		// GameRegistry.registerItem(itemSpawnEgg, "spawnEgg" + parEntityName);

		EntityRegistry.addSpawn(EntityBroom.class, 6, 1, 5,
				EnumCreatureType.CREATURE, BiomeGenBase.forest);
		// change the values to vary the spawn
		// rarity, biome, etc.

	}

}
