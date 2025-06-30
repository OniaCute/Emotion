package cc.emotion.features.themes;

import cc.emotion.Emotion;
import cc.emotion.features.account.EmotionAccount;
import cc.emotion.features.managers.NotifyManager;
import cc.emotion.features.notifications.NormalNotification;
import cc.emotion.modules.client.Client;
import cc.emotion.modules.client.Notify;

import java.awt.*;
import java.util.ArrayList;

public class Theme {
    private String name;
    private String displayName;
    private String description;
    private ArrayList<EmotionAccount> authors = new ArrayList<EmotionAccount>();
    private Color mainColor;
    private Color categoryBackgroundColor;
    private Color categoryTextColor;
    private Color moduleBackgroundColor;
    private Color moduleEnabledBackgroundColor;
    private Color moduleTextColor;
    private Color moduleEnabledTextColor;
    private Color notificationTextColor;
    private Color notificationHighlightTextColor;
    private Color notificationBackgroundColor;
    private Color buttonBackgroundColor;
    private Color buttonCircleColor;
    private Color buttonInlineColor;
    private Color buttonEnabledBackgroundColor;
    private Color buttonEnabledCircleColor;
    private Color buttonEnabledInlineColor;
    private Color optionsTextColor;
    private Color hudEditorTipsTextColor;
    private Color hoverComponentBackgroundColor;
    private Color hoverComponentTextColor;

    public Theme(String name, String displayName, String description, ArrayList<EmotionAccount> authors) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.authors = authors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void addAuthors(String name) {
        EmotionAccount author = new EmotionAccount(name);
        if (author.isExist()) {
            this.authors.add(author);
        } else {
            NotifyManager.addNotification(new NormalNotification(
                    Emotion.TEXT.get("Theme.Error.Notify.AuthorIsNotExist.title"),
                    Emotion.TEXT.get("Theme.Error.Notify.AuthorIsNotExist.description"),
                    Notify.INSTANCE.notificationAliveTime.getValue()
            ));
            Emotion.CONSOLE.logWarn("The author \""+ name + "\" of theme" + getDisplayName() + "(" + getName() + ")" + "doesn't exist!");
        }
    }

    public ArrayList<EmotionAccount> getAuthors() {
        return authors;
    }

    public void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public Color getMainColor() {
        return mainColor;
    }

    public void setCategoryBackgroundColor(Color categoryBackgroundColor) {
        this.categoryBackgroundColor = categoryBackgroundColor;
    }

    public Color getCategoryBackgroundColor() {
        return categoryBackgroundColor;
    }

    public void setCategoryTextColor(Color categoryTextColor) {
        this.categoryTextColor = categoryTextColor;
    }

    public Color getCategoryTextColor() {
        return categoryTextColor;
    }

    public void setModuleBackgroundColor(Color moduleBackgroundColor) {
        this.moduleBackgroundColor = moduleBackgroundColor;
    }

    public Color getModuleBackgroundColor() {
        return moduleBackgroundColor;
    }

    public void setModuleEnabledBackgroundColor(Color moduleEnabledBackgroundColor) {
        this.moduleEnabledBackgroundColor = moduleEnabledBackgroundColor;
    }

    public Color getModuleEnabledBackgroundColor() {
        return moduleEnabledBackgroundColor;
    }

    public void setModuleEnabledTextColor(Color moduleEnabledTextColor) {
        this.moduleEnabledTextColor = moduleEnabledTextColor;
    }

    public Color getModuleEnabledTextColor() {
        return moduleEnabledTextColor;
    }

    public void setModuleTextColor(Color moduleTextColor) {
        this.moduleTextColor = moduleTextColor;
    }

    public Color getModuleTextColor() {
        return moduleTextColor;
    }

    public void setNotificationBackgroundColor(Color notificationBackgroundColor) {
        this.notificationBackgroundColor = notificationBackgroundColor;
    }

    public Color getNotificationBackgroundColor() {
        return notificationBackgroundColor;
    }

    public void setNotificationHighlightTextColor(Color notificationHighlightTextColor) {
        this.notificationHighlightTextColor = notificationHighlightTextColor;
    }

    public Color getNotificationTextColor() {
        return notificationTextColor;
    }

    public void setNotificationTextColor(Color notificationTextColor) {
        this.notificationTextColor = notificationTextColor;
    }

    public Color getNotificationHighlightTextColor() {
        return notificationHighlightTextColor;
    }

    public void setButtonCircleColor(Color buttonCircleColor) {
        this.buttonCircleColor = buttonCircleColor;
    }

    public Color getButtonCircleColor() {
        return buttonCircleColor;
    }

    public void setButtonEnabledCircleColor(Color buttonEnabledCircleColor) {
        this.buttonEnabledCircleColor = buttonEnabledCircleColor;
    }

    public Color getButtonEnabledCircleColor() {
        return buttonEnabledCircleColor;
    }

    public void setButtonEnabledInlineColor(Color buttonEnabledInlineColor) {
        this.buttonEnabledInlineColor = buttonEnabledInlineColor;
    }

    public Color getButtonEnabledInlineColor() {
        return buttonEnabledInlineColor;
    }

    public void setButtonInlineColor(Color buttonInlineColor) {
        this.buttonInlineColor = buttonInlineColor;
    }

    public Color getButtonInlineColor() {
        return buttonInlineColor;
    }

    public void setButtonBackgroundColor(Color buttonBackgroundColor) {
        this.buttonBackgroundColor = buttonBackgroundColor;
    }

    public Color getButtonBackgroundColor() {
        return buttonBackgroundColor;
    }

    public void setButtonEnabledBackgroundColor(Color buttonEnabledBackgroundColor) {
        this.buttonEnabledBackgroundColor = buttonEnabledBackgroundColor;
    }

    public Color getButtonEnabledBackgroundColor() {
        return buttonEnabledBackgroundColor;
    }

    public void setOptionsTextColor(Color optionsTextColor) {
        this.optionsTextColor = optionsTextColor;
    }

    public Color getOptionsTextColor() {
        return optionsTextColor;
    }

    public void setHudEditorTipsTextColor(Color hudEditorTipsTextColor) {
        this.hudEditorTipsTextColor = hudEditorTipsTextColor;
    }

    public Color getHudEditorTipsTextColor() {
        return hudEditorTipsTextColor;
    }

    public void setHoverComponentBackgroundColor(Color hoverComponentBackgroundColor) {
        this.hoverComponentBackgroundColor = hoverComponentBackgroundColor;
    }

    public Color getHoverComponentBackgroundColor() {
        return hoverComponentBackgroundColor;
    }

    public void setHoverComponentTextColor(Color hoverComponentTextColor) {
        this.hoverComponentTextColor = hoverComponentTextColor;
    }

    public Color getHoverComponentTextColor() {
        return hoverComponentTextColor;
    }
}
