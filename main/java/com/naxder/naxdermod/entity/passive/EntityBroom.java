package com.naxder.naxdermod.entity.passive;

///summon naxder_mod.Broom

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Predicate;
import com.naxder.naxdermod.entity.player.EntityQuidditchPlayer;

public class EntityBroom extends EntityAnimal implements IInvBasic
{
    private static final Predicate broomBreedingSelector = new Predicate()
    {
        private static final String __OBFID = "CL_00001642";
        public boolean func_179873_a(Entity p_179873_1_)
        {
            return p_179873_1_ instanceof EntityBroom && ((EntityBroom)p_179873_1_).func_110205_ce();
        }
        public boolean apply(Object p_apply_1_)
        {
            return this.func_179873_a((Entity)p_apply_1_);
        }
    };
    private static final IAttribute broomJumpStrength = (new RangedAttribute((IAttribute)null, "broom.jumpStrength", 0.7D, 0.0D, 2.0D)).setDescription("Jump Strength").setShouldWatch(true);
    private static final String[] field_110273_bx = new String[] {"", "meo", "goo", "dio"};
    private static final String[] broomTextures = new String[] {"textures/entity/broom/broom_white.png", "textures/entity/broom/broom_creamy.png", "textures/entity/broom/broom_chestnut.png", "textures/entity/broom/broom_brown.png", "textures/entity/broom/broom_black.png", "textures/entity/broom/broom_gray.png", "textures/entity/broom/broom_darkbrown.png"};
    private static final String[] broomTextureString = new String[] {"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
    private static final String[] broomMarkingTextures = new String[] {null, "textures/entity/broom/broom_markings_white.png", "textures/entity/broom/broom_markings_whitefield.png", "textures/entity/broom/broom_markings_whitedots.png", "textures/entity/broom/broom_markings_blackdots.png"};
    private static final String[] broomMarkingTextureSTring = new String[] {"", "wo_", "wmo", "wdo", "bdo"};
    private int eatingHaystackCounter;
    private int openMouthCounter;
    private int jumpRearingCounter;
    public int field_110278_bp;
    public int field_110279_bq;
    protected boolean broomJumping;
    private AnimalChest broomChest;
    /** "The higher this value, the more likely the broom is to be tamed next time a player rides it." */
    protected int temper;
    protected float jumpPower;
    private boolean field_110294_bI;
    /** Used to determine the sound that the broom should make when it steps */
    private int gallopTime;
    private String texturePrefix;
    private String[] field_110280_bR = new String[3];
    private boolean field_175508_bO = false;
    private static final String __OBFID = "CL_00001641";

    public EntityBroom(World worldIn)
    {
        super(worldIn);
        this.setSize(1.4F, 1.6F);
        this.isImmuneToFire = false;
        this.setChested(false);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.2D));
        //this.tasks.addTask(1, new EntityAIRunAroundLikeCrazy(this, 1.2D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWander(this, 0.7D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.func_110226_cD();
        
