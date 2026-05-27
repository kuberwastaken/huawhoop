package com.huawei.agconnect.datastore.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
class ParcelableSerializer {
    private static final String TAG = "ParcelableSerializer";

    static <T extends Parcelable> String serializeToString(T t) {
        return SafeBase64.encodeToString(serializeToBytes(t), 0);
    }

    private static <T extends Parcelable> byte[] serializeToBytes(T t) {
        Parcel parcelObtain = Parcel.obtain();
        t.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    static <T extends Parcelable> T deserializeFromString(String str, Parcelable.Creator<T> creator) {
        return (T) deserializeFromBytes(SafeBase64.decode(str, 0), creator);
    }

    private static <T extends Parcelable> T deserializeFromBytes(byte[] bArr, Parcelable.Creator<T> creator) {
        if (creator == null || bArr.length == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }

    ParcelableSerializer() {
    }
}
