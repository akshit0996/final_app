package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;

public class CreateFolderRequest implements SafeParcelable {
    public static final Creator<CreateFolderRequest> CREATOR = new C0215l();
    final int CK;
    final MetadataBundle Px;
    final DriveId Pz;

    CreateFolderRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata) {
        this.CK = versionCode;
        this.Pz = (DriveId) jx.m1582i(parentDriveId);
        this.Px = (MetadataBundle) jx.m1582i(metadata);
    }

    public CreateFolderRequest(DriveId parentDriveId, MetadataBundle metadata) {
        this(1, parentDriveId, metadata);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0215l.m389a(this, dest, flags);
    }
}
