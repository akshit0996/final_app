package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1324b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.google.android.gms.drive.metadata.internal.k */
public class C1507k extends C1324b<String> {
    public C1507k(String str, int i) {
        super(str, Collections.singleton(str), Collections.emptySet(), i);
    }

    public static final Collection<String> bn(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    /* renamed from: a */
    protected void m4785a(Bundle bundle, Collection<String> collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return mo3683d(dataHolder, i, i2);
    }

    /* renamed from: d */
    protected Collection<String> mo3683d(DataHolder dataHolder, int i, int i2) {
        try {
            return C1507k.bn(dataHolder.m2493c(getName(), i, i2));
        } catch (Throwable e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    /* renamed from: i */
    protected /* synthetic */ Object mo2985i(Bundle bundle) {
        return m4789n(bundle);
    }

    /* renamed from: n */
    protected Collection<String> m4789n(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}
