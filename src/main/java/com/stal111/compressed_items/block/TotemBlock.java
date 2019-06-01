package com.stal111.compressed_items.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;

public class TotemBlock extends BasicBlock {
	
	private static final DirectionProperty FACING = BlockDirectional.FACING;

	public TotemBlock(String name, Material material, float hardness, float resistance, SoundType soundType) {
		super(name, material, hardness, resistance, soundType);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.UP));
	}
	
	public IBlockState func_185499_a(final IBlockState state, final Rotation rot) {
        switch (rot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90: {
                switch ((EnumFacing)state.get(TotemBlock.FACING)) {
                    case NORTH: {
                        return (IBlockState)state.with(TotemBlock.FACING, EnumFacing.NORTH);
                    }
                    case EAST: {
                        return (IBlockState)state.with(TotemBlock.FACING, EnumFacing.EAST);
                    }
                    case SOUTH: {
                        return (IBlockState)state.with(TotemBlock.FACING,  EnumFacing.SOUTH);
                    }
                    case WEST: {
                        return (IBlockState)state.with(TotemBlock.FACING, EnumFacing.WEST);
                    }
                    case UP: {
                        return (IBlockState)state.with(TotemBlock.FACING, EnumFacing.UP);
                    }
                    case DOWN: {
                        return (IBlockState)state.with(TotemBlock.FACING, EnumFacing.DOWN);
                    }
                    default: {
                        return state;
                    }
                }
            }
            default: {
                return state;
            }
        }
    }
    
	
	@Override
	protected void fillStateContainer(Builder<Block, IBlockState> builder) {
		builder.add(FACING);
	}
	
	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		return this.stateContainer.getBaseState().with(FACING, context.getFace());
	}

}
