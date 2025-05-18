package cc.emotion.features.managers;

import cc.emotion.util.font.FontRenderers;
import cc.emotion.util.interfaces.Wrapper;
import net.minecraft.client.gui.DrawContext;
import cc.emotion.features.enums.Aligns;
import oshi.util.tuples.Pair;

import java.awt.*;

public class FontManager implements Wrapper {
    private Pair<Double, Double> getAlignPosition(String text, double x, double y, double width, double height, Aligns align) {
        double newX = x;
        double newY = y;

        int fontHeight = mc.textRenderer.fontHeight;
        int textWidth = mc.textRenderer.getWidth(text);

        switch (align) {
            case LEFT:
                newY += (height - fontHeight) / 2;
                break;
            case CENTER:
                newX += (width - textWidth) / 2;
                newY += (height - fontHeight) / 2;
                break;
            case RIGHT:
                newX += width - textWidth;
                newY += (height - fontHeight) / 2;
                break;
            case TOP:
                newX += (width - textWidth) / 2;
                newY -= fontHeight;
                break;
            case BOTTOM:
                newX += (width - textWidth) / 2;
                newY += height;
                break;
            case LEFT_TOP:
                break;
            case LEFT_BOTTOM:
                newY += height;
                break;
            case RIGHT_TOP:
                newX += width - textWidth;
                newY -= fontHeight;
                break;
            case RIGHT_BOTTOM:
                newX += width - textWidth;
                newY += height;
                break;
        }

        return new Pair<>(newX, newY);
    }

    private Pair<Double, Double> getAlignPosition(String text, double x, double y, double width, double height, Aligns align, CustomFontSize fontSize) {
        double newX = x;
        double newY = y;

        int fontHeight = 0;
        int textWidth = 0;

        switch (fontSize) {
            case SMOOTH_6F -> {
                fontHeight = (int) FontRenderers.SMOOTH_6F.getFontHeight();
                textWidth = (int) FontRenderers.SMOOTH_6F.getWidth(text);
            }
            case SMOOTH_8F -> {
                fontHeight = (int) FontRenderers.SMOOTH_8F.getFontHeight();
                textWidth = (int) FontRenderers.SMOOTH_8F.getWidth(text);
            }
            case SMOOTH_10F -> {
                fontHeight = (int) FontRenderers.SMOOTH.getFontHeight();
                textWidth = (int) FontRenderers.SMOOTH.getWidth(text);
            }
            case SMOOTH_12F -> {
                fontHeight = (int) FontRenderers.SMOOTH_12F.getFontHeight();
                textWidth = (int) FontRenderers.SMOOTH_12F.getWidth(text);
            }
            case SMOOTH_16F -> {
                fontHeight = (int) FontRenderers.SMOOTH_16F.getFontHeight();
                textWidth = (int) FontRenderers.SMOOTH_16F.getWidth(text);
            }
        }

        switch (align) {
            case LEFT:
                newY += (height - fontHeight) / 2;
                break;
            case CENTER:
                newX += (width - textWidth) / 2;
                newY += (height - fontHeight) / 2;
                break;
            case RIGHT:
                newX += width - textWidth;
                newY += (height - fontHeight) / 2;
                break;
            case TOP:
                newX += (width - textWidth) / 2;
                newY -= fontHeight;
                break;
            case BOTTOM:
                newX += (width - textWidth) / 2;
                newY += height;
                break;
            case LEFT_TOP:
                break;
            case LEFT_BOTTOM:
                newY += height;
                break;
            case RIGHT_TOP:
                newX += width - textWidth;
                newY -= fontHeight;
                break;
            case RIGHT_BOTTOM:
                newX += width - textWidth;
                newY += height;
                break;
        }

        return new Pair<>(newX, newY);
    }

    public double getCustomHeight() {
        return FontRenderers.SMOOTH.getFontHeight();
    }

    public double getCustomWidth(String string) {
        return FontRenderers.SMOOTH.getWidth(string);
    }

    public double getCustomHeight6F() {
        return FontRenderers.SMOOTH_6F.getFontHeight();
    }

    public double getCustomHeight8F() {
        return FontRenderers.SMOOTH_8F.getFontHeight();
    }

