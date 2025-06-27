package cc.emotion.ui.gui.impl;

import cc.emotion.Emotion;
import cc.emotion.features.enums.Aligns;
import cc.emotion.features.enums.FontSize;
import cc.emotion.features.managers.GuiManager;
import cc.emotion.modules.Module;
import cc.emotion.ui.gui.GuiComponent;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;
import oshi.util.tuples.Pair;

public class ModuleComponent extends GuiComponent {
    private Module module;
    private boolean isSpread = false;
    public ModuleComponent(Module module) {
        this.module = module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    public void spread() {
        this.isSpread = true;
    }

    public boolean isSpread() {
        return isSpread;
    }


    @Override
    public void onDraw(DrawContext context, double mouseX, double mouseY, boolean CLICK_LEFT, boolean CLICK_RIGHT) {
        Double latestComponentX = GuiManager.latestComponentPosition.getA();
        Double latestComponentY = GuiManager.latestComponentPosition.getB();
        this.x = latestComponentX;
        this.y = latestComponentY + 30 * Render2DUtil.getScaleFactor();

        if (this.module.getStatus()) {
            Render2DUtil.drawRect(
                    context,
                    this.x,
                    this.y,
                    this.width * Render2DUtil.getScaleFactor(),
                    30 * Render2DUtil.getScaleFactor(),
                    Emotion.THEME.getTheme().getModuleEnabledBackgroundColor()
            );

            FontUtil.drawTextWithAlign(
                    context,
                    this.module.getDisplayName(),
                    this.x,
                    this.y,
                    this.x + this.width * Render2DUtil.getScaleFactor(),
                    this.y + 30 * Render2DUtil.getScaleFactor(),
                    Aligns.CENTER,
                    Emotion.THEME.getTheme().getModuleEnabledTextColor(),
                    FontSize.MEDIUM
            );
        } else {
            Render2DUtil.drawRect(
                    context,
                    this.x,
                    this.y,
                    this.width * Render2DUtil.getScaleFactor(),
                    30 * Render2DUtil.getScaleFactor(),
                    Emotion.THEME.getTheme().getModuleBackgroundColor()
            );

            FontUtil.drawTextWithAlign(
                    context,
                    this.module.getDisplayName(),
                    this.x,
                    this.y,
                    this.x + this.width * Render2DUtil.getScaleFactor(),
                    this.y + 30 * Render2DUtil.getScaleFactor(),
                    Aligns.CENTER,
                    Emotion.THEME.getTheme().getModuleTextColor(),
                    FontSize.MEDIUM
            );
        }

        GuiManager.latestComponentPosition = new Pair<>(this.x, this.y);

        if (isSpread()) {
            for (GuiComponent component : this.getSubComponents()) {
                component.onDraw(context, mouseX, mouseY, CLICK_LEFT, CLICK_RIGHT);
            }
        }
    }
}
