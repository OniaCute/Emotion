package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.modules.Module;
import cc.emotion.modules.client.Client;
import cc.emotion.modules.client.Notify;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static List<Module> modules = new ArrayList<Module>();

    public ModuleManager() {
        registerModule(new Client());
        registerModule(new Notify());
    }

    public void registerModule(Module module) {
        modules.add(module);
        module.onRegister();
        Emotion.CONSOLE.logInfo("Module \"" + module.getDisplayName() + "\" is loaded.");
    }
}
