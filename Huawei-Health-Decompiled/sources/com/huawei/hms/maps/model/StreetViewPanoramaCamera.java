package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.operation.utils.Constants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class StreetViewPanoramaCamera implements Parcelable {
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new Parcelable.Creator<StreetViewPanoramaCamera>() { // from class: com.huawei.hms.maps.model.StreetViewPanoramaCamera.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StreetViewPanoramaCamera[] newArray(int i) {
            return new StreetViewPanoramaCamera[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
            return new StreetViewPanoramaCamera(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreetViewPanoramaOrientation f5198a;
    public final float bearing;
    public final float tilt;
    public final float zoom;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int iBeginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeFloat(2, this.bearing);
        parcelWrite.writeFloat(3, this.tilt);
        parcelWrite.writeFloat(4, this.bearing);
        parcelWrite.finishObjectHeader(iBeginObjectHeader);
    }

    public String toString() {
        float f = this.zoom;
        float f2 = this.tilt;
        float f3 = this.bearing;
        StringBuilder sb = new StringBuilder(100);
        sb.append("zoom/tilt/bearing: (");
        sb.append(Float.valueOf(f));
        sb.append(",");
        sb.append(Float.valueOf(f2));
        sb.append(",");
        sb.append(Float.valueOf(f3));
        sb.append(Constants.RIGHT_BRACKET_ONLY);
        return sb.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)});
    }

    public static class Builder {
        public float bearing;
        public float tilt;
        public float zoom;

        public Builder zoom(float f) {
            this.zoom = f;
            return this;
        }

        public Builder tilt(float f) {
            this.tilt = f;
            return this;
        }

        public Builder orientation(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            this.bearing = streetViewPanoramaOrientation.bearing;
            this.tilt = streetViewPanoramaOrientation.tilt;
            return this;
        }

        public StreetViewPanoramaCamera build() {
            return new StreetViewPanoramaCamera(this.bearing, this.tilt, this.zoom);
        }

        public Builder bearing(float f) {
            this.bearing = f;
            return this;
        }

        public Builder(StreetViewPanoramaCamera streetViewPanoramaCamera) {
            this.bearing = streetViewPanoramaCamera.bearing;
            this.tilt = streetViewPanoramaCamera.tilt;
            this.zoom = streetViewPanoramaCamera.zoom;
        }

        public Builder() {
        }
    }

    public StreetViewPanoramaOrientation getOrientation() {
        return this.f5198a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.zoom) == Float.floatToIntBits(streetViewPanoramaCamera.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaCamera.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaCamera.bearing);
    }

    public static Builder builder(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        return new Builder(streetViewPanoramaCamera);
    }

    public static Builder builder() {
        return new Builder();
    }

    protected StreetViewPanoramaCamera(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        float f = parcelReader.readFloat(2, 0.0f);
        this.bearing = f;
        float f2 = parcelReader.readFloat(3, 0.0f);
        this.tilt = f2;
        this.zoom = parcelReader.readFloat(4, 0.0f);
        this.f5198a = new StreetViewPanoramaOrientation(f2, f);
    }

    public StreetViewPanoramaCamera(float f, float f2, float f3) {
        this.zoom = f;
        this.tilt = f2;
        this.bearing = f3;
        this.f5198a = new StreetViewPanoramaOrientation(f2, f3);
    }
}
