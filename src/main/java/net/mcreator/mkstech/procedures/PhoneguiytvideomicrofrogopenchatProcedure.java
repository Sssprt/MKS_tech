package net.mcreator.mkstech.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class PhoneguiytvideomicrofrogopenchatProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("microfrog https://www.youtube.com/watch?v=Xpf5P7X0sNo"), (false));
	}
}
