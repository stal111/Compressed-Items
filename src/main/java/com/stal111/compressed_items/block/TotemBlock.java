package com.stal111.compressed_items.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;

public class TotemBlock extends BasicBlock {

	private static final DirectionProperty FACING = BlockStateProperties.FACING;

	public TotemBlock(String name, Material material, float hardness, float resistance, SoundType soundType) {
		super(name, material, hardness, resistance, soundType);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP));
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		switch (rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90: {
			switch ((Direction) state.get(TotemBlock.FACING)) {
			case NORTH: {
				return (BlockState) state.with(TotemBlock.FACING, Direction.NORTH);
			}
			case EAST: {
				return (BlockState) state.with(TotemBlock.FACING, Direction.EAST);
			}
			case SOUTH: {
				return (BlockState) state.with(TotemBlock.FACING, Direction.SOUTH);
			}
			case WEST: {
				return (BlockState) state.with(TotemBlock.FACING, Direction.WEST);
			}
			case UP: {
				return (BlockState) state.with(TotemBlock.FACING, Direction.UP);
			}
			case DOWN: {
				return (BlockState) state.with(TotemBlock.FACING, Direction.DOWN);
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
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.stateContainer.getBaseState().with(FACING, context.getFace());
	}

}
