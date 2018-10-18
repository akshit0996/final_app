package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR = new C0222a();
    public static final AppVisibleCustomProperties Rd = new C0221a().iW();
    final int CK;
    final List<CustomProperty> Re;

    /* renamed from: com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties$a */
    public static class C0221a {
        private final Map<CustomPropertyKey, CustomProperty> Rf = new HashMap();

        /* renamed from: a */
        public C0221a m402a(CustomPropertyKey customPropertyKey, String str) {
            jx.m1578b((Object) customPropertyKey, (Object) "key");
            this.Rf.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public AppVisibleCustomProperties iW() {
            return new AppVisibleCustomProperties(this.Rf.values());
        }
    }

    AppVisibleCustomProperties(int versionCode, Collection<CustomProperty> properties) {
        this.CK = versionCode;
        jx.m1582i(properties);
        this.Re = new ArrayList(properties);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> properties) {
        this(1, (Collection) properties);
    }

    public int describeContents() {
        return 0;
    }

    public Map<CustomPropertyKey, String> iV() {
        Map hashMap = new HashMap(this.Re.size());
        for (CustomProperty customProperty : this.Re) {
            hashMap.put(customProperty.iX(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public Iterator<CustomProperty> iterator() {
        return this.Re.iterator();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0222a.m403a(this, dest, flags);
    }
}
