package cc.emotion.util.render;

import cc.emotion.features.enums.Aligns;
import cc.emotion.modules.client.Client;
import cc.emotion.util.interfaces.Wrapper;
import cc.emotion.util.math.MathUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.joml.Math;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import oshi.util.tuples.Pair;

import java.awt.*;
import java.util.Stack;

public class Render2DUtil implements Wrapper {
    final static Stack<Rectangle> clipStack = new Stack<>();

    public static void enableRender() {
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
    }
    public static void disableRender() {
        RenderSystem.disableBlend();
    }

    public static void drawRect(DrawContext context, double x, double y, double width, double height, Color color) {
        drawRect(context, (x * getScaleFactor()), (y * getScaleFactor()), ((width) * getScaleFactor()), ((height) * getScaleFactor()), color.getRGB());
    }

    public static void drawRect(DrawContext context, double x, double y, double width, double height, int color) {
        drawRect(context, (float) (x * getScaleFactor()), (float) (y * getScaleFactor()), (float) (width * getScaleFactor()), (float) (height * getScaleFactor()), color);
    }

    public static void drawRect(DrawContext context, float x, float y, float width, float height, int color) {
        context.fill((int) (x * getScaleFactor()), (int) (y * getScaleFactor()), (int) ((x + width) * getScaleFactor()), (int) ((y + height) * getScaleFactor()), color);
    }

    public static void drawRect(DrawContext context, float x, float y, float width, float height, int color, float outlineWidth, int outlineColor) {
        x = (x * getScaleFactor());
        y = (y * getScaleFactor());
        width = ((width + x) * getScaleFactor());
        height = ((height + y) * getScaleFactor());

        context.fill((int) x, (int) y, (int) (x + width), (int) (y + height), color);
        context.fill((int) x, (int) y, (int) (x + width), (int) (y + outlineWidth), outlineColor);
        context.fill((int) x, (int) (y + height - outlineWidth), (int) (x + width), (int) (y + height), outlineColor);
        context.fill((int) x, (int) y, (int) (x + outlineWidth), (int) (y + height), outlineColor);
        context.fill((int) (x + width - outlineWidth), (int) y, (int) (x + width), (int) (y + height), outlineColor);
    }

    public static void drawRoundedRect(MatrixStack matrices, float x, float y, float width, float height, float radius, int color) {
        renderRounded(matrices, new Color(color), x, y, width + x, height + y, radius, 64);
    }

    public static void drawRoundedRect(MatrixStack matrices, float x, float y, float width, float height, float radius, Color color) {
        renderRounded(matrices, color, (x * getScaleFactor()), (y * getScaleFactor()), ((width + x) * getScaleFactor()), ((height + y) * getScaleFactor()), ((radius * getScaleFactor())), 64);
    }

    public static void drawRoundedRect(MatrixStack matrices, double x, double y, double width, double height, double radius, Color color) {
        drawRoundedRect(matrices, (float) x, (float) y, (float) width, (float) height, (float) radius, color);
    }

