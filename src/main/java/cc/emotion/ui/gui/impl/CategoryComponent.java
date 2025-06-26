package cc.emotion.ui.gui.impl;

import cc.emotion.modules.Module;
import cc.emotion.ui.gui.GuiComponent;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;

public class CategoryComponent extends GuiComponent {
    public Module.Category category;

    public CategoryComponent(Module.Category category) {
        this.category = category;
    }

    @Override
    public void onDraw(DrawContext context, double mouseX, double mouseY, boolean CLICK_LEFT, boolean CLICK_RIGHT) {


        for (GuiComponent component : this.subComponents) {
            component.onDraw(context, mouseX, mouseY, CLICK_LEFT, CLICK_RIGHT);
        }
    }
}
