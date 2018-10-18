package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR = new C0682a();
    private final int CK;
    String ave;
    String avg;
    String avh;
    String avi;
    String avj;
    String avk;
    ArrayList<C1259p> avl;
    C1257l avm;
    ArrayList<LatLng> avn;
    String avo;
    String avp;
    ArrayList<C1253d> avq;
    boolean avr;
    ArrayList<C1258n> avs;
    ArrayList<C1256j> avt;
    ArrayList<C1258n> avu;
    String fl;
    String name;
    int state;

    /* renamed from: com.google.android.gms.wallet.wobs.CommonWalletObject$a */
    public final class C0681a {
        final /* synthetic */ CommonWalletObject awI;

        private C0681a(CommonWalletObject commonWalletObject) {
            this.awI = commonWalletObject;
        }

        public C0681a dh(String str) {
            this.awI.fl = str;
            return this;
        }

        public CommonWalletObject ri() {
            return this.awI;
        }
    }

    CommonWalletObject() {
        this.CK = 1;
        this.avl = la.ie();
        this.avn = la.ie();
        this.avq = la.ie();
        this.avs = la.ie();
        this.avt = la.ie();
        this.avu = la.ie();
    }

    CommonWalletObject(int versionCode, String id, String classId, String name, String issuerName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, int state, ArrayList<C1259p> messages, C1257l validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<C1253d> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<C1258n> imageModuleDataMainImageUris, ArrayList<C1256j> textModulesData, ArrayList<C1258n> linksModuleDataUris) {
        this.CK = versionCode;
        this.fl = id;
        this.avk = classId;
        this.name = name;
        this.ave = issuerName;
        this.avg = barcodeAlternateText;
        this.avh = barcodeType;
        this.avi = barcodeValue;
        this.avj = barcodeLabel;
        this.state = state;
        this.avl = messages;
        this.avm = validTimeInterval;
        this.avn = locations;
        this.avo = infoModuleDataHexFontColor;
        this.avp = infoModuleDataHexBackgroundColor;
        this.avq = infoModuleDataLabelValueRows;
        this.avr = infoModuleDataShowLastUpdateTime;
        this.avs = imageModuleDataMainImageUris;
        this.avt = textModulesData;
        this.avu = linksModuleDataUris;
    }

    public static C0681a rh() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new C0681a();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.fl;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0682a.m2256a(this, dest, flags);
    }
}
