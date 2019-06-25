package com.stal111.compressed_items.block;

import java.util.Random;

import com.stal111.compressed_items.util.VoxelShapeHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class SackBlock extends FallingBlock implements IWaterLoggable {

	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	private static final VoxelShape[] SHAPE = {
			Block.makeCuboidShape(0, 0, 0, 16, 9, 16),
			Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
			Block.makeCuboidShape(0, 10, 0, 16, 13, 16),
			Block.makeCuboidShape(1, 13, 1, 15, 15, 15),
			Block.makeCuboidShape(3, 15, 3, 13, 16, 13)};
	
	public SackBlock(String name) {
		super(name, Material.WOOL, 0.9F, SoundType.CLOTH);
		this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED);
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return VoxelShapeHelper.combineAll(SHAPE);
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return VoxelShapeHelper.combineAll(SHAPE);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
		return super.getStateForPlacement(context).with(WATERLOGGED, Boolean.valueOf(ifluidstate.isTagged(FluidTags.WATER) && ifluidstate.getLevel() == 8));
	}

	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world,
			BlockPos currentPos, BlockPos facingPos) {
		if (state.get(WATERLOGGED)) {
			world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}

		return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
	}

	@SuppressWarnings("deprecation")
	@Override
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	
	@Override
	public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
		if (this == ModBlocks.gunpowder_sack) {
			if (world.getBlockState(pos.up()).getBlock() == Blocks.AIR) {
				for (int i = 0; i < 1; i++) {
					double d0 = pos.getX() + 0.5F + (rand.nextFloat() - 0.5F) * 0.5D;
					double d1 = pos.getY() + 0.6F + (rand.nextFloat() - 0.5F) * 0.5D + 0.5D;
					double d2 = pos.getZ() + 0.5F + (rand.nextFloat() - 0.5F) * 0.5D;
					world.addParticle(ParticleTypes.SMOKE, d0, d1 + 0.2D, d2, 0D, 0D, 0D);
				}
			}
		}
	}
}
