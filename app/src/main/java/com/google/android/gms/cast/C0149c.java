package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.cast.c */
public class C0149c implements Creator<LaunchOptions> {
    /* renamed from: a */
    static void m120a(LaunchOptions launchOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, launchOptions.getVersionCode());
        C0186b.m259a(parcel, 2, launchOptions.getRelaunchIfRunning());
        C0186b.m256a(parcel, 3, launchOptions.getLanguage(), false);
        C0186b.m244H(parcel, H);
    }

    public LaunchOptions[] aa(int i) {
        return new LaunchOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m121w(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aa(x0);
    }

    /* renamed from: w */
    public LaunchOptions m121w(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LaunchOptions(i, z, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
