package com.huawei.health.devicemgr.business.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes10.dex */
public class DictionaryCommonInfo implements Parcelable {
    public static final Parcelable.Creator<DictionaryCommonInfo> CREATOR = new Parcelable.Creator<DictionaryCommonInfo>() { // from class: com.huawei.health.devicemgr.business.entity.DictionaryCommonInfo.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public DictionaryCommonInfo[] newArray(int i) {
            return new DictionaryCommonInfo[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: SH_, reason: merged with bridge method [inline-methods] */
        public DictionaryCommonInfo createFromParcel(Parcel parcel) {
            return DictionaryCommonInfo.getDictionaryCommonInfo(parcel);
        }
    };
    private String destPkgName;
    private DeviceInfo deviceInfo;
    private String srcPkgName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DictionaryCommonInfo() {
    }

    public DictionaryCommonInfo(String str, String str2, DeviceInfo deviceInfo) {
        this.srcPkgName = str;
        this.destPkgName = str2;
        this.deviceInfo = deviceInfo;
    }

    public String getSrcPkgName() {
        return this.srcPkgName;
    }

    public void setSrcPkgName(String str) {
        this.srcPkgName = str;
    }

    public String getDestPkgName() {
        return this.destPkgName;
    }

    public void setDestPkgName(String str) {
        this.destPkgName = str;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DictionaryCommonInfo getDictionaryCommonInfo(Parcel parcel) {
        DictionaryCommonInfo dictionaryCommonInfo = new DictionaryCommonInfo();
        dictionaryCommonInfo.srcPkgName = parcel.readString();
        dictionaryCommonInfo.destPkgName = parcel.readString();
        dictionaryCommonInfo.deviceInfo = (DeviceInfo) parcel.readParcelable(DeviceInfo.class.getClassLoader());
        return dictionaryCommonInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.srcPkgName);
        parcel.writeString(this.destPkgName);
        parcel.writeParcelable(this.deviceInfo, i);
    }
}
