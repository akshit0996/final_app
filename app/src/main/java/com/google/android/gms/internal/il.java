package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class il {
    protected final is He;
    private final String Hf;
    private iu Hg;

    protected il(String str, String str2, String str3) {
        in.aF(str);
        this.Hf = str;
        this.He = new is(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.He.aK(str3);
        }
    }

    /* renamed from: a */
    public final void m1444a(iu iuVar) {
        this.Hg = iuVar;
        if (this.Hg == null) {
            fV();
        }
    }

    /* renamed from: a */
    protected final void m1445a(String str, long j, String str2) throws IOException {
        this.He.m1468a("Sending text message: %s to: %s", str, str2);
        this.Hg.mo900a(this.Hf, str, j, str2);
    }

    public void aD(String str) {
    }

    /* renamed from: b */
    public void mo1851b(long j, int i) {
    }

    protected final long fU() {
        return this.Hg.fS();
    }

    public void fV() {
    }

    public final String getNamespace() {
        return this.Hf;
    }
}
