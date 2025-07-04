package cc.emotion.modules.client;

import cc.emotion.Emotion;
import cc.emotion.features.managers.GuiManager;
import cc.emotion.features.options.Option;
import cc.emotion.features.options.impl.BooleanOption;
import cc.emotion.features.options.impl.DoubleOption;
import cc.emotion.features.options.impl.EnumOption;
import cc.emotion.features.screens.ClickGuiScreen;
import cc.emotion.modules.Module;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class Client extends Module {
    public static Client INSTANCE;

    public Client() {
        super("Client", Category.CLIENT);
        INSTANCE = this;
    }

    public Option<Boolean> sync = addOption(new BooleanOption("Sync"));
    public Option<Enum<?>> UIScale = addOption(new EnumOption("UIScale", UIScales.X100));
    public Option<Enum<?>> EspScale = addOption(new EnumOption("EspScale", UIScales.X100));
    public Option<Enum<?>> language = addOption(new EnumOption("Language", UIScales.X100));

    @Override
    public void onRegister() {
        this.getBind().setValue(344);
    }

    @Override
    public void onMouseMoveInClickGuiScreen(DrawContext context, double mouseX, double mouseY) {
        Emotion.GUI.onMouseMoveInClickGuiScreen(context, mouseX, mouseY);
    }

    @Override
    public void onDraw2D(DrawContext context, float tickDelta) {
        Render2DUtil.drawRoundedRect(context.getMatrices(), 10, 10, 60, 60, 6, new Color(0,0,0));
        if (GuiManager.CLICK_GUI_SCREEN != null && mc.currentScreen == null) {
            mc.setScreen(GuiManager.CLICK_GUI_SCREEN);
            Emotion.GUI.initClickGui();
        }
    }

    public enum UIScales {
        X50,
        X100,
        X150,
        X200
    }

    public enum EspScales {
        X50,
        X100,
        X150,
        X200
    }
}
