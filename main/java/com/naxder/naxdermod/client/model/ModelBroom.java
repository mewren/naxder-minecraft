package com.naxder.naxdermod.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.naxder.naxdermod.entity.passive.EntityBroom;

@SideOnly(Side.CLIENT)
public class ModelBroom extends ModelBase
{
    private ModelRenderer head;
    private ModelRenderer field_178711_b;
    private ModelRenderer field_178712_c;
    private ModelRenderer broomLeftEar;
    private ModelRenderer broomRightEar;
    /** The left ear box for the mule model. */
    private ModelRenderer muleLeftEar;
    /** The right ear box for the mule model. */
    private ModelRenderer muleRightEar;
    private ModelRenderer neck;
    /** The box for the broom's ropes on its face. */
    private ModelRenderer broomFaceRopes;
    private ModelRenderer mane;
    private ModelRenderer body;
    private ModelRenderer tailBase;
    private ModelRenderer tailMiddle;
    private ModelRenderer tailTip;
    private ModelRenderer backLeftLeg;
    private ModelRenderer backLeftShin;
    private ModelRenderer backLeftHoof;
    private ModelRenderer backRightLeg;
    private ModelRenderer backRightShin;
    private ModelRenderer backRightHoof;
    private ModelRenderer frontLeftLeg;
    private ModelRenderer frontLeftShin;
    private ModelRenderer frontLeftHoof;
    private ModelRenderer frontRightLeg;
    private ModelRenderer frontRightShin;
    private ModelRenderer frontRightHoof;
    /** The left chest box on the mule model. */
    private ModelRenderer muleLeftChest;
    /** The right chest box on the mule model. */
    private ModelRenderer muleRightChest;
    private ModelRenderer broomSaddleBottom;
    private ModelRenderer broomSaddleFront;
    private ModelRenderer broomSaddleBack;
    private ModelRenderer broomLeftSaddleRope;
    private ModelRenderer broomLeftSaddleMetal;
    private ModelRenderer broomRightSaddleRope;
    private ModelRenderer broomRightSaddleMetal;
    /** The left metal connected to the broom's face ropes. */
    private ModelRenderer broomLeftFaceMetal;
    /** The right metal connected to the broom's face ropes. */
    private ModelRenderer broomRightFaceMetal;
    private ModelRenderer broomLeftRein;
    private ModelRenderer broomRightRein;
    private static final String __OBFID = "CL_00000846";

