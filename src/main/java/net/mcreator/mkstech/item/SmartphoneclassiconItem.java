
package net.mcreator.mkstech.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.mkstech.procedures.SmartphoneclassicoffPriNazhatiiPravoiKnopkoiMyshiProcedure;
import net.mcreator.mkstech.init.MksTechModTabs;

import java.util.List;

public class SmartphoneclassiconItem extends Item {
	public SmartphoneclassiconItem() {
		super(new Item.Properties().tab(MksTechModTabs.TAB_MKS_TECH).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Model: Classic"));
		list.add(new TextComponent("Color: Blue"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		SmartphoneclassicoffPriNazhatiiPravoiKnopkoiMyshiProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}
