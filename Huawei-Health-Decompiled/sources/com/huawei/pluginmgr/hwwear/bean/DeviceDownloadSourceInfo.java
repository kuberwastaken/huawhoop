package com.huawei.pluginmgr.hwwear.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceDownloadSourceInfo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DeviceDownloadSourceInfo> CREATOR = new Parcelable.Creator<DeviceDownloadSourceInfo>() { // from class: com.huawei.pluginmgr.hwwear.bean.DeviceDownloadSourceInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cvc_, reason: merged with bridge method [inline-methods] */
        public DeviceDownloadSourceInfo createFromParcel(Parcel parcel) {
            return new DeviceDownloadSourceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceDownloadSourceInfo[] newArray(int i) {
            return new DeviceDownloadSourceInfo[i];
        }
    };

    @SerializedName("configurationPoint")
    private String mConfigurationPoint;

    @SerializedName("indexName")
    private String mIndexName;

    @SerializedName("site")
    private int mSite;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DeviceDownloadSourceInfo(Parcel parcel) {
        if (parcel != null) {
            this.mSite = parcel.readInt();
            this.mIndexName = parcel.readString();
            this.mConfigurationPoint = parcel.readString();
        }
    }

    public int getSite() {
        return this.mSite;
    }

    public void setSite(int i) {
        this.mSite = i;
    }

    public String getIndexName() {
        return this.mIndexName;
    }

    public void setIndexName(String str) {
        this.mIndexName = str;
    }

    public String getConfigurationPoint() {
        return this.mConfigurationPoint;
    }

    public void setConfigurationPoint(String str) {
        this.mConfigurationPoint = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeInt(this.mSite);
            parcel.writeString(this.mIndexName);
            parcel.writeString(this.mConfigurationPoint);
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DeviceDownloadSourceInfo m1121clone() {
        DeviceDownloadSourceInfo deviceDownloadSourceInfo;
        try {
            if (!(super.clone() instanceof DeviceDownloadSourceInfo)) {
                return null;
            }
            deviceDownloadSourceInfo = (DeviceDownloadSourceInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            deviceDownloadSourceInfo = new DeviceDownloadSourceInfo(null);
            deviceDownloadSourceInfo.setConfigurationPoint(this.mConfigurationPoint);
            deviceDownloadSourceInfo.setIndexName(this.mIndexName);
            deviceDownloadSourceInfo.setSite(this.mSite);
        }
        return deviceDownloadSourceInfo;
    }
}
