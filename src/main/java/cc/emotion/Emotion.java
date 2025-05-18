package cc.emotion;

import cc.emotion.features.event.eventbus.EventBus;
import cc.emotion.features.managers.URLManager;
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
    public static final String MOD_ID = "nafity";
    public static final String NAME = "Nafity";
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

    // Mod Info Load
    static {
        MOD_INFO = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow().getMetadata();
    }

    @Override
    public void onInitialize() {
        CONSOLE = new Console();
        CONSOLE.logInfo("Nafity | Preloaded", true);
        CONSOLE.logInfo("VERSION: " + VERSION, true);
        CONSOLE.logInfo("Authors: Forizing", true);

        if (!MOD_INFO.getId().equals(MOD_ID)) {
            CONSOLE.logWarn("Fabric mod value check failed!");
            CONSOLE.logWarn("This version may have been acquired from informal sources or created without permission!");
            mc.stop();
        } else {
//            if (!AuthSystem.doAuth()) {
//                CONSOLE.logAuth("Auth failed, please check your network status and computer status.");
//                CONSOLE.logAuth("Nafity will not provide services until you have successfully auth.");
//                mc.stop();
//            }
            load();
        }
    }

    public static void load() {
        // Pre load
        EVENTBUS = new EventBus();
        EVENTBUS.registerLambdaFactory("cc.emotion", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
        // Information define & Intellectual property declaration
        AUTHORS.add("Onia");
        // Real load
        LOAD_TIME = System.currentTimeMillis();
        URL = new URLManager();

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
        EVENTBUS.listenerMap.clear();
    }

    public static void save() {}

}
