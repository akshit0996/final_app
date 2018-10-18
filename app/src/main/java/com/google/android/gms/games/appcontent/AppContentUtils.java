package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.la;
import java.util.ArrayList;

public final class AppContentUtils {

    private interface AppContentRunner {
        /* renamed from: b */
        void mo1169b(ArrayList<DataHolder> arrayList, int i);
    }

    /* renamed from: a */
    public static ArrayList<AppContentAction> m673a(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        final ArrayList<AppContentAction> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        m674a(dataHolder2, 1, str2, "action_id", i, new AppContentRunner() {
            /* renamed from: b */
            public void mo1169b(ArrayList<DataHolder> arrayList, int i) {
                arrayList2.add(new AppContentActionRef(arrayList, i));
            }
        }, arrayList);
        return arrayList2;
    }

    /* renamed from: a */
    private static void m674a(DataHolder dataHolder, int i, String str, String str2, int i2, AppContentRunner appContentRunner, ArrayList<DataHolder> arrayList) {
        DataHolder dataHolder2 = (DataHolder) arrayList.get(i);
        Object c = dataHolder.m2493c(str, i2, dataHolder.au(i2));
        if (!TextUtils.isEmpty(c)) {
            int count = dataHolder2.getCount();
            String[] split = c.split(",");
            for (int i3 = 0; i3 < count; i3++) {
                CharSequence c2 = dataHolder2.m2493c(str2, i3, dataHolder2.au(i3));
                if (!TextUtils.isEmpty(c2) && la.m1633b(split, c2)) {
                    appContentRunner.mo1169b(arrayList, i3);
                }
            }
        }
    }

    /* renamed from: b */
    public static ArrayList<AppContentAnnotation> m675b(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        final ArrayList<AppContentAnnotation> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        m674a(dataHolder2, 2, str2, "annotation_id", i, new AppContentRunner() {
            /* renamed from: b */
            public void mo1169b(ArrayList<DataHolder> arrayList, int i) {
                arrayList2.add(new AppContentAnnotationRef(arrayList, i));
            }
        }, arrayList);
        return arrayList2;
    }

    /* renamed from: c */
    public static ArrayList<AppContentCondition> m676c(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        final ArrayList<AppContentCondition> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        m674a(dataHolder2, 4, str2, "condition_id", i, new AppContentRunner() {
            /* renamed from: b */
            public void mo1169b(ArrayList<DataHolder> arrayList, int i) {
                arrayList2.add(new AppContentConditionRef(arrayList, i));
            }
        }, arrayList);
        return arrayList2;
    }

    /* renamed from: d */
    public static Bundle m677d(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        final Bundle bundle = new Bundle();
        final DataHolder dataHolder2 = (DataHolder) arrayList.get(3);
        AppContentRunner c08934 = new AppContentRunner() {
            /* renamed from: b */
            public void mo1169b(ArrayList<DataHolder> arrayList, int i) {
                AppContentTuple appContentTupleRef = new AppContentTupleRef(dataHolder2, i);
                bundle.putString(appContentTupleRef.getName(), appContentTupleRef.getValue());
            }
        };
        m674a(dataHolder, 3, str, "tuple_id", i, c08934, arrayList);
        return bundle;
    }
}
