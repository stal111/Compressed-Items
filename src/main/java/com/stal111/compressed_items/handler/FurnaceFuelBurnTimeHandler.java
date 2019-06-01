package com.stal111.compressed_items.handler;

import com.stal111.compressed_items.block.ModBlocks;

import net.minecraft.item.Item;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FurnaceFuelBurnTimeHandler {
	
	@SubscribeEvent
	public static void initFurnaceFuelBurnTime(final FurnaceFuelBurnTimeEvent event) {
		final Item item = event.getItemStack().getItem();
		if (item == ModBlocks.charcoal_block.asItem()) {
			event.setBurnTime(16000);
		} else if (item == ModBlocks.branches_block.asItem()) {
			event.setBurnTime(1100);
		} else if (item == ModBlocks.blaze_rod_block.asItem()) {
			event.setBurnTime(19500);
		}
	}

}
