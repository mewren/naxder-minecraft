package com.naxder.naxdermod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemModArmor extends ItemArmor {


    public ItemModArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType) {
        super(material, renderIndex, armorType);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(ModItems.tabMyMod);
        
    }
    
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
    	
    	//if wear individual pieces

        if (itemStack.getItem() == ModItems.tutorialHelmet) {
            effectPlayer(player, Potion.nightVision, 3);
        }
        if (itemStack.getItem() == ModItems.tutorialChestplate) {
            effectPlayer(player, Potion.digSpeed, 3);
        }
        if (itemStack.getItem() == ModItems.tutorialLeggings) {
            effectPlayer(player, Potion.moveSpeed, 3);
        }
        if (itemStack.getItem() == ModItems.tutorialBoots) {
            effectPlayer(player, Potion.jump, 3);
        }
        
        
        
      //if wear individual ranger pieces

        if (itemStack.getItem() == ModItems.rangerHelmet) {
            effectPlayer(player, Potion.nightVision, 3);
        }
        if (itemStack.getItem() == ModItems.rangerChestplate) {
            effectPlayer(player, Potion.moveSpeed, 3);
        }
        if (itemStack.getItem() == ModItems.rangerLeggings) {
            effectPlayer(player, Potion.moveSpeed, 3);
        }
        if (itemStack.getItem() == ModItems.rangerBoots) {
            effectPlayer(player, Potion.jump, 3);
        }
        
        
        
        //if wear all armor
        if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ModItems.tutorialHelmet
                && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ModItems.tutorialChestplate
                && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ModItems.tutorialLeggings
                && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ModItems.tutorialBoots) {
                this.effectPlayer(player, Potion.regeneration, 3);
                
                
                //if wear all ranger armor
                if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ModItems.rangerHelmet
                        && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ModItems.rangerChestplate
                        && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ModItems.rangerLeggings
                        && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ModItems.rangerBoots) {
                        this.effectPlayer(player, Potion.invisibility, 0);
                        
                    
        }}}
        
   

    private void effectPlayer(EntityPlayer player, Potion potion, int amplifier) {
        //Always effect for 8 seconds, then refresh
        if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
            player.addPotionEffect(new PotionEffect(potion.id, 159, amplifier, true, true));
    }
    

    
    
}