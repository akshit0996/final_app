package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hd.C0456a;
import com.google.android.gms.internal.hp.C0457a;
import com.google.android.gms.internal.mv.C1411a;
import com.google.android.gms.internal.mv.C1411a.C1410a;
import com.google.android.gms.plus.PlusShare;
import java.util.List;
import java.util.zip.CRC32;

public class hr implements SafeParcelable {
    public static final hs CREATOR = new hs();
    final int CK;
    final hf Dw;
    final long Dx;
    final int Dy;
    final hd Dz;
    public final String pc;

    hr(int i, hf hfVar, long j, int i2, String str, hd hdVar) {
        this.CK = i;
        this.Dw = hfVar;
        this.Dx = j;
        this.Dy = i2;
        this.pc = str;
        this.Dz = hdVar;
    }

    public hr(hf hfVar, long j, int i) {
        this(1, hfVar, j, i, null, null);
    }

    public hr(hf hfVar, long j, int i, String str, hd hdVar) {
        this(1, hfVar, j, i, str, hdVar);
    }

    public hr(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexingLink> list) {
        this(1, m3230a(str, intent), System.currentTimeMillis(), 0, null, m3229a(intent, str2, uri, str3, list).fD());
    }

    /* renamed from: a */
    public static C0456a m3229a(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        C0456a c0456a = new C0456a();
        c0456a.m1384a(av(str));
        if (uri != null) {
            c0456a.m1384a(m3232f(uri));
        }
        if (list != null) {
            c0456a.m1384a(m3231b(list));
        }
        String action = intent.getAction();
        if (action != null) {
            c0456a.m1384a(m3235i("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            c0456a.m1384a(m3235i("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            c0456a.m1384a(m3235i("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                c0456a.m1384a(m3235i("intent_extra_data", action));
            }
        }
        return c0456a.ar(str2).m1383F(true);
    }

    /* renamed from: a */
    public static hf m3230a(String str, Intent intent) {
        return m3234h(str, m3233g(intent));
    }

    private static hh av(String str) {
        return new hh(str, new C0457a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).m1406Q(1).m1405H(true).au("name").fG(), "text1");
    }

    /* renamed from: b */
    private static hh m3231b(List<AppIndexingLink> list) {
        qw c1411a = new C1411a();
        C1410a[] c1410aArr = new C1410a[list.size()];
        for (int i = 0; i < c1410aArr.length; i++) {
            c1410aArr[i] = new C1410a();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            c1410aArr[i].afw = appIndexingLink.appIndexingUrl.toString();
            c1410aArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                c1410aArr[i].afx = appIndexingLink.webUrl.toString();
            }
        }
        c1411a.afu = c1410aArr;
        return new hh(qw.m1906f(c1411a), new C0457a("outlinks").m1404G(true).au(".private:outLinks").at("blob").fG());
    }

    /* renamed from: f */
    private static hh m3232f(Uri uri) {
        return new hh(uri.toString(), new C0457a("web_url").m1406Q(4).m1404G(true).au(PlusShare.KEY_CALL_TO_ACTION_URL).fG());
    }

    /* renamed from: g */
    private static String m3233g(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: h */
    private static hf m3234h(String str, String str2) {
        return new hf(str, "", str2);
    }

    /* renamed from: i */
    private static hh m3235i(String str, String str2) {
        return new hh(str2, new C0457a(str).m1404G(true).fG(), str);
    }

    public int describeContents() {
        hs hsVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[]{this.Dw, Long.valueOf(this.Dx), Integer.valueOf(this.Dy)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        hs hsVar = CREATOR;
        hs.m1410a(this, dest, flags);
    }
}
