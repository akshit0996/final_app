package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class cj extends aj {
    private static final String ID = C0361a.RESOLUTION.toString();
    private final Context mContext;

    public cj(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return di.m2202u(i + "x" + displayMetrics.heightPixels);
    }

    public boolean pe() {
        return true;
    }
}
