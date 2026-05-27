package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() { // from class: com.amap.api.maps.offlinemap.Province.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province[] newArray(int i) {
            return a(i);
        }

        private static Province a(Parcel parcel) {
            return new Province(parcel);
        }

        private static Province[] a(int i) {
            return new Province[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1415a;
    private String b;
    private String c;
    private String d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Province() {
        this.f1415a = "";
        this.d = "";
    }

    public String getProvinceName() {
        return this.f1415a;
    }

    public String getJianpin() {
        return this.b;
    }

    public String getPinyin() {
        return this.c;
    }

    public void setProvinceName(String str) {
        this.f1415a = str;
    }

    public void setJianpin(String str) {
        this.b = str;
    }

    public void setPinyin(String str) {
        this.c = str;
    }

    public void setProvinceCode(String str) {
        this.d = str;
    }

    public String getProvinceCode() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1415a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public Province(Parcel parcel) {
        this.f1415a = "";
        this.d = "";
        this.f1415a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
