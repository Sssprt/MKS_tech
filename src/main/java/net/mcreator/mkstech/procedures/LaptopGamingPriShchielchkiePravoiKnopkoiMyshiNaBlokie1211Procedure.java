package net.mcreator.mkstech.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.item.ItemStack;

import net.mcreator.mkstech.init.MksTechModBlocks;

public class LaptopGamingPriShchielchkiePravoiKnopkoiMyshiNaBlokie1211Procedure {
	public static void execute(ItemStack itemstack) {
		{
			ItemStack _isc = itemstack;
			final ItemStack _setstack = new ItemStack(MksTechModBlocks.LAPTOP_GAMING_BLOCK_OBJECT.get());
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
