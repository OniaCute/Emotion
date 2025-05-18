package cc.emotion.features.account;

import java.util.Date;

public class EmotionAccount {
    public String name;
    public String token;
    public AccountStatus status;
    public SubscriptionTypes subscription;
    public Date expireDate;

    public EmotionAccount(String name, AccountStatus status, SubscriptionTypes subscription, Date expireDate, String token) {
        this.name = name;
        this.status = status;
        this.subscription = subscription;
        this.expireDate = expireDate;
        this.token = token;
    }
}
