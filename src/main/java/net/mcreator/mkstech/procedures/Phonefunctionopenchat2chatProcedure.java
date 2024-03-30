package net.mcreator.mkstech.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.Util;

import java.util.HashMap;

public class Phonefunctionopenchat2chatProcedure {
	public static void execute(LevelAccessor world, HashMap guistate) {
		if (guistate == null)
			return;
		if (!world.isClientSide()) {
			MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
			if (_mcserv != null)
				_mcserv.getPlayerList().broadcastMessage(new TextComponent((guistate.containsKey("text:chat2chat_placeholder") ? ((EditBox) guistate.get("text:chat2chat_placeholder")).getValue() : "")), ChatType.SYSTEM, Util.NIL_UUID);
		}
	}
}
