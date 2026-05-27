package com.chinatelecom.multisimservice.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class MultiSimDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<MultiSimDeviceInfo> CREATOR = new Parcelable.Creator<MultiSimDeviceInfo>() { // from class: com.chinatelecom.multisimservice.model.MultiSimDeviceInfo.4
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cB_, reason: merged with bridge method [inline-methods] */
        public MultiSimDeviceInfo createFromParcel(Parcel parcel) {
            return new MultiSimDeviceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MultiSimDeviceInfo[] newArray(int i) {
            return new MultiSimDeviceInfo[i];
        }
    };
    public static final int DEVICE_TYPE_ESIM = 2;
    public static final int DEVICE_TYPE_INVALID = 0;
    public static final int DEVICE_TYPE_NO_MODEM = 3;
    public static final int DEVICE_TYPE_SIM = 1;
    private String mCiphertext;
    private String mCiphertextSign;
    private int mDeviceType;
    private int mResultCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MultiSimDeviceInfo() {
    }

    public MultiSimDeviceInfo(Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mDeviceType = parcel.readInt();
        this.mCiphertextSign = parcel.readString();
        this.mCiphertext = parcel.readString();
    }

    public String getCiphertextSign() {
        return this.mCiphertextSign;
    }

    public void setCiphertextSign(String str) {
        this.mCiphertextSign = str;
    }

    public String getCiphertext() {
        return this.mCiphertext;
    }

    public void setCiphertext(String str) {
        this.mCiphertext = str;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public void setResultCode(int i) {
        this.mResultCode = i;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public void setDeviceType(int i) {
        this.mDeviceType = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mResultCode);
        parcel.writeInt(this.mDeviceType);
        parcel.writeString(this.mCiphertextSign);
        parcel.writeString(this.mCiphertext);
    }
}
