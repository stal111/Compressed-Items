package com.stal111.compressed_items.items;

import com.stal111.compressed_items.Main;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModItemGroup extends ItemGroup {

	public ModItemGroup(String label) {
		super(label);
//		this.setBackgroundImageName("ci_item_search.png");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.gold_nugget_bag);
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
		return new ResourceLocation(Main.MODID, "textures/gui/ci_tabs.png");
	}

}
