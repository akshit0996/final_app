package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.analytics.n */
abstract class C0123n<T extends C0121m> {
    Context mContext;
    C0122a<T> yL;

    /* renamed from: com.google.android.gms.analytics.n$a */
    public interface C0122a<U extends C0121m> {
        /* renamed from: c */
        void mo823c(String str, int i);

        /* renamed from: e */
        void mo824e(String str, String str2);

        /* renamed from: e */
        void mo825e(String str, boolean z);

        U er();

        /* renamed from: f */
        void mo827f(String str, String str2);
    }

    public C0123n(Context context, C0122a<T> c0122a) {
        this.mContext = context;
        this.yL = c0122a;
    }

    /* renamed from: a */
    private T m68a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    String trim;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.yL.mo824e(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || trim == null)) {
                            this.yL.mo827f(r0, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.yL.mo825e(toLowerCase, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                ae.m42T("Error parsing bool configuration value: " + trim);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || TextUtils.isEmpty(trim))) {
                            try {
                                this.yL.mo823c(r0, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                ae.m42T("Error parsing int configuration value: " + trim);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            ae.m42T("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            ae.m42T("Error parsing tracker configuration file: " + e4);
        }
        return this.yL.er();
    }

    /* renamed from: x */
    public T m69x(int i) {
        try {
            return m68a(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            ae.m45W("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
