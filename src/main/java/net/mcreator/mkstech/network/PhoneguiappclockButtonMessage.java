
package net.mcreator.mkstech.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.mkstech.world.inventory.PhoneguiappclockMenu;
import net.mcreator.mkstech.procedures.PhonehomebuttonscriptProcedure;
import net.mcreator.mkstech.procedures.AppclocktimesetfullnightProcedure;
import net.mcreator.mkstech.procedures.AppclocktimesetdayProcedure;
import net.mcreator.mkstech.MksTechMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PhoneguiappclockButtonMessage {
	private final int buttonID, x, y, z;

	public PhoneguiappclockButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PhoneguiappclockButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PhoneguiappclockButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PhoneguiappclockButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = PhoneguiappclockMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			AppclocktimesetdayProcedure.execute(world);
		}
		if (buttonID == 1) {

			AppclocktimesetfullnightProcedure.execute(world);
		}
		if (buttonID == 2) {

			PhonehomebuttonscriptProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MksTechMod.addNetworkMessage(PhoneguiappclockButtonMessage.class, PhoneguiappclockButtonMessage::buffer, PhoneguiappclockButtonMessage::new, PhoneguiappclockButtonMessage::handler);
	}
}
