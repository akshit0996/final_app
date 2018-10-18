package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.C1253d;
import com.google.android.gms.wallet.wobs.C1254f;
import com.google.android.gms.wallet.wobs.C1256j;
import com.google.android.gms.wallet.wobs.C1257l;
import com.google.android.gms.wallet.wobs.C1258n;
import com.google.android.gms.wallet.wobs.C1259p;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.j */
public class C0674j implements Creator<LoyaltyWalletObject> {
    /* renamed from: a */
    static void m2250a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0186b.m256a(parcel, 2, loyaltyWalletObject.fl, false);
        C0186b.m256a(parcel, 3, loyaltyWalletObject.avd, false);
        C0186b.m256a(parcel, 4, loyaltyWalletObject.ave, false);
        C0186b.m256a(parcel, 5, loyaltyWalletObject.avf, false);
        C0186b.m256a(parcel, 6, loyaltyWalletObject.aki, false);
        C0186b.m256a(parcel, 7, loyaltyWalletObject.avg, false);
        C0186b.m256a(parcel, 8, loyaltyWalletObject.avh, false);
        C0186b.m256a(parcel, 9, loyaltyWalletObject.avi, false);
        C0186b.m256a(parcel, 10, loyaltyWalletObject.avj, false);
        C0186b.m256a(parcel, 11, loyaltyWalletObject.avk, false);
        C0186b.m268c(parcel, 12, loyaltyWalletObject.state);
        C0186b.m269c(parcel, 13, loyaltyWalletObject.avl, false);
        C0186b.m252a(parcel, 14, loyaltyWalletObject.avm, i, false);
        C0186b.m269c(parcel, 15, loyaltyWalletObject.avn, false);
        C0186b.m256a(parcel, 17, loyaltyWalletObject.avp, false);
        C0186b.m256a(parcel, 16, loyaltyWalletObject.avo, false);
        C0186b.m259a(parcel, 19, loyaltyWalletObject.avr);
        C0186b.m269c(parcel, 18, loyaltyWalletObject.avq, false);
        C0186b.m269c(parcel, 21, loyaltyWalletObject.avt, false);
        C0186b.m269c(parcel, 20, loyaltyWalletObject.avs, false);
        C0186b.m252a(parcel, 23, loyaltyWalletObject.avv, i, false);
        C0186b.m269c(parcel, 22, loyaltyWalletObject.avu, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dR(x0);
    }

    public LoyaltyWalletObject dR(Parcel parcel) {
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
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList ie = la.ie();
        C1257l c1257l = null;
        ArrayList ie2 = la.ie();
        String str11 = null;
        String str12 = null;
        ArrayList ie3 = la.ie();
        boolean z = false;
        ArrayList ie4 = la.ie();
        ArrayList ie5 = la.ie();
        ArrayList ie6 = la.ie();
        C1254f c1254f = null;
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
                    str9 = C0185a.m229o(parcel, F);
                    break;
                case 11:
                    str10 = C0185a.m229o(parcel, F);
                    break;
                case 12:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 13:
                    ie = C0185a.m216c(parcel, F, C1259p.CREATOR);
                    break;
                case 14:
                    c1257l = (C1257l) C0185a.m210a(parcel, F, C1257l.CREATOR);
                    break;
                case 15:
                    ie2 = C0185a.m216c(parcel, F, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = C0185a.m229o(parcel, F);
                    break;
                case 17:
                    str12 = C0185a.m229o(parcel, F);
                    break;
                case 18:
                    ie3 = C0185a.m216c(parcel, F, C1253d.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 20:
                    ie4 = C0185a.m216c(parcel, F, C1258n.CREATOR);
                    break;
                case 21:
                    ie5 = C0185a.m216c(parcel, F, C1256j.CREATOR);
                    break;
                case 22:
                    ie6 = C0185a.m216c(parcel, F, C1258n.CREATOR);
                    break;
                case 23:
                    c1254f = (C1254f) C0185a.m210a(parcel, F, C1254f.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, ie, c1257l, ie2, str11, str12, ie3, z, ie4, ie5, ie6, c1254f);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public LoyaltyWalletObject[] fY(int i) {
        return new LoyaltyWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fY(x0);
    }
}
