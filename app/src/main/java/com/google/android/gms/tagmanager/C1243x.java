package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.x */
class C1243x implements bi {
    private int yM = 5;

    C1243x() {
    }

    /* renamed from: S */
    public void mo2573S(String str) {
        if (this.yM <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    /* renamed from: T */
    public void mo2574T(String str) {
        if (this.yM <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    /* renamed from: U */
    public void mo2575U(String str) {
        if (this.yM <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    /* renamed from: V */
    public void mo2576V(String str) {
        if (this.yM <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    /* renamed from: W */
    public void mo2577W(String str) {
        if (this.yM <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    /* renamed from: b */
    public void mo2578b(String str, Throwable th) {
        if (this.yM <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    /* renamed from: d */
    public void mo2579d(String str, Throwable th) {
        if (this.yM <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void setLogLevel(int logLevel) {
        this.yM = logLevel;
    }
}
