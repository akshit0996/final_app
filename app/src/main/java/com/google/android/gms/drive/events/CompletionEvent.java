package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0218w;
import com.google.android.gms.drive.internal.ah.C0824a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.lh;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR = new C0196b();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int CK;
    final String DZ;
    final int FP;
    final ParcelFileDescriptor OY;
    final ParcelFileDescriptor OZ;
    final DriveId Oj;
    final MetadataBundle Pa;
    final List<String> Pb;
    final IBinder Pc;
    private boolean Pd = false;
    private boolean Pe = false;
    private boolean Pf = false;

    CompletionEvent(int versionCode, DriveId driveId, String accountName, ParcelFileDescriptor baseParcelFileDescriptor, ParcelFileDescriptor modifiedParcelFileDescriptor, MetadataBundle modifiedMetadataBundle, List<String> trackingTags, int status, IBinder releaseCallback) {
        this.CK = versionCode;
        this.Oj = driveId;
        this.DZ = accountName;
        this.OY = baseParcelFileDescriptor;
        this.OZ = modifiedParcelFileDescriptor;
        this.Pa = modifiedMetadataBundle;
        this.Pb = trackingTags;
        this.FP = status;
        this.Pc = releaseCallback;
    }

    /* renamed from: M */
    private void m4752M(boolean z) {
        iC();
        this.Pf = true;
        lh.m1640a(this.OY);
        lh.m1640a(this.OZ);
        if (this.Pc == null) {
            C0218w.m396p("CompletionEvent", "No callback on " + (z ? "snooze" : "dismiss"));
            return;
        }
        try {
            C0824a.aa(this.Pc).mo1020M(z);
        } catch (RemoteException e) {
            C0218w.m396p("CompletionEvent", "RemoteException on " + (z ? "snooze" : "dismiss") + ": " + e);
        }
    }

    private void iC() {
        if (this.Pf) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        m4752M(false);
    }

    public String getAccountName() {
        iC();
        return this.DZ;
    }

    public InputStream getBaseContentsInputStream() {
        iC();
        if (this.OY == null) {
            return null;
        }
        if (this.Pd) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.Pd = true;
        return new FileInputStream(this.OY.getFileDescriptor());
    }

    public DriveId getDriveId() {
        iC();
        return this.Oj;
    }

    public InputStream getModifiedContentsInputStream() {
        iC();
        if (this.OZ == null) {
            return null;
        }
        if (this.Pe) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.Pe = true;
        return new FileInputStream(this.OZ.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        iC();
        return this.Pa != null ? new MetadataChangeSet(this.Pa) : null;
    }

    public int getStatus() {
        iC();
        return this.FP;
    }

    public List<String> getTrackingTags() {
        iC();
        return new ArrayList(this.Pb);
    }

    public int getType() {
        return 2;
    }

    public void snooze() {
        m4752M(true);
    }

    public String toString() {
        String str = this.Pb == null ? "<null>" : "'" + TextUtils.join("','", this.Pb) + "'";
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.Oj, Integer.valueOf(this.FP), str});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0196b.m289a(this, dest, flags);
    }
}
