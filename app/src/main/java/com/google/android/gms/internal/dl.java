package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.dk.C0402a;
import org.json.JSONObject;

@ey
public class dl {
    private final Context mContext;
    private final WindowManager mR;
    private final gu mo;
    int rA = -1;
    int rB = -1;
    private int rC;
    private int rD = -1;
    private int rE = -1;
    private int[] rF = new int[2];
    private final bl rx;
    DisplayMetrics ry;
    private float rz;

    public dl(gu guVar, Context context, bl blVar) {
        this.mo = guVar;
        this.mContext = context;
        this.rx = blVar;
        this.mR = (WindowManager) context.getSystemService("window");
        bV();
        bW();
        bX();
    }

    private void bV() {
        this.ry = new DisplayMetrics();
        Display defaultDisplay = this.mR.getDefaultDisplay();
        defaultDisplay.getMetrics(this.ry);
        this.rz = this.ry.density;
        this.rC = defaultDisplay.getRotation();
    }

    private void bX() {
        this.mo.getLocationOnScreen(this.rF);
        this.mo.measure(0, 0);
        float f = 160.0f / ((float) this.ry.densityDpi);
        this.rD = Math.round(((float) this.mo.getMeasuredWidth()) * f);
        this.rE = Math.round(f * ((float) this.mo.getMeasuredHeight()));
    }

    private dk cd() {
        return new C0402a().m1132l(this.rx.bo()).m1131k(this.rx.bp()).m1133m(this.rx.bt()).m1134n(this.rx.bq()).m1135o(this.rx.br()).bU();
    }

    void bW() {
        int s = gi.m1311s(this.mContext);
        float f = 160.0f / ((float) this.ry.densityDpi);
        this.rA = Math.round(((float) this.ry.widthPixels) * f);
        this.rB = Math.round(((float) (this.ry.heightPixels - s)) * f);
    }

    public void bY() {
        cb();
        cc();
        ca();
        bZ();
    }

    public void bZ() {
        if (gr.m1346v(2)) {
            gr.m1339U("Dispatching Ready Event.");
        }
        this.mo.m1357b("onReadyEventReceived", new JSONObject());
    }

    public void ca() {
        try {
            this.mo.m1357b("onDefaultPositionReceived", new JSONObject().put("x", this.rF[0]).put("y", this.rF[1]).put("width", this.rD).put("height", this.rE));
        } catch (Throwable e) {
            gr.m1343b("Error occured while dispatching default position.", e);
        }
    }

    public void cb() {
        try {
            this.mo.m1357b("onScreenInfoChanged", new JSONObject().put("width", this.rA).put("height", this.rB).put("density", (double) this.rz).put("rotation", this.rC));
        } catch (Throwable e) {
            gr.m1343b("Error occured while obtaining screen information.", e);
        }
    }

    public void cc() {
        this.mo.m1357b("onDeviceFeaturesReceived", cd().toJson());
    }
}
