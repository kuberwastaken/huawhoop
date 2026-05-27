package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() { // from class: com.amap.api.services.route.RailwaySpace.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace[] newArray(int i) {
            return a(i);
        }

        private static RailwaySpace a(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        private static RailwaySpace[] a(int i) {
            return new RailwaySpace[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1523a;
    private float b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RailwaySpace(String str, float f) {
        this.f1523a = str;
        this.b = f;
    }

    public String getCode() {
        return this.f1523a;
    }

    public float getCost() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1523a);
        parcel.writeFloat(this.b);
    }

    protected RailwaySpace(Parcel parcel) {
        this.f1523a = parcel.readString();
        this.b = parcel.readFloat();
    }
}
