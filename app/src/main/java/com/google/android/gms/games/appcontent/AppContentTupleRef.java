package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;

public final class AppContentTupleRef extends C0174d implements AppContentTuple {
    AppContentTupleRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentTupleEntity.m4040a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return ld();
    }

    public String getName() {
        return getString("tuple_name");
    }

    public String getValue() {
        return getString("tuple_value");
    }

    public int hashCode() {
        return AppContentTupleEntity.m4039a(this);
    }

    public AppContentTuple ld() {
        return new AppContentTupleEntity(this);
    }

    public String toString() {
        return AppContentTupleEntity.m4041b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentTupleEntity) ld()).writeToParcel(dest, flags);
    }
}