    public double getCustomWidth6F(String string) {
        return FontRenderers.SMOOTH_6F.getWidth(string);
    }

    public double getCustomWidth8F(String string) {
        return FontRenderers.SMOOTH_8F.getWidth(string);
    }

    public double getCustomHeight12F() {
        return FontRenderers.SMOOTH_12F.getFontHeight();
    }

    public double getCustomWidth12F(String string) {
        return FontRenderers.SMOOTH_12F.getWidth(string);
    }

    public double getCustomHeight16F() {
        return FontRenderers.SMOOTH_16F.getFontHeight();
    }

    public double getCustomWidth16F(String string) {
        return FontRenderers.SMOOTH_16F.getWidth(string);
    }

    public void drawCustomString6F(DrawContext context, String text, Color color, double x, double y) {
        FontRenderers.SMOOTH_6F.drawString(context.getMatrices(), text, (int) x - 2, (int) y - 0.3, color.getRGB());
    }

    public void drawCustomString8F(DrawContext context, String text, Color color, double x, double y) {
        FontRenderers.SMOOTH_8F.drawString(context.getMatrices(), text, (int) x - 2, (int) y - 0.3, color.getRGB());
    }

    public void drawCustomString(DrawContext context, String text, Color color, double x, double y) {
        FontRenderers.SMOOTH.drawString(context.getMatrices(), text, (int) x - 2, (int) y - 0.3, color.getRGB());
    }

    public void drawCustomString12F(DrawContext context, String text, Color color, double x, double y) {
        FontRenderers.SMOOTH_12F.drawString(context.getMatrices(), text, (int) x - 2, (int) y - 0.3, color.getRGB());
    }

    public void drawCustomString16F(DrawContext context, String text, Color color, double x, double y) {
        FontRenderers.SMOOTH_16F.drawString(context.getMatrices(), text, (int) x - 2, (int) y - 0.3, color.getRGB());
    }

    public void drawCustomStringWithScale(DrawContext context, String text, Color color, double x, double y, float scale, boolean shadow) {
        if (scale != 1) {
            context.getMatrices().push();
            context.getMatrices().scale(scale, scale, 1.0f);
            if (scale > 1.0f) {
                context.getMatrices().translate(-x / scale, -y / scale, 0.0f);
            } else {
                context.getMatrices().translate((x / scale) - x, (y * scale) - y, 0.0f);
            }
        }
        drawCustomString(context, text, color, x, y);
        context.getMatrices().pop();
    }

