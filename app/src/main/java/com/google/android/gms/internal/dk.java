package com.google.android.gms.internal;

import org.json.JSONObject;

@ey
public class dk {
    private final boolean rs;
    private final boolean rt;
    private final boolean ru;
    private final boolean rv;
    private final boolean rw;

    /* renamed from: com.google.android.gms.internal.dk$a */
    public static final class C0402a {
        private boolean rs;
        private boolean rt;
        private boolean ru;
        private boolean rv;
        private boolean rw;

        public dk bU() {
            return new dk();
        }

        /* renamed from: k */
        public C0402a m1131k(boolean z) {
            this.rs = z;
            return this;
        }

        /* renamed from: l */
        public C0402a m1132l(boolean z) {
            this.rt = z;
            return this;
        }

        /* renamed from: m */
        public C0402a m1133m(boolean z) {
            this.ru = z;
            return this;
        }

        /* renamed from: n */
        public C0402a m1134n(boolean z) {
            this.rv = z;
            return this;
        }

        /* renamed from: o */
        public C0402a m1135o(boolean z) {
            this.rw = z;
            return this;
        }
    }

    private dk(C0402a c0402a) {
        this.rs = c0402a.rs;
        this.rt = c0402a.rt;
        this.ru = c0402a.ru;
        this.rv = c0402a.rv;
        this.rw = c0402a.rw;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.rs).put("tel", this.rt).put("calendar", this.ru).put("storePicture", this.rv).put("inlineVideo", this.rw);
        } catch (Throwable e) {
            gr.m1343b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
