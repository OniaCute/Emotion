package cc.emotion.ui.gui.impl;

import cc.emotion.Emotion;
import cc.emotion.features.enums.Aligns;
import cc.emotion.features.enums.FontSize;
import cc.emotion.features.enums.MouseButtons;
import cc.emotion.features.managers.GuiManager;
import cc.emotion.modules.Module;
import cc.emotion.ui.gui.GuiComponent;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;
import oshi.util.tuples.Pair;

public class CategoryComponent extends GuiComponent {
    public Module.Category category;

    public CategoryComponent(Module.Category category) {
        this.category = category;
        this.setDisplayName(Emotion.TEXT.get("Module.Category." + category.name() + ".name"));
    }

    @Override
    public void onMouseClick(double mouseX, double mouseY, MouseButtons button) {

    }

    @Override
    public void onMouseRelease(double mouseX, double mouseY, MouseButtons button) {

    }

    @Override
    public void onDraw(DrawContext context, double mouseX, double mouseY) {
        Render2DUtil.drawRoundedRect(
                context.getMatrices(),
                this.getX(),
                this.getY(),
                this.getWidth(),
                this.getHeight(),
                3 * Render2DUtil.getScaleFactor(),
                Emotion.THEME.getTheme().getCategoryBackgroundColor()
        );

        FontUtil.drawTextWithAlign(
                context,
                this.getDisplayName(),
                this.getX(),
                this.getY(),
                this.getX() + this.getWidth(),
                this.getY() + this.getHeight(),
                Aligns.CENTER,
                Emotion.THEME.getTheme().getCategoryTextColor(),
                FontSize.LARGEST
        );

        for (GuiComponent component : this.subComponents) {
            component.onDraw(context, mouseX, mouseY);
        }
    }
}
