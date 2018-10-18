package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0212i;
import com.google.android.gms.drive.internal.C0827s;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lh;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final C0212i Ol = new C0212i(0);
    private DriveContents Om;
    private boolean On;

    public IntentSender build(GoogleApiClient apiClient) {
        jx.m1578b(Boolean.valueOf(this.On), (Object) "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        boolean z = apiClient.mo927a(Drive.SCOPE_FILE) || apiClient.mo927a(Drive.Oo);
        jx.m1580b(z, (Object) "The apiClient must have suitable scope to create files");
        if (this.Om != null) {
            lh.m1640a(this.Om.getParcelFileDescriptor());
            this.Om.is();
        }
        return this.Ol.build(apiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.Ol.m385a(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.Ol.bl(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.Ol.bq(1);
        } else if (!(driveContents instanceof C0827s)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.it()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.Ol.bq(driveContents.ir().getRequestId());
            this.Om = driveContents;
        }
        this.On = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.Ol.m386a(metadataChangeSet);
        return this;
    }
}
