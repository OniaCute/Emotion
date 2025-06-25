package cc.emotion.features.themes;

import cc.emotion.Emotion;
import cc.emotion.features.account.EmotionAccount;
import cc.emotion.features.managers.TextManager;

import java.awt.*;
import java.util.ArrayList;

public class DefaultTheme extends Theme {
    public static DefaultTheme INSTANCE;
    public DefaultTheme() {
        super("default", Emotion.TEXT.get("Theme.DefaultTheme.name"), Emotion.TEXT.get("Theme.DefaultTheme.description"), new ArrayList<>());
        this.addAuthors("Voury");
        this.addAuthors("Onia");
        setMainColor(new Color(0, 149, 255));
        setCategoryBackgroundColor(new Color(45, 45, 45));
        setCategoryTextColor(new Color(255, 255, 255));
        setModuleBackgroundColor(new Color(126, 126, 126));
        setModuleEnabledBackgroundColor(new Color(141, 141, 141));
        setModuleTextColor(new Color(255, 255, 255));
        setModuleEnabledTextColor(new Color(0, 149, 255));
        setNotificationBackgroundColor(new Color(35, 35, 35, 182));
        setNotificationTextColor(new Color(255, 255, 255));
        setNotificationHighlightTextColor(new Color(0, 140, 255));

        INSTANCE = this;
    }
}
