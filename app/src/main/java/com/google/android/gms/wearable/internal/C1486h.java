package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* renamed from: com.google.android.gms.wearable.internal.h */
public final class C1486h extends C0174d implements DataEvent {
    private final int Ya;

    public C1486h(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.Ya = i2;
    }

    public /* synthetic */ Object freeze() {
        return rn();
    }

    public DataItem getDataItem() {
        return new C1491o(this.JG, this.KZ, this.Ya);
    }

    public int getType() {
        return getInteger("event_type");
    }

    public DataEvent rn() {
        return new C1485g(this);
    }
}
