package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0099R;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dj {
    private final Context mContext;
    private final gu mo;
    private final Map<String, String> rd;

    /* renamed from: com.google.android.gms.internal.dj$2 */
    class C04002 implements OnClickListener {
        final /* synthetic */ dj rr;

        C04002(dj djVar) {
            this.rr = djVar;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.rr.mo.m1357b("onStorePictureCanceled", new JSONObject());
        }
    }

    public dj(gu guVar, Map<String, String> map) {
        this.mo = guVar;
        this.rd = map;
        this.mContext = guVar.dI();
    }

    /* renamed from: B */
    String m1124B(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    /* renamed from: b */
    Request m1125b(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        if (ll.ig()) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
        } else {
            request.setShowRunningNotification(true);
        }
        return request;
    }

    public void execute() {
        if (!new bl(this.mContext).bq()) {
            gr.m1341W("Store picture feature is not supported on this device.");
        } else if (TextUtils.isEmpty((CharSequence) this.rd.get("iurl"))) {
            gr.m1341W("Image url cannot be empty.");
        } else {
            final String str = (String) this.rd.get("iurl");
            if (URLUtil.isValidUrl(str)) {
                final String B = m1124B(str);
                if (gi.m1286N(B)) {
                    Builder builder = new Builder(this.mContext);
                    builder.setTitle(ga.m3194c(C0099R.string.store_picture_title, "Save image"));
                    builder.setMessage(ga.m3194c(C0099R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    builder.setPositiveButton(ga.m3194c(C0099R.string.accept, "Accept"), new OnClickListener(this) {
                        final /* synthetic */ dj rr;

                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                ((DownloadManager) this.rr.mContext.getSystemService("download")).enqueue(this.rr.m1125b(str, B));
                            } catch (IllegalStateException e) {
                                gr.m1339U("Could not store picture.");
                            }
                        }
                    });
                    builder.setNegativeButton(ga.m3194c(C0099R.string.decline, "Decline"), new C04002(this));
                    builder.create().show();
                    return;
                }
                gr.m1341W("Image type not recognized:");
                return;
            }
            gr.m1341W("Invalid image url:" + str);
        }
    }
}
