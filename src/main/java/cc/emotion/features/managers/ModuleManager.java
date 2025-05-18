package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.modules.Module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public List<Module> modules = new ArrayList<Module>();

    public void registerModule(Module module) {
        modules.add(module);
        Emotion.CONSOLE.logInfo("Module \"" + module.displayName + "\" is loaded.");
    }
}
