package net.mcreator.mkstech.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.item.ItemStack;

import net.mcreator.mkstech.init.MksTechModItems;

public class FullchargesmartphoneprocedureProcedure {
	public static void execute() {
		{
			ItemStack _isc = new ItemStack(MksTechModItems.SMARTPHONECLASSICOFF.get());
			final ItemStack _setstack = new ItemStack(MksTechModItems.SMARTPHONECLASSICON.get());
			final int _sltid = 0;
			_setstack.setCount(1);
			_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
	}
}
