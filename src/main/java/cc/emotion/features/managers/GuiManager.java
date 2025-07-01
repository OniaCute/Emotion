package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.features.enums.Aligns;
import cc.emotion.features.enums.FontSize;
import cc.emotion.features.enums.MouseButtons;
import cc.emotion.features.options.Option;
import cc.emotion.features.screens.ClickGuiScreen;
import cc.emotion.features.screens.HudEditorScreen;
import cc.emotion.modules.Module;
import cc.emotion.modules.client.Client;
import cc.emotion.ui.gui.GuiComponent;
import cc.emotion.ui.gui.impl.CategoryComponent;
import cc.emotion.ui.gui.impl.ModuleComponent;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.interfaces.Wrapper;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class GuiManager implements Wrapper {
    private static GuiComponent currentComponent = null;
    public static ArrayList<GuiComponent> rootComponents = new ArrayList<>();
    public static Pair<Double, Double> latestComponentPosition = new Pair<>(0.00, 0.00);
    public static ClickGuiScreen CLICK_GUI_SCREEN = new ClickGuiScreen();;
    public static HudEditorScreen HUD_EDITOR_SCREEN = new HudEditorScreen();
    public static boolean isComponentsLoaded = false;

    public GuiManager() {
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
            drawClickGuiScreen(context, mouseX, mouseY);
        }
    }

    public void onMouseMoveInHudEditorScreen(DrawContext context, double mouseX, double mouseY) {
        if (mc.currentScreen instanceof HudEditorScreen) {
            drawHudEditor(context, mouseX, mouseY);
        }
    }

    public void onMouseClick(double mouseX, double mouseY, Screen screen, MouseButtons button) {
        if (!isComponentsLoaded) {
            return ;
        }
        if (screen instanceof ClickGuiScreen) {
            for (GuiComponent rootComponent : rootComponents) {
                if (rootComponent.isHovered(mouseX, mouseY)) {
                    rootComponent.onMouseClick(mouseX, mouseY, button);
                }
            }
        }
        else if (screen instanceof HudEditorScreen) {
            // for hud editor
        }
    }

    public void onMouseRelease(double mouseX, double mouseY, Screen screen, MouseButtons button) {
        if (!isComponentsLoaded) {
            return ;
        }
        if (screen instanceof ClickGuiScreen) {
            for (GuiComponent rootComponent : rootComponents) {
                if (rootComponent.isHovered(mouseX, mouseY)) {
                    rootComponent.onMouseRelease(mouseX, mouseY, button);
                }
            }
        }
        else if (screen instanceof HudEditorScreen) {
            // for hud editor
        }
    }

    public void initClickGui() {
        if (Client.INSTANCE.getStatus()) {
            mc.setScreen(CLICK_GUI_SCREEN);
        } else {
            mc.setScreen(null);
        }

        HashMap<Module.Category, Module> categoryModuleHashMap = new HashMap<>();
        for (Module module : ModuleManager.modules) {
            categoryModuleHashMap.put(module.getCategory(), module);
        }

        for (Module.Category category : Module.getCategories()) {
            Emotion.CONSOLE.logInfo("[DEBUG] new category component: \"" + category.name() + "\"");
            CategoryComponent categoryComponent = new CategoryComponent(category);
            categoryComponent.setX(latestComponentPosition.getA() + 5 * Render2DUtil.getScaleFactor());
            categoryComponent.setY(latestComponentPosition.getB());
            categoryComponent.setWidth(0);
            categoryComponent.setHeight(FontUtil.getHeight(FontSize.LARGEST));
            latestComponentPosition = new Pair<>(categoryComponent.getX() + categoryComponent.getWidth(), categoryComponent.getY());

            for (Module module : ModuleManager.modules) {
                if (category == module.getCategory()) {
                    Emotion.CONSOLE.logInfo("[DEBUG] new module component: \"" + module.getName() + "\", belong to: \"" + module.getCategory().name() + "\" ");
                    ModuleComponent moduleComponent = new ModuleComponent(module);
                    if (FontUtil.getWidth(FontSize.MEDIUM, moduleComponent.getModule().getDisplayName()) >= categoryComponent.getWidth()) {
                        categoryComponent.setWidth(FontUtil.getWidth(FontSize.MEDIUM, moduleComponent.getModule().getDisplayName()) + (4 * Render2DUtil.getScaleFactor()));
                    }
                    moduleComponent.setX(categoryComponent.getX() + 2 * Render2DUtil.getScaleFactor());
                    moduleComponent.setY(latestComponentPosition.getB());
                    moduleComponent.setWidth(categoryComponent.getWidth() - 4 * Render2DUtil.getScaleFactor());
                    moduleComponent.setHeight(FontUtil.getHeight(FontSize.MEDIUM));
                    latestComponentPosition = new Pair<>(moduleComponent.getX() + moduleComponent.getWidth(), moduleComponent.getY() + moduleComponent.getHeight());


                    for (Option<?> option : module.getOptionsList()) {
                        Emotion.CONSOLE.logInfo("[DEBUG] new option component: \"" + option.getName() + "\", belong to: \"" + module.getName() + "\" ");
                        // OptionComponents, pass
                    }

                    moduleComponent.setParentComponent(categoryComponent);
                    categoryComponent.addSub(moduleComponent);
                }
            }
            rootComponents.add(categoryComponent);
        }
    }

    private void drawClickGuiScreen(DrawContext context, double mouseX, double mouseY) {
        for (GuiComponent component : rootComponents) {
            component.onDraw(context, mouseX, mouseY);
        }
    }

    private void drawHudEditor(DrawContext context, double mouseX, double mouseY) {
        FontUtil.drawTextWithAlign(
                context,
                "LEFT - Move Position",
                0,
                0,
                mc.currentScreen.width,
                mc.currentScreen.height,
                Aligns.LEFT_BOTTOM,
                Emotion.THEME.getTheme().getHudEditorTipsTextColor(),
                FontSize.SMALL
        );

        FontUtil.drawTextWithAlign(
                context,
                "RIGHT - Edit Setting",
                0,
                0,
                mc.currentScreen.width,
                mc.currentScreen.height - FontUtil.getHeight(FontSize.SMALL),
                Aligns.LEFT_BOTTOM,
                Emotion.THEME.getTheme().getHudEditorTipsTextColor(),
                FontSize.SMALL
        );
    }
}
