package com.stal111.compressed_items.block;

import java.util.Random;

import com.stal111.compressed_items.Main;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FallingBlock extends BlockFalling {

	public FallingBlock(String name, Properties builder) {
		super(builder);
		this.setRegistryName(Main.MODID, name);
	}
	
	@Override
	public void animateTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
	}

}
