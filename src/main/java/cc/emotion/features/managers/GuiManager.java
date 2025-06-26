package cc.emotion.features.managers;

import cc.emotion.features.enums.FontSize;
import cc.emotion.features.options.Option;
import cc.emotion.features.screens.ClickGuiScreen;
import cc.emotion.modules.Module;
import cc.emotion.ui.gui.GuiComponent;
import cc.emotion.ui.gui.impl.CategoryComponent;
import cc.emotion.ui.gui.impl.ModuleComponent;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.interfaces.Wrapper;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class GuiManager implements Wrapper {
    private static GuiComponent currentComponent = null;
    public static ArrayList<GuiComponent> rootComponents = new ArrayList<>();
    public static Pair<Double, Double> latestComponentPosition = new Pair<>(0.00, 0.00);
    public static ClickGuiScreen CLICK_GUI_SCREEN;
    public static boolean CLICKED_LEFT;
    public static boolean CLICKED_RIGHT;

    public GuiManager() {
        CLICK_GUI_SCREEN = new ClickGuiScreen();
    }

    public boolean isAvailable() {
        return currentComponent == null;
    }

    public boolean isAvailable(GuiComponent component) {
        return currentComponent == component;
    }

    public static void setCurrentComponent(GuiComponent currentComponent) {
        GuiManager.currentComponent = currentComponent;
    }

    public void onMouseMoveInClickGuiScreen(DrawContext context, double mouseX, double mouseY) {
        if (mc.currentScreen instanceof ClickGuiScreen) {
            drawClickScreen(context, mouseX, mouseY);
        }
    }

    public void initClickGui() {
        HashMap<Module.Category, Module> categoryModuleHashMap = new HashMap<>();
        for (Module module : ModuleManager.modules) {
            categoryModuleHashMap.put(module.getCategory(), module);
        }

        for (Module.Category category : categoryModuleHashMap.keySet()) {
            CategoryComponent categoryComponent = new CategoryComponent(category);
            for (Module module : ModuleManager.modules) {
                if (category == module.getCategory()) {
                    ModuleComponent moduleComponent = new ModuleComponent(module);
                    if (FontUtil.getWidth(FontSize.MEDIUM, moduleComponent.getModule().getDisplayName()) >= categoryComponent.getWidth()) {
                        categoryComponent.setWidth(FontUtil.getWidth(FontSize.MEDIUM, moduleComponent.getModule().getDisplayName()) + (4 * Render2DUtil.getScaleFactor()));
                    }
//                    for (Option<?> option : module.getOptionsList()) {
//                        // OptionComponents, pass
//                    }

                    moduleComponent.setParentComponent(categoryComponent);
                    categoryComponent.addSub(moduleComponent);
                }
            }
            rootComponents.add(categoryComponent);
        }
    }

    private void drawClickScreen(DrawContext context, double mouseX, double mouseY) {
        for (GuiComponent component : rootComponents) {
            component.onDraw(context, mouseX, mouseY, CLICKED_LEFT, CLICKED_RIGHT);
        }
    }
}
