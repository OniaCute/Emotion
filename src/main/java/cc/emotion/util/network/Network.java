package cc.emotion.util.network;

import cc.emotion.Emotion;
import cc.emotion.features.account.*;
import cc.emotion.features.managers.URLManager;
import cc.emotion.util.data.JsonUtil;

import java.util.Date;
import java.util.HashMap;

public class Network {
    public static EmotionLocalAccount login(String accountName, String password, String HWID) {
        HashMap<?, ?> result = JsonUtil.stringToHashMap(Emotion.URL.getResponse(URLManager.serverAccountAddress + "?action=" + ActionType.PasswordLogin.name() + "&u=" + accountName + "&p=" + password + "&h=" + HWID));
        if (result.get("status") == "0") {
            if (result.get("result") == "true") {
                return new EmotionLocalAccount(
                        (String) result.get("account_username"),
                        (AccountStatus) result.get("account_status"),
                        (SubscriptionTypes) result.get("account_sub"),
                        (Date) result.get("account_expire"),
                        (String) result.get("account_token")
                );
            } else {
                if (result.get("cause") == "ERR_HWID") {
                    Emotion.CONSOLE.logAuth("Password Login failed! Error HWID.");
                }
                else if (result.get("cause") == "ERR_AE") {
                    Emotion.CONSOLE.logAuth("Password Login failed! The account name or password is wrong.");
                } else {
                    Emotion.CONSOLE.logAuth("Password Login failed! A excepted cause.");
                }
                return null;
            }
        }
        Emotion.CONSOLE.logAuth("Password Login failed! Cannot connect to login server!");
        return null;
    }

    public static EmotionLocalAccount login(LoginToken token, String HWID) {
        HashMap<?, ?> result = JsonUtil.stringToHashMap(Emotion.URL.getResponse(URLManager.serverAccountAddress + "?action=" + ActionType.CheckLoginToken.name() + "&t=" + token.token + "&h=" + HWID));
        if (result.get("status") == "0") {
            if (result.get("result") == "true") {
                return new EmotionLocalAccount(
                        (String) result.get("account_username"),
                        (AccountStatus) result.get("account_status"),
                        (SubscriptionTypes) result.get("account_sub"),
                        (Date) result.get("account_expire"),
                        (String) result.get("account_token")
                );
            } else {
                if (result.get("cause") == "ERR_HWID") {
                    Emotion.CONSOLE.logAuth("Token Login failed! Error HWID.");
                }
                else if (result.get("cause") == "ERR_NA") {
                    Emotion.CONSOLE.logAuth("Token Login failed! The token is not available anymore.");
                } else {
                    Emotion.CONSOLE.logAuth("Token Login failed! A excepted cause.");
                }
                return null;
            }
        }
        Emotion.CONSOLE.logAuth("Token Login failed! Cannot connect to login server!");
        return null;
    }

    public static String getUserStatus(EmotionLocalAccount account) {
        return account.status.name();
    }

    public static String getUserSubscription(EmotionLocalAccount account) {
        return account.subscription.name();
    }
}
