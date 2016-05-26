package com.naxder.naxdermod.client.renderer.entity;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Maps;
import com.naxder.naxdermod.client.model.ModelBroom;
import com.naxder.naxdermod.entity.passive.EntityBroom;

@SideOnly(Side.CLIENT)
public class RenderBroom extends RenderLiving
{
    private static final Map field_110852_a = Maps.newHashMap();
    private static final ResourceLocation whiteBroomTextures = new ResourceLocation("textures/entity/broom/broom_white.png");
    private static final ResourceLocation muleTextures = new ResourceLocation("textures/entity/broom/mule.png");
    private static final ResourceLocation donkeyTextures = new ResourceLocation("textures/entity/broom/donkey.png");
    private static final ResourceLocation zombieBroomTextures = new ResourceLocation("textures/entity/broom/broom_zombie.png");
    private static final ResourceLocation skeletonBroomTextures = new ResourceLocation("textures/entity/broom/broom_skeleton.png");
    private static final String __OBFID = "CL_00001000";

    public RenderBroom(RenderManager p_i46170_1_, ModelBroom p_i46170_2_, float p_i46170_3_)
    {
        super(p_i46170_1_, p_i46170_2_, p_i46170_3_);
    }

    protected void func_180580_a(EntityBroom p_180580_1_, float p_180580_2_)
    {
        float f1 = 1.0F;
        int i = p_180580_1_.getBroomType();

        if (i == 1)
        {
            f1 *= 0.87F;
        }
        else if (i == 2)
        {
            f1 *= 0.92F;
        }

        GlStateManager.scale(f1, f1, f1);
        super.preRenderCallback(p_180580_1_, p_180580_2_);
    }

    protected ResourceLocation func_180581_a(EntityBroom p_180581_1_)
    {
        if (!p_180581_1_.func_110239_cn())
        {
            switch (p_180581_1_.getBroomType())
            {
                case 0:
                default:
                    return whiteBroomTextures;
                case 1:
                    return donkeyTextures;
                case 2:
                    return muleTextures;
                case 3:
                    return zombieBroomTextures;
                case 4:
                    return skeletonBroomTextures;
            }
        }
        else
        {
            return this.func_110848_b(p_180581_1_);
        }
    }

    private ResourceLocation func_110848_b(EntityBroom p_110848_1_)
    {
        String s = p_110848_1_.getBroomTexture();

        if (!p_110848_1_.func_175507_cI())
        {
            return null;
        }
        else
        {
            ResourceLocation resourcelocation = (ResourceLocation)field_110852_a.get(s);

            if (resourcelocation == null)
            {
                resourcelocation = new ResourceLocation(s);
                Minecraft.getMinecraft().getTextureManager().loadTexture(resourcelocation, new LayeredTexture(p_110848_1_.getVariantTexturePaths()));
                field_110852_a.put(s, resourcelocation);
            }

            return resourcelocation;
        }
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.func_180580_a((EntityBroom)p_77041_1_, p_77041_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.func_180581_a((EntityBroom)entity);
    }
}