    public void drawCustomStringWithAlign8F(DrawContext context, String text, Color color, double x, double y, double width, double height, Aligns align) {
        double newX = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_8F).getA();
        double newY = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_8F).getB();
        drawCustomString8F(context, text, color, newX, newY);
    }

    public void drawCustomStringWithAlign6F(DrawContext context, String text, Color color, double x, double y, double width, double height, Aligns align) {
        double newX = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_6F).getA();
        double newY = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_6F).getB();
        drawCustomString6F(context, text, color, newX, newY);
    }


    public Pair<Double, Double> drawCustomStringWithAlign8FWithReturn(DrawContext context, String text, Color color, double x, double y, double width, double height, Aligns align) {
        double newX = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_8F).getA();
        double newY = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_8F).getB();
        drawCustomString8F(context, text, color, newX, newY);
        return new Pair<>(newX, newY);
    }

    public void drawCustomStringWithAlign(DrawContext context, String text, Color color, double x, double y, double width, double height, Aligns align) {
        double newX = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_10F).getA();
        double newY = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_10F).getB();
        drawCustomString(context, text, color, newX, newY);
    }

    public void drawCustomStringWithAlign12F(DrawContext context, String text, Color color, double x, double y, double width, double height, Aligns align) {
        double newX = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_12F).getA();
        double newY = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_12F).getB();
        drawCustomString12F(context, text, color, newX, newY);
    }

    public void drawCustomStringWithAlign16F(DrawContext context, String text, Color color, double x, double y, double width, double height, Aligns align) {
        double newX = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_16F).getA();
        double newY = getAlignPosition(text, x, y, width, height, align, CustomFontSize.SMOOTH_16F).getB();
        drawCustomString16F(context, text, color, newX, newY);
    }

    public void drawCustomStringWithAlignWithScale(DrawContext context, String text, Color color, double x, double y, double width, double height, float scale, Aligns align) {
        if (scale != 1) {
            context.getMatrices().push();
            context.getMatrices().scale(scale, scale, 1.0f);
            if (scale > 1.0f) {
                context.getMatrices().translate(-x / scale, -y / scale, 0.0f);
            } else {
                context.getMatrices().translate((x / scale) - x, (y * scale) - y, 0.0f);
            }
        }
        drawCustomStringWithAlign(context, text, color, x, y, width, height, align);
        context.getMatrices().pop();
    }

    // Minecraft Fonts

    public void drawMinecraftString(DrawContext context, String text, Color color, double x, double y, boolean shadow) {
        context.drawText(mc.textRenderer, text, (int) x, (int) y, color.getRGB(), shadow);
    }

    public void drawMinecraftString(DrawContext context, String text, double x, double y, boolean shadow) {
        drawMinecraftString(context, text, new Color(255, 255, 255), x, y, shadow);
    }

    public void drawMinecraftString(DrawContext context, String text, double x, double y) {
        drawMinecraftString(context, text, new Color(255, 255, 255), x, y, true);
    }

    public void drawMinecraftStringWithScale(DrawContext context, String text, Color color, double x, double y, float scale, boolean shadow) {
        if (scale != 1) {
            context.getMatrices().push();
            context.getMatrices().scale(scale, scale, 1.0f);
            if (scale > 1.0f) {
                context.getMatrices().translate(-x / scale, -y / scale, 0.0f);
            } else {
                context.getMatrices().translate((x / scale) - x, (y * scale) - y, 0.0f);
            }
        }
        context.drawText(mc.textRenderer, text, (int)x, (int)y, color.getRGB(), shadow);
        context.getMatrices().pop();
    }

    public void drawMinecraftStringWithScale(DrawContext context, String text, double x, double y, float scale, boolean shadow) {
        drawMinecraftStringWithScale(context, text, new Color(255, 255, 255), x, y, scale, shadow);
    }

    public void drawMinecraftStringWithScale(DrawContext context, String text, double x, double y, float scale) {
        drawMinecraftStringWithScale(context, text, new Color(255, 255, 255), x, y, scale, true);
    }

    public void drawMinecraftStringWithAlign(DrawContext context, String text, Color color, double x, double y, double width, double height, boolean shadow, Aligns align) {
        double newX = x;
        double newY = y;

        int fontHeight = mc.textRenderer.fontHeight;
        int textWidth = mc.textRenderer.getWidth(text);

        switch (align) {
            case LEFT:
                newY += (height - fontHeight) / 2;
                break;
            case CENTER:
                newX += (width - textWidth) / 2;
                newY += (height - fontHeight) / 2;
                break;
            case RIGHT:
                newX += width - textWidth;
                newY += (height - fontHeight) / 2;
                break;
            case TOP:
                newX += (width - textWidth) / 2;
                newY -= fontHeight;
                break;
            case BOTTOM:
                newX += (width - textWidth) / 2;
                newY += height;
                break;
            case LEFT_TOP:
                break;
            case LEFT_BOTTOM:
                newY += height;
                break;
            case RIGHT_TOP:
                newX += width - textWidth;
                newY -= fontHeight;
                break;
            case RIGHT_BOTTOM:
                newX += width - textWidth;
                newY += height;
                break;
        }

        drawMinecraftString(context, text, color, newX, newY, shadow);
    }

    public void drawMinecraftStringWithAlign(DrawContext context, String text, double x, double y, double width, double height, boolean shadow, Aligns align) {
        drawMinecraftStringWithAlign(context, text, new Color(255, 255, 255), x, y, width, height, shadow, align);
    }

    public void drawMinecraftStringWithAlign(DrawContext context, String text, double x, double y, double width, double height, Aligns align) {
        drawMinecraftStringWithAlign(context, text, new Color(255, 255, 255), x, y, width, height, true, align);
    }
}