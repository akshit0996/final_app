package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.events.d */
public class C0198d {
    /* renamed from: a */
    public static boolean m291a(int i, DriveId driveId) {
        return driveId != null || C0198d.bi(i);
    }

    public static boolean bi(int i) {
        return (2 & ((long) (1 << i))) != 0;
    }
}
