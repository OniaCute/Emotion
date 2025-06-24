package cc.emotion.util.font;

import cc.emotion.Emotion;
import cc.emotion.features.enums.FontScales;
import cc.emotion.features.enums.FontSize;
import cc.emotion.modules.client.Client;
import cc.emotion.util.interfaces.Wrapper;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class FontUtil implements Wrapper {
    public static FontScales asFontScales(Client.UIScales uiScales, FontSize size) {
        switch (uiScales) {
            case X50 -> {
                switch (size) {
                    case LARGEST -> {return FontScales.SMOOTH_7F;}
                    case LARGE -> {return FontScales.SMOOTH_6F;}
                    case MEDIUM -> {return FontScales.SMOOTH_5F;}
                    case SMALL -> {return FontScales.SMOOTH_4F;}
                    case SMALLEST -> {return FontScales.SMOOTH_3F;}
                }
            }
            case X100 -> {
                switch (size) {
                    case LARGEST -> {return FontScales.SMOOTH_14F;}
                    case LARGE -> {return FontScales.SMOOTH_12F;}
                    case MEDIUM -> {return FontScales.SMOOTH_10F;}
                    case SMALL -> {return FontScales.SMOOTH_8F;}
                    case SMALLEST -> {return FontScales.SMOOTH_6F;}
                }
            }
            case X150 -> {
                switch (size) {
                    case LARGEST -> {return FontScales.SMOOTH_21F;}
                    case LARGE -> {return FontScales.SMOOTH_18F;}
                    case MEDIUM -> {return FontScales.SMOOTH_15F;}
                    case SMALL -> {return FontScales.SMOOTH_12F;}
                    case SMALLEST -> {return FontScales.SMOOTH_9F;}
                }
            }
            case X200 -> {
                switch (size) {
                    case LARGEST -> {return FontScales.SMOOTH_28F;}
                    case LARGE -> {return FontScales.SMOOTH_24F;}
                    case MEDIUM -> {return FontScales.SMOOTH_20F;}
                    case SMALL -> {return FontScales.SMOOTH_16F;}
                    case SMALLEST -> {return FontScales.SMOOTH_12F;}
                }
            }
        }

        return FontScales.SMOOTH_10F;
    }

    public static double getWidth(FontSize size, String text) {
        if (Client.INSTANCE == null) {return FontRenderers.SMOOTH_10F.getWidth(text);}

        FontScales fontScales = asFontScales((Client.UIScales) Client.INSTANCE.UIScale.getValue(), size);
        switch (fontScales) {
            case SMOOTH_3F -> {return FontRenderers.SMOOTH_3F.getWidth(text);}
            case SMOOTH_4F -> {return FontRenderers.SMOOTH_4F.getWidth(text);}
            case SMOOTH_5F -> {return FontRenderers.SMOOTH_5F.getWidth(text);}
            case SMOOTH_6F -> {return FontRenderers.SMOOTH_6F.getWidth(text);}
            case SMOOTH_7F -> {return FontRenderers.SMOOTH_7F.getWidth(text);}
            case SMOOTH_8F -> {return FontRenderers.SMOOTH_8F.getWidth(text);}
            case SMOOTH_9F -> {return FontRenderers.SMOOTH_9F.getWidth(text);}
            case SMOOTH_10F -> {return FontRenderers.SMOOTH_10F.getWidth(text);}
            case SMOOTH_12F -> {return FontRenderers.SMOOTH_12F.getWidth(text);}
            case SMOOTH_14F -> {return FontRenderers.SMOOTH_14F.getWidth(text);}
            case SMOOTH_15F -> {return FontRenderers.SMOOTH_15F.getWidth(text);}
            case SMOOTH_16F -> {return FontRenderers.SMOOTH_16F.getWidth(text);}
            case SMOOTH_18F -> {return FontRenderers.SMOOTH_18F.getWidth(text);}
            case SMOOTH_20F -> {return FontRenderers.SMOOTH_20F.getWidth(text);}
            case SMOOTH_21F -> {return FontRenderers.SMOOTH_21F.getWidth(text);}
            case SMOOTH_24F -> {return FontRenderers.SMOOTH_24F.getWidth(text);}
            case SMOOTH_28F -> {return FontRenderers.SMOOTH_28F.getWidth(text);}
        }
        return FontRenderers.SMOOTH_10F.getWidth(text);
    }

    public static double getHeight(FontSize size) {
        return getHeight(size, "Get Emotion Get Good");
    }

    public static double getHeight(FontSize size, String text) {
        if (Client.INSTANCE == null) {return FontRenderers.SMOOTH_10F.getFontHeight(text);}

        FontScales fontScales = asFontScales((Client.UIScales) Client.INSTANCE.UIScale.getValue(), size);
        switch (fontScales) {
            case SMOOTH_3F -> {return FontRenderers.SMOOTH_3F.getFontHeight(text);}
            case SMOOTH_4F -> {return FontRenderers.SMOOTH_4F.getFontHeight(text);}
            case SMOOTH_5F -> {return FontRenderers.SMOOTH_5F.getFontHeight(text);}
            case SMOOTH_6F -> {return FontRenderers.SMOOTH_6F.getFontHeight(text);}
            case SMOOTH_7F -> {return FontRenderers.SMOOTH_7F.getFontHeight(text);}
            case SMOOTH_8F -> {return FontRenderers.SMOOTH_8F.getFontHeight(text);}
            case SMOOTH_9F -> {return FontRenderers.SMOOTH_9F.getFontHeight(text);}
            case SMOOTH_10F -> {return FontRenderers.SMOOTH_10F.getFontHeight(text);}
            case SMOOTH_12F -> {return FontRenderers.SMOOTH_12F.getFontHeight(text);}
            case SMOOTH_14F -> {return FontRenderers.SMOOTH_14F.getFontHeight(text);}
            case SMOOTH_15F -> {return FontRenderers.SMOOTH_15F.getFontHeight(text);}
            case SMOOTH_16F -> {return FontRenderers.SMOOTH_16F.getFontHeight(text);}
            case SMOOTH_18F -> {return FontRenderers.SMOOTH_18F.getFontHeight(text);}
            case SMOOTH_20F -> {return FontRenderers.SMOOTH_20F.getFontHeight(text);}
            case SMOOTH_21F -> {return FontRenderers.SMOOTH_21F.getFontHeight(text);}
            case SMOOTH_24F -> {return FontRenderers.SMOOTH_24F.getFontHeight(text);}
            case SMOOTH_28F -> {return FontRenderers.SMOOTH_28F.getFontHeight(text);}
        }
        return FontRenderers.SMOOTH_10F.getFontHeight(text);
    }

    public static void drawText(DrawContext context, String text, double x, double y, Color color, FontSize size) {
        drawText(context, text, (float) x, (float) y, color.getRGB(), size);
    }

    public static void drawText(DrawContext context, String text, float x, float y, Color color, FontSize size) {
        drawText(context, text, x, y, color.getRGB(), size);
    }

    public static void drawText(DrawContext context, String text, double x, double y, int color, FontSize size) {
        drawText(context, text, (float) x, (float) y, color, size);
    }

    public static void drawText(DrawContext context, String text, float x, float y, int color, FontSize size) {
        if (Client.INSTANCE == null) {return ;}

        Emotion.CONSOLE.logInfo("============================== on Gotten().");
        FontScales fontScales = asFontScales((Client.UIScales) Client.INSTANCE.UIScale.getValue(), size);
        switch (fontScales) {
            case SMOOTH_3F -> FontRenderers.SMOOTH_3F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_4F -> FontRenderers.SMOOTH_4F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_5F -> FontRenderers.SMOOTH_5F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_6F -> FontRenderers.SMOOTH_6F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_7F -> FontRenderers.SMOOTH_7F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_8F -> FontRenderers.SMOOTH_8F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_9F -> FontRenderers.SMOOTH_9F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_10F -> FontRenderers.SMOOTH_10F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_12F -> FontRenderers.SMOOTH_12F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_14F -> FontRenderers.SMOOTH_14F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_15F -> FontRenderers.SMOOTH_15F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_16F -> FontRenderers.SMOOTH_16F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_18F -> FontRenderers.SMOOTH_18F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_20F -> FontRenderers.SMOOTH_20F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_21F -> FontRenderers.SMOOTH_21F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_24F -> FontRenderers.SMOOTH_24F.drawString(context.getMatrices(), text, x, y, color);
            case SMOOTH_28F -> FontRenderers.SMOOTH_28F.drawString(context.getMatrices(), text, x, y, color);
        }
    }
}
