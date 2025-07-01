package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.modules.client.Client;

import java.util.HashMap;
import java.util.Map;

public class TextManager {
    private final Map<String, String> englishLanguageBase = new HashMap<>();
    private final Map<String, String> chineseLanguageBase = new HashMap<>();

    public TextManager() {
        loadEnglish();
        Emotion.CONSOLE.logInfo("language \"English\" was loaded!");
        loadChinese();
        Emotion.CONSOLE.logInfo("language \"Chinese\" was loaded!");
    }

    private void loadEnglish() {
        englishLanguageBase.put("Module.Category.CLIENT.name", "Client");
        englishLanguageBase.put("Module.Category.COMBAT.name", "Combat");
        englishLanguageBase.put("Module.Category.MOVEMENT.ame", "Movement");
        englishLanguageBase.put("Module.Category.PLAYER.name", "PLAYER");
        englishLanguageBase.put("Module.Category.EXPLOIT.name", "Exploit");
        englishLanguageBase.put("Module.Category.VISUAL.name", "Visual");
        englishLanguageBase.put("Module.Category.MISC.name", "Misc");
        englishLanguageBase.put("Module.Category.HUD.name", "HUD");

        englishLanguageBase.put("Theme.Error.Notify.AuthorIsNotExist.title", "Theme Error");
        englishLanguageBase.put("Theme.Error.Notify.AuthorIsNotExist.description", "The author of the theme does not exist!");

        englishLanguageBase.put("Module.Modules.Client.name", "Client");
        englishLanguageBase.put("Module.Modules.Client.Options.BooleanOption.Sync.name", "SYNC");
        englishLanguageBase.put("Module.Modules.Client.Options.BooleanOption.Sync.description", "Share your Emotion user status so that you can be seen by other users who have enabled Sync and have their Emotion icons displayed.");
        englishLanguageBase.put("Module.Modules.Client.Options.EnumOption.UIScale.name", "UI Scale");
        englishLanguageBase.put("Module.Modules.Client.Options.EnumOption.EspScale.name", "ESP Scale");
        englishLanguageBase.put("Module.Modules.Client.Options.EnumOption.Language.name", "Language");
        englishLanguageBase.put("Module.Modules.Client.Options.BooleanOption.SafeMode.name", "SafeMode");
        englishLanguageBase.put("Module.Modules.Client.Options.BooleanOption.SafeMode.description", "SafeMode is enabled by default when EmotionClient is loaded. This option will help minimize the chances of your cheating behavior being detected.");

        englishLanguageBase.put("Module.Modules.Notify.name", "Notify");
        englishLanguageBase.put("Module.Modules.Notify.description", "Setting about notifications");

        englishLanguageBase.put("Module.Modules.HudEditor.name", "HUD Editor");
        englishLanguageBase.put("Module.Modules.HudEditor.description", "Edit something about HUDs");

    }

    private void loadChinese() {
        chineseLanguageBase.put("Module.Category.CLIENT.name", "客户端");
        chineseLanguageBase.put("Module.Category.COMBAT.name", "战斗类");
        chineseLanguageBase.put("Module.Category.MOVEMENT.name", "移动类");
        chineseLanguageBase.put("Module.Category.PLAYER.name", "玩家类");
        chineseLanguageBase.put("Module.Category.EXPLOIT.name", "漏洞类");
        chineseLanguageBase.put("Module.Category.VISUAL.name", "视觉类");
        chineseLanguageBase.put("Module.Category.MISC.name", "杂项");
        chineseLanguageBase.put("Module.Category.HUD.name", "HUD");

        chineseLanguageBase.put("Theme.Error.Notify.AuthorIsNotExist.title", "主题错误");
        chineseLanguageBase.put("Theme.Error.Notify.AuthorIsNotExist.description", "该主题的作者不存在!");

        chineseLanguageBase.put("Module.Category.Client.Name", "客户端");
        chineseLanguageBase.put("Module.Modules.Client.Options.BooleanOption.Sync.name", "SYNC");
        chineseLanguageBase.put("Module.Modules.Client.Options.BooleanOption.Sync.description", "将你的Emotion用户标识公开,使其可以和其他开启了Sync的用户相互看见标识.");
        chineseLanguageBase.put("Module.Modules.Client.Options.EnumOption.UIScale.name", "UI缩放等级");
        chineseLanguageBase.put("Module.Modules.Client.Options.EnumOption.EspScale.name", "玩家透视缩放等级");
        chineseLanguageBase.put("Module.Modules.Client.Options.EnumOption.Language.name", "语言设置");
        chineseLanguageBase.put("Module.Modules.Client.Options.BooleanOption.SafeMode.name", "安全模式");
        chineseLanguageBase.put("Module.Modules.Client.Options.BooleanOption.SafeMode.description", "安全模式在EmotionClient加载时默认开启,该选项将协助你的作弊行为尽可能不被检测");

        chineseLanguageBase.put("Module.Modules.Notify.name", "通知");
        chineseLanguageBase.put("Module.Modules.Notify.description", "设置通知样式");

        chineseLanguageBase.put("Module.Modules.HudEditor.name", "HUD编辑器");
        chineseLanguageBase.put("Module.Modules.HudEditor.description", "编辑HUD内容");
    }

    public String get(String key) {
        String result;
//        switch (Client.INSTANCE.language.getValue().name()) {
        switch ("e") {
            case "Chinese" -> {
                result = chineseLanguageBase.get(key);
            }
            default -> {
                result = englishLanguageBase.get(key);
            }
        }

        if (result == null) {
            return key;
        }

        return result;
    }
}
