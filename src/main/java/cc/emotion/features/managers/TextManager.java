package cc.emotion.features.managers;

import cc.emotion.modules.client.Client;

import java.util.HashMap;

public class TextManager {
    private HashMap<String, String> englishLanguageBase;
    private HashMap<String, String> chineseLanguageBase;

    public TextManager() {
        loadEnglish();
        loadChinese();
    }

    private void loadEnglish() {
        englishLanguageBase.put("Module.Category.CLIENT.Name", "Client");
        englishLanguageBase.put("Module.Category.COMBAT.Name", "Combat");
        englishLanguageBase.put("Module.Category.MOVEMENT.Name", "Movement");
        englishLanguageBase.put("Module.Category.PLAYER.Name", "PLAYER");
        englishLanguageBase.put("Module.Category.EXPLOIT.Name", "Exploit");
        englishLanguageBase.put("Module.Category.VISUAL.Name", "Visual");
        englishLanguageBase.put("Module.Category.MISC.Name", "Misc");
        englishLanguageBase.put("Module.Category.HUD.Name", "HUD");

        englishLanguageBase.put("Module.Modules.Client.Name", "Client");
        englishLanguageBase.put("Module.Modules.Client.Options.BooleanOption.Sync.name", "SYNC");
        englishLanguageBase.put("Module.Modules.Client.Options.BooleanOption.Sync.description", "Share your Emotion user status so that you can be seen by other users who have enabled Sync and have their Emotion icons displayed.");
        englishLanguageBase.put("Module.Modules.Client.Options.EnumOption.UIScale.name", "UI Scale");
        englishLanguageBase.put("Module.Modules.Client.Options.EnumOption.EspScale.name", "ESP Scale");
        englishLanguageBase.put("Module.Modules.Client.Options.EnumOption.Language.name", "Language");
        englishLanguageBase.put("Module.Modules.Client.Options.BooleanOption.SafeMode.name", "SafeMode");
        englishLanguageBase.put("Module.Modules.Client.Options.BooleanOption.SafeMode.description", "SafeMode is enabled by default when EmotionClient is loaded. This option will help minimize the chances of your cheating behavior being detected.");
    }

    private void loadChinese() {
        chineseLanguageBase.put("Module.Category.CLIENT.Name", "客户端");
        chineseLanguageBase.put("Module.Category.COMBAT.Name", "战斗类");
        chineseLanguageBase.put("Module.Category.MOVEMENT.Name", "移动类");
        chineseLanguageBase.put("Module.Category.PLAYER.Name", "玩家类");
        chineseLanguageBase.put("Module.Category.EXPLOIT.Name", "漏洞类");
        chineseLanguageBase.put("Module.Category.VISUAL.Name", "视觉类");
        chineseLanguageBase.put("Module.Category.MISC.Name", "杂项");
        chineseLanguageBase.put("Module.Category.HUD.Name", "HUD");

        chineseLanguageBase.put("Module.Category.Client.Name", "客户端");
        chineseLanguageBase.put("Module.Modules.Client.Options.BooleanOption.Sync.name", "SYNC");
        chineseLanguageBase.put("Module.Modules.Client.Options.BooleanOption.Sync.description", "将你的Emotion用户标识公开,使其可以和其他开启了Sync的用户相互看见标识.");
        chineseLanguageBase.put("Module.Modules.Client.Options.EnumOption.UIScale.name", "UI缩放等级");
        chineseLanguageBase.put("Module.Modules.Client.Options.EnumOption.EspScale.name", "玩家透视缩放等级");
        chineseLanguageBase.put("Module.Modules.Client.Options.EnumOption.Language.name", "语言设置");
        chineseLanguageBase.put("Module.Modules.Client.Options.BooleanOption.SafeMode.name", "安全模式");
        chineseLanguageBase.put("Module.Modules.Client.Options.BooleanOption.SafeMode.description", "安全模式在EmotionClient加载时默认开启,该选项将协助你的作弊行为尽可能不被检测");
    }

    public String get(String key) {
        switch (Client.INSTANCE.language.getValue().name()) {
            case "Chinese" -> {
                return chineseLanguageBase.get(key);
            }
            default -> {
                return englishLanguageBase.get(key);
            }
        }

    }
}
