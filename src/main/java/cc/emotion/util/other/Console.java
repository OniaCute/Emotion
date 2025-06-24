package cc.emotion.util.other;

public class Console {
    public void logAuth(String message) {
        logAuth(message, false);
    }

    public void logAuth(String message, boolean nameless) {
        System.out.println(nameless ? "" : "[Emotion] " + "[AUTH] " + message);
    }
    public void logInfo(String message) {
        logInfo(message, false);
    }

    public void logInfo(String message, boolean nameless) {
        System.out.println(nameless ? "" : "[Emotion] " + "[INFO] " + message);
    }

    public void logWarn(String message) {
        logWarn(message, false);
    }

    public void logWarn(String message, boolean nameless) {
        System.out.println(nameless ? "" : "[Emotion] " + "[WARN] " + message);
    }

    public void logError(String message) {
        logError(message, false);
    }

    public void logError(String message, boolean nameless) {
        System.out.println(nameless ? "" : "[Emotion] " + "[ERROR] " + message);
    }
}
