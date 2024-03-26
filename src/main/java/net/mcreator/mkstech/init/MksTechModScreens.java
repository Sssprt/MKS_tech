
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mkstech.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.mkstech.client.gui.PhoneguimessengerappScreen;
import net.mcreator.mkstech.client.gui.PhoneguiYTScreen;
import net.mcreator.mkstech.client.gui.PhoneguiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MksTechModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MksTechModMenus.PHONEGUI, PhoneguiScreen::new);
			MenuScreens.register(MksTechModMenus.PHONEGUI_YT, PhoneguiYTScreen::new);
			MenuScreens.register(MksTechModMenus.PHONEGUIMESSENGERAPP, PhoneguimessengerappScreen::new);
		});
	}
}
