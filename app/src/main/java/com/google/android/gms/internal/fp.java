package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.bv.C0380a;
import com.google.android.gms.internal.fn.C0429a;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fp implements C0429a<bu> {
    /* renamed from: a */
    public /* synthetic */ C0380a mo1795a(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return m3185c(fnVar, jSONObject);
    }

    /* renamed from: c */
    public bu m3185c(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new bu(jSONObject.getString("headline"), (Drawable) fnVar.m1221a(jSONObject, "image", true).get(), jSONObject.getString("body"), (Drawable) fnVar.m1221a(jSONObject, "secondary_image", false).get(), jSONObject.getString("call_to_action"), jSONObject.getString("attribution"));
    }
}
