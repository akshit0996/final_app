package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer.C0601b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager atW;
    private final DataLayer aqn;
    private final C0645r asD;
    private final C0607a atT;
    private final cx atU;
    private final ConcurrentMap<C1472n, Boolean> atV;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.TagManager$3 */
    class C06053 implements ComponentCallbacks2 {
        final /* synthetic */ TagManager atX;

        C06053(TagManager tagManager) {
            this.atX = tagManager;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.atX.dispatch();
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager$a */
    interface C0607a {
        /* renamed from: a */
        C1473o mo2511a(Context context, TagManager tagManager, Looper looper, String str, int i, C0645r c0645r);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager$1 */
    class C12091 implements C0601b {
        final /* synthetic */ TagManager atX;

        C12091(TagManager tagManager) {
            this.atX = tagManager;
        }

        /* renamed from: C */
        public void mo2510C(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.atX.cV(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager$2 */
    static class C12102 implements C0607a {
        C12102() {
        }

        /* renamed from: a */
        public C1473o mo2511a(Context context, TagManager tagManager, Looper looper, String str, int i, C0645r c0645r) {
            return new C1473o(context, tagManager, looper, str, i, c0645r);
        }
    }

    TagManager(Context context, C0607a containerHolderLoaderProvider, DataLayer dataLayer, cx serviceManager) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.atU = serviceManager;
        this.atT = containerHolderLoaderProvider;
        this.atV = new ConcurrentHashMap();
        this.aqn = dataLayer;
        this.aqn.m2079a(new C12091(this));
        this.aqn.m2079a(new C1223d(this.mContext));
        this.asD = new C0645r();
        qP();
    }

    private void cV(String str) {
        for (C1472n cr : this.atV.keySet()) {
            cr.cr(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (atW == null) {
                if (context == null) {
                    bh.m2114T("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                atW = new TagManager(context, new C12102(), new DataLayer(new C1242v(context)), cy.qN());
            }
            tagManager = atW;
        }
        return tagManager;
    }

    private void qP() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new C06053(this));
        }
    }

    /* renamed from: a */
    void m2087a(C1472n c1472n) {
        this.atV.put(c1472n, Boolean.valueOf(true));
    }

    /* renamed from: b */
    boolean m2088b(C1472n c1472n) {
        return this.atV.remove(c1472n) != null;
    }

    public void dispatch() {
        this.atU.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.aqn;
    }

    /* renamed from: i */
    synchronized boolean m2089i(Uri uri) {
        boolean z;
        ce qa = ce.qa();
        if (qa.m2131i(uri)) {
            String containerId = qa.getContainerId();
            switch (qa.qb()) {
                case NONE:
                    for (C1472n c1472n : this.atV.keySet()) {
                        if (c1472n.getContainerId().equals(containerId)) {
                            c1472n.ct(null);
                            c1472n.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (C1472n c1472n2 : this.atV.keySet()) {
                        if (c1472n2.getContainerId().equals(containerId)) {
                            c1472n2.ct(qa.qc());
                            c1472n2.refresh();
                        } else if (c1472n2.pl() != null) {
                            c1472n2.ct(null);
                            c1472n2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.atT.mo2511a(this.mContext, this, null, containerId, defaultContainerResourceId, this.asD);
        a.po();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.atT.mo2511a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.asD);
        a.po();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.atT.mo2511a(this.mContext, this, null, containerId, defaultContainerResourceId, this.asD);
        a.pq();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.atT.mo2511a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.asD);
        a.pq();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.atT.mo2511a(this.mContext, this, null, containerId, defaultContainerResourceId, this.asD);
        a.pp();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.atT.mo2511a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.asD);
        a.pp();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
