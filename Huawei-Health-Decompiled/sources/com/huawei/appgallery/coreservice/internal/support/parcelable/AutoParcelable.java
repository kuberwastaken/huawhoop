package com.huawei.appgallery.coreservice.internal.support.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.azv;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AutoParcelable implements Parcelable {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static class AutoCreator<T extends AutoParcelable> implements Parcelable.Creator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f1908a;

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i) {
            return (T[]) ((AutoParcelable[]) Array.newInstance((Class<?>) this.f1908a, i));
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return (T) azv.iD_(this.f1908a, parcel);
        }

        public AutoCreator(Class<T> cls) {
            this.f1908a = cls;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        azv.iF_(this, parcel, i);
    }
}
