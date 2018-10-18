package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method apU = null;
    private static final Object ut = new Object();

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    /* renamed from: V */
    private static void m2060V(Context context) throws ClassNotFoundException, NoSuchMethodException {
        apU = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        jx.m1578b((Object) context, (Object) "Context must not be null");
        GooglePlayServicesUtil.m124C(context);
        Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (ut) {
            try {
                if (apU == null) {
                    m2060V(remoteContext);
                }
                apU.invoke(null, new Object[]{remoteContext});
            } catch (Exception e) {
                Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener listener) {
        jx.m1578b((Object) context, (Object) "Context must not be null");
        jx.m1578b((Object) listener, (Object) "Listener must not be null");
        jx.aU("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() {
            /* renamed from: c */
            protected Integer m2058c(Void... voidArr) {
                try {
                    ProviderInstaller.installIfNeeded(context);
                    return Integer.valueOf(0);
                } catch (GooglePlayServicesRepairableException e) {
                    return Integer.valueOf(e.getConnectionStatusCode());
                } catch (GooglePlayServicesNotAvailableException e2) {
                    return Integer.valueOf(e2.errorCode);
                }
            }

            /* renamed from: d */
            protected void m2059d(Integer num) {
                if (num.intValue() == 0) {
                    listener.onProviderInstalled();
                    return;
                }
                listener.onProviderInstallFailed(num.intValue(), GooglePlayServicesUtil.aj(num.intValue()));
            }

            protected /* synthetic */ Object doInBackground(Object[] x0) {
                return m2058c((Void[]) x0);
            }

            protected /* synthetic */ void onPostExecute(Object x0) {
                m2059d((Integer) x0);
            }
        }.execute(new Void[0]);
    }
}
