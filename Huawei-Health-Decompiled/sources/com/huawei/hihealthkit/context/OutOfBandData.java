package com.huawei.hihealthkit.context;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.jpr;

/* JADX INFO: loaded from: classes.dex */
public abstract class OutOfBandData implements Parcelable {
    public static final Parcelable.Creator<OutOfBandData> CREATOR = new jpr();
    int tag = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.tag);
    }
}
