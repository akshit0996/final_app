package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.maps.model.CameraPosition;

/* renamed from: com.google.android.gms.maps.a */
public class C0522a implements Creator<GoogleMapOptions> {
    /* renamed from: a */
    static void m1946a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, googleMapOptions.getVersionCode());
        C0186b.m245a(parcel, 2, googleMapOptions.nD());
        C0186b.m245a(parcel, 3, googleMapOptions.nE());
        C0186b.m268c(parcel, 4, googleMapOptions.getMapType());
        C0186b.m252a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0186b.m245a(parcel, 6, googleMapOptions.nF());
        C0186b.m245a(parcel, 7, googleMapOptions.nG());
        C0186b.m245a(parcel, 8, googleMapOptions.nH());
        C0186b.m245a(parcel, 9, googleMapOptions.nI());
        C0186b.m245a(parcel, 10, googleMapOptions.nJ());
        C0186b.m245a(parcel, 11, googleMapOptions.nK());
        C0186b.m245a(parcel, 12, googleMapOptions.nL());
        C0186b.m245a(parcel, 14, googleMapOptions.nM());
        C0186b.m244H(parcel, H);
    }

    public GoogleMapOptions cX(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        byte b9 = (byte) 0;
        byte b10 = (byte) 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    b = C0185a.m219e(parcel, F);
                    break;
                case 3:
                    b2 = C0185a.m219e(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C0185a.m210a(parcel, F, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = C0185a.m219e(parcel, F);
                    break;
                case 7:
                    b4 = C0185a.m219e(parcel, F);
                    break;
                case 8:
                    b5 = C0185a.m219e(parcel, F);
                    break;
                case 9:
                    b6 = C0185a.m219e(parcel, F);
                    break;
                case 10:
                    b7 = C0185a.m219e(parcel, F);
                    break;
                case 11:
                    b8 = C0185a.m219e(parcel, F);
                    break;
                case 12:
                    b9 = C0185a.m219e(parcel, F);
                    break;
                case 14:
                    b10 = C0185a.m219e(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GoogleMapOptions(i, b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cX(x0);
    }

    public GoogleMapOptions[] eT(int i) {
        return new GoogleMapOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eT(x0);
    }
}
