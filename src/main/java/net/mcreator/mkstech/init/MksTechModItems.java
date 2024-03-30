
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mkstech.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.mkstech.item.TabletclassicItem;
import net.mcreator.mkstech.item.SmartphoneclassiconItem;
import net.mcreator.mkstech.item.SmartphoneclassicoffItem;
import net.mcreator.mkstech.item.LaptopoldclassicItem;
import net.mcreator.mkstech.item.LaptopGamingItem;
import net.mcreator.mkstech.item.HeadphonesItem;
import net.mcreator.mkstech.MksTechMod;

public class MksTechModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MksTechMod.MODID);
	public static final RegistryObject<Item> SMARTPHONECLASSICON = REGISTRY.register("smartphoneclassicon", () -> new SmartphoneclassiconItem());
	public static final RegistryObject<Item> TABLETCLASSIC = REGISTRY.register("tabletclassic", () -> new TabletclassicItem());
	public static final RegistryObject<Item> LAPTOPOLDCLASSIC = REGISTRY.register("laptopoldclassic", () -> new LaptopoldclassicItem());
	public static final RegistryObject<Item> HEADPHONES = REGISTRY.register("headphones", () -> new HeadphonesItem());
	public static final RegistryObject<Item> LAPTOP_GAMING = REGISTRY.register("laptop_gaming", () -> new LaptopGamingItem());
	public static final RegistryObject<Item> LAPTOP_GAMING_BLOCK_OBJECT = block(MksTechModBlocks.LAPTOP_GAMING_BLOCK_OBJECT, MksTechModTabs.TAB_MKS_TECH);
	public static final RegistryObject<Item> SMARTPHONECLASSICOFF = REGISTRY.register("smartphoneclassicoff", () -> new SmartphoneclassicoffItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
