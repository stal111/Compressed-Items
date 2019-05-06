package com.stal111.compressed_items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stal111.compressed_items.block.ModBlocks;
import com.stal111.compressed_items.item.ModItemGroup;
import com.stal111.compressed_items.item.ModItems;

@Mod(Main.MODID)
public class Main
{
	public static final String MODID = "compressed_items";

    public static final Logger LOGGER = LogManager.getLogger(Main.MODID);
    
    public static final ItemGroup COMPRESSED_ITEMS = new ModItemGroup(Main.MODID);

    public Main() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    	
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            ModItems.register(itemRegistryEvent);
        }
        
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            ModBlocks.register(blockRegistryEvent);
        }
    }
}
