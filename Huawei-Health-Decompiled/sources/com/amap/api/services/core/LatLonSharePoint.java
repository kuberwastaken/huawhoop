package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes9.dex */
public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() { // from class: com.amap.api.services.core.LatLonSharePoint.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint[] newArray(int i) {
            return a(i);
        }

        private static LatLonSharePoint a(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        private static LatLonSharePoint[] a(int i) {
            return new LatLonSharePoint[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1445a;

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonSharePoint(double d, double d2, String str) {
        super(d, d2);
        this.f1445a = str;
    }

    public String getSharePointName() {
        return this.f1445a;
    }

    public void setSharePointName(String str) {
        this.f1445a = str;
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f1445a = parcel.readString();
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f1445a);
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int iHashCode = super.hashCode();
        String str = this.f1445a;
        return (iHashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        String str = this.f1445a;
        if (str == null) {
            if (latLonSharePoint.f1445a != null) {
                return false;
            }
        } else if (!str.equals(latLonSharePoint.f1445a)) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + "," + this.f1445a;
    }
}
