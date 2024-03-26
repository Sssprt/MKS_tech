
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mkstech.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.mkstech.world.inventory.PhoneguimessengerappMenu;
import net.mcreator.mkstech.world.inventory.PhoneguiYTMenu;
import net.mcreator.mkstech.world.inventory.PhoneguiMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MksTechModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<PhoneguiMenu> PHONEGUI = register("phonegui", (id, inv, extraData) -> new PhoneguiMenu(id, inv, extraData));
	public static final MenuType<PhoneguiYTMenu> PHONEGUI_YT = register("phonegui_yt", (id, inv, extraData) -> new PhoneguiYTMenu(id, inv, extraData));
	public static final MenuType<PhoneguimessengerappMenu> PHONEGUIMESSENGERAPP = register("phoneguimessengerapp", (id, inv, extraData) -> new PhoneguimessengerappMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
