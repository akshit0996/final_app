package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats implements SafeParcelable {
    public static final Creator<StorageStats> CREATOR = new C0200g();
    final int CK;
    final long OM;
    final long ON;
    final long OO;
    final long OP;
    final int OQ;

    StorageStats(int versionCode, long metadataSizeBytes, long cachedContentsSizeBytes, long pinnedItemsSizeBytes, long totalSizeBytes, int numPinnedItems) {
        this.CK = versionCode;
        this.OM = metadataSizeBytes;
        this.ON = cachedContentsSizeBytes;
        this.OO = pinnedItemsSizeBytes;
        this.OP = totalSizeBytes;
        this.OQ = numPinnedItems;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0200g.m294a(this, out, flags);
    }
}
