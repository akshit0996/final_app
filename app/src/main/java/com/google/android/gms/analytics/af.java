package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class af {
    private final Map<String, Integer> BO = new HashMap();
    private final Map<String, String> BP = new HashMap();
    private final boolean BQ;
    private final String BR;

    public af(String str, boolean z) {
        this.BQ = z;
        this.BR = str;
    }

    /* renamed from: e */
    public void m46e(String str, int i) {
        if (this.BQ) {
            Integer num = (Integer) this.BO.get(str);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.BO.put(str, Integer.valueOf(num.intValue() + i));
        }
    }

    public String fg() {
        if (!this.BQ) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.BR);
        for (String str : this.BO.keySet()) {
            stringBuilder.append("&").append(str).append("=").append(this.BO.get(str));
        }
        for (String str2 : this.BP.keySet()) {
            stringBuilder.append("&").append(str2).append("=").append((String) this.BP.get(str2));
        }
        return stringBuilder.toString();
    }

    /* renamed from: g */
    public void m47g(String str, String str2) {
        if (this.BQ && !TextUtils.isEmpty(str)) {
            this.BP.put(str, str2);
        }
    }
}
