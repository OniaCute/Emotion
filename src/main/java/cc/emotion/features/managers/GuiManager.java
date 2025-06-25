package cc.emotion.features.managers;

import cc.emotion.ui.gui.GuiComponent;

public class GuiManager {
    private static GuiComponent currentComponent = null;

    public boolean isAvailable() {
        return currentComponent == null;
    }

    public boolean isAvailable(GuiComponent component) {
        return currentComponent == component;
    }

    public static void setCurrentComponent(GuiComponent currentComponent) {
        GuiManager.currentComponent = currentComponent;
    }
}