    public ModelBroom()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new ModelRenderer(this, 0, 34);
        this.body.addBox(-5.0F, -8.0F, -19.0F, 10, 10, 24);
        this.body.setRotationPoint(0.0F, 11.0F, 9.0F);
        this.tailBase = new ModelRenderer(this, 44, 0);
        this.tailBase.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3);
        this.tailBase.setRotationPoint(0.0F, 3.0F, 14.0F);
        this.setBoxRotation(this.tailBase, -1.134464F, 0.0F, 0.0F);
        this.tailMiddle = new ModelRenderer(this, 38, 7);
        this.tailMiddle.addBox(-1.5F, -2.0F, 3.0F, 3, 4, 7);
        this.tailMiddle.setRotationPoint(0.0F, 3.0F, 14.0F);
        this.setBoxRotation(this.tailMiddle, -1.134464F, 0.0F, 0.0F);
        this.tailTip = new ModelRenderer(this, 24, 3);
        this.tailTip.addBox(-1.5F, -4.5F, 9.0F, 3, 4, 7);
        this.tailTip.setRotationPoint(0.0F, 3.0F, 14.0F);
        this.setBoxRotation(this.tailTip, -1.40215F, 0.0F, 0.0F);
        this.backLeftLeg = new ModelRenderer(this, 78, 29);
        this.backLeftLeg.addBox(-2.5F, -2.0F, -2.5F, 4, 9, 5);
        this.backLeftLeg.setRotationPoint(4.0F, 9.0F, 11.0F);
        this.backLeftShin = new ModelRenderer(this, 78, 43);
        this.backLeftShin.addBox(-2.0F, 0.0F, -1.5F, 3, 5, 3);
        this.backLeftShin.setRotationPoint(4.0F, 16.0F, 11.0F);
        this.backLeftHoof = new ModelRenderer(this, 78, 51);
        this.backLeftHoof.addBox(-2.5F, 5.1F, -2.0F, 4, 3, 4);
        this.backLeftHoof.setRotationPoint(4.0F, 16.0F, 11.0F);
        this.backRightLeg = new ModelRenderer(this, 96, 29);
        this.backRightLeg.addBox(-1.5F, -2.0F, -2.5F, 4, 9, 5);
        this.backRightLeg.setRotationPoint(-4.0F, 9.0F, 11.0F);
        this.backRightShin = new ModelRenderer(this, 96, 43);
        this.backRightShin.addBox(-1.0F, 0.0F, -1.5F, 3, 5, 3);
        this.backRightShin.setRotationPoint(-4.0F, 16.0F, 11.0F);
        this.backRightHoof = new ModelRenderer(this, 96, 51);
        this.backRightHoof.addBox(-1.5F, 5.1F, -2.0F, 4, 3, 4);
        this.backRightHoof.setRotationPoint(-4.0F, 16.0F, 11.0F);
        this.frontLeftLeg = new ModelRenderer(this, 44, 29);
        this.frontLeftLeg.addBox(-1.9F, -1.0F, -2.1F, 3, 8, 4);
        this.frontLeftLeg.setRotationPoint(4.0F, 9.0F, -8.0F);
        this.frontLeftShin = new ModelRenderer(this, 44, 41);
        this.frontLeftShin.addBox(-1.9F, 0.0F, -1.6F, 3, 5, 3);
        this.frontLeftShin.setRotationPoint(4.0F, 16.0F, -8.0F);
        this.frontLeftHoof = new ModelRenderer(this, 44, 51);
        this.frontLeftHoof.addBox(-2.4F, 5.1F, -2.1F, 4, 3, 4);
        this.frontLeftHoof.setRotationPoint(4.0F, 16.0F, -8.0F);
        this.frontRightLeg = new ModelRenderer(this, 60, 29);
        this.frontRightLeg.addBox(-1.1F, -1.0F, -2.1F, 3, 8, 4);
        this.frontRightLeg.setRotationPoint(-4.0F, 9.0F, -8.0F);
        this.frontRightShin = new ModelRenderer(this, 60, 41);
        this.frontRightShin.addBox(-1.1F, 0.0F, -1.6F, 3, 5, 3);
        this.frontRightShin.setRotationPoint(-4.0F, 16.0F, -8.0F);
        this.frontRightHoof = new ModelRenderer(this, 60, 51);
        this.frontRightHoof.addBox(-1.6F, 5.1F, -2.1F, 4, 3, 4);
        this.frontRightHoof.setRotationPoint(-4.0F, 16.0F, -8.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.5F, -10.0F, -1.5F, 5, 5, 7);
        this.head.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.head, 0.5235988F, 0.0F, 0.0F);
        this.field_178711_b = new ModelRenderer(this, 24, 18);
        this.field_178711_b.addBox(-2.0F, -10.0F, -7.0F, 4, 3, 6);
        this.field_178711_b.setRotationPoint(0.0F, 3.95F, -10.0F);
        this.setBoxRotation(this.field_178711_b, 0.5235988F, 0.0F, 0.0F);
        this.field_178712_c = new ModelRenderer(this, 24, 27);
        this.field_178712_c.addBox(-2.0F, -7.0F, -6.5F, 4, 2, 5);
        this.field_178712_c.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.field_178712_c, 0.5235988F, 0.0F, 0.0F);
        this.head.addChild(this.field_178711_b);
        this.head.addChild(this.field_178712_c);
        this.broomLeftEar = new ModelRenderer(this, 0, 0);
        this.broomLeftEar.addBox(0.45F, -12.0F, 4.0F, 2, 3, 1);
        this.broomLeftEar.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.broomLeftEar, 0.5235988F, 0.0F, 0.0F);
        this.broomRightEar = new ModelRenderer(this, 0, 0);
        this.broomRightEar.addBox(-2.45F, -12.0F, 4.0F, 2, 3, 1);
        this.broomRightEar.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.broomRightEar, 0.5235988F, 0.0F, 0.0F);
        this.muleLeftEar = new ModelRenderer(this, 0, 12);
        this.muleLeftEar.addBox(-2.0F, -16.0F, 4.0F, 2, 7, 1);
        this.muleLeftEar.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.muleLeftEar, 0.5235988F, 0.0F, 0.2617994F);
        this.muleRightEar = new ModelRenderer(this, 0, 12);
        this.muleRightEar.addBox(0.0F, -16.0F, 4.0F, 2, 7, 1);
        this.muleRightEar.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.muleRightEar, 0.5235988F, 0.0F, -0.2617994F);
        this.neck = new ModelRenderer(this, 0, 12);
        this.neck.addBox(-2.05F, -9.8F, -2.0F, 4, 14, 8);
        this.neck.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.neck, 0.5235988F, 0.0F, 0.0F);
        this.muleLeftChest = new ModelRenderer(this, 0, 34);
        this.muleLeftChest.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3);
        this.muleLeftChest.setRotationPoint(-7.5F, 3.0F, 10.0F);
        this.setBoxRotation(this.muleLeftChest, 0.0F, ((float)Math.PI / 2F), 0.0F);
        this.muleRightChest = new ModelRenderer(this, 0, 47);
        this.muleRightChest.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3);
        this.muleRightChest.setRotationPoint(4.5F, 3.0F, 10.0F);
        this.setBoxRotation(this.muleRightChest, 0.0F, ((float)Math.PI / 2F), 0.0F);
        this.broomSaddleBottom = new ModelRenderer(this, 80, 0);
        this.broomSaddleBottom.addBox(-5.0F, 0.0F, -3.0F, 10, 1, 8);
        this.broomSaddleBottom.setRotationPoint(0.0F, 2.0F, 2.0F);
        this.broomSaddleFront = new ModelRenderer(this, 106, 9);
        this.broomSaddleFront.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2);
        this.broomSaddleFront.setRotationPoint(0.0F, 2.0F, 2.0F);
        this.broomSaddleBack = new ModelRenderer(this, 80, 9);
        this.broomSaddleBack.addBox(-4.0F, -1.0F, 3.0F, 8, 1, 2);
        this.broomSaddleBack.setRotationPoint(0.0F, 2.0F, 2.0F);
        this.broomLeftSaddleMetal = new ModelRenderer(this, 74, 0);
        this.broomLeftSaddleMetal.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2);
        this.broomLeftSaddleMetal.setRotationPoint(5.0F, 3.0F, 2.0F);
        this.broomLeftSaddleRope = new ModelRenderer(this, 70, 0);
        this.broomLeftSaddleRope.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.broomLeftSaddleRope.setRotationPoint(5.0F, 3.0F, 2.0F);
        this.broomRightSaddleMetal = new ModelRenderer(this, 74, 4);
        this.broomRightSaddleMetal.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2);
        this.broomRightSaddleMetal.setRotationPoint(-5.0F, 3.0F, 2.0F);
        this.broomRightSaddleRope = new ModelRenderer(this, 80, 0);
        this.broomRightSaddleRope.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.broomRightSaddleRope.setRotationPoint(-5.0F, 3.0F, 2.0F);
        this.broomLeftFaceMetal = new ModelRenderer(this, 74, 13);
        this.broomLeftFaceMetal.addBox(1.5F, -8.0F, -4.0F, 1, 2, 2);
        this.broomLeftFaceMetal.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.broomLeftFaceMetal, 0.5235988F, 0.0F, 0.0F);
        this.broomRightFaceMetal = new ModelRenderer(this, 74, 13);
        this.broomRightFaceMetal.addBox(-2.5F, -8.0F, -4.0F, 1, 2, 2);
        this.broomRightFaceMetal.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.broomRightFaceMetal, 0.5235988F, 0.0F, 0.0F);
        this.broomLeftRein = new ModelRenderer(this, 44, 10);
        this.broomLeftRein.addBox(2.6F, -6.0F, -6.0F, 0, 3, 16);
        this.broomLeftRein.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.broomRightRein = new ModelRenderer(this, 44, 5);
        this.broomRightRein.addBox(-2.6F, -6.0F, -6.0F, 0, 3, 16);
        this.broomRightRein.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.mane = new ModelRenderer(this, 58, 0);
        this.mane.addBox(-1.0F, -11.5F, 5.0F, 2, 16, 4);
        this.mane.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.mane, 0.5235988F, 0.0F, 0.0F);
        this.broomFaceRopes = new ModelRenderer(this, 80, 12);
        this.broomFaceRopes.addBox(-2.5F, -10.1F, -7.0F, 5, 5, 12, 0.2F);
        this.broomFaceRopes.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setBoxRotation(this.broomFaceRopes, 0.5235988F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        EntityBroom entitybroom = (EntityBroom)p_78088_1_;
        int i = entitybroom.getBroomType();
        float f6 = entitybroom.getGrassEatingAmount(0.0F);
        boolean flag = entitybroom.isAdultBroom();
        boolean flag1 = flag && entitybroom.isBroomSaddled();
        boolean flag2 = flag && entitybroom.isChested();
        boolean flag3 = i == 1 || i == 2;
        float f7 = entitybroom.getBroomSize();
        boolean flag4 = entitybroom.riddenByEntity != null;

        if (flag1)
        {
            this.broomFaceRopes.render(p_78088_7_);
            this.broomSaddleBottom.render(p_78088_7_);
            this.broomSaddleFront.render(p_78088_7_);
            this.broomSaddleBack.render(p_78088_7_);
            this.broomLeftSaddleRope.render(p_78088_7_);
            this.broomLeftSaddleMetal.render(p_78088_7_);
            this.broomRightSaddleRope.render(p_78088_7_);
            this.broomRightSaddleMetal.render(p_78088_7_);
            this.broomLeftFaceMetal.render(p_78088_7_);
            this.broomRightFaceMetal.render(p_78088_7_);

            if (flag4)
            {
                this.broomLeftRein.render(p_78088_7_);
                this.broomRightRein.render(p_78088_7_);
            }
        }

        if (!flag)
        {
            GlStateManager.pushMatrix();
            GlStateManager.scale(f7, 0.5F + f7 * 0.5F, f7);
            GlStateManager.translate(0.0F, 0.95F * (1.0F - f7), 0.0F);
        }

        this.backLeftLeg.render(p_78088_7_);
        this.backLeftShin.render(p_78088_7_);
        this.backLeftHoof.render(p_78088_7_);
        this.backRightLeg.render(p_78088_7_);
        this.backRightShin.render(p_78088_7_);
        this.backRightHoof.render(p_78088_7_);
        this.frontLeftLeg.render(p_78088_7_);
        this.frontLeftShin.render(p_78088_7_);
        this.frontLeftHoof.render(p_78088_7_);
        this.frontRightLeg.render(p_78088_7_);
        this.frontRightShin.render(p_78088_7_);
        this.frontRightHoof.render(p_78088_7_);

        if (!flag)
        {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(f7, f7, f7);
            GlStateManager.translate(0.0F, 1.35F * (1.0F - f7), 0.0F);
        }

        this.body.render(p_78088_7_);
        this.tailBase.render(p_78088_7_);
        this.tailMiddle.render(p_78088_7_);
        this.tailTip.render(p_78088_7_);
        this.neck.render(p_78088_7_);
        this.mane.render(p_78088_7_);

        if (!flag)
        {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            float f8 = 0.5F + f7 * f7 * 0.5F;
            GlStateManager.scale(f8, f8, f8);

            if (f6 <= 0.0F)
            {
                GlStateManager.translate(0.0F, 1.35F * (1.0F - f7), 0.0F);
            }
            else
            {
                GlStateManager.translate(0.0F, 0.9F * (1.0F - f7) * f6 + 1.35F * (1.0F - f7) * (1.0F - f6), 0.15F * (1.0F - f7) * f6);
            }
        }

        if (flag3)
        {
            this.muleLeftEar.render(p_78088_7_);
            this.muleRightEar.render(p_78088_7_);
        }
        else
        {
            this.broomLeftEar.render(p_78088_7_);
            this.broomRightEar.render(p_78088_7_);
        }

        this.head.render(p_78088_7_);

        if (!flag)
        {
            GlStateManager.popMatrix();
        }

        if (flag2)
        {
            this.muleLeftChest.render(p_78088_7_);
            this.muleRightChest.render(p_78088_7_);
        }
    }

    /**
     * Sets the rotations for a ModelRenderer in the ModelBroom class.
     */
    private void setBoxRotation(ModelRenderer p_110682_1_, float p_110682_2_, float p_110682_3_, float p_110682_4_)
    {
        p_110682_1_.rotateAngleX = p_110682_2_;
        p_110682_1_.rotateAngleY = p_110682_3_;
        p_110682_1_.rotateAngleZ = p_110682_4_;
    }

    /**
     * Fixes and offsets a rotation in the ModelBroom class.
     */
    private float updateBroomRotation(float p_110683_1_, float p_110683_2_, float p_110683_3_)
    {
        float f3;

        for (f3 = p_110683_2_ - p_110683_1_; f3 < -180.0F; f3 += 360.0F)
        {
            ;
        }

        while (f3 >= 180.0F)
        {
            f3 -= 360.0F;
        }

        return p_110683_1_ + p_110683_3_ * f3;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        super.setLivingAnimations(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
        float f3 = this.updateBroomRotation(p_78086_1_.prevRenderYawOffset, p_78086_1_.renderYawOffset, p_78086_4_);
        float f4 = this.updateBroomRotation(p_78086_1_.prevRotationYawHead, p_78086_1_.rotationYawHead, p_78086_4_);
        float f5 = p_78086_1_.prevRotationPitch + (p_78086_1_.rotationPitch - p_78086_1_.prevRotationPitch) * p_78086_4_;
        float f6 = f4 - f3;
        float f7 = f5 / (180F / (float)Math.PI);

        if (f6 > 20.0F)
        {
            f6 = 20.0F;
        }

        if (f6 < -20.0F)
        {
            f6 = -20.0F;
        }

        if (p_78086_3_ > 0.2F)
        {
            f7 += MathHelper.cos(p_78086_2_ * 0.4F) * 0.15F * p_78086_3_;
        }

        EntityBroom entitybroom = (EntityBroom)p_78086_1_;
        float f8 = entitybroom.getGrassEatingAmount(p_78086_4_);
        float f9 = entitybroom.getRearingAmount(p_78086_4_);
        float f10 = 1.0F - f9;
        float f11 = entitybroom.func_110201_q(p_78086_4_);
        boolean flag = entitybroom.field_110278_bp != 0;
        boolean flag1 = entitybroom.isBroomSaddled();
        boolean flag2 = entitybroom.riddenByEntity != null;
        float f12 = (float)p_78086_1_.ticksExisted + p_78086_4_;
        float f13 = MathHelper.cos(p_78086_2_ * 0.6662F + (float)Math.PI);
        float f14 = f13 * 0.8F * p_78086_3_;
        this.head.rotationPointY = 4.0F;
        this.head.rotationPointZ = -10.0F;
        this.tailBase.rotationPointY = 3.0F;
        this.tailMiddle.rotationPointZ = 14.0F;
        this.muleRightChest.rotationPointY = 3.0F;
        this.muleRightChest.rotationPointZ = 10.0F;
        this.body.rotateAngleX = 0.0F;
        this.head.rotateAngleX = 0.5235988F + f7;
        this.head.rotateAngleY = f6 / (180F / (float)Math.PI);
        this.head.rotateAngleX = f9 * (0.2617994F + f7) + f8 * 2.18166F + (1.0F - Math.max(f9, f8)) * this.head.rotateAngleX;
        this.head.rotateAngleY = f9 * f6 / (180F / (float)Math.PI) + (1.0F - Math.max(f9, f8)) * this.head.rotateAngleY;
        this.head.rotationPointY = f9 * -6.0F + f8 * 11.0F + (1.0F - Math.max(f9, f8)) * this.head.rotationPointY;
        this.head.rotationPointZ = f9 * -1.0F + f8 * -10.0F + (1.0F - Math.max(f9, f8)) * this.head.rotationPointZ;
        this.tailBase.rotationPointY = f9 * 9.0F + f10 * this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = f9 * 18.0F + f10 * this.tailMiddle.rotationPointZ;
        this.muleRightChest.rotationPointY = f9 * 5.5F + f10 * this.muleRightChest.rotationPointY;
        this.muleRightChest.rotationPointZ = f9 * 15.0F + f10 * this.muleRightChest.rotationPointZ;
        this.body.rotateAngleX = f9 * -45.0F / (180F / (float)Math.PI) + f10 * this.body.rotateAngleX;
        this.broomLeftEar.rotationPointY = this.head.rotationPointY;
        this.broomRightEar.rotationPointY = this.head.rotationPointY;
        this.muleLeftEar.rotationPointY = this.head.rotationPointY;
        this.muleRightEar.rotationPointY = this.head.rotationPointY;
        this.neck.rotationPointY = this.head.rotationPointY;
        this.field_178711_b.rotationPointY = 0.02F;
        this.field_178712_c.rotationPointY = 0.0F;
        this.mane.rotationPointY = this.head.rotationPointY;
        this.broomLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.broomRightEar.rotationPointZ = this.head.rotationPointZ;
        this.muleLeftEar.rotationPointZ = this.head.rotationPointZ;
        this.muleRightEar.rotationPointZ = this.head.rotationPointZ;
        this.neck.rotationPointZ = this.head.rotationPointZ;
        this.field_178711_b.rotationPointZ = 0.02F - f11 * 1.0F;
        this.field_178712_c.rotationPointZ = 0.0F + f11 * 1.0F;
        this.mane.rotationPointZ = this.head.rotationPointZ;
        this.broomLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.broomRightEar.rotateAngleX = this.head.rotateAngleX;
        this.muleLeftEar.rotateAngleX = this.head.rotateAngleX;
        this.muleRightEar.rotateAngleX = this.head.rotateAngleX;
        this.neck.rotateAngleX = this.head.rotateAngleX;
        this.field_178711_b.rotateAngleX = 0.0F - 0.09424778F * f11;
        this.field_178712_c.rotateAngleX = 0.0F + 0.15707964F * f11;
        this.mane.rotateAngleX = this.head.rotateAngleX;
        this.broomLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.broomRightEar.rotateAngleY = this.head.rotateAngleY;
        this.muleLeftEar.rotateAngleY = this.head.rotateAngleY;
        this.muleRightEar.rotateAngleY = this.head.rotateAngleY;
        this.neck.rotateAngleY = this.head.rotateAngleY;
        this.field_178711_b.rotateAngleY = 0.0F;
        this.field_178712_c.rotateAngleY = 0.0F;
        this.mane.rotateAngleY = this.head.rotateAngleY;
        this.muleLeftChest.rotateAngleX = f14 / 5.0F;
        this.muleRightChest.rotateAngleX = -f14 / 5.0F;
        float f15 = ((float)Math.PI / 2F);
        float f16 = ((float)Math.PI * 3F / 2F);
        float f17 = -1.0471976F;
        float f18 = 0.2617994F * f9;
        float f19 = MathHelper.cos(f12 * 0.6F + (float)Math.PI);
        this.frontLeftLeg.rotationPointY = -2.0F * f9 + 9.0F * f10;
        this.frontLeftLeg.rotationPointZ = -2.0F * f9 + -8.0F * f10;
        this.frontRightLeg.rotationPointY = this.frontLeftLeg.rotationPointY;
        this.frontRightLeg.rotationPointZ = this.frontLeftLeg.rotationPointZ;
        this.backLeftShin.rotationPointY = this.backLeftLeg.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f18 + f10 * -f13 * 0.5F * p_78086_3_) * 7.0F;
        this.backLeftShin.rotationPointZ = this.backLeftLeg.rotationPointZ + MathHelper.cos(((float)Math.PI * 3F / 2F) + f18 + f10 * -f13 * 0.5F * p_78086_3_) * 7.0F;
        this.backRightShin.rotationPointY = this.backRightLeg.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f18 + f10 * f13 * 0.5F * p_78086_3_) * 7.0F;
        this.backRightShin.rotationPointZ = this.backRightLeg.rotationPointZ + MathHelper.cos(((float)Math.PI * 3F / 2F) + f18 + f10 * f13 * 0.5F * p_78086_3_) * 7.0F;
        float f20 = (-1.0471976F + f19) * f9 + f14 * f10;
        float f21 = (-1.0471976F + -f19) * f9 + -f14 * f10;
        this.frontLeftShin.rotationPointY = this.frontLeftLeg.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f20) * 7.0F;
        this.frontLeftShin.rotationPointZ = this.frontLeftLeg.rotationPointZ + MathHelper.cos(((float)Math.PI * 3F / 2F) + f20) * 7.0F;
        this.frontRightShin.rotationPointY = this.frontRightLeg.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f21) * 7.0F;
        this.frontRightShin.rotationPointZ = this.frontRightLeg.rotationPointZ + MathHelper.cos(((float)Math.PI * 3F / 2F) + f21) * 7.0F;
        this.backLeftLeg.rotateAngleX = f18 + -f13 * 0.5F * p_78086_3_ * f10;
        this.backLeftShin.rotateAngleX = -0.08726646F * f9 + (-f13 * 0.5F * p_78086_3_ - Math.max(0.0F, f13 * 0.5F * p_78086_3_)) * f10;
        this.backLeftHoof.rotateAngleX = this.backLeftShin.rotateAngleX;
        this.backRightLeg.rotateAngleX = f18 + f13 * 0.5F * p_78086_3_ * f10;
        this.backRightShin.rotateAngleX = -0.08726646F * f9 + (f13 * 0.5F * p_78086_3_ - Math.max(0.0F, -f13 * 0.5F * p_78086_3_)) * f10;
        this.backRightHoof.rotateAngleX = this.backRightShin.rotateAngleX;
        this.frontLeftLeg.rotateAngleX = f20;
        this.frontLeftShin.rotateAngleX = (this.frontLeftLeg.rotateAngleX + (float)Math.PI * Math.max(0.0F, 0.2F + f19 * 0.2F)) * f9 + (f14 + Math.max(0.0F, f13 * 0.5F * p_78086_3_)) * f10;
        this.frontLeftHoof.rotateAngleX = this.frontLeftShin.rotateAngleX;
        this.frontRightLeg.rotateAngleX = f21;
        this.frontRightShin.rotateAngleX = (this.frontRightLeg.rotateAngleX + (float)Math.PI * Math.max(0.0F, 0.2F - f19 * 0.2F)) * f9 + (-f14 + Math.max(0.0F, -f13 * 0.5F * p_78086_3_)) * f10;
        this.frontRightHoof.rotateAngleX = this.frontRightShin.rotateAngleX;
        this.backLeftHoof.rotationPointY = this.backLeftShin.rotationPointY;
        this.backLeftHoof.rotationPointZ = this.backLeftShin.rotationPointZ;
        this.backRightHoof.rotationPointY = this.backRightShin.rotationPointY;
        this.backRightHoof.rotationPointZ = this.backRightShin.rotationPointZ;
        this.frontLeftHoof.rotationPointY = this.frontLeftShin.rotationPointY;
        this.frontLeftHoof.rotationPointZ = this.frontLeftShin.rotationPointZ;
        this.frontRightHoof.rotationPointY = this.frontRightShin.rotationPointY;
        this.frontRightHoof.rotationPointZ = this.frontRightShin.rotationPointZ;

        if (flag1)
        {
            this.broomSaddleBottom.rotationPointY = f9 * 0.5F + f10 * 2.0F;
            this.broomSaddleBottom.rotationPointZ = f9 * 11.0F + f10 * 2.0F;
            this.broomSaddleFront.rotationPointY = this.broomSaddleBottom.rotationPointY;
            this.broomSaddleBack.rotationPointY = this.broomSaddleBottom.rotationPointY;
            this.broomLeftSaddleRope.rotationPointY = this.broomSaddleBottom.rotationPointY;
            this.broomRightSaddleRope.rotationPointY = this.broomSaddleBottom.rotationPointY;
            this.broomLeftSaddleMetal.rotationPointY = this.broomSaddleBottom.rotationPointY;
            this.broomRightSaddleMetal.rotationPointY = this.broomSaddleBottom.rotationPointY;
            this.muleLeftChest.rotationPointY = this.muleRightChest.rotationPointY;
            this.broomSaddleFront.rotationPointZ = this.broomSaddleBottom.rotationPointZ;
            this.broomSaddleBack.rotationPointZ = this.broomSaddleBottom.rotationPointZ;
            this.broomLeftSaddleRope.rotationPointZ = this.broomSaddleBottom.rotationPointZ;
            this.broomRightSaddleRope.rotationPointZ = this.broomSaddleBottom.rotationPointZ;
            this.broomLeftSaddleMetal.rotationPointZ = this.broomSaddleBottom.rotationPointZ;
            this.broomRightSaddleMetal.rotationPointZ = this.broomSaddleBottom.rotationPointZ;
            this.muleLeftChest.rotationPointZ = this.muleRightChest.rotationPointZ;
            this.broomSaddleBottom.rotateAngleX = this.body.rotateAngleX;
            this.broomSaddleFront.rotateAngleX = this.body.rotateAngleX;
            this.broomSaddleBack.rotateAngleX = this.body.rotateAngleX;
            this.broomLeftRein.rotationPointY = this.head.rotationPointY;
            this.broomRightRein.rotationPointY = this.head.rotationPointY;
            this.broomFaceRopes.rotationPointY = this.head.rotationPointY;
            this.broomLeftFaceMetal.rotationPointY = this.head.rotationPointY;
            this.broomRightFaceMetal.rotationPointY = this.head.rotationPointY;
            this.broomLeftRein.rotationPointZ = this.head.rotationPointZ;
            this.broomRightRein.rotationPointZ = this.head.rotationPointZ;
            this.broomFaceRopes.rotationPointZ = this.head.rotationPointZ;
            this.broomLeftFaceMetal.rotationPointZ = this.head.rotationPointZ;
            this.broomRightFaceMetal.rotationPointZ = this.head.rotationPointZ;
            this.broomLeftRein.rotateAngleX = f7;
            this.broomRightRein.rotateAngleX = f7;
            this.broomFaceRopes.rotateAngleX = this.head.rotateAngleX;
            this.broomLeftFaceMetal.rotateAngleX = this.head.rotateAngleX;
            this.broomRightFaceMetal.rotateAngleX = this.head.rotateAngleX;
            this.broomFaceRopes.rotateAngleY = this.head.rotateAngleY;
            this.broomLeftFaceMetal.rotateAngleY = this.head.rotateAngleY;
            this.broomLeftRein.rotateAngleY = this.head.rotateAngleY;
            this.broomRightFaceMetal.rotateAngleY = this.head.rotateAngleY;
            this.broomRightRein.rotateAngleY = this.head.rotateAngleY;

            if (flag2)
            {
                this.broomLeftSaddleRope.rotateAngleX = -1.0471976F;
                this.broomLeftSaddleMetal.rotateAngleX = -1.0471976F;
                this.broomRightSaddleRope.rotateAngleX = -1.0471976F;
                this.broomRightSaddleMetal.rotateAngleX = -1.0471976F;
                this.broomLeftSaddleRope.rotateAngleZ = 0.0F;
                this.broomLeftSaddleMetal.rotateAngleZ = 0.0F;
                this.broomRightSaddleRope.rotateAngleZ = 0.0F;
                this.broomRightSaddleMetal.rotateAngleZ = 0.0F;
            }
            else
            {
                this.broomLeftSaddleRope.rotateAngleX = f14 / 3.0F;
                this.broomLeftSaddleMetal.rotateAngleX = f14 / 3.0F;
                this.broomRightSaddleRope.rotateAngleX = f14 / 3.0F;
                this.broomRightSaddleMetal.rotateAngleX = f14 / 3.0F;
                this.broomLeftSaddleRope.rotateAngleZ = f14 / 5.0F;
                this.broomLeftSaddleMetal.rotateAngleZ = f14 / 5.0F;
                this.broomRightSaddleRope.rotateAngleZ = -f14 / 5.0F;
                this.broomRightSaddleMetal.rotateAngleZ = -f14 / 5.0F;
            }
        }

        f15 = -1.3089F + p_78086_3_ * 1.5F;

        if (f15 > 0.0F)
        {
            f15 = 0.0F;
        }

        if (flag)
        {
            this.tailBase.rotateAngleY = MathHelper.cos(f12 * 0.7F);
            f15 = 0.0F;
        }
        else
        {
            this.tailBase.rotateAngleY = 0.0F;
        }

        this.tailMiddle.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailTip.rotateAngleY = this.tailBase.rotateAngleY;
        this.tailMiddle.rotationPointY = this.tailBase.rotationPointY;
        this.tailTip.rotationPointY = this.tailBase.rotationPointY;
        this.tailMiddle.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailTip.rotationPointZ = this.tailBase.rotationPointZ;
        this.tailBase.rotateAngleX = f15;
        this.tailMiddle.rotateAngleX = f15;
        this.tailTip.rotateAngleX = -0.2618F + f15;
    }
}