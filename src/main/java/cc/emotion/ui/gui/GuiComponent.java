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
    protected GuiComponent parentComponent;
    protected ArrayList<GuiComponent> subComponents = new ArrayList<GuiComponent>();
    protected boolean pinned = false;

    protected boolean isHovered(double mouseX, double mouseY) {
        return x < mouseX && x + width > mouseX && y < mouseY && y + height > mouseY;
    }

    public abstract void onDraw(DrawContext context, double mouseX, double mouseY, boolean CLICK_LEFT, boolean CLICK_RIGHT);

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void addSub(GuiComponent component) {
        this.subComponents.add(component);
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public ArrayList<GuiComponent> getSubComponents() {
        return subComponents;
    }

    public void setParentComponent(GuiComponent parentComponent) {
        this.parentComponent = parentComponent;
    }

    public GuiComponent getParentComponent() {
        return parentComponent;
    }
}