        this.setTemper(100);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Integer.valueOf(0));
        this.dataWatcher.addObject(19, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(20, Integer.valueOf(0));
        this.dataWatcher.addObject(21, String.valueOf(""));
        this.dataWatcher.addObject(22, Integer.valueOf(0));
    }

    public void setBroomType(int p_110214_1_)
    {
        this.dataWatcher.updateObject(19, Byte.valueOf((byte)p_110214_1_));
        this.resetTexturePrefix();
    }

    /**
     * Returns the broom type. 0 = Normal, 1 = Donkey, 2 = Mule, 3 = Undead Broom, 4 = Skeleton Broom
     */
    public int getBroomType()
    {
        return this.dataWatcher.getWatchableObjectByte(19);
    }

    public void setBroomVariant(int p_110235_1_)
    {
        this.dataWatcher.updateObject(20, Integer.valueOf(p_110235_1_));
        this.resetTexturePrefix();
    }

    public int getBroomVariant()
    {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getName()
    {
        if (this.hasCustomName())
        {
            return this.getCustomNameTag();
        }
        else
        {
            int i = this.getBroomType();

            switch (i)
            {
                case 0:
                default:
                    return StatCollector.translateToLocal("entity.broom.name");
                case 1:
                    return StatCollector.translateToLocal("entity.firebolt.name");
                case 2:
                    return StatCollector.translateToLocal("entity.nimbus2000.name");
                case 3:
                    return StatCollector.translateToLocal("entity.nimbus2001.name");
                case 4:
                    return StatCollector.translateToLocal("entity.nimbus2002.name");
            }
        }
    }

    private boolean getBroomWatchableBoolean(int p_110233_1_)
    {
        return (this.dataWatcher.getWatchableObjectInt(16) & p_110233_1_) != 0;
    }

    private void setBroomWatchableBoolean(int p_110208_1_, boolean p_110208_2_)
    {
        int j = this.dataWatcher.getWatchableObjectInt(16);

        if (p_110208_2_)
        {
            this.dataWatcher.updateObject(16, Integer.valueOf(j | p_110208_1_));
        }
        else
        {
            this.dataWatcher.updateObject(16, Integer.valueOf(j & ~p_110208_1_));
        }
    }


    public boolean isTame()
    {
    	return true;
        //return this.getBroomWatchableBoolean(2);
    }


    public String func_152119_ch()
    {
        return this.dataWatcher.getWatchableObjectString(21);
    }

    public void func_152120_b(String p_152120_1_)
    {
        this.dataWatcher.updateObject(21, p_152120_1_);
    }


    public boolean isBroomJumping()
    {
        return this.broomJumping;
    }

    public void setBroomTamed(boolean p_110234_1_)
    {
        this.setBroomWatchableBoolean(2, p_110234_1_);
    }

    public void setBroomJumping(boolean p_110255_1_)
    {
        this.broomJumping = p_110255_1_;
    }

    public boolean allowLeashing()
    {
        return !this.isUndead() && super.allowLeashing();
    }

    protected void func_142017_o(float p_142017_1_)
    {
        if (p_142017_1_ > 6.0F && this.isEatingHaystack())
        {
            this.setEatingHaystack(false);
        }
    }

    public boolean isChested()
    {
        return this.getBroomWatchableBoolean(8);
    }

    public int func_110241_cb()
    {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public boolean isEatingHaystack()
    {
        return this.getBroomWatchableBoolean(32);
    }

    public boolean isRearing()
    {
        return this.getBroomWatchableBoolean(64);
    }

    public boolean func_110205_ce()
    {
        return this.getBroomWatchableBoolean(16);
    }

  

    public void func_110242_l(boolean p_110242_1_)
    {
        this.setBroomWatchableBoolean(16, p_110242_1_);
    }

    public void setChested(boolean p_110207_1_)
    {
        this.setBroomWatchableBoolean(8, p_110207_1_);
    }

  

    public int getTemper()
    {
        return this.temper;
    }

    public void setTemper(int p_110238_1_)
    {
        this.temper = p_110238_1_;
    }

    public int increaseTemper(int p_110198_1_)
    {
        int j = MathHelper.clamp_int(this.getTemper() + p_110198_1_, 0, this.getMaxTemper());
        this.setTemper(j);
        return j;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        Entity entity = source.getEntity();
        return this.riddenByEntity != null && this.riddenByEntity.equals(entity) ? false : super.attackEntityFrom(source, amount);
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return this.riddenByEntity == null;
    }

    public boolean prepareChunkForSpawn()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posZ);
        this.worldObj.getBiomeGenForCoords(new BlockPos(i, 0, j));
        return true;
    }

    public void dropChests()
    {
        if (!this.worldObj.isRemote && this.isChested())
        {
            this.dropItem(Item.getItemFromBlock(Blocks.chest), 1);
            this.setChested(false);
        }
    }

    private void func_110266_cB()
    {
        this.openBroomMouth();

        if (!this.isSilent())
        {
            this.worldObj.playSoundAtEntity(this, "eating", 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
        }
    }

    public void fall(float distance, float damageMultiplier)
    {
        if (distance > 1.0F)
        {
            this.playSound("mob.broom.land", 0.4F, 1.0F);
        }

        int i = MathHelper.ceiling_float_int((distance * 0.5F - 3.0F) * damageMultiplier);

        if (i > 0)
        {
            this.attackEntityFrom(DamageSource.fall, (float)i);

            if (this.riddenByEntity != null)
            {
                this.riddenByEntity.attackEntityFrom(DamageSource.fall, (float)i);
            }

            Block block = this.worldObj.getBlockState(new BlockPos(this.posX, this.posY - 0.2D - (double)this.prevRotationYaw, this.posZ)).getBlock();

            if (block.getMaterial() != Material.air && !this.isSilent())
            {
                Block.SoundType soundtype = block.stepSound;
                this.worldObj.playSoundAtEntity(this, soundtype.getStepSound(), soundtype.getVolume() * 0.5F, soundtype.getFrequency() * 0.75F);
            }
        }
    }

    private int func_110225_cC()
    {
        int i = this.getBroomType();
        return this.isChested() && (i == 1 || i == 2) ? 17 : 2;
    }

    private void func_110226_cD()
    {
        AnimalChest animalchest = this.broomChest;
        this.broomChest = new AnimalChest("BroomChest", this.func_110225_cC());
        this.broomChest.setCustomName(this.getName());

        if (animalchest != null)
        {
            animalchest.func_110132_b(this);
            int i = Math.min(animalchest.getSizeInventory(), this.broomChest.getSizeInventory());

            for (int j = 0; j < i; ++j)
            {
                ItemStack itemstack = animalchest.getStackInSlot(j);

                if (itemstack != null)
                {
                    this.broomChest.setInventorySlotContents(j, itemstack.copy());
                }
            }
        }

        this.broomChest.func_110134_a(this);
    }

    /**
     * Called by InventoryBasic.onInventoryChanged() on a array that is never filled.
     */
    public void onInventoryChanged(InventoryBasic p_76316_1_)
    {
        int i = this.func_110241_cb();
        boolean flag = this.isBroomSaddled();
      
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        this.prepareChunkForSpawn();
        return super.getCanSpawnHere();
    }

    protected EntityBroom getClosestBroom(Entity p_110250_1_, double p_110250_2_)
    {
        double d1 = Double.MAX_VALUE;
        Entity entity1 = null;
        List list = this.worldObj.func_175674_a(p_110250_1_, p_110250_1_.getEntityBoundingBox().addCoord(p_110250_2_, p_110250_2_, p_110250_2_), broomBreedingSelector);
        Iterator iterator = list.iterator();

        while (iterator.hasNext())
        {
            Entity entity2 = (Entity)iterator.next();
            double d2 = entity2.getDistanceSq(p_110250_1_.posX, p_110250_1_.posY, p_110250_1_.posZ);

            if (d2 < d1)
            {
                entity1 = entity2;
                d1 = d2;
            }
        }

        return (EntityBroom)entity1;
    }

    public double getBroomJumpStrength()
    {
        return this.getEntityAttribute(broomJumpStrength).getAttributeValue();
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        this.openBroomMouth();
        int i = this.getBroomType();
        return i == 3 ? "mob.broom.zombie.death" : (i == 4 ? "mob.broom.skeleton.death" : (i != 1 && i != 2 ? "mob.broom.death" : "mob.broom.donkey.death"));
    }

    protected Item getDropItem()
    {
        boolean flag = this.rand.nextInt(4) == 0;
        int i = this.getBroomType();
        return i == 4 ? Items.bone : (i == 3 ? (flag ? null : Items.rotten_flesh) : Items.leather);
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        this.openBroomMouth();

        if (this.rand.nextInt(3) == 0)
        {
            this.makeBroomRear();
        }

        int i = this.getBroomType();
        return i == 3 ? "mob.broom.zombie.hit" : (i == 4 ? "mob.broom.skeleton.hit" : (i != 1 && i != 2 ? "mob.broom.hit" : "mob.broom.donkey.hit"));
    }

    public boolean isBroomSaddled()
    {
        return this.getBroomWatchableBoolean(4);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        this.openBroomMouth();

        if (this.rand.nextInt(10) == 0 && !this.isMovementBlocked())
        {
            this.makeBroomRear();
        }

        int i = this.getBroomType();
        return i == 3 ? "mob.broom.zombie.idle" : (i == 4 ? "mob.broom.skeleton.idle" : (i != 1 && i != 2 ? "mob.broom.idle" : "mob.broom.donkey.idle"));
    }

    protected String getAngrySoundName()
    {
        this.openBroomMouth();
        this.makeBroomRear();
        int i = this.getBroomType();
        return i != 3 && i != 4 ? (i != 1 && i != 2 ? "mob.broom.angry" : "mob.broom.donkey.angry") : null;
    }

    protected void playStepSound(BlockPos p_180429_1_, Block p_180429_2_)
    {
        Block.SoundType soundtype = p_180429_2_.stepSound;

        if (this.worldObj.getBlockState(p_180429_1_.up()).getBlock() == Blocks.snow_layer)
        {
            soundtype = Blocks.snow_layer.stepSound;
        }

        if (!p_180429_2_.getMaterial().isLiquid())
        {
            int i = this.getBroomType();

            if (this.riddenByEntity != null && i != 1 && i != 2)
            {
                ++this.gallopTime;

                if (this.gallopTime > 5 && this.gallopTime % 3 == 0)
                {
                    this.playSound("mob.broom.gallop", soundtype.getVolume() * 0.15F, soundtype.getFrequency());

                    if (i == 0 && this.rand.nextInt(10) == 0)
                    {
                        this.playSound("mob.broom.breathe", soundtype.getVolume() * 0.6F, soundtype.getFrequency());
                    }
                }
                else if (this.gallopTime <= 5)
                {
                    this.playSound("mob.broom.wood", soundtype.getVolume() * 0.15F, soundtype.getFrequency());
                }
            }
            else if (soundtype == Block.soundTypeWood)
            {
                this.playSound("mob.broom.wood", soundtype.getVolume() * 0.15F, soundtype.getFrequency());
            }
            else
            {
                this.playSound("mob.broom.soft", soundtype.getVolume() * 0.15F, soundtype.getFrequency());
            }
        }
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(broomJumpStrength);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(53.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22499999403953552D);
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 6;
    }

    public int getMaxTemper()
    {
        return 100;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.8F;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return 400;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_110239_cn()
    {
        return this.getBroomType() == 0 || this.func_110241_cb() > 0;
    }

    private void resetTexturePrefix()
    {
        this.texturePrefix = null;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_175507_cI()
    {
        return this.field_175508_bO;
    }

    @SideOnly(Side.CLIENT)
    private void setBroomTexturePaths()
    {
        this.texturePrefix = "broom/";
        this.field_110280_bR[0] = null;
        this.field_110280_bR[1] = null;
        this.field_110280_bR[2] = null;
        int i = this.getBroomType();
        int j = this.getBroomVariant();
        int k;

        if (i == 0)
        {
            k = j & 255;
            int l = (j & 65280) >> 8;

            if (k >= broomTextures.length)
            {
                this.field_175508_bO = false;
                return;
            }

            this.field_110280_bR[0] = broomTextures[k];
            this.texturePrefix = this.texturePrefix + broomTextureString[k];

            if (l >= broomMarkingTextures.length)
            {
                this.field_175508_bO = false;
                return;
            }

            this.field_110280_bR[1] = broomMarkingTextures[l];
            this.texturePrefix = this.texturePrefix + broomMarkingTextureSTring[l];
        }
        else
        {
            this.field_110280_bR[0] = "";
            this.texturePrefix = this.texturePrefix + "_" + i + "_";
        }

        k = this.func_110241_cb();

            this.texturePrefix = this.texturePrefix + field_110273_bx[k];
            this.field_175508_bO = true;
    }

    @SideOnly(Side.CLIENT)
    public String getBroomTexture()
    {
        if (this.texturePrefix == null)
        {
            this.setBroomTexturePaths();
        }

        return this.texturePrefix;
    }

    @SideOnly(Side.CLIENT)
    public String[] getVariantTexturePaths()
    {
        if (this.texturePrefix == null)
        {
            this.setBroomTexturePaths();
        }

        return this.field_110280_bR;
    }

    public void openGUI(EntityQuidditchPlayer playerEntity)
    {
        if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == playerEntity) && this.isTame())
        {
            this.broomChest.setCustomName(this.getName());
            playerEntity.displayGUIBroom(this, this.broomChest);
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityQuidditchPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() == Items.spawn_egg)
        {
            return super.interact(player);
        }
        else if (!this.isTame() && this.isUndead())
        {
            return false;
        }
        else if (this.isTame()  && player.isSneaking())
        {
            this.openGUI(player);
            return true;
        }
        else if ( this.riddenByEntity != null)
        {
            return super.interact(player);
        }
        else
        {
            if (itemstack != null)
            {
                boolean flag = false;

                if (this.canWearArmor())
                {
                    byte b0 = -1;

//                    if (itemstack.getItem() == Items.iron_broom_armor)
//                    {
//                        b0 = 1;
//                    }
//                    else if (itemstack.getItem() == Items.golden_broom_armor)
//                    {
//                        b0 = 2;
//                    }
//                    else if (itemstack.getItem() == Items.diamond_broom_armor)
//                    {
//                        b0 = 3;
//                    }

                    if (b0 >= 0)
                    {
                        if (!this.isTame())
                        {
                            this.makeBroomRearWithSound();
                            return true;
                        }

                        this.openGUI(player);
                        return true;
                    }
                }

                if (!flag && !this.isUndead())
                {
                    float f = 0.0F;
                    short short1 = 0;
                    byte b1 = 0;

                    if (itemstack.getItem() == Items.wheat)
                    {
                        f = 2.0F;
                        short1 = 20;
                        b1 = 3;
                    }
                    else if (itemstack.getItem() == Items.sugar)
                    {
                        f = 1.0F;
                        short1 = 30;
                        b1 = 3;
                    }
                    else if (Block.getBlockFromItem(itemstack.getItem()) == Blocks.hay_block)
                    {
                        f = 20.0F;
                        short1 = 180;
                    }
                    else if (itemstack.getItem() == Items.apple)
                    {
                        f = 3.0F;
                        short1 = 60;
                        b1 = 3;
                    }
                    else if (itemstack.getItem() == Items.golden_carrot)
                    {
                        f = 4.0F;
                        short1 = 60;
                        b1 = 5;

                        if (this.isTame() && this.getGrowingAge() == 0)
                        {
                            flag = true;
                            this.setInLove(player);
                        }
                    }
                    else if (itemstack.getItem() == Items.golden_apple)
                    {
                        f = 10.0F;
                        short1 = 240;
                        b1 = 10;

                        if (this.isTame() && this.getGrowingAge() == 0)
                        {
                            flag = true;
                            this.setInLove(player);
                        }
                    }

                    if (this.getHealth() < this.getMaxHealth() && f > 0.0F)
                    {
                        this.heal(f);
                        flag = true;
                    }

                    if ( short1 > 0)
                    {
                        this.addGrowth(short1);
                        flag = true;
                    }

                    if (b1 > 0 && (flag || !this.isTame()) && b1 < this.getMaxTemper())
                    {
                        flag = true;
                        this.increaseTemper(b1);
                    }

                    if (flag)
                    {
                        this.func_110266_cB();
                    }
                }

                if (!this.isTame() && !flag)
                {
                    if (itemstack != null && itemstack.interactWithEntity(player, this))
                    {
                        return true;
                    }

                    this.makeBroomRearWithSound();
                    return true;
                }

                if (!flag && this.canCarryChest() && !this.isChested() && itemstack.getItem() == Item.getItemFromBlock(Blocks.chest))
                {
                    this.setChested(true);
                    this.playSound("mob.chickenplop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                    flag = true;
                    this.func_110226_cD();
                }

                if (!flag && !this.isBroomSaddled() && itemstack.getItem() == Items.saddle)
                {
                    this.openGUI(player);
                    return true;
                }

                if (flag)
                {
                    if (!player.capabilities.isCreativeMode && --itemstack.stackSize == 0)
                    {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                    }

                    return true;
                }
            }

            if ( this.riddenByEntity == null)
            {
                if (itemstack != null && itemstack.interactWithEntity(player, this))
                {
                    return true;
                }
                else
                {
                    this.func_110237_h(player);
                    return true;
                }
            }
            else
            {
                return super.interact(player);
            }
        }
    }

    private void func_110237_h(EntityPlayer p_110237_1_)
    {
        p_110237_1_.rotationYaw = this.rotationYaw;
        p_110237_1_.rotationPitch = this.rotationPitch;
        this.setEatingHaystack(false);
        this.setRearing(false);

        if (!this.worldObj.isRemote)
        {
            p_110237_1_.mountEntity(this);
        }
    }

    /**
     * Return true if the broom entity can wear an armor
     */
    public boolean canWearArmor()
    {
        return this.getBroomType() == 0;
    }

    /**
     * Return true if the broom entity can carry a chest.
     */
    public boolean canCarryChest()
    {
        int i = this.getBroomType();
        return i == 2 || i == 1;
    }

    /**
     * Dead and sleeping entities cannot move
     */
    protected boolean isMovementBlocked()
    {
        return this.riddenByEntity != null && this.isBroomSaddled() ? true : this.isEatingHaystack() || this.isRearing();
    }

    /**
     * Used to know if the broom can be leashed, if he can mate, or if we can interact with him
     */
    public boolean isUndead()
    {
        int i = this.getBroomType();
        return i == 3 || i == 4;
    }

    /**
     * Return true if the broom entity is sterile (Undead || Mule)
     */
    public boolean isSterile()
    {
        return this.isUndead() || this.getBroomType() == 2;
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack)
    {
        return false;
    }

    private void func_110210_cH()
    {
        this.field_110278_bp = 1;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);

        if (!this.worldObj.isRemote)
        {
            this.dropChestItems();
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.rand.nextInt(200) == 0)
        {
            this.func_110210_cH();
        }

        super.onLivingUpdate();

        if (!this.worldObj.isRemote)
        {
            if (this.rand.nextInt(900) == 0 && this.deathTime == 0)
            {
                this.heal(1.0F);
            }

            if (!this.isEatingHaystack() && this.riddenByEntity == null && this.rand.nextInt(300) == 0 && this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) - 1, MathHelper.floor_double(this.posZ))).getBlock() == Blocks.grass)
            {
                this.setEatingHaystack(true);
            }

            if (this.isEatingHaystack() && ++this.eatingHaystackCounter > 50)
            {
                this.eatingHaystackCounter = 0;
                this.setEatingHaystack(false);
            }

            if (this.func_110205_ce() && !this.isEatingHaystack())
            {
                EntityBroom entitybroom = this.getClosestBroom(this, 16.0D);

                if (entitybroom != null && this.getDistanceSqToEntity(entitybroom) > 4.0D)
                {
                    this.navigator.getPathToEntityLiving(entitybroom);
                }
            }
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.worldObj.isRemote && this.dataWatcher.hasObjectChanged())
        {
            this.dataWatcher.func_111144_e();
            this.resetTexturePrefix();
        }

        if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30)
        {
            this.openMouthCounter = 0;
            this.setBroomWatchableBoolean(128, false);
        }

        if (!this.worldObj.isRemote && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20)
        {
            this.jumpRearingCounter = 0;
            this.setRearing(false);
        }

        if (this.field_110278_bp > 0 && ++this.field_110278_bp > 8)
        {
            this.field_110278_bp = 0;
        }

        if (this.field_110279_bq > 0)
        {
            ++this.field_110279_bq;

            if (this.field_110279_bq > 300)
            {
                this.field_110279_bq = 0;
            }
        }

    }

    private void openBroomMouth()
    {
        if (!this.worldObj.isRemote)
        {
            this.openMouthCounter = 1;
            this.setBroomWatchableBoolean(128, true);
        }
    }

    /**
     * Return true if the broom entity ready to mate. (no rider, not riding, tame, adult, not steril...)
     */
    private boolean canMate()
    {
        return this.riddenByEntity == null && this.ridingEntity == null && this.isTame() && !this.isSterile() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    public void setEating(boolean eating)
    {
        this.setBroomWatchableBoolean(32, eating);
    }

    public void setEatingHaystack(boolean p_110227_1_)
    {
        this.setEating(p_110227_1_);
    }

    public void setRearing(boolean p_110219_1_)
    {
        if (p_110219_1_)
        {
            this.setEatingHaystack(false);
        }

        this.setBroomWatchableBoolean(64, p_110219_1_);
    }

    private void makeBroomRear()
    {
        if (!this.worldObj.isRemote)
        {
            this.jumpRearingCounter = 1;
            this.setRearing(true);
        }
    }

    public void makeBroomRearWithSound()
    {
        this.makeBroomRear();
        String s = this.getAngrySoundName();

        if (s != null)
        {
            this.playSound(s, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    public void dropChestItems()
    {
        this.dropItemsInChest(this, this.broomChest);
        this.dropChests();
    }

    private void dropItemsInChest(Entity p_110240_1_, AnimalChest p_110240_2_)
    {
        if (p_110240_2_ != null && !this.worldObj.isRemote)
        {
            for (int i = 0; i < p_110240_2_.getSizeInventory(); ++i)
            {
                ItemStack itemstack = p_110240_2_.getStackInSlot(i);

                if (itemstack != null)
                {
                    this.entityDropItem(itemstack, 0.0F);
                }
            }
        }
    }

    public boolean setTamedBy(EntityPlayer p_110263_1_)
    {
        this.func_152120_b(p_110263_1_.getUniqueID().toString());
        this.setBroomTamed(true);
        return true;
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase && this.isBroomSaddled())
        {
            this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
            p_70612_1_ = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
            p_70612_2_ = ((EntityLivingBase)this.riddenByEntity).moveForward;

            if (p_70612_2_ <= 0.0F)
            {
                p_70612_2_ *= 0.25F;
                this.gallopTime = 0;
            }

            if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.field_110294_bI)
            {
                p_70612_1_ = 0.0F;
                p_70612_2_ = 0.0F;
            }

            if (this.jumpPower > 0.0F && !this.isBroomJumping() && this.onGround)
            {
                this.motionY = this.getBroomJumpStrength() * (double)this.jumpPower;

                if (this.isPotionActive(Potion.jump))
                {
                    this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
                }

                this.setBroomJumping(true);
                this.isAirBorne = true;

                if (p_70612_2_ > 0.0F)
                {
                    float f2 = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F);
                    float f3 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F);
                    this.motionX += (double)(-0.4F * f2 * this.jumpPower);
                    this.motionZ += (double)(0.4F * f3 * this.jumpPower);
                    this.playSound("mob.broom.jump", 0.4F, 1.0F);
                }

                this.jumpPower = 0.0F;
                net.minecraftforge.common.ForgeHooks.onLivingJump(this);
            }

            this.stepHeight = 1.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (!this.worldObj.isRemote)
            {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
            }

            if (this.onGround)
            {
                this.jumpPower = 0.0F;
                this.setBroomJumping(false);
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f4 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;

            if (f4 > 1.0F)
            {
                f4 = 1.0F;
            }

            this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
        else
        {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("EatingHaystack", this.isEatingHaystack());
        tagCompound.setBoolean("ChestedBroom", this.isChested());
        tagCompound.setBoolean("Bred", this.func_110205_ce());
        tagCompound.setInteger("Type", this.getBroomType());
        tagCompound.setInteger("Variant", this.getBroomVariant());
        tagCompound.setInteger("Temper", this.getTemper());
        tagCompound.setBoolean("Tame", this.isTame());
        tagCompound.setString("OwnerUUID", this.func_152119_ch());

        if (this.isChested())
        {
            NBTTagList nbttaglist = new NBTTagList();

            for (int i = 2; i < this.broomChest.getSizeInventory(); ++i)
            {
                ItemStack itemstack = this.broomChest.getStackInSlot(i);

                if (itemstack != null)
                {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                    nbttagcompound1.setByte("Slot", (byte)i);
                    itemstack.writeToNBT(nbttagcompound1);
                    nbttaglist.appendTag(nbttagcompound1);
                }
            }

            tagCompound.setTag("Items", nbttaglist);
        }

        if (this.broomChest.getStackInSlot(1) != null)
        {
            tagCompound.setTag("ArmorItem", this.broomChest.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
        }

        if (this.broomChest.getStackInSlot(0) != null)
        {
            tagCompound.setTag("SaddleItem", this.broomChest.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        this.setEatingHaystack(tagCompund.getBoolean("EatingHaystack"));
        this.func_110242_l(tagCompund.getBoolean("Bred"));
        this.setChested(tagCompund.getBoolean("ChestedBroom"));
        this.setBroomType(tagCompund.getInteger("Type"));
        this.setBroomVariant(tagCompund.getInteger("Variant"));
        this.setTemper(tagCompund.getInteger("Temper"));
        this.setBroomTamed(tagCompund.getBoolean("Tame"));
        String s = "";

        if (tagCompund.hasKey("OwnerUUID", 8))
        {
            s = tagCompund.getString("OwnerUUID");
        }
        else
        {
            String s1 = tagCompund.getString("Owner");
            s = PreYggdrasilConverter.func_152719_a(s1);
        }

        if (s.length() > 0)
        {
            this.func_152120_b(s);
        }

        IAttributeInstance iattributeinstance = this.getAttributeMap().getAttributeInstanceByName("Speed");

        if (iattributeinstance != null)
        {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(iattributeinstance.getBaseValue() * 0.25D);
        }

        if (this.isChested())
        {
            NBTTagList nbttaglist = tagCompund.getTagList("Items", 10);
            this.func_110226_cD();

            for (int i = 0; i < nbttaglist.tagCount(); ++i)
            {
                NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
                int j = nbttagcompound1.getByte("Slot") & 255;

                if (j >= 2 && j < this.broomChest.getSizeInventory())
                {
                    this.broomChest.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
                }
            }
        }

        ItemStack itemstack;

        if (tagCompund.hasKey("ArmorItem", 10))
        {
            itemstack = ItemStack.loadItemStackFromNBT(tagCompund.getCompoundTag("ArmorItem"));

//            if (itemstack != null && func_146085_a(itemstack.getItem()))
//            {
//                this.broomChest.setInventorySlotContents(1, itemstack);
//            }
        }

        if (tagCompund.hasKey("SaddleItem", 10))
        {
            itemstack = ItemStack.loadItemStackFromNBT(tagCompund.getCompoundTag("SaddleItem"));

            if (itemstack != null && itemstack.getItem() == Items.saddle)
            {
                this.broomChest.setInventorySlotContents(0, itemstack);
            }
        }
        else if (tagCompund.getBoolean("Saddle"))
        {
            this.broomChest.setInventorySlotContents(0, new ItemStack(Items.saddle));
        }
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal otherAnimal)
    {
        if (otherAnimal == this)
        {
            return false;
        }
        else if (otherAnimal.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            EntityBroom entitybroom = (EntityBroom)otherAnimal;

            if (this.canMate() && entitybroom.canMate())
            {
                int i = this.getBroomType();
                int j = entitybroom.getBroomType();
                return i == j || i == 0 && j == 1 || i == 1 && j == 0;
            }
            else
            {
                return false;
            }
        }
    }

    public EntityAgeable createChild(EntityAgeable ageable)
    {
        EntityBroom entitybroom = (EntityBroom)ageable;
        EntityBroom entitybroom1 = new EntityBroom(this.worldObj);
        int i = this.getBroomType();
        int j = entitybroom.getBroomType();
        int k = 0;

        if (i == j)
        {
            k = i;
        }
        else if (i == 0 && j == 1 || i == 1 && j == 0)
        {
            k = 2;
        }

        if (k == 0)
        {
            int i1 = this.rand.nextInt(9);
            int l;

            if (i1 < 4)
            {
                l = this.getBroomVariant() & 255;
            }
            else if (i1 < 8)
            {
                l = entitybroom.getBroomVariant() & 255;
            }
            else
            {
                l = this.rand.nextInt(7);
            }

            int j1 = this.rand.nextInt(5);

            if (j1 < 2)
            {
                l |= this.getBroomVariant() & 65280;
            }
            else if (j1 < 4)
            {
                l |= entitybroom.getBroomVariant() & 65280;
            }
            else
            {
                l |= this.rand.nextInt(5) << 8 & 65280;
            }

            entitybroom1.setBroomVariant(l);
        }

        entitybroom1.setBroomType(k);
        double d1 = this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + ageable.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (double)this.func_110267_cL();
        entitybroom1.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d1 / 3.0D);
        double d2 = this.getEntityAttribute(broomJumpStrength).getBaseValue() + ageable.getEntityAttribute(broomJumpStrength).getBaseValue() + this.func_110245_cM();
        entitybroom1.getEntityAttribute(broomJumpStrength).setBaseValue(d2 / 3.0D);
        double d0 = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + ageable.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + this.func_110203_cN();
        entitybroom1.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d0 / 3.0D);
        return entitybroom1;
    }

    public IEntityLivingData func_180482_a(DifficultyInstance p_180482_1_, IEntityLivingData p_180482_2_)
    {
        Object p_180482_2_1 = super.func_180482_a(p_180482_1_, p_180482_2_);
        boolean flag = false;
        int i = 0;
        int l;

        if (p_180482_2_1 instanceof EntityBroom.GroupData)
        {
            l = ((EntityBroom.GroupData)p_180482_2_1).field_111107_a;
            i = ((EntityBroom.GroupData)p_180482_2_1).field_111106_b & 255 | this.rand.nextInt(5) << 8;
        }
        else
        {
            if (this.rand.nextInt(10) == 0)
            {
                l = 1;
            }
            else
            {
                int j = this.rand.nextInt(7);
                int k = this.rand.nextInt(5);
                l = 0;
                i = j | k << 8;
            }

            p_180482_2_1 = new EntityBroom.GroupData(l, i);
        }

        this.setBroomType(l);
        this.setBroomVariant(i);

        if (this.rand.nextInt(5) == 0)
        {
            this.setGrowingAge(-24000);
        }

        if (l != 4 && l != 3)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.func_110267_cL());

            if (l == 0)
            {
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.func_110203_cN());
            }
            else
            {
                this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.17499999701976776D);
            }
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
        }

        if (l != 2 && l != 1)
        {
            this.getEntityAttribute(broomJumpStrength).setBaseValue(this.func_110245_cM());
        }
        else
        {
            this.getEntityAttribute(broomJumpStrength).setBaseValue(0.5D);
        }

        this.setHealth(this.getMaxHealth());
        return (IEntityLivingData)p_180482_2_1;
    }

    public void setJumpPower(int p_110206_1_)
    {
        if (this.isBroomSaddled())
        {
            if (p_110206_1_ < 0)
            {
                p_110206_1_ = 0;
            }
            else
            {
                this.field_110294_bI = true;
                this.makeBroomRear();
            }

            if (p_110206_1_ >= 90)
            {
                this.jumpPower = 1.0F;
            }
            else
            {
                this.jumpPower = 0.4F + 0.4F * (float)p_110206_1_ / 90.0F;
            }
        }
    }

    /**
     * "Spawns particles for the broom entity. par1 tells whether to spawn hearts. If it is false, it spawns smoke."
     */
    @SideOnly(Side.CLIENT)
    protected void spawnBroomParticles(boolean p_110216_1_)
    {
        EnumParticleTypes enumparticletypes = p_110216_1_ ? EnumParticleTypes.HEART : EnumParticleTypes.SMOKE_NORMAL;

        for (int i = 0; i < 7; ++i)
        {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(enumparticletypes, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2, new int[0]);
        }
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_)
    {
        if (p_70103_1_ == 7)
        {
            this.spawnBroomParticles(true);
        }
        else if (p_70103_1_ == 6)
        {
            this.spawnBroomParticles(false);
        }
        else
        {
            super.handleHealthUpdate(p_70103_1_);
        }
    }

    public void updateRiderPosition()
    {
        super.updateRiderPosition();
    }

    private float func_110267_cL()
    {
        return 15.0F + (float)this.rand.nextInt(8) + (float)this.rand.nextInt(9);
    }

    private double func_110245_cM()
    {
        return 0.4000000059604645D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D;
    }

    private double func_110203_cN()
    {
        return (0.44999998807907104D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D) * 0.25D;
    }

