package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.z */
class C1245z extends aj {
    private static final String ID = C0361a.DEVICE_ID.toString();
    private final Context mContext;

    public C1245z(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        String Y = m3799Y(this.mContext);
        return Y == null ? di.rb() : di.m2202u(Y);
    }

    /* renamed from: Y */
    protected String m3799Y(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean pe() {
        return true;
    }
}
