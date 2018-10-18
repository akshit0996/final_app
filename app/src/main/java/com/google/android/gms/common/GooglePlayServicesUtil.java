package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.C0099R;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.jf;
import com.google.android.gms.internal.jh;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lc;
import com.google.android.gms.internal.ll;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 6587000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean Jg = false;
    public static boolean Jh = false;
    private static int Ji = -1;
    private static final Object Jj = new Object();

    /* renamed from: com.google.android.gms.common.GooglePlayServicesUtil$a */
    private static class C0150a extends Handler {
        private final Context mO;

        C0150a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.mO = context.getApplicationContext();
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mO);
                    if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                        GooglePlayServicesUtil.m129a(isGooglePlayServicesAvailable, this.mO);
                        return;
                    }
                    return;
                default:
                    Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + msg.what);
                    return;
            }
        }
    }

    private GooglePlayServicesUtil() {
    }

    /* renamed from: C */
    public static void m124C(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent aj = aj(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (aj == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", aj);
        }
    }

    /* renamed from: D */
    private static void m125D(Context context) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable e) {
            Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.version");
            if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 6587000 but found " + i + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
            return;
        }
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }

    /* renamed from: E */
    private static void m126E(Context context) {
        Handler c0150a = new C0150a(context);
        c0150a.sendMessageDelayed(c0150a.obtainMessage(1), 120000);
    }

    /* renamed from: F */
    private static String m127F(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    /* renamed from: a */
    private static Dialog m128a(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Builder builder;
        Intent aj;
        OnClickListener jhVar;
        CharSequence c;
        if (lc.m1636K(activity) && i == 2) {
            i = 42;
        }
        if (ll.ij()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(activity, 5);
                if (builder == null) {
                    builder = new Builder(activity);
                }
                builder.setMessage(m134b((Context) activity, i));
                if (onCancelListener != null) {
                    builder.setOnCancelListener(onCancelListener);
                }
                aj = aj(i);
                jhVar = fragment != null ? new jh(activity, aj, i2) : new jh(fragment, aj, i2);
                c = m139c(activity, i);
                if (c != null) {
                    builder.setPositiveButton(c, jhVar);
                }
                switch (i) {
                    case 0:
                        return null;
                    case 1:
                        return builder.setTitle(C0099R.string.common_google_play_services_install_title).create();
                    case 2:
                        return builder.setTitle(C0099R.string.common_google_play_services_update_title).create();
                    case 3:
                        return builder.setTitle(C0099R.string.common_google_play_services_enable_title).create();
                    case 4:
                    case 6:
                        return builder.create();
                    case 5:
                        Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                        return builder.setTitle(C0099R.string.common_google_play_services_invalid_account_title).create();
                    case 7:
                        Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                        return builder.setTitle(C0099R.string.common_google_play_services_network_error_title).create();
                    case 8:
                        Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
                        return builder.create();
                    case 9:
                        Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                        return builder.setTitle(C0099R.string.common_google_play_services_unsupported_title).create();
                    case 10:
                        Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
                        return builder.create();
                    case 11:
                        Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
                        return builder.create();
                    case 42:
                        return builder.setTitle(C0099R.string.common_android_wear_update_title).create();
                    default:
                        Log.e("GooglePlayServicesUtil", "Unexpected error code " + i);
                        return builder.create();
                }
            }
        }
        builder = null;
        if (builder == null) {
            builder = new Builder(activity);
        }
        builder.setMessage(m134b((Context) activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        aj = aj(i);
        if (fragment != null) {
        }
        c = m139c(activity, i);
        if (c != null) {
            builder.setPositiveButton(c, jhVar);
        }
        switch (i) {
            case 0:
                return null;
            case 1:
                return builder.setTitle(C0099R.string.common_google_play_services_install_title).create();
            case 2:
                return builder.setTitle(C0099R.string.common_google_play_services_update_title).create();
            case 3:
                return builder.setTitle(C0099R.string.common_google_play_services_enable_title).create();
            case 4:
            case 6:
                return builder.create();
            case 5:
                Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                return builder.setTitle(C0099R.string.common_google_play_services_invalid_account_title).create();
            case 7:
                Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                return builder.setTitle(C0099R.string.common_google_play_services_network_error_title).create();
            case 8:
                Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
                return builder.create();
            case 9:
                Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                return builder.setTitle(C0099R.string.common_google_play_services_unsupported_title).create();
            case 10:
                Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
                return builder.create();
            case 11:
                Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
                return builder.create();
            case 42:
                return builder.setTitle(C0099R.string.common_android_wear_update_title).create();
            default:
                Log.e("GooglePlayServicesUtil", "Unexpected error code " + i);
                return builder.create();
        }
    }

    /* renamed from: a */
    private static void m129a(int i, Context context) {
        Notification build;
        Resources resources = context.getResources();
        CharSequence d = m141d(context, i);
        CharSequence string = resources.getString(C0099R.string.common_google_play_services_error_notification_requested_by_msg, new Object[]{m127F(context)});
        PendingIntent errorPendingIntent = getErrorPendingIntent(i, context, 0);
        if (lc.m1636K(context)) {
            jx.m1574K(ll.ik());
            build = new Notification.Builder(context).setSmallIcon(C0099R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(d + " " + string)).addAction(C0099R.drawable.common_full_open_on_phone, resources.getString(C0099R.string.common_open_on_phone), errorPendingIntent).build();
        } else {
            Notification notification = new Notification(17301642, resources.getString(C0099R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
            notification.flags |= 16;
            notification.setLatestEventInfo(context, d, string, errorPendingIntent);
            build = notification;
        }
        ((NotificationManager) context.getSystemService("notification")).notify(ak(i), build);
    }

    /* renamed from: a */
    public static boolean m130a(PackageManager packageManager, PackageInfo packageInfo) {
        boolean z = true;
        boolean z2 = false;
        if (packageInfo == null) {
            return false;
        }
        if (m140c(packageManager)) {
            if (m132a(packageInfo, true) == null) {
                z = false;
            }
            return z;
        }
        if (m132a(packageInfo, false) != null) {
            z2 = true;
        }
        if (z2 || m132a(packageInfo, true) == null) {
            return z2;
        }
        Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
        return z2;
    }

    /* renamed from: a */
    public static boolean m131a(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (ll.ig() && ((resources.getConfiguration().screenLayout & 15) > 3)) || m138b(resources);
    }

    /* renamed from: a */
    private static byte[] m132a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        }
        Object toByteArray = packageInfo.signatures[0].toByteArray();
        if ((z ? C0169b.gu() : C0169b.gv()).contains(toByteArray)) {
            return toByteArray;
        }
        if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
            Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(toByteArray, 0));
        }
        return null;
    }

    /* renamed from: a */
    private static byte[] m133a(PackageInfo packageInfo, byte[]... bArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        }
        byte[] toByteArray = packageInfo.signatures[0].toByteArray();
        for (byte[] bArr2 : bArr) {
            if (Arrays.equals(bArr2, toByteArray)) {
                return bArr2;
            }
        }
        if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
            Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(toByteArray, 0));
        }
        return null;
    }

    public static Intent aj(int i) {
        switch (i) {
            case 1:
            case 2:
                return jo.ba(GOOGLE_PLAY_SERVICES_PACKAGE);
            case 3:
                return jo.aY(GOOGLE_PLAY_SERVICES_PACKAGE);
            case 42:
                return jo.hE();
            default:
                return null;
        }
    }

    private static int ak(int i) {
        switch (i) {
            case 1:
            case 3:
                return 10436;
            default:
                return 39789;
        }
    }

    /* renamed from: b */
    public static String m134b(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return m131a(context.getResources()) ? resources.getString(C0099R.string.common_google_play_services_install_text_tablet) : resources.getString(C0099R.string.common_google_play_services_install_text_phone);
            case 2:
                return resources.getString(C0099R.string.common_google_play_services_update_text);
            case 3:
                return resources.getString(C0099R.string.common_google_play_services_enable_text);
            case 5:
                return resources.getString(C0099R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(C0099R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(C0099R.string.common_google_play_services_unsupported_text);
            case 42:
                return resources.getString(C0099R.string.common_android_wear_update_text);
            default:
                return resources.getString(C0099R.string.common_google_play_services_unknown_issue);
        }
    }

    /* renamed from: b */
    public static boolean m136b(PackageManager packageManager) {
        synchronized (Jj) {
            if (Ji == -1) {
                try {
                    if (m133a(packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64), C0169b.Jc[1]) != null) {
                        Ji = 1;
                    } else {
                        Ji = 0;
                    }
                } catch (NameNotFoundException e) {
                    Ji = 0;
                }
            }
        }
        return Ji != 0;
    }

    /* renamed from: b */
    public static boolean m137b(PackageManager packageManager, String str) {
        try {
            return m130a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (NameNotFoundException e) {
            if (Log.isLoggable("GooglePlayServicesUtil", 3)) {
                Log.d("GooglePlayServicesUtil", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m138b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return ll.ii() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }

    /* renamed from: c */
    public static String m139c(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0099R.string.common_google_play_services_install_button);
            case 2:
            case 42:
                return resources.getString(C0099R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(C0099R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    /* renamed from: c */
    public static boolean m140c(PackageManager packageManager) {
        return m136b(packageManager) || !gw();
    }

    /* renamed from: d */
    public static String m141d(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0099R.string.f8x8f024ee1);
            case 2:
                return resources.getString(C0099R.string.common_google_play_services_notification_needs_update_title);
            case 3:
                return resources.getString(C0099R.string.common_google_play_services_needs_enabling_title);
            case 5:
                return resources.getString(C0099R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(C0099R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(C0099R.string.common_google_play_services_unsupported_text);
            case 42:
                return resources.getString(C0099R.string.common_android_wear_notification_needs_update_text);
            default:
                return resources.getString(C0099R.string.common_google_play_services_unknown_issue);
        }
    }

    /* renamed from: e */
    public static boolean m142e(Context context, int i) {
        if (i == 1) {
            try {
                if (context.getPackageManager().getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 8192).enabled) {
                    return true;
                }
            } catch (NameNotFoundException e) {
            }
        }
        return false;
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode) {
        return getErrorDialog(errorCode, activity, requestCode, null);
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return m128a(errorCode, activity, null, requestCode, cancelListener);
    }

    public static PendingIntent getErrorPendingIntent(int errorCode, Context context, int requestCode) {
        Intent aj = aj(errorCode);
        return aj == null ? null : PendingIntent.getActivity(context, requestCode, aj, DriveFile.MODE_READ_ONLY);
    }

    public static String getErrorString(int errorCode) {
        switch (errorCode) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                return "UNKNOWN_ERROR_CODE";
        }
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Uri.Builder().scheme("android.resource").authority(GOOGLE_PLAY_SERVICES_PACKAGE).appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean gw() {
        return Jg ? Jh : "user".equals(Build.TYPE);
    }

    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (!jf.Mv) {
            try {
                context.getResources().getString(C0099R.string.common_google_play_services_unknown_issue);
            } catch (Throwable th) {
                Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
            }
        }
        if (!jf.Mv) {
            m125D(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            if (lc.aU(packageInfo.versionCode)) {
                int i = gw() ? 0 : 1;
                if (m133a(packageInfo, C0169b.Ix[i], C0169b.IE[i], C0169b.IC[i]) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Services signature invalid on Glass.");
                    return 9;
                }
                String packageName = context.getPackageName();
                try {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(packageName, 64);
                    if (!m130a(packageManager, packageInfo2)) {
                        Log.w("GooglePlayServicesUtil", "Calling package " + packageInfo2.packageName + " signature invalid on Glass.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Could not get info for calling package: " + packageName);
                    return 9;
                }
            } else if (!lc.m1636K(context)) {
                try {
                    if (m133a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), C0169b.Ix) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (m133a(packageInfo, m133a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), C0169b.Ix)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e2) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                    return 9;
                }
            } else if (m133a(packageInfo, C0169b.Ix) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (lc.aS(packageInfo.versionCode) < lc.aS(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 6587000 but found " + packageInfo.versionCode);
                return 2;
            }
            try {
                return !packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0).enabled ? 3 : 0;
            } catch (NameNotFoundException e3) {
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                e3.printStackTrace();
                return 1;
            }
        } catch (NameNotFoundException e4) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    public static boolean isGoogleSignedUid(PackageManager packageManager, int uid) {
        if (packageManager == null) {
            throw new SecurityException("Unknown error: invalid Package Manager");
        }
        String[] packagesForUid = packageManager.getPackagesForUid(uid);
        if (packagesForUid.length != 0 && m137b(packageManager, packagesForUid[0])) {
            return true;
        }
        throw new SecurityException("Uid is not Google Signed");
    }

    public static boolean isUserRecoverableError(int errorCode) {
        switch (errorCode) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode) {
        return showErrorDialogFragment(errorCode, activity, requestCode, null);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return showErrorDialogFragment(errorCode, activity, null, requestCode, cancelListener);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, Fragment fragment, int requestCode, OnCancelListener cancelListener) {
        boolean z = false;
        Dialog a = m128a(errorCode, activity, fragment, requestCode, cancelListener);
        if (a == null) {
            return z;
        }
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(a, cancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), GMS_ERROR_DIALOG);
        } else if (ll.ig()) {
            ErrorDialogFragment.newInstance(a, cancelListener).show(activity.getFragmentManager(), GMS_ERROR_DIALOG);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    public static void showErrorNotification(int errorCode, Context context) {
        if (lc.m1636K(context) && errorCode == 2) {
            errorCode = 42;
        }
        if (m142e(context, errorCode)) {
            m126E(context);
        } else {
            m129a(errorCode, context);
        }
    }
}
