package com.huawei.openalliance.ad.hsf;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class PPSHsfService implements Parcelable {
    public static final Parcelable.Creator<PPSHsfService> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7168a;
    private final IBinder b;
    private final int c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7168a);
        parcel.writeStrongBinder(this.b);
        parcel.writeInt(this.c);
    }

    static class a implements Parcelable.Creator<PPSHsfService> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSHsfService[] newArray(int i) {
            return new PPSHsfService[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PPSHsfService createFromParcel(Parcel parcel) {
            return new PPSHsfService(parcel.readString(), parcel.readStrongBinder(), parcel.readInt());
        }

        private a() {
        }
    }

    public IBinder b() {
        return this.b;
    }

    public String a() {
        return this.f7168a;
    }

    public PPSHsfService(String str, IBinder iBinder, int i) {
        this.f7168a = str;
        this.b = iBinder;
        this.c = i;
    }
}
