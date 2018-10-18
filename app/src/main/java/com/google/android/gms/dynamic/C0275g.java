package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.dynamic.g */
public abstract class C0275g<T> {
    private final String TI;
    private T TJ;

    /* renamed from: com.google.android.gms.dynamic.g$a */
    public static class C0274a extends Exception {
        public C0274a(String str) {
            super(str);
        }

        public C0274a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0275g(String str) {
        this.TI = str;
    }

    /* renamed from: L */
    protected final T m513L(Context context) throws C0274a {
        if (this.TJ == null) {
            jx.m1582i(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0274a("Could not get remote context.");
            }
            try {
                this.TJ = mo1672d((IBinder) remoteContext.getClassLoader().loadClass(this.TI).newInstance());
            } catch (Throwable e) {
                throw new C0274a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new C0274a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new C0274a("Could not access creator.", e22);
            }
        }
        return this.TJ;
    }

    /* renamed from: d */
    protected abstract T mo1672d(IBinder iBinder);
}
