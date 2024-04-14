
package net.mcreator.mkstech.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.mkstech.init.MksTechModTabs;

import java.util.List;

public class MotherboardMdeu4nmovieItem extends Item {
	public MotherboardMdeu4nmovieItem() {
		super(new Item.Properties().tab(MksTechModTabs.TAB_MKSTECHPCCOMPLECT).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Supported processor: \u00A7louttech u4\u00A7r"));
		list.add(new TextComponent("Supported video cards: \u00A7lnmovie G"));
	}
}
