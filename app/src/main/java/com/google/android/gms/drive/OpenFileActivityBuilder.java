package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C1317r;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.internal.jx;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String OH;
    private String[] OI;
    private DriveId OJ;

    public IntentSender build(GoogleApiClient apiClient) {
        jx.m1576a(apiClient.isConnected(), "Client must be connected");
        if (this.OI == null) {
            this.OI = new String[0];
        }
        try {
            return ((C1317r) apiClient.mo925a(Drive.DQ)).iG().mo971a(new OpenFileIntentSenderRequest(this.OH, this.OI, this.OJ));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.OJ = (DriveId) jx.m1582i(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.OH = (String) jx.m1582i(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        jx.m1580b(mimeTypes != null, (Object) "mimeTypes may not be null");
        this.OI = mimeTypes;
        return this;
    }
}
