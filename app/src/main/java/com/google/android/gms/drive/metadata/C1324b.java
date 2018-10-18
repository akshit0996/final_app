package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.b */
public abstract class C1324b<T> extends C0834a<Collection<T>> {
    protected C1324b(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return mo3683d(dataHolder, i, i2);
    }

    /* renamed from: d */
    protected Collection<T> mo3683d(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
