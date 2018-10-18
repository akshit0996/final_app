package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class ei {
    /* renamed from: D */
    public static String m1166D(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                gr.m1341W("Fail to parse purchase data");
            }
        }
        return str2;
    }

    /* renamed from: E */
    public static String m1167E(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("purchaseToken");
            } catch (JSONException e) {
                gr.m1341W("Fail to parse purchase data");
            }
        }
        return str2;
    }

    /* renamed from: b */
    public static int m1168b(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            gr.m1341W("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            gr.m1341W("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    /* renamed from: d */
    public static int m1169d(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            gr.m1341W("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            gr.m1341W("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    /* renamed from: e */
    public static String m1170e(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    /* renamed from: f */
    public static String m1171f(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }
}
