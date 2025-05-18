package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.modules.Module;
import cc.emotion.modules.client.Client;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static List<Module> modules = new ArrayList<Module>();

    public ModuleManager() {
        registerModule(new Client());
    }

    public void registerModule(Module module) {
        modules.add(module);
        Emotion.CONSOLE.logInfo("Module \"" + module.getDisplayName() + "\" is loaded.");
    }
}