//    public static boolean func_146085_a(Item p_146085_0_)
//    {
//        return p_146085_0_ == Items.iron_broom_armor || p_146085_0_ == Items.golden_broom_armor || p_146085_0_ == Items.diamond_broom_armor;
//    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    public boolean isOnLadder()
    {
        return false;
    }

    public float getEyeHeight()
    {
        return this.height;
    }

    public boolean replaceItemInInventory(int p_174820_1_, ItemStack p_174820_2_)
    {
        if (p_174820_1_ == 499 && this.canCarryChest())
        {
            if (p_174820_2_ == null && this.isChested())
            {
                this.setChested(false);
                this.func_110226_cD();
                return true;
            }

            if (p_174820_2_ != null && p_174820_2_.getItem() == Item.getItemFromBlock(Blocks.chest) && !this.isChested())
            {
                this.setChested(true);
                this.func_110226_cD();
                return true;
            }
        }

        int j = p_174820_1_ - 400;

        if (j >= 0 && j < 2 && j < this.broomChest.getSizeInventory())
        {
            if (j == 0 && p_174820_2_ != null && p_174820_2_.getItem() != Items.saddle)
            {
                return false;
            }
//            else if (j == 1 && (p_174820_2_ != null && !func_146085_a(p_174820_2_.getItem()) || !this.canWearArmor()))
//            {
//                return false;
//            }
            else
            {
                this.broomChest.setInventorySlotContents(j, p_174820_2_);
                return true;
            }
        }
        else
        {
            int k = p_174820_1_ - 500 + 2;

            if (k >= 2 && k < this.broomChest.getSizeInventory())
            {
                this.broomChest.setInventorySlotContents(k, p_174820_2_);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public static class GroupData implements IEntityLivingData
        {
            public int field_111107_a;
            public int field_111106_b;
            private static final String __OBFID = "CL_00001643";

            public GroupData(int p_i1684_1_, int p_i1684_2_)
            {
                this.field_111107_a = p_i1684_1_;
                this.field_111106_b = p_i1684_2_;
            }
        }
}