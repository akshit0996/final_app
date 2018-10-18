package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
    AppContentAnnotationRef(ArrayList<DataHolder> dataHolders, int dataRow) {
        super(dataHolders, 2, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentAnnotationEntity.m4028a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return kM();
    }

    public String getDescription() {
        return getString("annotation_description");
    }

    public String getTitle() {
        return getString("annotation_title");
    }

    public String getType() {
        return getString("annotation_type");
    }

    public int hashCode() {
        return AppContentAnnotationEntity.m4027a(this);
    }

    public Uri kL() {
        return aR("annotation_image_uri");
    }

    public AppContentAnnotation kM() {
        return new AppContentAnnotationEntity(this);
    }

    public String toString() {
        return AppContentAnnotationEntity.m4029b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentAnnotationEntity) kM()).writeToParcel(dest, flags);
    }
}
