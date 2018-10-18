package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.data.p */
public class C0297p implements Creator<Session> {
    /* renamed from: a */
    static void m554a(Session session, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m248a(parcel, 1, session.jo());
        C0186b.m268c(parcel, 1000, session.getVersionCode());
        C0186b.m248a(parcel, 2, session.jp());
        C0186b.m256a(parcel, 3, session.getName(), false);
        C0186b.m256a(parcel, 4, session.getIdentifier(), false);
        C0186b.m256a(parcel, 5, session.getDescription(), false);
        C0186b.m268c(parcel, 7, session.jm());
        C0186b.m252a(parcel, 8, session.jx(), i, false);
        C0186b.m244H(parcel, H);
    }

    public Session bC(Parcel parcel) {
        long j = 0;
        int i = 0;
        C0873a c0873a = null;
        int G = C0185a.m208G(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 2:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 8:
                    c0873a = (C0873a) C0185a.m210a(parcel, F, C0873a.CREATOR);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Session(i2, j2, j, str3, str2, str, i, c0873a);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Session[] cW(int i) {
        return new Session[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cW(x0);
    }
}
