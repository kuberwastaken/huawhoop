package com.huawei.android.airsharing.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public enum EHwTransportState implements Parcelable {
    INVALID(-1),
    STOPPED(1),
    PLAYING(0),
    PAUSED_PLAYBACK(2),
    PAUSED_RECODING(5),
    NO_MEDIA_PRESENT(4);

    public static final Parcelable.Creator<EHwTransportState> CREATOR = new Parcelable.Creator<EHwTransportState>() { // from class: com.huawei.android.airsharing.api.EHwTransportState.5
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: eJ_, reason: merged with bridge method [inline-methods] */
        public EHwTransportState createFromParcel(Parcel parcel) {
            return EHwTransportState.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public EHwTransportState[] newArray(int i) {
            return new EHwTransportState[i];
        }
    };
    private int value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    EHwTransportState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeString(name());
        }
    }
}
