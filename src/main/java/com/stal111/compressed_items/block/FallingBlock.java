package com.stal111.compressed_items.block;

import java.util.Random;

import com.stal111.compressed_items.Main;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FallingBlock extends net.minecraft.block.FallingBlock {

	public FallingBlock(String name, Material material, float hardnessAndResistance, SoundType soundType) {
		super(Block.Properties.create(material).hardnessAndResistance(hardnessAndResistance).sound(soundType));
		this.setRegistryName(Main.MODID, name);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
	}

}
