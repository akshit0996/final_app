package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;

@ey
public final class gl {
    private final Context mContext;
    private int mState;
    private final float rz;
    private String wH;
    private float wI;
    private float wJ;
    private float wK;

    /* renamed from: com.google.android.gms.internal.gl$2 */
    class C04422 implements OnClickListener {
        final /* synthetic */ gl wM;

        C04422(gl glVar) {
            this.wM = glVar;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    public gl(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.rz = context.getResources().getDisplayMetrics().density;
    }

    public gl(Context context, String str) {
        this(context);
        this.wH = str;
    }

    /* renamed from: a */
    private void m1318a(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.wI = f;
            this.wJ = f2;
            this.wK = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.wJ) {
                    this.wJ = f2;
                } else if (f2 < this.wK) {
                    this.wK = f2;
                }
                if (this.wJ - this.wK > 30.0f * this.rz) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.wI >= 50.0f * this.rz) {
                        this.wI = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.wI <= -50.0f * this.rz) {
                    this.wI = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.wI) {
                        this.wI = f;
                    }
                } else if (this.mState == 2 && f < this.wI) {
                    this.wI = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    private void showDialog() {
        Object obj;
        if (TextUtils.isEmpty(this.wH)) {
            obj = "No debug information";
        } else {
            Uri build = new Builder().encodedQuery(this.wH).build();
            StringBuilder stringBuilder = new StringBuilder();
            Map c = gi.m1305c(build);
            for (String str : c.keySet()) {
                stringBuilder.append(str).append(" = ").append((String) c.get(str)).append("\n\n");
            }
            obj = stringBuilder.toString().trim();
            if (TextUtils.isEmpty(obj)) {
                obj = "No debug information";
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(obj);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new OnClickListener(this) {
            final /* synthetic */ gl wM;

            public void onClick(DialogInterface dialog, int which) {
                this.wM.mContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", obj), "Share via"));
            }
        });
        builder.setNegativeButton("Close", new C04422(this));
        builder.create().show();
    }

    /* renamed from: Q */
    public void m1319Q(String str) {
        this.wH = str;
    }

    /* renamed from: c */
    public void m1320c(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m1318a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m1318a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
