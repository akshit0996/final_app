package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.C0151a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0501r.C1076a;
import com.google.android.gms.internal.ii;
import com.google.android.gms.internal.jx;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    private static final ComponentName Ek = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.auth.GetToken");
    private static final ComponentName El = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.recovery.RecoveryService");
    private static final Intent Em = new Intent().setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE).setComponent(Ek);
    private static final Intent En = new Intent().setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE).setComponent(El);
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = (VERSION.SDK_INT >= 14 ? "androidPackageName" : "androidPackageName");
    public static final String KEY_CALLER_UID = (VERSION.SDK_INT >= 11 ? "callerUid" : "callerUid");
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

    private GoogleAuthUtil() {
    }

    /* renamed from: C */
    private static void m94C(Context context) throws GoogleAuthException {
        try {
            GooglePlayServicesUtil.m124C(context);
        } catch (GooglePlayServicesRepairableException e) {
            throw new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        }
    }

    /* renamed from: a */
    private static String m95a(Context context, String str, String str2, Bundle bundle) throws IOException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            return getToken(context, str, str2, bundle);
        } catch (GooglePlayServicesAvailabilityException e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (UserRecoverableAuthException e2) {
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }

    private static boolean ax(String str) {
        return "NetworkError".equals(str) || "ServiceUnavailable".equals(str) || "Timeout".equals(str);
    }

    private static boolean ay(String str) {
        return "BadAuthentication".equals(str) || "CaptchaRequired".equals(str) || "DeviceManagementRequiredOrSyncDisabled".equals(str) || "NeedPermission".equals(str) || "NeedsBrowser".equals(str) || "UserCancel".equals(str) || "AppDownloadRequired".equals(str) || ii.DM_SYNC_DISABLED.fO().equals(str) || ii.DM_ADMIN_BLOCKED.fO().equals(str) || ii.DM_ADMIN_PENDING_APPROVAL.fO().equals(str) || ii.DM_STALE_SYNC_REQUIRED.fO().equals(str) || ii.DM_DEACTIVATED.fO().equals(str) || ii.DM_REQUIRED.fO().equals(str);
    }

    public static void clearToken(Context context, String token) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Context applicationContext = context.getApplicationContext();
        jx.aV("Calling this from your main thread can lead to deadlock");
        m94C(applicationContext);
        Bundle bundle = new Bundle();
        String str = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str);
        }
        ServiceConnection c0151a = new C0151a();
        if (applicationContext.bindService(Em, c0151a, 1)) {
            try {
                bundle = C1076a.m3544a(c0151a.gs()).mo2115a(token, bundle);
                String string = bundle.getString(ii.Fk);
                if (bundle.getBoolean("booleanResult")) {
                    applicationContext.unbindService(c0151a);
                    return;
                }
                throw new GoogleAuthException(string);
            } catch (Throwable e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            } catch (Throwable th) {
                applicationContext.unbindService(c0151a);
            }
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context ctx, int eventIndex, String accountName) throws GoogleAuthException, IOException {
        jx.m1579b(accountName, (Object) "accountName must be provided");
        jx.aV("Calling this from your main thread can lead to deadlock");
        Context applicationContext = ctx.getApplicationContext();
        m94C(applicationContext);
        ServiceConnection c0151a = new C0151a();
        if (applicationContext.bindService(Em, c0151a, 1)) {
            try {
                List<AccountChangeEvent> events = C1076a.m3544a(c0151a.gs()).mo2117a(new AccountChangeEventsRequest().setAccountName(accountName).setEventIndex(eventIndex)).getEvents();
                applicationContext.unbindService(c0151a);
                return events;
            } catch (Throwable e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            } catch (Throwable th) {
                applicationContext.unbindService(c0151a);
            }
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static String getAccountId(Context ctx, String accountName) throws GoogleAuthException, IOException {
        jx.m1579b(accountName, (Object) "accountName must be provided");
        jx.aV("Calling this from your main thread can lead to deadlock");
        m94C(ctx.getApplicationContext());
        return getToken(ctx, accountName, "^^_account_id_^^", new Bundle());
    }

    public static String getAppCert(Context context, String packageNameToCertify) {
        return "spatula";
    }

    public static String getToken(Context context, String accountName, String scope) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, accountName, scope, new Bundle());
    }

    public static String getToken(Context context, String accountName, String scope, Bundle extras) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Context applicationContext = context.getApplicationContext();
        jx.aV("Calling this from your main thread can lead to deadlock");
        m94C(applicationContext);
        extras = extras == null ? new Bundle() : new Bundle(extras);
        String str = context.getApplicationInfo().packageName;
        extras.putString("clientPackageName", str);
        if (!extras.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            extras.putString(KEY_ANDROID_PACKAGE_NAME, str);
        }
        ServiceConnection c0151a = new C0151a();
        if (applicationContext.bindService(Em, c0151a, 1)) {
            try {
                Bundle a = C1076a.m3544a(c0151a.gs()).mo2116a(accountName, scope, extras);
                if (a == null) {
                    Log.w("GoogleAuthUtil", "Binder call returned null.");
                    throw new GoogleAuthException("ServiceUnavailable");
                }
                Object string = a.getString("authtoken");
                if (TextUtils.isEmpty(string)) {
                    String string2 = a.getString("Error");
                    Intent intent = (Intent) a.getParcelable("userRecoveryIntent");
                    if (ay(string2)) {
                        throw new UserRecoverableAuthException(string2, intent);
                    } else if (ax(string2)) {
                        throw new IOException(string2);
                    } else {
                        throw new GoogleAuthException(string2);
                    }
                }
                applicationContext.unbindService(c0151a);
                return string;
            } catch (Throwable e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            } catch (Throwable th) {
                applicationContext.unbindService(c0151a);
            }
        } else {
            throw new IOException("Could not bind to service with the given context.");
        }
    }

    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putBoolean("handle_notification", true);
        return m95a(context, accountName, scope, extras);
    }

    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras, Intent callback) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        m96h(callback);
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putParcelable("callback_intent", callback);
        extras.putBoolean("handle_notification", true);
        return m95a(context, accountName, scope, extras);
    }

    public static String getTokenWithNotification(Context context, String accountName, String scope, Bundle extras, String authority, Bundle syncBundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalArgumentException("Authority cannot be empty or null.");
        }
        if (extras == null) {
            extras = new Bundle();
        }
        if (syncBundle == null) {
            syncBundle = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(syncBundle);
        extras.putString("authority", authority);
        extras.putBundle("sync_extras", syncBundle);
        extras.putBoolean("handle_notification", true);
        return m95a(context, accountName, scope, extras);
    }

    /* renamed from: h */
    private static void m96h(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    @Deprecated
    public static void invalidateToken(Context context, String token) {
        AccountManager.get(context).invalidateAuthToken(GOOGLE_ACCOUNT_TYPE, token);
    }
}
