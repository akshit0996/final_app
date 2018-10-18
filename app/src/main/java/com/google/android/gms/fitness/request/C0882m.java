package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.fitness.request.m */
public class C0882m implements SafeParcelable {
    public static final Creator<C0882m> CREATOR = new C0328n();
    private final int CK;
    private final DataType TM;

    /* renamed from: com.google.android.gms.fitness.request.m$a */
    public static class C0327a {
        private DataType TM;

        /* renamed from: c */
        public C0327a m636c(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public C0882m ka() {
            return new C0882m();
        }
    }

    C0882m(int i, DataType dataType) {
        this.CK = i;
        this.TM = dataType;
    }

    private C0882m(C0327a c0327a) {
        this.CK = 1;
        this.TM = c0327a.TM;
    }

    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.TM;
    }

    int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0328n.m637a(this, parcel, flags);
    }
}
