package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.bv.C0380a;
import com.google.android.gms.internal.fn.C0429a;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fo implements C0429a<bt> {
    /* renamed from: a */
    public /* synthetic */ C0380a mo1795a(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return m3183b(fnVar, jSONObject);
    }

    /* renamed from: b */
    public bt m3183b(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new bt(jSONObject.getString("headline"), (Drawable) fnVar.m1221a(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) fnVar.m1221a(jSONObject, "app_icon", true).get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"));
    }
}
