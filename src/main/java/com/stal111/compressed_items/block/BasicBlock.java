package com.stal111.compressed_items.block;

import com.stal111.compressed_items.Main;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {

	public BasicBlock(String name, Material material, float hardnessAndResistance, SoundType soundType) {
		super(Block.Properties.create(material).hardnessAndResistance(hardnessAndResistance).sound(soundType));
		this.setRegistryName(Main.MODID, name);
	}

}
