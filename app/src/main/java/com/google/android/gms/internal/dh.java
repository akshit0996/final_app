package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C0099R;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dh {
    private final Context mContext;
    private final gu mo;
    private final Map<String, String> rd;
    private String re;
    private long rf;
    private long rg;
    private String rh;
    private String ri;

    /* renamed from: com.google.android.gms.internal.dh$1 */
    class C03971 implements OnClickListener {
        final /* synthetic */ dh rj;

        C03971(dh dhVar) {
            this.rj = dhVar;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.rj.mContext.startActivity(this.rj.createIntent());
        }
    }

    /* renamed from: com.google.android.gms.internal.dh$2 */
    class C03982 implements OnClickListener {
        final /* synthetic */ dh rj;

        C03982(dh dhVar) {
            this.rj = dhVar;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.rj.mo.m1357b("onCalendarEventCanceled", new JSONObject());
        }
    }

    public dh(gu guVar, Map<String, String> map) {
        this.mo = guVar;
        this.rd = map;
        this.mContext = guVar.dI();
        bQ();
    }

    /* renamed from: A */
    private String m1117A(String str) {
        return TextUtils.isEmpty((CharSequence) this.rd.get(str)) ? "" : (String) this.rd.get(str);
    }

    private void bQ() {
        this.re = m1117A(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.rh = m1117A("summary");
        this.rf = gi.m1287O((String) this.rd.get("start"));
        this.rg = gi.m1287O((String) this.rd.get("end"));
        this.ri = m1117A("location");
    }

    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.rh);
        data.putExtra("eventLocation", this.ri);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.re);
        data.putExtra("beginTime", this.rf);
        data.putExtra("endTime", this.rg);
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }

    public void execute() {
        if (new bl(this.mContext).bt()) {
            Builder builder = new Builder(this.mContext);
            builder.setTitle(ga.m3194c(C0099R.string.create_calendar_title, "Create calendar event"));
            builder.setMessage(ga.m3194c(C0099R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            builder.setPositiveButton(ga.m3194c(C0099R.string.accept, "Accept"), new C03971(this));
            builder.setNegativeButton(ga.m3194c(C0099R.string.decline, "Decline"), new C03982(this));
            builder.create().show();
            return;
        }
        gr.m1341W("This feature is not available on this version of the device.");
    }
}
