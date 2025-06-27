package cc.emotion.ui.gui.impl;

import cc.emotion.Emotion;
import cc.emotion.features.enums.Aligns;
import cc.emotion.features.enums.FontSize;
import cc.emotion.features.managers.GuiManager;
import cc.emotion.features.options.impl.BooleanOption;
import cc.emotion.ui.gui.GuiComponent;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;
import org.joml.Math;
import oshi.util.tuples.Pair;

public class BooleanComponent extends GuiComponent {
    private BooleanOption option;

    public BooleanComponent(BooleanOption option) {
        this.option = option;
    }

    public void setOption(BooleanOption option) {
        this.option = option;
    }

    public BooleanOption getOption() {
        return option;
    }

    @Override
    public void onDraw(DrawContext context, double mouseX, double mouseY, boolean CLICK_LEFT, boolean CLICK_RIGHT) {
        this.x = GuiManager.latestComponentPosition.getA();
        this.y = GuiManager.latestComponentPosition.getB();

        FontUtil.drawTextWithAlign(
                context,
                this.option.getDisplayName(),
                this.x,
                this.y,
                this.x + this.width * FontUtil.getScaleFactor(),
                this.y + 30 * FontUtil.getScaleFactor(),
                Aligns.LEFT,
                Emotion.THEME.getTheme().getOptionsTextColor(),
                FontSize.SMALL
        );

        if (this.option.getValue()) {
            Pair<Double, Double> backgroundPosition = Render2DUtil.drawRoundedRectWithAlign(
                    context.getMatrices(),
                    this.x,
                    this.y,
                    this.x + this.width * FontUtil.getScaleFactor(),
                    this.y + 30 * FontUtil.getScaleFactor(),
                    3 * Render2DUtil.getScaleFactor(),
                    Emotion.THEME.getTheme().getButtonEnabledBackgroundColor(),
                    Aligns.RIGHT
            );

            Render2DUtil.drawCircleWithInline(
                    context.getMatrices(),
                    Emotion.THEME.getTheme().getButtonEnabledCircleColor(),
                    Emotion.THEME.getTheme().getButtonEnabledInlineColor(),
                    backgroundPosition.getA(),
                    backgroundPosition.getB(),
                    360,
                    1 * Render2DUtil.getScaleFactor(),
                    1 * Render2DUtil.getScaleFactor(),
                    360
            );
        } else {
            Render2DUtil.drawRoundedRectWithAlign(
                    context.getMatrices(),
                    this.x,
                    this.y,
                    this.x + this.width * FontUtil.getScaleFactor(),
                    this.y + 30 * FontUtil.getScaleFactor(),
                    3 * Render2DUtil.getScaleFactor(),
                    Emotion.THEME.getTheme().getButtonEnabledBackgroundColor(),
                    Aligns.RIGHT
            );
        }
    }
}
