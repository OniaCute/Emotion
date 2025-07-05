package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.modules.Module;
import cc.emotion.modules.client.Client;
import cc.emotion.modules.client.HudEditor;
import cc.emotion.modules.client.Notify;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ModuleManager {
    public static List<Module> modules = new ArrayList<Module>();

    public ModuleManager() {

        registerModule(new Client());
        registerModule(new Notify());
        registerModule(new HudEditor());
        
    }

    public void registerModule(Module module) {
        Emotion.CONSOLE.logInfo("Registering module \"" + module.getName() + "\" ...");
        modules.add(module);
        module.onRegister();
        Emotion.CONSOLE.logInfo("Module \"" + module.getName() + "\" is loaded.");
    }
}
