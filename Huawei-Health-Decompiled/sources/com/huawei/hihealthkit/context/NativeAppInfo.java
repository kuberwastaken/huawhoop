package com.huawei.hihealthkit.context;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class NativeAppInfo extends OutOfBandData {
    public static final Parcelable.Creator<NativeAppInfo> CREATOR = new Parcelable.Creator<NativeAppInfo>() { // from class: com.huawei.hihealthkit.context.NativeAppInfo.4
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bCM_, reason: merged with bridge method [inline-methods] */
        public NativeAppInfo createFromParcel(Parcel parcel) {
            return new NativeAppInfo();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NativeAppInfo[] newArray(int i) {
            return new NativeAppInfo[i];
        }
    };

    public NativeAppInfo() {
        this.tag = 3;
    }
}
