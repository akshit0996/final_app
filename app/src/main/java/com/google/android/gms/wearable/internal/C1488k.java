package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;

/* renamed from: com.google.android.gms.wearable.internal.k */
public class C1488k extends C0174d implements DataItemAsset {
    public C1488k(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return ro();
    }

    public String getDataItemKey() {
        return getString("asset_key");
    }

    public String getId() {
        return getString("asset_id");
    }

    public DataItemAsset ro() {
        return new C1487i(this);
    }
}
