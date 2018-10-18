package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends C1307g<AppContentSection> {
    private final ArrayList<DataHolder> XX;

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4810h(i, i2);
    }

    /* renamed from: h */
    protected AppContentSection m4810h(int i, int i2) {
        return new AppContentSectionRef(this.XX, i, i2);
    }

    protected String ha() {
        return "section_id";
    }

    protected String hc() {
        return "card_id";
    }

    public void release() {
        super.release();
        int size = this.XX.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = (DataHolder) this.XX.get(i);
            if (dataHolder != null) {
                dataHolder.close();
            }
        }
    }
}
