package com.google.android.clockwork.companion.partnerapi;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class SmartWatchInfo implements Parcelable {
    public static final Parcelable.Creator<SmartWatchInfo> CREATOR = new Parcelable.Creator<SmartWatchInfo>() { // from class: com.google.android.clockwork.companion.partnerapi.SmartWatchInfo.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cS_, reason: merged with bridge method [inline-methods] */
        public SmartWatchInfo createFromParcel(Parcel parcel) {
            return new SmartWatchInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SmartWatchInfo[] newArray(int i) {
            if (i > 65535 || i < 0) {
                return null;
            }
            return new SmartWatchInfo[i];
        }
    };
    private BluetoothDevice mBluetoothDevice;
    private int mResId;
    private int mRssi;
    private long mTimeStampsMs;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SmartWatchInfo() {
    }

    protected SmartWatchInfo(Parcel parcel) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        int i = parcel.readInt();
        int i2 = parcel.readInt();
        long j = parcel.readLong();
        this.mBluetoothDevice = bluetoothDevice;
        this.mRssi = i;
        this.mResId = i2;
        this.mTimeStampsMs = j;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.mBluetoothDevice = bluetoothDevice;
    }

    public int getRssiValue() {
        return this.mRssi;
    }

    public void setRssiValue(int i) {
        this.mRssi = i;
    }

    public int getDeviceModelImageResId() {
        return this.mResId;
    }

    public void setDeviceModelImageResId(int i) {
        this.mResId = i;
    }

    public long getTimeStampMs() {
        return this.mTimeStampsMs;
    }

    public void setTimeStampMs(long j) {
        this.mTimeStampsMs = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getBluetoothDevice(), i);
        parcel.writeInt(getRssiValue());
        parcel.writeInt(getDeviceModelImageResId());
        parcel.writeLong(getTimeStampMs());
    }
}
