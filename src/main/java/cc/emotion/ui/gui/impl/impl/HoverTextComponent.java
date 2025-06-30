package cc.emotion.ui.gui.impl.impl;

import cc.emotion.Emotion;
import cc.emotion.features.enums.Aligns;
import cc.emotion.features.enums.FontSize;
import cc.emotion.features.enums.MouseButtons;
import cc.emotion.ui.gui.GuiComponent;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;

public class HoverTextComponent extends GuiComponent {
    private String text;

    public HoverTextComponent(String text, double x, double y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    @Override
    public void onDraw(DrawContext context, double mouseX, double mouseY) {
        Render2DUtil.drawRoundedRect(
                context.getMatrices(),
                this.x,
                this.y,
                FontUtil.getWidth(FontSize.SMALL, this.text),
                FontUtil.getHeight(FontSize.SMALL),
                2,
                Emotion.THEME.getTheme().getHoverComponentBackgroundColor()
        );
        FontUtil.drawTextWithAlign(
                context,
                this.text,
                this.x,
                this.y,
                this.x + FontUtil.getWidth(FontSize.SMALL, this.text),
                this.y + FontUtil.getHeight(FontSize.SMALL),
                Aligns.LEFT,
                Emotion.THEME.getTheme().getHoverComponentTextColor(),
                FontSize.SMALL
        );
    }

    @Override
    public void onMouseClick(double mouseX, double mouseY, MouseButtons button) {
    }

    @Override
    public void onMouseRelease(double mouseX, double mouseY, MouseButtons button) {
    }
}
