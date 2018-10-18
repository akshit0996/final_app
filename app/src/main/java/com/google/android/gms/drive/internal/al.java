package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.Contents;

public class al implements Creator<OnContentsResponse> {
    /* renamed from: a */
    static void m357a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, onContentsResponse.CK);
        C0186b.m252a(parcel, 2, onContentsResponse.PW, i, false);
        C0186b.m259a(parcel, 3, onContentsResponse.QJ);
        C0186b.m244H(parcel, H);
    }

    public OnContentsResponse aq(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        Contents contents = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            Contents contents2;
            int g;
            boolean z2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    boolean z3 = z;
                    contents2 = contents;
                    g = C0185a.m221g(parcel, F);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    Contents contents3 = (Contents) C0185a.m210a(parcel, F, Contents.CREATOR);
                    z2 = z;
                    contents2 = contents3;
                    break;
                case 3:
                    z2 = C0185a.m217c(parcel, F);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    z2 = z;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            z = z2;
        }
        if (parcel.dataPosition() == G) {
            return new OnContentsResponse(i, contents, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public OnContentsResponse[] bF(int i) {
        return new OnContentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bF(x0);
    }
}
