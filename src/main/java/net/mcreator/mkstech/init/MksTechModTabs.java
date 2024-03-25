
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mkstech.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class MksTechModTabs {
	public static CreativeModeTab TAB_MKS_TECH;

	public static void load() {
		TAB_MKS_TECH = new CreativeModeTab("tabmks_tech") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MksTechModItems.SMARTPHONECLASSICOFF.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
