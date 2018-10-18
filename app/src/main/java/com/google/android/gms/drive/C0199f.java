package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.drive.f */
public class C0199f implements Creator<RealtimeDocumentSyncRequest> {
    /* renamed from: a */
    static void m292a(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, realtimeDocumentSyncRequest.CK);
        C0186b.m267b(parcel, 2, realtimeDocumentSyncRequest.OK, false);
        C0186b.m267b(parcel, 3, realtimeDocumentSyncRequest.OL, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: U */
    public RealtimeDocumentSyncRequest m293U(Parcel parcel) {
        List list = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    list2 = C0185a.m204C(parcel, F);
                    break;
                case 3:
                    list = C0185a.m204C(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new RealtimeDocumentSyncRequest(i, list2, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public RealtimeDocumentSyncRequest[] bc(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m293U(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bc(x0);
    }
}
