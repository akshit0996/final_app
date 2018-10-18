package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.bg.C0379a;
import com.google.android.gms.internal.jx;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = bg.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final bg lg;

    public static final class Builder {
        private final C0379a lh = new C0379a();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.lh.m1068b(adapterClass, customEventExtras);
            return this;
        }

        public Builder addKeyword(String keyword) {
            this.lh.m1072r(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.lh.m1065a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.lh.m1066a(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.lh.m1073s(deviceId);
            return this;
        }

        public AdRequest build() {
            return new AdRequest();
        }

        public Builder setBirthday(Date birthday) {
            this.lh.m1067a(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            jx.m1578b((Object) contentUrl, (Object) "Content URL must be non-null.");
            jx.m1579b(contentUrl, (Object) "Content URL must be non-empty.");
            jx.m1581b(contentUrl.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(contentUrl.length()));
            this.lh.m1074t(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.lh.m1069h(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.lh.m1064a(location);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.lh.m1071j(tagForChildDirectedTreatment);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.lg = new bg(builder.lh);
    }

    /* renamed from: Y */
    bg m9Y() {
        return this.lg;
    }

    public Date getBirthday() {
        return this.lg.getBirthday();
    }

    public String getContentUrl() {
        return this.lg.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.lg.getCustomEventExtrasBundle(adapterClass);
    }

    public int getGender() {
        return this.lg.getGender();
    }

    public Set<String> getKeywords() {
        return this.lg.getKeywords();
    }

    public Location getLocation() {
        return this.lg.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.lg.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.lg.getNetworkExtrasBundle(adapterClass);
    }

    public boolean isTestDevice(Context context) {
        return this.lg.isTestDevice(context);
    }
}
