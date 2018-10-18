package com.google.android.gms.internal;

import android.accounts.Account;
import android.text.TextUtils;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.internal.jq.C1002a;

public class jd extends C1002a {
    private Account CR;

    public jd(Account account) {
        this.CR = account;
    }

    public static jd aT(String str) {
        return new jd(TextUtils.isEmpty(str) ? null : new Account(str, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
    }

    public Account hk() {
        return this.CR;
    }
}
