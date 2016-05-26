package com.naxder.naxdermod.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.world.World;

import com.mojang.authlib.GameProfile;
import com.naxder.naxdermod.entity.passive.EntityBroom;

public class EntityQuidditchPlayer extends EntityPlayer {

	public EntityQuidditchPlayer(World worldIn, GameProfile p_i45324_2_) {
		super(worldIn, p_i45324_2_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSpectator() {
		// TODO Auto-generated method stub
		return false;
	}

	public void displayGUIBroom(EntityBroom entityBroom, AnimalChest broomChest) {
		// TODO Auto-generated method stub
		
	}

}
