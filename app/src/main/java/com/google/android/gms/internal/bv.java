package com.google.android.gms.internal;

import org.json.JSONObject;

@ey
public class bv {
    private C1440u pM;
    private ah pN;
    private JSONObject pO;

    /* renamed from: com.google.android.gms.internal.bv$a */
    public interface C0380a {
        /* renamed from: a */
        void mo3306a(bv bvVar);
    }

    public bv(C1440u c1440u, ah ahVar, JSONObject jSONObject) {
        this.pM = c1440u;
        this.pN = ahVar;
        this.pO = jSONObject;
    }

    public void aw() {
        this.pM.an();
    }

    /* renamed from: b */
    public void m1091b(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset", i);
            jSONObject.put("template", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad", this.pO);
            jSONObject2.put("click", jSONObject);
            this.pN.mo1665a("google.afma.nativeAds.handleClick", jSONObject2);
        } catch (Throwable e) {
            gr.m1343b("Unable to create click JSON.", e);
        }
    }
}
