package com.google.android.gms.internal;

import java.util.Map;

@ey
public final class ca implements cd {
    private final cb pP;

    public ca(cb cbVar) {
        this.pP = cbVar;
    }

    /* renamed from: a */
    public void mo1660a(gu guVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            gr.m1341W("App event with no name parameter.");
        } else {
            this.pP.onAppEvent(str, (String) map.get("info"));
        }
    }
}
