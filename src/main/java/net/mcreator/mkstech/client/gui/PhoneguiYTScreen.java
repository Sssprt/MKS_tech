
package net.mcreator.mkstech.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.mkstech.world.inventory.PhoneguiYTMenu;
import net.mcreator.mkstech.network.PhoneguiYTButtonMessage;
import net.mcreator.mkstech.MksTechMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PhoneguiYTScreen extends AbstractContainerScreen<PhoneguiYTMenu> {
	private final static HashMap<String, Object> guistate = PhoneguiYTMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_microfrog;
	ImageButton imagebutton_home_button;

	public PhoneguiYTScreen(PhoneguiYTMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 150;
		this.imageHeight = 200;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, new ResourceLocation("mks_tech:textures/screens/smartphone_ui_bkgr.png"));
		this.blit(ms, this.leftPos + -4, this.topPos + -20, 0, 0, 160, 240, 160, 240);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
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
		button_microfrog = new Button(this.leftPos + 7, this.topPos + -4, 72, 20, new TranslatableComponent("gui.mks_tech.phonegui_yt.button_microfrog"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguiYTButtonMessage(0, x, y, z));
				PhoneguiYTButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_microfrog", button_microfrog);
		this.addRenderableWidget(button_microfrog);
		imagebutton_home_button = new ImageButton(this.leftPos + 55, this.topPos + 204, 44, 16, 0, 0, 16, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_home_button.png"), 44, 32, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguiYTButtonMessage(1, x, y, z));
				PhoneguiYTButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_button", imagebutton_home_button);
		this.addRenderableWidget(imagebutton_home_button);
	}
}
