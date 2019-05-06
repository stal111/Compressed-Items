package com.stal111.compressed_items.block;

import java.util.Random;

import com.stal111.compressed_items.Main;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FallingBlock extends BlockFalling {

	public FallingBlock(String name, Material material, float hardnessAndResistance, SoundType soundType) {
		super(Block.Properties.create(material).hardnessAndResistance(hardnessAndResistance).sound(soundType));
		this.setRegistryName(Main.MODID, name);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
	}

}
