package com.naxder.naxdermod.blocks;

import com.naxder.naxdermod.items.ModItems;

import net.minecraft.block.BlockFurnace;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BedrockFurnace extends BlockFurnace {

    private static boolean keepInventory = true;
    
	public BedrockFurnace(boolean isBurning) {
		super(isBurning);

		// this.setBlockUnbreakable();
		this.setCreativeTab(ModItems.tabMyMod);
		this.setHarvestLevel("pickaxe", 4);

		this.setUnlocalizedName("bedrock_furnace");

	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!keepInventory) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityFurnace) {
				InventoryHelper.dropInventoryItems(worldIn, pos,
						(TileEntityFurnace) tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityFurnace();
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityFurnace) {
				playerIn.displayGUIChest((TileEntityFurnace) tileentity);
			}

			return true;
		}
	}

	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state,
			EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer
				.getHorizontalFacing().getOpposite()), 2);

		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityFurnace) {
				((TileEntityFurnace) tileentity).setCustomInventoryName(stack
						.getDisplayName());
			}
		}
	}

}
