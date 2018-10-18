package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0099R;

public final class jz extends Button {
    public jz(Context context) {
        this(context, null);
    }

    public jz(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    /* renamed from: b */
    private int m1583b(int i, int i2, int i3) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    /* renamed from: b */
    private void m1584b(Resources resources, int i, int i2) {
        int b;
        switch (i) {
            case 0:
            case 1:
                b = m1583b(i2, C0099R.drawable.common_signin_btn_text_dark, C0099R.drawable.common_signin_btn_text_light);
                break;
            case 2:
                b = m1583b(i2, C0099R.drawable.common_signin_btn_icon_dark, C0099R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (b == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(b));
    }

    /* renamed from: c */
    private void m1585c(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    /* renamed from: c */
    private void m1586c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(m1583b(i2, C0099R.color.common_signin_btn_text_dark, C0099R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                setText(resources.getString(C0099R.string.common_signin_button_text));
                return;
            case 1:
                setText(resources.getString(C0099R.string.common_signin_button_text_long));
                return;
            case 2:
                setText(null);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    /* renamed from: a */
    public void m1587a(Resources resources, int i, int i2) {
        boolean z = i >= 0 && i < 3;
        jx.m1577a(z, "Unknown button size %d", Integer.valueOf(i));
        z = i2 >= 0 && i2 < 2;
        jx.m1577a(z, "Unknown color scheme %s", Integer.valueOf(i2));
        m1585c(resources);
        m1584b(resources, i, i2);
        m1586c(resources, i, i2);
    }
}
