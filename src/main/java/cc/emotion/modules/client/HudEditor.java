package cc.emotion.modules.client;

import cc.emotion.Emotion;
import cc.emotion.modules.Module;
import net.minecraft.client.gui.DrawContext;

public class HudEditor extends Module {
    public static HudEditor INSTANCE;
    public HudEditor() {
        super("HudEditor", Category.CLIENT);
        INSTANCE = this;
    }

    @Override
    public void onMouseMoveInHudEditorScreen(DrawContext context, double mouseX, double mouseY) {
        Emotion.GUI.onMouseMoveInHudEditorScreen(context, mouseX, mouseY);
    }
}
