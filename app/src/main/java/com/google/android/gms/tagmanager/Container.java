package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0381c.C1383f;
import com.google.android.gms.internal.C0381c.C1386i;
import com.google.android.gms.internal.C0381c.C1387j;
import com.google.android.gms.internal.C0386d.C1389a;
import com.google.android.gms.tagmanager.C1240s.C0646a;
import com.google.android.gms.tagmanager.ce.C0617a;
import com.google.android.gms.tagmanager.cr.C0625c;
import com.google.android.gms.tagmanager.cr.C0629g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String aqm;
    private final DataLayer aqn;
    private ct aqo;
    private Map<String, FunctionCallMacroCallback> aqp = new HashMap();
    private Map<String, FunctionCallTagCallback> aqq = new HashMap();
    private volatile long aqr;
    private volatile String aqs = "";
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.Container$a */
    private class C1205a implements C0646a {
        final /* synthetic */ Container aqt;

        private C1205a(Container container) {
            this.aqt = container;
        }

        /* renamed from: b */
        public Object mo2505b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback cp = this.aqt.cp(str);
            return cp == null ? null : cp.getValue(str, map);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.Container$b */
    private class C1206b implements C0646a {
        final /* synthetic */ Container aqt;

        private C1206b(Container container) {
            this.aqt = container;
        }

        /* renamed from: b */
        public Object mo2505b(String str, Map<String, Object> map) {
            FunctionCallTagCallback cq = this.aqt.cq(str);
            if (cq != null) {
                cq.execute(str, map);
            }
            return di.ra();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C1387j resource) {
        this.mContext = context;
        this.aqn = dataLayer;
        this.aqm = containerId;
        this.aqr = lastRefreshTime;
        m2061a(resource.gs);
        if (resource.gr != null) {
            m2064a(resource.gr);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0625c resource) {
        this.mContext = context;
        this.aqn = dataLayer;
        this.aqm = containerId;
        this.aqr = lastRefreshTime;
        m2062a(resource);
    }

    /* renamed from: a */
    private void m2061a(C1383f c1383f) {
        if (c1383f == null) {
            throw new NullPointerException();
        }
        try {
            m2062a(cr.m2153b(c1383f));
        } catch (C0629g e) {
            bh.m2114T("Not loading resource: " + c1383f + " because it is invalid: " + e.toString());
        }
    }

    /* renamed from: a */
    private void m2062a(C0625c c0625c) {
        this.aqs = c0625c.getVersion();
        C0625c c0625c2 = c0625c;
        m2063a(new ct(this.mContext, c0625c2, this.aqn, new C1205a(), new C1206b(), cs(this.aqs)));
    }

    /* renamed from: a */
    private synchronized void m2063a(ct ctVar) {
        this.aqo = ctVar;
    }

    /* renamed from: a */
    private void m2064a(C1386i[] c1386iArr) {
        List arrayList = new ArrayList();
        for (Object add : c1386iArr) {
            arrayList.add(add);
        }
        pk().m2181l(arrayList);
    }

    private synchronized ct pk() {
        return this.aqo;
    }

    FunctionCallMacroCallback cp(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.aqp) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.aqp.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback cq(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.aqq) {
            functionCallTagCallback = (FunctionCallTagCallback) this.aqq.get(str);
        }
        return functionCallTagCallback;
    }

    void cr(String str) {
        pk().cr(str);
    }

    ag cs(String str) {
        if (ce.qa().qb().equals(C0617a.CONTAINER_DEBUG)) {
        }
        return new br();
    }

    public boolean getBoolean(String key) {
        ct pk = pk();
        if (pk == null) {
            bh.m2114T("getBoolean called for closed container.");
            return di.qY().booleanValue();
        }
        try {
            return di.m2195n((C1389a) pk.cT(key).getObject()).booleanValue();
        } catch (Exception e) {
            bh.m2114T("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.qY().booleanValue();
        }
    }

    public String getContainerId() {
        return this.aqm;
    }

    public double getDouble(String key) {
        ct pk = pk();
        if (pk == null) {
            bh.m2114T("getDouble called for closed container.");
            return di.qX().doubleValue();
        }
        try {
            return di.m2194m((C1389a) pk.cT(key).getObject()).doubleValue();
        } catch (Exception e) {
            bh.m2114T("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.qX().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.aqr;
    }

    public long getLong(String key) {
        ct pk = pk();
        if (pk == null) {
            bh.m2114T("getLong called for closed container.");
            return di.qW().longValue();
        }
        try {
            return di.m2193l((C1389a) pk.cT(key).getObject()).longValue();
        } catch (Exception e) {
            bh.m2114T("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.qW().longValue();
        }
    }

    public String getString(String key) {
        ct pk = pk();
        if (pk == null) {
            bh.m2114T("getString called for closed container.");
            return di.ra();
        }
        try {
            return di.m2191j((C1389a) pk.cT(key).getObject());
        } catch (Exception e) {
            bh.m2114T("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.ra();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    String pj() {
        return this.aqs;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.aqp) {
            this.aqp.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.aqq) {
            this.aqq.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.aqo = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.aqp) {
            this.aqp.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.aqq) {
            this.aqq.remove(customTagName);
        }
    }
}
