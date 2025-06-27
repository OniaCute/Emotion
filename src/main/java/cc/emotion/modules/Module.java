package cc.emotion.modules;

import cc.emotion.Emotion;
import cc.emotion.features.managers.TextManager;
import cc.emotion.features.options.Option;
import cc.emotion.features.options.impl.EnumOption;
import cc.emotion.util.interfaces.Wrapper;
import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;
import java.util.List;

public class Module implements Wrapper {
    private String name;
    private String displayName;
    private Category category;
    private int priority = 0;
    private boolean status = false; // default disabled
    public List<Option<?>> options = new ArrayList<>();

    public Module(String name, Category category) {
        this.name = name;
        this.displayName = Emotion.TEXT.get("Module.Modules." + name + ".name");
        this.category = category;
    }

    public <T> Option<T> addOption(Option<T> option) {
        options.add(option);
        return option;
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void onRegister() {
    }

    public void onTick() {
    }

    public void onDraw2D(DrawContext context,  float tickDelta) {
    }

    public void onMouseMoveInClickGuiScreen(DrawContext context,  double mouseX, double mouseY) {
    }

    public void onDraw3D() {
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Category getCategory() {
        return category;
    }

    public String getCategoryDisplayName(Category category) {
        return Emotion.TEXT.get("Module.Category." + name + ".name");
    }

    public List<Option<?>> getOptionsList() {
        return options;
    }

    public static ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(Category.CLIENT);
        categories.add(Category.COMBAT);
        categories.add(Category.MISC);
        categories.add(Category.EXPLOIT);
        categories.add(Category.MOVEMENT);
        categories.add(Category.PLAYER);
        categories.add(Category.VISUAL);
        categories.add(Category.HUD);
        return categories;
    }
    public enum Category {
        CLIENT, COMBAT, MISC, EXPLOIT, MOVEMENT, PLAYER, VISUAL, HUD
    }
}
