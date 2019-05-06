package com.stal111.compressed_items.item;

import com.stal111.compressed_items.Main;
import com.stal111.compressed_items.block.ModBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModItemGroup extends ItemGroup {

	public ModItemGroup(String label) {
		super(label);
		this.setBackgroundImageName("compressed_items_item_search.png");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModBlocks.wheat_seeds_sack);
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
	
	@Override
	public int getSearchbarWidth() {
		return 65;
	}
	
	@Override
	public ResourceLocation getTabsImage() {
		return new ResourceLocation(Main.MODID, "textures/gui/compressed_items_tabs.png");
	}

}
