package com.stal111.compressed_items.block;

import com.stal111.compressed_items.Main;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class TranslucentBlock extends AbstractGlassBlock {

	public TranslucentBlock(String name, Material material, float hardness, float resistance) {
		super(Block.Properties.create(material).hardnessAndResistance(hardness, resistance));
		this.setRegistryName(Main.MODID, name);
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
}
