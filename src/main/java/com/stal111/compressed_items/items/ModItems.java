package com.stal111.compressed_items.items;

import com.stal111.compressed_items.Main;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Main.MODID)
public class ModItems {
	
	public static final Item
			iron_nugget_bag = null,
			gold_nugget_bag = null;
		
	@SubscribeEvent
    public static void register(final RegistryEvent.Register<Item> registry) {
        registerItems(registry, 
        		new BasicItem("iron_nugget_bag"),
        		new BasicItem("gold_nugget_bag"));
    }
    
	
	public static void registerItems(final RegistryEvent.Register<Item> registry, final Item... items) {
		registry.getRegistry().registerAll(items);
    }

}
