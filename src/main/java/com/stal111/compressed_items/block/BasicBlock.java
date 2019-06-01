package com.stal111.compressed_items.block;

import java.util.Random;

import com.stal111.compressed_items.Main;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Particles;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BasicBlock extends Block {

	public BasicBlock(String name, Material material, float hardnessAndResistance, SoundType soundType) {
		super(Block.Properties.create(material).hardnessAndResistance(hardnessAndResistance).sound(soundType));
		this.setRegistryName(Main.MODID, name);
	}
	
	public BasicBlock(String name, Material material, float hardness, float resistance, SoundType soundType) {
		super(Block.Properties.create(material).hardnessAndResistance(hardness, resistance).sound(soundType));
		this.setRegistryName(Main.MODID, name);
	}
	
	public BasicBlock(String name, Material material, float hardness, float resistance) {
		super(Block.Properties.create(material).hardnessAndResistance(hardness, resistance));
		this.setRegistryName(Main.MODID, name);
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(IBlockState state, World world, BlockPos pos, Random rand) {
		if (this == ModBlocks.ender_pearl_block) {
			for(int i = 0; i < 3; ++i) {
		         int j = rand.nextInt(2) * 2 - 1;
		         int k = rand.nextInt(2) * 2 - 1;
		         double d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
		         double d1 = (double)((float)pos.getY() + rand.nextFloat());
		         double d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)k;
		         double d3 = (double)(rand.nextFloat() * (float)j);
		         double d4 = ((double)rand.nextFloat() - 0.5D) * 0.125D;
		         double d5 = (double)(rand.nextFloat() * (float)k);
		         world.spawnParticle(Particles.PORTAL, d0, d1, d2, d3, d4, d5);
		      }
		} else if (this == ModBlocks.blaze_rod_block) {
			if (world.getBlockState(pos.up()).getBlock() == Blocks.AIR) {
				for (int i = 0; i < 1; i++) {
					double d0 = pos.getX() + 0.5F + (rand.nextFloat() - 0.5F) * 0.5D;
					double d1 = pos.getY() + 0.6F + (rand.nextFloat() - 0.5F) * 0.5D;
					double d2 = pos.getZ() + 0.5F + (rand.nextFloat() - 0.5F) * 0.5D;
					world.spawnParticle(Particles.LARGE_SMOKE, d0, d1 + 0.35D, d2, 0D, 0D, 0D);
				}
			}
		}
	}
	
	@Override
	public void onFallenUpon(World world, BlockPos pos, Entity entityIn, float fallDistance) {
		if (world.getBlockState(pos).getBlock() == ModBlocks.pillow_block) {
            entityIn.fall(fallDistance, 0.2f);
        }
        else {
            entityIn.fall(fallDistance, 1.0f);
        }
		
	}

}
