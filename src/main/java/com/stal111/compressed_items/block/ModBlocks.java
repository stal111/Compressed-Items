package com.stal111.compressed_items.block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.stal111.compressed_items.Main;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class ModBlocks {
	
    public static List<Block> blockList = new ArrayList<Block>();
    
	public static final Block
			wheat_seeds_sack = null,
			carrot_sack = null,
			melon_seeds_sack = null,
			pumpkin_seeds_sack = null,
			potato_sack = null,
			beetroot_sack = null,
			beetroot_seeds_sack = null,
			gunpowder_sack = null,
			sugar_sack = null,
			iron_nugget_sack = null,
			gold_nugget_sack = null,
			set_of_eggs = null,
			leather_block = null,
			pillow_block = null,
			nether_star_block = null,
			charcoal_block = null,
			sugar_cane_block = null,
			totem_block = null,
			wallpaper_block = null,
			phantom_membrane_block = null,
			flint_block = null,
			branches_block = null,
			apple_block = null,
			golden_apple_block = null,
			ender_pearl_block = null,
			blaze_rod_block = null;
	
	 public static void register(final RegistryEvent.Register<Block> blockRegistryEvent) {
	        registerBlocks(blockRegistryEvent, 
	        		new SackBlock("wheat_seeds_sack"),
	        		new SackBlock("carrot_sack"),
	        		new SackBlock("melon_seeds_sack"),
	        		new SackBlock("pumpkin_seeds_sack"),
	        		new SackBlock("potato_sack"),
	        		new SackBlock("beetroot_sack"),
	        		new SackBlock("beetroot_seeds_sack"),
	        		new SackBlock("gunpowder_sack"),
	        		new SackBlock("sugar_sack"),
	        		new SackBlock("iron_nugget_sack"),
	        		new SackBlock("gold_nugget_sack"),
	        		new SackBlock("set_of_eggs"),
	        		new BasicBlock("leather_block", Material.CLOTH, 1.5F, SoundType.CLOTH),
	        		new BasicBlock("pillow_block", Material.CLOTH, 0.7F, SoundType.CLOTH),
	        		new BasicBlock("nether_star_block", Material.IRON, 60F, SoundType.METAL),
	        		new BasicBlock("charcoal_block", Material.ROCK, 3.5F, SoundType.STONE),
	        		new CutoutBlock("sugar_cane_block", Material.PLANTS, 0.7F, SoundType.PLANT),
	        		new TotemBlock("totem_block", Material.WOOD, 3.0F, SoundType.WOOD),
	        		new BasicBlock("wallpaper_block", Material.CIRCUITS, 1.0F, SoundType.CLOTH),
	        		new PhantomMembraneBlock("phantom_membrane_block", Material.CIRCUITS, 1.2F, 3.2F),
	        		new BasicBlock("flint_block", Material.ROCK, 3F, 20F, SoundType.STONE),
	        		new BasicBlock("branches_block", Material.WOOD, 3F, 5F, SoundType.WOOD),
	        		new FallingBlock("apple_block", Material.CACTUS, 1.0F, SoundType.CLOTH),
	        		new FallingBlock("golden_apple_block", Material.CACTUS, 1.0F, SoundType.CLOTH),
	        		new BasicBlock("ender_pearl_block", Material.ROCK, 3.1F, 25F, SoundType.STONE),
	        		new BasicBlock("blaze_rod_block", Material.ROCK, 3.1F, 25F, SoundType.STONE));
	    }
	
	public static void registerBlocks(final RegistryEvent.Register<Block> blockRegistryEvent, final Block... blocks) {
		blockList.addAll(Arrays.asList(blocks));
		blockRegistryEvent.getRegistry().registerAll(blocks);
    }
	
	public static void registerItemBlocks(final RegistryEvent.Register<Item> registry) {
		for (final Block block : blockList) {
			registry.getRegistry().registerAll(new ItemBlock(block, new Item.Properties().group(Main.COMPRESSED_ITEMS)).setRegistryName(block.getRegistryName()));
		}
	}

}
