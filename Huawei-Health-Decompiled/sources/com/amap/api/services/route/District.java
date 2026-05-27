package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new Parcelable.Creator<District>() { // from class: com.amap.api.services.route.District.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ District[] newArray(int i) {
            return null;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ District createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        private static District a(Parcel parcel) {
            return new District(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1507a;
    private String b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistrictName() {
        return this.f1507a;
    }

    public void setDistrictName(String str) {
        this.f1507a = str;
    }

    public String getDistrictAdcode() {
        return this.b;
    }

    public void setDistrictAdcode(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1507a);
        parcel.writeString(this.b);
    }

    public District(Parcel parcel) {
        this.f1507a = parcel.readString();
        this.b = parcel.readString();
    }

    public District() {
    }
}
