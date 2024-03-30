
package net.mcreator.mkstech.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.mkstech.world.inventory.PhoneguimessengerappMenu;
import net.mcreator.mkstech.network.PhoneguimessengerappButtonMessage;
import net.mcreator.mkstech.MksTechMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PhoneguimessengerappScreen extends AbstractContainerScreen<PhoneguimessengerappMenu> {
	private final static HashMap<String, Object> guistate = PhoneguimessengerappMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox chat2chat_placeholder;
	Button button_send;
	ImageButton imagebutton_home_button_rotated;

	public PhoneguimessengerappScreen(PhoneguimessengerappMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 150;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		chat2chat_placeholder.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, new ResourceLocation("mks_tech:textures/screens/smartphoneguirotated.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + -1, 0, 0, 200, 150, 200, 150);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (chat2chat_placeholder.isFocused())
			return chat2chat_placeholder.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		chat2chat_placeholder.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		chat2chat_placeholder = new EditBox(this.font, this.leftPos + 20, this.topPos + 107, 120, 20, new TranslatableComponent("gui.mks_tech.phoneguimessengerapp.chat2chat_placeholder"));
		chat2chat_placeholder.setMaxLength(32767);
		guistate.put("text:chat2chat_placeholder", chat2chat_placeholder);
		this.addWidget(this.chat2chat_placeholder);
		button_send = new Button(this.leftPos + 140, this.topPos + 107, 46, 20, new TranslatableComponent("gui.mks_tech.phoneguimessengerapp.button_send"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimessengerappButtonMessage(0, x, y, z));
				PhoneguimessengerappButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_send", button_send);
		this.addRenderableWidget(button_send);
		imagebutton_home_button_rotated = new ImageButton(this.leftPos + 188, this.topPos + 59, 10, 26, 0, 0, 26, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_home_button_rotated.png"), 10, 52, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimessengerappButtonMessage(1, x, y, z));
				PhoneguimessengerappButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_button_rotated", imagebutton_home_button_rotated);
		this.addRenderableWidget(imagebutton_home_button_rotated);
	}
}
