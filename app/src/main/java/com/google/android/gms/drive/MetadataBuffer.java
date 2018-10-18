package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.C1313m;
import com.google.android.gms.drive.metadata.C1324b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0224e;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.ln;

public final class MetadataBuffer extends DataBuffer<Metadata> {
    private final String OB;
    private C1310a OC;

    /* renamed from: com.google.android.gms.drive.MetadataBuffer$a */
    private static class C1310a extends Metadata {
        private final DataHolder JG;
        private final int La;
        private final int OD;

        public C1310a(DataHolder dataHolder, int i) {
            this.JG = dataHolder;
            this.OD = i;
            this.La = dataHolder.au(i);
        }

        /* renamed from: a */
        protected <T> T mo2961a(MetadataField<T> metadataField) {
            return metadataField.mo1056a(this.JG, this.OD, this.La);
        }

        public /* synthetic */ Object freeze() {
            return iy();
        }

        public boolean isDataValid() {
            return !this.JG.isClosed();
        }

        public Metadata iy() {
            MetadataBundle iZ = MetadataBundle.iZ();
            for (MetadataField metadataField : C0224e.iY()) {
                if (!((metadataField instanceof C1324b) || metadataField == ln.RI)) {
                    metadataField.mo1057a(this.JG, iZ, this.OD, this.La);
                }
            }
            return new C1313m(iZ);
        }
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.OB = nextPageToken;
        dataHolder.gV().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        C1310a c1310a = this.OC;
        if (c1310a != null && c1310a.OD == row) {
            return c1310a;
        }
        Metadata c1310a2 = new C1310a(this.JG, row);
        this.OC = c1310a2;
        return c1310a2;
    }

    public String getNextPageToken() {
        return this.OB;
    }
}
