package cc.emotion;

import cc.emotion.features.event.eventbus.EventBus;
import cc.emotion.features.managers.*;
import cc.emotion.util.other.Console;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

import static cc.emotion.util.interfaces.Wrapper.mc;

public class Emotion implements ModInitializer {
    // Information & Mod status
    public static final ModMetadata MOD_INFO;
    public static final String MOD_ID = "emotion";
    public static final String NAME = "Emotion";
    public static final String VERSION = "1.0.0";
    public static final ArrayList<String> AUTHORS = new ArrayList<String>();
    public static String PREFIX = "$";
    public static String HWID = "";
    public static String AUTHID = "00000x00000d00000";
    public static boolean AUTHED = false;
    public static boolean LOADED = false;
    public static long LOAD_TIME;

    // Manager & Preload
    public static Console CONSOLE;
    public static EventBus EVENTBUS;
    public static URLManager URL;
    public static TextManager TEXT;
    public static ThemeManager THEME;
    public static GuiManager GUI;
    public static ModuleManager MODULE;
    public static NotifyManager NOTIFY;
    public static EventManager EVENTS;

    // Mod Info Load
    static {
        MOD_INFO = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow().getMetadata();
    }

    @Override
    public void onInitialize() {
        CONSOLE = new Console();
        CONSOLE.logInfo("Emotion | Preloaded", true);
        CONSOLE.logInfo("VERSION: " + VERSION, true);
        CONSOLE.logInfo("Authors: Voury, Onia", true);

        if (!MOD_INFO.getId().equals(MOD_ID)) {
            CONSOLE.logWarn("Fabric mod value check failed!");
            CONSOLE.logWarn("This version may have been acquired from informal sources or created without permission!");
            mc.stop();
        } else {
//            if (!AuthSystem.doAuth()) {
//                CONSOLE.logAuth("Auth failed, please check your network status and computer status.");
//                CONSOLE.logAuth("Emotion will not provide services until you have successfully auth.");
//                mc.stop();
//            }
            load();
        }
    }

    public static void load() {
        // Pre load
        CONSOLE.logInfo("Event Bus is loading...");
        EVENTBUS = new EventBus();
        CONSOLE.logInfo("Event Bus is loaded.");
        CONSOLE.logInfo("Registering Event bus ...");
        EVENTBUS.registerLambdaFactory("cc.emotion", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
        CONSOLE.logInfo("Lambda was loaded.");
        // Information define & Intellectual property declaration
        AUTHORS.add("Voury");
        AUTHORS.add("Onia");
        // Real load
        LOAD_TIME = System.currentTimeMillis();
        URL = new URLManager();
        CONSOLE.logInfo("URL Manager was loaded");
        TEXT = new TextManager();
        CONSOLE.logInfo("Text Manager was loaded");
        THEME = new ThemeManager();
        CONSOLE.logInfo("Theme Manager was loaded");
        GUI = new GuiManager();
        CONSOLE.logInfo("GUI Manager was loaded");
        MODULE = new ModuleManager();
        CONSOLE.logInfo("Module Manager was loaded");
        NOTIFY = new NotifyManager();
        CONSOLE.logInfo("Notify Manager was loaded");
        EVENTS = new EventManager();
        CONSOLE.logInfo("Event Manager was loaded");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (LOADED) {
                save();
            }
        }));

        CONSOLE.logInfo("Emotion Client Loaded!");
        CONSOLE.logInfo("Emotion Loaded In " + (System.currentTimeMillis() - LOAD_TIME) + " ms.");

        LOADED = true;
    }

    public static void unload() {
        CONSOLE.logInfo("Client was unloaded.");
        EVENTBUS.listenerMap.clear();
    }

    public static void save() {
        CONSOLE.logInfo("Client config is saving...");
    }

}
