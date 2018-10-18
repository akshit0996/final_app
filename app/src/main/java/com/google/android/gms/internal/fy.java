package com.google.android.gms.internal;

import com.google.android.gms.internal.bv.C0380a;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@ey
public final class fy {
    public final int errorCode;
    public final int orientation;
    public final long qA;
    public final cq qP;
    public final cz qQ;
    public final String qR;
    public final ct qS;
    public final List<String> qw;
    public final List<String> qx;
    public final gu se;
    public final av tL;
    public final String tO;
    public final long tV;
    public final boolean tW;
    public final long tX;
    public final List<String> tY;
    public final String ub;
    public final JSONObject vD;
    public final cr vE;
    public final ay vF;
    public final long vG;
    public final long vH;
    public final C0380a vI;

    @ey
    /* renamed from: com.google.android.gms.internal.fy$a */
    public static final class C0432a {
        public final int errorCode;
        public final ay lS;
        public final JSONObject vD;
        public final cr vE;
        public final long vG;
        public final long vH;
        public final fh vJ;
        public final fj vK;

        public C0432a(fh fhVar, fj fjVar, cr crVar, ay ayVar, int i, long j, long j2, JSONObject jSONObject) {
            this.vJ = fhVar;
            this.vK = fjVar;
            this.vE = crVar;
            this.lS = ayVar;
            this.errorCode = i;
            this.vG = j;
            this.vH = j2;
            this.vD = jSONObject;
        }
    }

    public fy(av avVar, gu guVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, cq cqVar, cz czVar, String str2, cr crVar, ct ctVar, long j2, ay ayVar, long j3, long j4, long j5, String str3, JSONObject jSONObject, C0380a c0380a) {
        this.tL = avVar;
        this.se = guVar;
        this.qw = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.qx = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.tY = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.qA = j;
        this.tO = str;
        this.tW = z;
        this.qP = cqVar;
        this.qQ = czVar;
        this.qR = str2;
        this.vE = crVar;
        this.qS = ctVar;
        this.tX = j2;
        this.vF = ayVar;
        this.tV = j3;
        this.vG = j4;
        this.vH = j5;
        this.ub = str3;
        this.vD = jSONObject;
        this.vI = c0380a;
    }

    public fy(C0432a c0432a, gu guVar, cq cqVar, cz czVar, String str, ct ctVar, C0380a c0380a) {
        this(c0432a.vJ.tL, guVar, c0432a.vK.qw, c0432a.errorCode, c0432a.vK.qx, c0432a.vK.tY, c0432a.vK.orientation, c0432a.vK.qA, c0432a.vJ.tO, c0432a.vK.tW, cqVar, czVar, str, c0432a.vE, ctVar, c0432a.vK.tX, c0432a.lS, c0432a.vK.tV, c0432a.vG, c0432a.vH, c0432a.vK.ub, c0432a.vD, c0380a);
    }
}
