package com.stal111.compressed_items.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TranslucentBlock extends BasicBlock {

	public TranslucentBlock(String name, Material material, float hardness, float resistance) {
		super(name, material, hardness, resistance);
	}

	@Override
	public boolean propagatesSkylightDown(IBlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isSideInvisible(IBlockState state, IBlockState adjacentBlockState, EnumFacing side) {
		return adjacentBlockState.getBlock() == this ? true : false;
	}
}