    public static void drawCircle(MatrixStack matrices, Color c, double originX, double originY, double radius, int segments) {
        originX *= getScaleFactor();
        originY *= getScaleFactor();
        radius *= getScaleFactor();
        int segments1 = MathHelper.clamp(segments, 4, 360);
        int color = c.getRGB();

        Matrix4f matrix = matrices.peek().getPositionMatrix();
        float f = transformColor((float) (color >> 24 & 255) / 255.0F);
        float g = (float) (color >> 16 & 255) / 255.0F;
        float h = (float) (color >> 8 & 255) / 255.0F;
        float k = (float) (color & 255) / 255.0F;
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
        enableRender();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
        Tessellator.getInstance().begin(VertexFormat.DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
        for (int i = 0; i < 360; i += Math.min(360 / segments1, 360 - i)) {
            double radians = Math.toRadians(i);
            double sin = Math.sin(radians) * radius;
            double cos = Math.cos(radians) * radius;
            bufferBuilder.vertex(matrix, (float) (originX + sin), (float) (originY + cos), 0).color(g, h, k, f);
        }
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
    }

    public static void drawCircleWithInline(MatrixStack matrices, Color baseColor, Color inlineColor,
                                            double originX, double originY, double radius,
                                            float inlineDistance, float inlineWidth, int segments) {
        inlineDistance *= getScaleFactor();
        inlineWidth *= getScaleFactor();

        drawCircle(matrices, baseColor, originX, originY, radius, segments);

        originX *= getScaleFactor();
        originY *= getScaleFactor();
        radius *= getScaleFactor();
        int clampedSegments = MathHelper.clamp(segments, 8, 360);
        Matrix4f matrix = matrices.peek().getPositionMatrix();

        float br = baseColor.getRed() / 255f;
        float bg = baseColor.getGreen() / 255f;
        float bb = baseColor.getBlue() / 255f;
        float ba = transformColor(baseColor.getAlpha() / 255f);

        float ir = inlineColor.getRed() / 255f;
        float ig = inlineColor.getGreen() / 255f;
        float ib = inlineColor.getBlue() / 255f;
        float ia = transformColor(inlineColor.getAlpha() / 255f);

        enableRender();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

        // 1. 绘制圆环
        float innerR = (float) (radius - inlineDistance - inlineWidth);
        float outerR = (float) (radius - inlineDistance);
        if (innerR > 0 && inlineWidth > 0) {
            BufferBuilder buffer = Tessellator.getInstance().begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
            for (int i = 0; i <= clampedSegments; i++) {
                double angle = 2 * Math.PI * i / clampedSegments;
                float cos = (float) Math.cos(angle);
                float sin = (float) Math.sin(angle);

                buffer.vertex(matrix, (float) (originX + cos * outerR), (float) (originY + sin * outerR), 0).color(ir, ig, ib, ia);
                buffer.vertex(matrix, (float) (originX + cos * innerR), (float) (originY + sin * innerR), 0).color(ir, ig, ib, ia);
            }
            BufferRenderer.drawWithGlobalProgram(buffer.end());
        }

        // 2. 清空圆环内部（主色）
        if (innerR > 0) {
            BufferBuilder buffer = Tessellator.getInstance().begin(VertexFormat.DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
            buffer.vertex(matrix, (float) originX, (float) originY, 0).color(br, bg, bb, ba);
            for (int i = 0; i <= clampedSegments; i++) {
                double angle = 2 * Math.PI * i / clampedSegments;
                float x = (float) (originX + Math.cos(angle) * innerR);
                float y = (float) (originY + Math.sin(angle) * innerR);
                buffer.vertex(matrix, x, y, 0).color(br, bg, bb, ba);
            }
            BufferRenderer.drawWithGlobalProgram(buffer.end());
        }

        disableRender();
    }

    public static void drawRectWithAlign(DrawContext context, double x1, double y1, double x2, double y2, Color color, Aligns align) {
        float width = (float) Math.abs(x2 - x1);
        float height = (float) Math.abs(y2 - y1);

        double[] aligned = getAlignPosition(x1, y1, x2, y2, width, height, align);
        drawRect(context, aligned[0], aligned[1], width, height, color);
    }

    public static Pair<Double, Double> drawRoundedRectWithAlign(MatrixStack matrices, double x1, double y1, double x2, double y2, double radius, Color color, Aligns align) {
        float width = (float) Math.abs(x2 - x1);
        float height = (float) Math.abs(y2 - y1);

        double[] aligned = getAlignPosition(x1, y1, x2, y2, width, height, align);
        drawRoundedRect(matrices, aligned[0], aligned[1], width, height, radius, color);
        return new Pair<Double, Double>(aligned[0], aligned[1]);
    }

    public static void drawCircleWithAlign(MatrixStack matrices, Color color,
                                           double x1, double y1, double x2, double y2, double radius, int segments, Aligns align) {
        double[] aligned = getAlignPosition(x1, y1, x2, y2, radius * 2, radius * 2, align);
        double cx = aligned[0] + radius;
        double cy = aligned[1] + radius;
        drawCircle(matrices, color, cx, cy, radius, segments);
    }

    public static void drawCircleWithInlineWithAlign(MatrixStack matrices, Color baseColor, Color inlineColor,
                                                     double x1, double y1, double x2, double y2, double radius,
                                                     float inlineDistance, float inlineWidth, int segments,
                                                     Aligns align) {
        double[] aligned = getAlignPosition(x1, y1, x2, y2, radius * 2, radius * 2, align);
        double originX = aligned[0] + radius;
        double originY = aligned[1] + radius;
        drawCircleWithInline(matrices, baseColor, inlineColor,
                originX, originY, radius,
                inlineDistance, inlineWidth, segments);
    }



    public static void renderRounded(MatrixStack matrices, Color c, double fromX, double fromY, double toX, double toY, double radius, double samples) {
        enableRender();
        RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
        renderRoundedInternal(matrices.peek().getPositionMatrix(), c.getRed() / 255f, c.getGreen() / 255f, c.getBlue() / 255f, c.getAlpha() / 255f, fromX, fromY, toX, toY, radius, samples);
        disableRender();
    }

    public static void renderRoundedInternal(Matrix4f matrix, float cr, float cg, float cb, float ca, double fromX, double fromY, double toX, double toY, double radius, double samples) {
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
        Tessellator.getInstance().begin(VertexFormat.DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);

        double[][] map = new double[][]{new double[]{toX - radius, toY - radius, radius}, new double[]{toX - radius, fromY + radius, radius}, new double[]{fromX + radius, fromY + radius, radius}, new double[]{fromX + radius, toY - radius, radius}};
        for (int i = 0; i < 4; i++) {
            double[] current = map[i];
            double rad = current[2];
            for (double r = i * 90d; r < (360 / 4d + i * 90d); r += (90 / samples)) {
                float rad1 = (float) Math.toRadians(r);
                float sin = (float) (Math.sin(rad1) * rad);
                float cos = (float) (Math.cos(rad1) * rad);
                bufferBuilder.vertex(matrix, (float) current[0] + sin, (float) current[1] + cos, 0.0F).color(cr, cg, cb, ca);
            }
            float rad1 = (float) Math.toRadians((360 / 4d + i * 90d));
            float sin = (float) (Math.sin(rad1) * rad);
            float cos = (float) (Math.cos(rad1) * rad);
            bufferBuilder.vertex(matrix, (float) current[0] + sin, (float) current[1] + cos, 0.0F).color(cr, cg, cb, ca);
        }
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
    }

    public static void pushDisplayArea(MatrixStack stack, Rectangle r1) {
        Matrix4f matrix = stack.peek().getPositionMatrix();
        Vector4f coord = new Vector4f(r1.x, r1.y, 0, 1);
        Vector4f end = new Vector4f(r1.x1, r1.y1, 0, 1);
        coord.mulTranspose(matrix);
        end.mulTranspose(matrix);
        float x = coord.x();
        float y = coord.y();
        float endX = end.x();
        float endY = end.y();
        Rectangle r = new Rectangle(x, y, endX, endY);
        if (clipStack.empty()) {
            clipStack.push(r);
            beginScissor(r.x, r.y, r.x1, r.y1);
        } else {
            Rectangle lastClip = clipStack.peek();
            float lsx = lastClip.x;
            float lsy = lastClip.y;
            float lstx = lastClip.x1;
            float lsty = lastClip.y1;
            float nsx = MathHelper.clamp(r.x, lsx, lstx);
            float nsy = MathHelper.clamp(r.y, lsy, lsty);
            float nstx = MathHelper.clamp(r.x1, nsx, lstx);
            float nsty = MathHelper.clamp(r.y1, nsy, lsty);
            clipStack.push(new Rectangle(nsx, nsy, nstx, nsty));
            beginScissor(nsx, nsy, nstx, nsty);
        }
    }

    public static void pushDisplayArea(MatrixStack stack, float x, float y, float x1, float y1, double animation_factor) {
        float h = y + y1;
        float h2 = (float) (h * (1d - MathUtil.clamp(animation_factor, 0, 1.0025f)));

        float x3 = x;
        float y3 = y + h2;
        float x4 = x1;
        float y4 = y1 - h2;

        if (x4 < x3) x4 = x3;
        if (y4 < y3) y4 = y3;
        pushDisplayArea(stack, new Rectangle(x3, y3, x4, y4));
    }

    public static void popDisplayArea() {
        clipStack.pop();
        if (clipStack.empty()) {
            endScissor();
        } else {
            Rectangle r = clipStack.peek();
            beginScissor(r.x, r.y, r.x1, r.y1);
        }
    }

    public static void beginScissor(double x, double y, double endX, double endY) {
        double width = endX - x;
        double height = endY - y;
        width = java.lang.Math.max(0, width);
        height = java.lang.Math.max(0, height);
        float d = (float) mc.getWindow().getScaleFactor();
        int ay = (int) ((mc.getWindow().getScaledHeight() - (y + height)) * d);
        RenderSystem.enableScissor((int) (x * d), ay, (int) (width * d), (int) (height * d));
    }

    public static void endScissor() {
        RenderSystem.disableScissor();
    }

    public record Rectangle(float x, float y, float x1, float y1) {
        public boolean contains(double x, double y) {
            return x >= this.x && x <= x1 && y >= this.y && y <= y1;
        }
    }

    public static double interpolate(double oldValue, double newValue, double interpolationValue) {
        return (oldValue + (newValue - oldValue) * interpolationValue);
    }

    public static float transformColor(float f) {
        return AlphaOverride.compute((int) (f * 255)) / 255f;
    }

    public static float getScaleFactor() {
        if (Client.INSTANCE == null || Client.INSTANCE.UIScale == null) {
            return 1.0f;
        }
        return switch ((Client.UIScales) Client.INSTANCE.UIScale.getValue()) {
            case X50 -> 0.5f;
            case X150 -> 1.5f;
            case X200 -> 2.0f;
            default -> 1.0f;
        };
    }

    public static double[] getAlignPosition(double x1, double y1, double x2, double y2, double width, double height, Aligns align) {
        float scale = getScaleFactor();
        width *= scale;
        height *= scale;
        x1 *= scale;
        y1 *= scale;
        x2 *= scale;
        y2 *= scale;

        double startX = x1, startY = y1;

        switch (align) {
            case LEFT -> {
                startX = x1;
                startY = (y1 + y2 - height) / 2;
            }
            case RIGHT -> {
                startX = x2 - width;
                startY = (y1 + y2 - height) / 2;
            }
            case CENTER -> {
                startX = (x1 + x2 - width) / 2;
                startY = (y1 + y2 - height) / 2;
            }
            case TOP -> {
                startX = (x1 + x2 - width) / 2;
                startY = y1;
            }
            case BOTTOM -> {
                startX = (x1 + x2 - width) / 2;
                startY = y2 - height;
            }
            case LEFT_TOP -> {
                startX = x1;
                startY = y1;
            }
            case LEFT_BOTTOM -> {
                startX = x1;
                startY = y2 - height;
            }
            case RIGHT_TOP -> {
                startX = x2 - width;
                startY = y1;
            }
            case RIGHT_BOTTOM -> {
                startX = x2 - width;
                startY = y2 - height;
            }
        }

        return new double[]{startX, startY};
    }
}
