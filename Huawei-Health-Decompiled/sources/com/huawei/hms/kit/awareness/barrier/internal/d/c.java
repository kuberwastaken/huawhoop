package com.huawei.hms.kit.awareness.barrier.internal.d;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes10.dex */
public class c extends f {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.huawei.hms.kit.awareness.barrier.internal.d.c.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i) {
            return new c[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }
    };
    public static final int b = 399;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5056a;

    private static boolean a(int i) {
        return ((1 << i) & b) != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5056a);
    }

    public String toString() {
        return "BehaviorTypes: " + this.f5056a;
    }

    public int hashCode() {
        return this.f5056a;
    }

    @Override // com.huawei.hms.kit.awareness.barrier.internal.d.f
    public boolean g() {
        return (this.f5056a & (-400)) == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return obj == this || hashCode() == obj.hashCode();
        }
        return false;
    }

    public int a() {
        return this.f5056a;
    }

    public static boolean a(int... iArr) {
        if (com.huawei.hms.kit.awareness.barrier.internal.f.c.a(iArr)) {
            return false;
        }
        for (int i : iArr) {
            if (!a(i)) {
                return false;
            }
        }
        return true;
    }

    public c(int[] iArr) {
        if (com.huawei.hms.kit.awareness.barrier.internal.f.c.a(iArr)) {
            this.f5056a = 0;
            return;
        }
        for (int i : iArr) {
            if (a(i)) {
                this.f5056a = (1 << i) | this.f5056a;
            }
        }
    }

    private c(Parcel parcel) {
        this.f5056a = parcel.readInt();
    }
}
