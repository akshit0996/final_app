package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    /* renamed from: com.google.android.gms.tagmanager.PreviewActivity$1 */
    class C06041 implements OnClickListener {
        final /* synthetic */ PreviewActivity asl;

        C06041(PreviewActivity previewActivity) {
            this.asl = previewActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    /* renamed from: d */
    private void m2084d(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C06041(this));
        create.show();
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            bh.m2115U("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).m2089i(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                bh.m2117W(str);
                m2084d("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                bh.m2115U("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            bh.m2115U("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            bh.m2114T("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
