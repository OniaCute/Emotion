package cc.emotion.ui.gui;

import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;

public abstract class GuiComponent {
    protected int id;
    protected String name;
    protected String displayName;
    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected ArrayList<GuiComponent> subComponents = new ArrayList<GuiComponent>();
    protected boolean pinned = false;

    public void onDraw(DrawContext context, float tickDelta) {
    }
}
