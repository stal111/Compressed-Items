package com.stal111.compressed_items.item;

import com.stal111.compressed_items.Main;
import com.stal111.compressed_items.block.ModBlocks;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class ModItems {
	
	public static final Item
			iron_nugget_bag = null,
			gold_nugget_bag = null;

    public static void register(final RegistryEvent.Register<Item> itemRegistryEvent) {
        registerItems(itemRegistryEvent, 
        		new BasicItem("iron_nugget_bag"),
        		new BasicItem("gold_nugget_bag"));
        
        ModBlocks.registerItemBlocks(itemRegistryEvent);
    }
    
	
	public static void registerItems(final RegistryEvent.Register<Item> itemRegistryEvent, final Item... items) {
		itemRegistryEvent.getRegistry().registerAll(items);
    }

}
