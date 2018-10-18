package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.drive.internal.i */
public class C0212i {
    private String OH;
    private DriveId OJ;
    protected MetadataChangeSet Pu;
    private Integer Pv;
    private final int Pw;

    public C0212i(int i) {
        this.Pw = i;
    }

    /* renamed from: a */
    public void m385a(DriveId driveId) {
        this.OJ = (DriveId) jx.m1582i(driveId);
    }

    /* renamed from: a */
    public void m386a(MetadataChangeSet metadataChangeSet) {
        this.Pu = (MetadataChangeSet) jx.m1582i(metadataChangeSet);
    }

    public void bl(String str) {
        this.OH = (String) jx.m1582i(str);
    }

    public void bq(int i) {
        this.Pv = Integer.valueOf(i);
    }

    public IntentSender build(GoogleApiClient apiClient) {
        jx.m1578b(this.Pu, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        jx.m1576a(apiClient.isConnected(), "Client must be connected");
        C1317r c1317r = (C1317r) apiClient.mo925a(Drive.DQ);
        this.Pu.iz().setContext(c1317r.getContext());
        try {
            return c1317r.iG().mo970a(new CreateFileIntentSenderRequest(this.Pu.iz(), this.Pv == null ? -1 : this.Pv.intValue(), this.OH, this.OJ, this.Pw));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }
}
