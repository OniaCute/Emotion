package cc.emotion.util.render;

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
        drawRect(context, x, y, width, height, color.getRGB());
    }

    public static void drawRect(DrawContext context, double x, double y, double width, double height, int color) {
        drawRect(context, (float) x, (float) y, (float) width, (float) height, color);
    }

    public static void drawRect(DrawContext context, float x, float y, float width, float height, int color) {
        context.fill((int) x, (int) y, (int) (x + width), (int) (y + height), color);
    }

    public static void drawRect(DrawContext context, float x, float y, float width, float height, int color, float outlineWidth, int outlineColor) {
        context.fill((int) x, (int) y, (int) (x + width), (int) (y + height), color);
        context.fill((int) x, (int) y, (int) (x + width), (int) (y + outlineWidth), outlineColor);
        context.fill((int) x, (int) (y + height - outlineWidth), (int) (x + width), (int) (y + height), outlineColor);
        context.fill((int) x, (int) y, (int) (x + outlineWidth), (int) (y + height), outlineColor);
        context.fill((int) (x + width - outlineWidth), (int) y, (int) (x + width), (int) (y + height), outlineColor);
    }

    public static void drawRoundedRect(MatrixStack matrices, float x, float y, float width, float height, float radius, int color) {
        renderRounded(matrices, new Color(color), x, y, width + x, height + y, radius, 8);
    }

    public static void drawRoundedRect(MatrixStack matrices, float x, float y, float width, float height, float radius, Color color) {
        renderRounded(matrices, color, x, y, width + x, height + y, radius, 64);
    }

    public static void drawRoundedRect(MatrixStack matrices, double x, double y, double width, double height, double radius, Color color) {
        drawRoundedRect(matrices, (float) x, (float) y, (float) width, (float) height, (float) radius, color);
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
}
