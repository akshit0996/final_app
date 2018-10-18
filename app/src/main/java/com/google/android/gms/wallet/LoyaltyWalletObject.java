package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.C1253d;
import com.google.android.gms.wallet.wobs.C1254f;
import com.google.android.gms.wallet.wobs.C1256j;
import com.google.android.gms.wallet.wobs.C1257l;
import com.google.android.gms.wallet.wobs.C1258n;
import com.google.android.gms.wallet.wobs.C1259p;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator<LoyaltyWalletObject> CREATOR = new C0674j();
    private final int CK;
    String aki;
    String avd;
    String ave;
    String avf;
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
    C1254f avv;
    String fl;
    int state;

    LoyaltyWalletObject() {
        this.CK = 4;
        this.avl = la.ie();
        this.avn = la.ie();
        this.avq = la.ie();
        this.avs = la.ie();
        this.avt = la.ie();
        this.avu = la.ie();
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, String classId, int state, ArrayList<C1259p> messages, C1257l validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<C1253d> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<C1258n> imageModuleDataMainImageUris, ArrayList<C1256j> textModulesData, ArrayList<C1258n> linksModuleDataUris, C1254f loyaltyPoints) {
        this.CK = versionCode;
        this.fl = id;
        this.avd = accountId;
        this.ave = issuerName;
        this.avf = programName;
        this.aki = accountName;
        this.avg = barcodeAlternateText;
        this.avh = barcodeType;
        this.avi = barcodeValue;
        this.avj = barcodeLabel;
        this.avk = classId;
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
        this.avv = loyaltyPoints;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.avd;
    }

    public String getAccountName() {
        return this.aki;
    }

    public String getBarcodeAlternateText() {
        return this.avg;
    }

    public String getBarcodeType() {
        return this.avh;
    }

    public String getBarcodeValue() {
        return this.avi;
    }

    public String getId() {
        return this.fl;
    }

    public String getIssuerName() {
        return this.ave;
    }

    public String getProgramName() {
        return this.avf;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0674j.m2250a(this, dest, flags);
    }
}
