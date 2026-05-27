package com.huawei.hms.kit.awareness.barrier.internal.d;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes10.dex */
public class h extends f {
    public static final Parcelable.Creator<h> CREATOR = new Parcelable.Creator<h>() { // from class: com.huawei.hms.kit.awareness.barrier.internal.d.h.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h[] newArray(int i) {
            return new h[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5060a;
    private final int b;
    private final int c;

    public static boolean a(int i) {
        return i == 1 || i == 0 || i == -1;
    }

    public static boolean b(int i) {
        return i >= 0;
    }

    private boolean c(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5060a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }

    @Override // com.huawei.hms.kit.awareness.barrier.internal.d.f
    public boolean g() {
        return c(this.f5060a) && b(this.b) && a(this.c);
    }

    public int c() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int a() {
        return this.f5060a;
    }

    private h(Parcel parcel) {
        this.f5060a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }

    public h(int i, int i2, int i3) {
        this.f5060a = i;
        this.b = i2;
        this.c = i3;
    }
}
