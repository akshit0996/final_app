package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@ey
public final class gq {
    public static final Handler wR = new Handler(Looper.getMainLooper());

    /* renamed from: R */
    public static String m1330R(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static int m1331a(Context context, int i) {
        return m1332a(context.getResources().getDisplayMetrics(), i);
    }

    /* renamed from: a */
    public static int m1332a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    /* renamed from: a */
    public static void m1333a(ViewGroup viewGroup, ay ayVar, String str) {
        m1334a(viewGroup, ayVar, str, ViewCompat.MEASURED_STATE_MASK, -1);
    }

    /* renamed from: a */
    private static void m1334a(ViewGroup viewGroup, ay ayVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m1331a(context, 3);
            frameLayout.addView(textView, new LayoutParams(ayVar.widthPixels - a, ayVar.heightPixels - a, 17));
            viewGroup.addView(frameLayout, ayVar.widthPixels, ayVar.heightPixels);
        }
    }

    /* renamed from: a */
    public static void m1335a(ViewGroup viewGroup, ay ayVar, String str, String str2) {
        gr.m1341W(str2);
        m1334a(viewGroup, ayVar, str, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK);
    }

    public static boolean dA() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean dB() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: v */
    public static String m1336v(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || dA()) {
            string = "emulator";
        }
        return m1330R(string);
    }
}
