package com.huawei.agconnect.common.datastore.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.secure.android.common.util.SafeBase64;

/* JADX INFO: loaded from: classes10.dex */
class ParcelableSerializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1744a = "ParcelableSerializer";

    static <T> String b(T t) {
        return SafeBase64.encodeToString(a(t), 0);
    }

    private static <T> byte[] a(T t) {
        if (t == null || !Parcelable.class.isAssignableFrom(t.getClass())) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        ((Parcelable) t).writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    private static <T> T a(byte[] bArr, Class<T> cls) {
        StringBuilder sb;
        if (bArr == null || bArr.length == 0 || !Parcelable.class.isAssignableFrom(cls)) {
            return null;
        }
        try {
            Parcelable.Creator creator = (Parcelable.Creator) cls.getField("CREATOR").get(null);
            if (creator != null) {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                T t = (T) creator.createFromParcel(parcelObtain);
                parcelObtain.recycle();
                return t;
            }
        } catch (IllegalAccessException e) {
            e = e;
            sb = new StringBuilder("illegal access exception : ");
            sb.append(e.getMessage());
            Logger.e(f1744a, sb.toString());
        } catch (NoSuchFieldException e2) {
            e = e2;
            sb = new StringBuilder("no such field exception : ");
            sb.append(e.getMessage());
            Logger.e(f1744a, sb.toString());
        }
        return null;
    }

    static <T> T a(String str, Class<T> cls) {
        return (T) a(SafeBase64.decode(str, 0), cls);
    }

    ParcelableSerializer() {
    }
}
