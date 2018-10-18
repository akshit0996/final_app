package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.android.gms.internal.bv.C0380a;
import com.google.android.gms.internal.fy.C0432a;
import com.google.android.gms.internal.gn.C0444a;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fn implements Callable<fy> {
    private final Context mContext;
    private final Object mH = new Object();
    private final C1440u pM;
    private final C0432a tB;
    private int tq;
    private final gn ul;
    private final ai um;
    private boolean un;
    private List<String> uo;

    /* renamed from: com.google.android.gms.internal.fn$a */
    public interface C0429a<T extends C0380a> {
        /* renamed from: a */
        T mo1795a(fn fnVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    public fn(Context context, C1440u c1440u, ai aiVar, gn gnVar, C0432a c0432a) {
        this.mContext = context;
        this.pM = c1440u;
        this.ul = gnVar;
        this.um = aiVar;
        this.tB = c0432a;
        this.un = false;
        this.tq = -2;
        this.uo = null;
    }

    /* renamed from: a */
    private C0380a m1217a(ah ahVar, C0429a c0429a, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (cO()) {
            return null;
        }
        String[] b = m1219b(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.uo = b == null ? null : Arrays.asList(b);
        C0380a a = c0429a.mo1795a(this, jSONObject);
        if (a == null) {
            gr.m1338T("Failed to retrieve ad assets.");
            return null;
        }
        a.mo3306a(new bv(this.pM, ahVar, jSONObject));
        return a;
    }

    /* renamed from: a */
    private fy m1218a(C0380a c0380a) {
        int i;
        synchronized (this.mH) {
            i = this.tq;
            if (c0380a == null && this.tq == -2) {
                i = 0;
            }
        }
        return new fy(this.tB.vJ.tL, null, this.tB.vK.qw, i, this.tB.vK.qx, this.uo, this.tB.vK.orientation, this.tB.vK.qA, this.tB.vJ.tO, false, null, null, null, null, null, 0, this.tB.lS, this.tB.vK.tV, this.tB.vG, this.tB.vH, this.tB.vK.ub, this.tB.vD, i != -2 ? null : c0380a);
    }

    /* renamed from: b */
    private String[] m1219b(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    /* renamed from: c */
    private JSONObject m1220c(final ah ahVar) throws TimeoutException, JSONException {
        if (cO()) {
            return null;
        }
        final gj gjVar = new gj();
        ahVar.mo1664a("/nativeAdPreProcess", new cd(this) {
            final /* synthetic */ fn ur;

            /* renamed from: a */
            public void mo1660a(gu guVar, Map<String, String> map) {
                ahVar.mo1668g("/nativeAdPreProcess");
                try {
                    String str = (String) map.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        gjVar.m1316a(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (Throwable e) {
                    gr.m1343b("Malformed native JSON response.", e);
                }
                this.ur.m1224t(0);
                jx.m1576a(this.ur.cO(), "Unable to set the ad state error!");
                gjVar.m1316a(null);
            }
        });
        ahVar.mo1665a("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.tB.vK.tU));
        return (JSONObject) gjVar.get();
    }

    private ah cN() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (cO()) {
            return null;
        }
        ah ahVar = (ah) this.um.m1004a(this.mContext, this.tB.vJ.lO, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html").get();
        ahVar.mo1663a(this.pM, this.pM, this.pM, this.pM, false, this.pM);
        return ahVar;
    }

    /* renamed from: a */
    public Future<Drawable> m1221a(JSONObject jSONObject, String str, final boolean z) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        Object string = z ? jSONObject2.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject2.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (!TextUtils.isEmpty(string)) {
            return this.ul.m1328a(string, new C0444a<Drawable>(this) {
                final /* synthetic */ fn ur;

                /* renamed from: a */
                public Drawable m3180a(InputStream inputStream) {
                    byte[] d;
                    try {
                        d = lh.m1643d(inputStream);
                    } catch (IOException e) {
                        d = null;
                    }
                    if (d == null) {
                        this.ur.m1222a(2, z);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(d, 0, d.length);
                    if (decodeByteArray != null) {
                        return new BitmapDrawable(Resources.getSystem(), decodeByteArray);
                    }
                    this.ur.m1222a(2, z);
                    return null;
                }

                /* renamed from: b */
                public /* synthetic */ Object mo1793b(InputStream inputStream) {
                    return m3180a(inputStream);
                }

                public Drawable cP() {
                    this.ur.m1222a(2, z);
                    return null;
                }

                public /* synthetic */ Object cQ() {
                    return cP();
                }
            });
        }
        m1222a(0, z);
        return new gk(null);
    }

    /* renamed from: a */
    public void m1222a(int i, boolean z) {
        if (z) {
            m1224t(i);
        }
    }

    /* renamed from: b */
    protected C0429a m1223b(JSONObject jSONObject) throws JSONException {
        if (cO()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        if ("2".equals(string)) {
            return new fo();
        }
        if ("1".equals(string)) {
            return new fp();
        }
        m1224t(0);
        return null;
    }

    public fy cM() {
        try {
            ah cN = cN();
            JSONObject c = m1220c(cN);
            return m1218a(m1217a(cN, m1223b(c), c));
        } catch (CancellationException e) {
            if (!this.un) {
                m1224t(0);
            }
            return m1218a(null);
        } catch (ExecutionException e2) {
            if (this.un) {
                m1224t(0);
            }
            return m1218a(null);
        } catch (InterruptedException e3) {
            if (this.un) {
                m1224t(0);
            }
            return m1218a(null);
        } catch (Throwable e4) {
            gr.m1345d("Malformed native JSON response.", e4);
            if (this.un) {
                m1224t(0);
            }
            return m1218a(null);
        } catch (Throwable e42) {
            gr.m1345d("Timeout when loading native ad.", e42);
            if (this.un) {
                m1224t(0);
            }
            return m1218a(null);
        }
    }

    public boolean cO() {
        boolean z;
        synchronized (this.mH) {
            z = this.un;
        }
        return z;
    }

    public /* synthetic */ Object call() throws Exception {
        return cM();
    }

    /* renamed from: t */
    public void m1224t(int i) {
        synchronized (this.mH) {
            this.un = true;
            this.tq = i;
        }
    }
}
