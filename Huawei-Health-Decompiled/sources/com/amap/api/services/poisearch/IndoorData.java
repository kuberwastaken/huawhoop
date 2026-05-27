package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new Parcelable.Creator<IndoorData>() { // from class: com.amap.api.services.poisearch.IndoorData.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData[] newArray(int i) {
            return a(i);
        }

        private static IndoorData a(Parcel parcel) {
            return new IndoorData(parcel);
        }

        private static IndoorData[] a(int i) {
            return new IndoorData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1477a;
    private int b;
    private String c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IndoorData(String str, int i, String str2) {
        this.f1477a = str;
        this.b = i;
        this.c = str2;
    }

    public String getPoiId() {
        return this.f1477a;
    }

    public void setPoiId(String str) {
        this.f1477a = str;
    }

    public int getFloor() {
        return this.b;
    }

    public void setFloor(int i) {
        this.b = i;
    }

    public String getFloorName() {
        return this.c;
    }

    public void setFloorName(String str) {
        this.c = str;
    }

    protected IndoorData(Parcel parcel) {
        this.f1477a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1477a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
    }
}
