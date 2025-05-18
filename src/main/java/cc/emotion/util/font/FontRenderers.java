package cc.emotion.util.font;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class FontRenderers {
    public static FontAdapter SMOOTH;
    public static @NotNull RendererFontAdapter createDefault(float size, String name) throws IOException, FontFormatException {
        return new RendererFontAdapter(Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(FontRenderers.class.getClassLoader().getResourceAsStream("assets/minecraft/font/" + name + ".ttf"))).deriveFont(Font.PLAIN, size), size);
    }

    public static RendererFontAdapter create(String name, int style, float size) {
        return new RendererFontAdapter(new Font(name, style, (int) size), size);
    }

    public static RendererFontAdapter SmoothFont(float size) throws IOException, FontFormatException {
        InputStream fontStream = FontRenderers.class.getClassLoader().getResourceAsStream("assets/nafity/fonts/Smooth.otf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(Font.PLAIN, size);
        return new RendererFontAdapter(font, size);
    }
}