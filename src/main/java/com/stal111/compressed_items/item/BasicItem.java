package com.stal111.compressed_items.item;

import com.stal111.compressed_items.Main;

import net.minecraft.item.Item;

public class BasicItem extends Item {

	public BasicItem(String name) {
		super(new Item.Properties().group(Main.COMPRESSED_ITEMS));
		this.setRegistryName(Main.MODID, name);
	}
	
}
