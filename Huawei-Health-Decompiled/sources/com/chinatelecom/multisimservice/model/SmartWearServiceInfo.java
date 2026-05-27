package com.chinatelecom.multisimservice.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes9.dex */
public class SmartWearServiceInfo implements Parcelable {
    public static final Parcelable.Creator<SmartWearServiceInfo> CREATOR = new Parcelable.Creator<SmartWearServiceInfo>() { // from class: com.chinatelecom.multisimservice.model.SmartWearServiceInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cC_, reason: merged with bridge method [inline-methods] */
        public SmartWearServiceInfo createFromParcel(Parcel parcel) {
            return new SmartWearServiceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public SmartWearServiceInfo[] newArray(int i) {
            return new SmartWearServiceInfo[i];
        }
    };
    private String packageName;
    private String versionCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SmartWearServiceInfo(String str, String str2) {
        this.packageName = str;
        this.versionCode = str2;
    }

    protected SmartWearServiceInfo(Parcel parcel) {
        this.packageName = parcel.readString();
        this.versionCode = parcel.readString();
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getVersionName() {
        return this.versionCode;
    }

    public void setVersionName(String str) {
        this.versionCode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeString(this.versionCode);
    }
}
