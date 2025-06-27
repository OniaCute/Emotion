package cc.emotion.features.account;

/*

 result form:

 {
     "status":"0",
     "result":"true/false",
     "cause":"ERR_xxx/0",
     "account_token":"xxx1mo+i0n",
     "account_username":"xxx",
     "account_status":"xxx",
     "account_sub":"xxx",
     "account_expire":"xxx",
 }

 (status) -1 : maintenance (service is not running)
          0  : normal
          1  : busy (busy for servicing)

 */

public enum ActionType {
    PasswordLogin,

    CheckLoginToken
}
