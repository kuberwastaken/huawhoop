package com.huawei.android.airsharing.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public enum EHwMediaInfoType implements Parcelable {
    IMAGE,
    AUDIO,
    VIDEO,
    FOLDER,
    IMAGE_VIDEO,
    IDLE,
    CUSTOM,
    UNKNOWN;

    public static final Parcelable.Creator<EHwMediaInfoType> CREATOR = new Parcelable.Creator<EHwMediaInfoType>() { // from class: com.huawei.android.airsharing.api.EHwMediaInfoType.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: eI_, reason: merged with bridge method [inline-methods] */
        public EHwMediaInfoType createFromParcel(Parcel parcel) {
            return EHwMediaInfoType.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public EHwMediaInfoType[] newArray(int i) {
            return new EHwMediaInfoType[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeString(name());
        }
    }
}
