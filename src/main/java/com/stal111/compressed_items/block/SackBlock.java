package com.stal111.compressed_items.block;

import java.util.Random;

import com.stal111.compressed_items.util.VoxelShapeHelper;

import net.minecraft.block.Block;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.init.Fluids;
import net.minecraft.init.Particles;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class SackBlock extends FallingBlock implements IBucketPickupHandler, ILiquidContainer {

	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	private static final VoxelShape[] SHAPE = {
			Block.makeCuboidShape(0, 0, 0, 16, 9, 16),
			Block.makeCuboidShape(1, 9, 1, 15, 10, 15),
			Block.makeCuboidShape(0, 10, 0, 16, 13, 16),
			Block.makeCuboidShape(1, 13, 1, 15, 15, 15),
			Block.makeCuboidShape(3, 15, 3, 13, 16, 13)};
	
	public SackBlock(String name) {
		super(name, Material.CLOTH, 0.9F, SoundType.CLOTH);
	}

	@Override
	protected void fillStateContainer(Builder<Block, IBlockState> builder) {
		builder.add(WATERLOGGED);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
	
	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		return VoxelShapeHelper.combineAll(SHAPE);
	}
	
	@Override
	public VoxelShape getCollisionShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		return VoxelShapeHelper.combineAll(SHAPE);
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return false;
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!world.isRemote) {
			if (state.get(WATERLOGGED)) {
				world.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			}
		}
	}

	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(WATERLOGGED,
				Boolean.valueOf(context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER));
	}

	@Override
	public IBlockState updatePostPlacement(IBlockState state, EnumFacing facing, IBlockState facingState, IWorld world,
			BlockPos currentPos, BlockPos facingPos) {
		if (state.get(WATERLOGGED)) {
			world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}
		return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
	}
	
	@Override
	public void animateTick(IBlockState state, World world, BlockPos pos, Random rand) {
		if (this == ModBlocks.gunpowder_sack) {
			if (world.getFluidState(pos.up()) != FluidTags.WATER && world.getFluidState(pos.up()) != FluidTags.LAVA) {
				for (int i = 0; i < 1; i++) {
					double d0 = pos.getX() + 0.5F + (rand.nextFloat() - 0.5F) * 0.5D;
					double d1 = pos.getY() + 0.6F + (rand.nextFloat() - 0.5F) * 0.5D + 0.5D;
					double d2 = pos.getZ() + 0.5F + (rand.nextFloat() - 0.5F) * 0.5D;
					world.spawnParticle(Particles.SMOKE, d0, d1 + 0.2D, d2, 0D, 0D, 0D);
				}
			}
		}
	}

	@Override
	public boolean canContainFluid(IBlockReader world, BlockPos pos, IBlockState state, Fluid fluid) {
		return !state.get(WATERLOGGED) && fluid == Fluids.WATER;
	}

	@Override
	public boolean receiveFluid(IWorld world, BlockPos pos, IBlockState state, IFluidState fluidState) {
		if (!state.get(WATERLOGGED) && fluidState.getFluid() == Fluids.WATER) {
			if (!world.isRemote()) {
				world.setBlockState(pos, state.with(WATERLOGGED, Boolean.valueOf(true)), 3);
				world.getPendingFluidTicks().scheduleTick(pos, fluidState.getFluid(),
						fluidState.getFluid().getTickRate(world));
			}
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public IFluidState getFluidState(IBlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	public Fluid pickupFluid(IWorld world, BlockPos pos, IBlockState state) {
		if (state.get(WATERLOGGED)) {
			world.setBlockState(pos, state.with(WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER;
		} else {
			return Fluids.EMPTY;
		}
	}

}
