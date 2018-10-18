package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.C1324b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.C0234f;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.c */
public class C0835c implements C0234f<String> {
    /* renamed from: a */
    public <T> String m2587a(C1324b<T> c1324b, T t) {
        return String.format("contains(%s,%s)", new Object[]{c1324b.getName(), t});
    }

    /* renamed from: a */
    public <T> String m2588a(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", new Object[]{operator.getTag(), metadataField.getName(), t});
    }

    /* renamed from: a */
    public String m2589a(Operator operator, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder(operator.getTag() + "(");
        String str = "";
        for (String str2 : list) {
            stringBuilder.append(str);
            stringBuilder.append(str2);
            str = ",";
        }
        return stringBuilder.append(")").toString();
    }

    /* renamed from: b */
    public /* synthetic */ Object mo1061b(C1324b c1324b, Object obj) {
        return m2587a(c1324b, obj);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo1062b(Operator operator, MetadataField metadataField, Object obj) {
        return m2588a(operator, metadataField, obj);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo1063b(Operator operator, List list) {
        return m2589a(operator, list);
    }

    public String bq(String str) {
        return String.format("not(%s)", new Object[]{str});
    }

    /* renamed from: c */
    public String m2593c(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", new Object[]{metadataField.getName()});
    }

    /* renamed from: c */
    public <T> String m2594c(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", new Object[]{metadataField.getName(), t});
    }

    /* renamed from: d */
    public /* synthetic */ Object mo1064d(MetadataField metadataField) {
        return m2593c(metadataField);
    }

    /* renamed from: d */
    public /* synthetic */ Object mo1065d(MetadataField metadataField, Object obj) {
        return m2594c(metadataField, obj);
    }

    /* renamed from: j */
    public /* synthetic */ Object mo1066j(Object obj) {
        return bq((String) obj);
    }

    public String jc() {
        return "all()";
    }

    public /* synthetic */ Object jd() {
        return jc();
    }
}
