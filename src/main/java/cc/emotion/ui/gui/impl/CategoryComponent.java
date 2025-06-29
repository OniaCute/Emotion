package cc.emotion.ui.gui.impl;

import cc.emotion.Emotion;
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
    }

    @Override
    public void onMouseClick(double mouseX, double mouseY, MouseButtons button) {

    }

    @Override
    public void onMouseRelease(double mouseX, double mouseY, MouseButtons button) {

    }

    @Override
    public void onDraw(DrawContext context, double mouseX, double mouseY, boolean CLICK_LEFT, boolean CLICK_RIGHT) {
        Double latestComponentX = GuiManager.latestComponentPosition.getA();
        Double latestComponentY = GuiManager.latestComponentPosition.getB();
        this.x = latestComponentX + 5 * Render2DUtil.getScaleFactor();
        this.y = latestComponentY + 30 * Render2DUtil.getScaleFactor();

        Render2DUtil.drawRoundedRect(
                context.getMatrices(),
                this.x - 2 * Render2DUtil.getScaleFactor(),
                this.y,
                this.width + 4 * Render2DUtil.getScaleFactor(),
                this.getHeight(),
                3 * Render2DUtil.getScaleFactor(),
                Emotion.THEME.getTheme().getCategoryBackgroundColor()
        );

        GuiManager.latestComponentPosition = new Pair<>(this.x, this.y);

        for (GuiComponent component : this.subComponents) {
            component.onDraw(context, mouseX, mouseY, CLICK_LEFT, CLICK_RIGHT);
        }
    }
}
