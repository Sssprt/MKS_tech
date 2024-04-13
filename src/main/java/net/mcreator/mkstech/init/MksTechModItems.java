
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

import net.mcreator.mkstech.item.VideocardNmovieG720Item;
import net.mcreator.mkstech.item.TabletclassicItem;
import net.mcreator.mkstech.item.SmartwatchOldItem;
import net.mcreator.mkstech.item.SmartwatchNewYellowItem;
import net.mcreator.mkstech.item.SmartphoneclassiconItem;
import net.mcreator.mkstech.item.SmartphoneclassicoffItem;
import net.mcreator.mkstech.item.ProcessorOuttechu42413Item;
import net.mcreator.mkstech.item.MemoryHDD512gbItem;
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
	public static final RegistryObject<Item> SMARTWATCH_OLD = REGISTRY.register("smartwatch_old", () -> new SmartwatchOldItem());
	public static final RegistryObject<Item> SMARTWATCH_NEW_YELLOW = REGISTRY.register("smartwatch_new_yellow", () -> new SmartwatchNewYellowItem());
	public static final RegistryObject<Item> KEYBOARD = block(MksTechModBlocks.KEYBOARD, MksTechModTabs.TAB_MKS_TECH);
	public static final RegistryObject<Item> GAMING_MONITOR = block(MksTechModBlocks.GAMING_MONITOR, MksTechModTabs.TAB_MKS_TECH);
	public static final RegistryObject<Item> ROBOT_VACUUM_CLEANER = block(MksTechModBlocks.ROBOT_VACUUM_CLEANER, MksTechModTabs.TAB_MKS_TECH);
	public static final RegistryObject<Item> MEMORY_HDD_512GB = REGISTRY.register("memory_hdd_512gb", () -> new MemoryHDD512gbItem());
	public static final RegistryObject<Item> VIDEOCARD_NMOVIE_G_720 = REGISTRY.register("videocard_nmovie_g_720", () -> new VideocardNmovieG720Item());
	public static final RegistryObject<Item> PROCESSOR_OUTTECHU_42413 = REGISTRY.register("processor_outtechu_42413", () -> new ProcessorOuttechu42413Item());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
