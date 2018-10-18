package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.C1324b;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.f */
public interface C0234f<F> {
    /* renamed from: b */
    <T> F mo1061b(C1324b<T> c1324b, T t);

    /* renamed from: b */
    <T> F mo1062b(Operator operator, MetadataField<T> metadataField, T t);

    /* renamed from: b */
    F mo1063b(Operator operator, List<F> list);

    /* renamed from: d */
    F mo1064d(MetadataField<?> metadataField);

    /* renamed from: d */
    <T> F mo1065d(MetadataField<T> metadataField, T t);

    /* renamed from: j */
    F mo1066j(F f);

    F jd();
}
