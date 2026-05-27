package com.huawei.watchface.mvp.model.datatype;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Parcelable.Creator<DeviceInfo>() { // from class: com.huawei.watchface.mvp.model.datatype.DeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            String string = parcel.readString();
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.setDeviceConnectState(i);
            deviceInfo.setDeviceName(string);
            return deviceInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInfo[] newArray(int i) {
            return new DeviceInfo[i];
        }
    };
    private int mDeviceConnectState;
    private String mDeviceName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mDeviceConnectState);
        parcel.writeString(this.mDeviceName);
    }

    public int getDeviceConnectState() {
        return this.mDeviceConnectState;
    }

    public void setDeviceConnectState(int i) {
        this.mDeviceConnectState = i;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public void setDeviceName(String str) {
        this.mDeviceName = str;
    }

    public String toString() {
        return "DeviceInfo{mDeviceConnectState=" + this.mDeviceConnectState + ", mDeviceName='" + this.mDeviceName + "'}";
    }
}
