
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mkstech.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.mkstech.item.SmartphoneclassicoffItem;
import net.mcreator.mkstech.MksTechMod;

public class MksTechModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MksTechMod.MODID);
	public static final RegistryObject<Item> SMARTPHONECLASSICOFF = REGISTRY.register("smartphoneclassicoff", () -> new SmartphoneclassicoffItem());
}
