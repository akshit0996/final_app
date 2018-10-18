package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.Contents;

/* renamed from: com.google.android.gms.drive.internal.g */
public class C0210g implements Creator<CloseContentsRequest> {
    /* renamed from: a */
    static void m383a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, closeContentsRequest.CK);
        C0186b.m252a(parcel, 2, closeContentsRequest.Pr, i, false);
        C0186b.m253a(parcel, 3, closeContentsRequest.Pt, false);
        C0186b.m244H(parcel, H);
    }

    public CloseContentsRequest ae(Parcel parcel) {
        Boolean bool = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < G) {
            Contents contents2;
            int g;
            Boolean bool2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    g = C0185a.m221g(parcel, F);
                    bool2 = bool3;
                    break;
                case 2:
                    g = i;
                    Contents contents3 = (Contents) C0185a.m210a(parcel, F, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case 3:
                    bool2 = C0185a.m218d(parcel, F);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    bool2 = bool;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == G) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CloseContentsRequest[] bo(int i) {
        return new CloseContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ae(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bo(x0);
    }
}
