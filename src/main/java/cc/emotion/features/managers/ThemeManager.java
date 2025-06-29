package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.features.themes.DefaultTheme;
import cc.emotion.features.themes.Theme;

public class ThemeManager {
    private static Theme currentTheme = null;
    public Theme defaultTheme;

    public ThemeManager() {
        defaultTheme = new DefaultTheme();
        currentTheme = defaultTheme;
    }

    public void loadTheme(Theme theme) {
        if (theme == defaultTheme) {
            Emotion.CONSOLE.logWarn("Theme unload failed. It's default theme.");
        }
        currentTheme = theme;
    }

    public void unloadTheme() {
        Emotion.CONSOLE.logInfo("unloading theme ...");
        currentTheme = new DefaultTheme();
        Emotion.CONSOLE.logInfo("Theme unloaded, now the theme is default theme.");
    }

    public Theme getTheme() {
        return currentTheme;
    }
}
