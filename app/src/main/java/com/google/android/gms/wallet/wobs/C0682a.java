package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.a */
public class C0682a implements Creator<CommonWalletObject> {
    /* renamed from: a */
    static void m2256a(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, commonWalletObject.getVersionCode());
        C0186b.m256a(parcel, 2, commonWalletObject.fl, false);
        C0186b.m256a(parcel, 3, commonWalletObject.avk, false);
        C0186b.m256a(parcel, 4, commonWalletObject.name, false);
        C0186b.m256a(parcel, 5, commonWalletObject.ave, false);
        C0186b.m256a(parcel, 6, commonWalletObject.avg, false);
        C0186b.m256a(parcel, 7, commonWalletObject.avh, false);
        C0186b.m256a(parcel, 8, commonWalletObject.avi, false);
        C0186b.m256a(parcel, 9, commonWalletObject.avj, false);
        C0186b.m268c(parcel, 10, commonWalletObject.state);
        C0186b.m269c(parcel, 11, commonWalletObject.avl, false);
        C0186b.m252a(parcel, 12, commonWalletObject.avm, i, false);
        C0186b.m269c(parcel, 13, commonWalletObject.avn, false);
        C0186b.m256a(parcel, 14, commonWalletObject.avo, false);
        C0186b.m256a(parcel, 15, commonWalletObject.avp, false);
        C0186b.m259a(parcel, 17, commonWalletObject.avr);
        C0186b.m269c(parcel, 16, commonWalletObject.avq, false);
        C0186b.m269c(parcel, 19, commonWalletObject.avt, false);
        C0186b.m269c(parcel, 18, commonWalletObject.avs, false);
        C0186b.m269c(parcel, 20, commonWalletObject.avu, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ec(x0);
    }

    public CommonWalletObject ec(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        ArrayList ie = la.ie();
        C1257l c1257l = null;
        ArrayList ie2 = la.ie();
        String str9 = null;
        String str10 = null;
        ArrayList ie3 = la.ie();
        boolean z = false;
        ArrayList ie4 = la.ie();
        ArrayList ie5 = la.ie();
        ArrayList ie6 = la.ie();
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    str6 = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    str7 = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    str8 = C0185a.m229o(parcel, F);
                    break;
                case 10:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 11:
                    ie = C0185a.m216c(parcel, F, C1259p.CREATOR);
                    break;
                case 12:
                    c1257l = (C1257l) C0185a.m210a(parcel, F, C1257l.CREATOR);
                    break;
                case 13:
                    ie2 = C0185a.m216c(parcel, F, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = C0185a.m229o(parcel, F);
                    break;
                case 15:
                    str10 = C0185a.m229o(parcel, F);
                    break;
                case 16:
                    ie3 = C0185a.m216c(parcel, F, C1253d.CREATOR);
                    break;
                case 17:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 18:
                    ie4 = C0185a.m216c(parcel, F, C1258n.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    ie5 = C0185a.m216c(parcel, F, C1256j.CREATOR);
                    break;
                case 20:
                    ie6 = C0185a.m216c(parcel, F, C1258n.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, ie, c1257l, ie2, str9, str10, ie3, z, ie4, ie5, ie6);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CommonWalletObject[] gl(int i) {
        return new CommonWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gl(x0);
    }
}
