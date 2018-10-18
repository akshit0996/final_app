package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.wearable.internal.o */
public final class C1491o extends C0174d implements DataItem {
    private final int Ya;

    public C1491o(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.Ya = i2;
    }

    public /* synthetic */ Object freeze() {
        return rp();
    }

    public Map<String, DataItemAsset> getAssets() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            C1488k c1488k = new C1488k(this.JG, this.KZ + i);
            if (c1488k.getDataItemKey() != null) {
                hashMap.put(c1488k.getDataItemKey(), c1488k);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public DataItem rp() {
        return new C1489l(this);
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }
}
