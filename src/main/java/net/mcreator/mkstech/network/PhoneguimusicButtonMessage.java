
package net.mcreator.mkstech.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.mkstech.world.inventory.PhoneguimusicMenu;
import net.mcreator.mkstech.procedures.PhonehomebuttonscriptProcedure;
import net.mcreator.mkstech.procedures.AppmusicstopallProcedure;
import net.mcreator.mkstech.procedures.Appmusicplaywallc418Procedure;
import net.mcreator.mkstech.procedures.Appmusicplaywaitc418Procedure;
import net.mcreator.mkstech.procedures.Appmusicplaystradc418Procedure;
import net.mcreator.mkstech.procedures.Appmusicplaystalc418Procedure;
import net.mcreator.mkstech.procedures.AppmusicplaypigsteplenareyneProcedure;
import net.mcreator.mkstech.procedures.Appmusicplayfarc418Procedure;
import net.mcreator.mkstech.procedures.Appmusicplaycatc418Procedure;
import net.mcreator.mkstech.procedures.Appmusicplayblocksc418Procedure;
import net.mcreator.mkstech.procedures.Appmusicplay13c418Procedure;
import net.mcreator.mkstech.procedures.Appmusicplay11c418Procedure;
import net.mcreator.mkstech.MksTechMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PhoneguimusicButtonMessage {
	private final int buttonID, x, y, z;

	public PhoneguimusicButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PhoneguimusicButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PhoneguimusicButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PhoneguimusicButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = PhoneguimusicMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			AppmusicplaypigsteplenareyneProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			AppmusicstopallProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			Appmusicplaystradc418Procedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			Appmusicplaywaitc418Procedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			Appmusicplaycatc418Procedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			Appmusicplayblocksc418Procedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			Appmusicplaywallc418Procedure.execute(world, x, y, z);
		}
		if (buttonID == 7) {

			Appmusicplayfarc418Procedure.execute(world, x, y, z);
		}
		if (buttonID == 8) {

			Appmusicplaystalc418Procedure.execute(world, x, y, z);
		}
		if (buttonID == 9) {

			Appmusicplay13c418Procedure.execute(world, x, y, z);
		}
		if (buttonID == 10) {

			Appmusicplay11c418Procedure.execute(world, x, y, z);
		}
		if (buttonID == 11) {

			PhonehomebuttonscriptProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MksTechMod.addNetworkMessage(PhoneguimusicButtonMessage.class, PhoneguimusicButtonMessage::buffer, PhoneguimusicButtonMessage::new, PhoneguimusicButtonMessage::handler);
	}
}
