package com.stal111.compressed_items.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class CutoutBlock extends BasicBlock {

	public CutoutBlock(String name, Material material, float hardness, float resistance, SoundType soundType) {
		super(name, material, hardness, resistance, soundType);
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

}
