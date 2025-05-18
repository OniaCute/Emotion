package cc.emotion.features.managers;

import cc.emotion.modules.Module;

public class EventManager {
    public void onTick() {
        for (Module module : ModuleManager.modules) {
            module.onTick();
        }
    }
}
