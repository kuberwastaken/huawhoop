package com.huawei.hms.kit.awareness.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.DonateStatus;

/* JADX INFO: loaded from: classes5.dex */
public class q implements Parcelable, DonateStatus {
    public static final Parcelable.Creator<q> CREATOR = new Parcelable.Creator<q>() { // from class: com.huawei.hms.kit.awareness.b.q.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q[] newArray(int i) {
            return new q[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel.readInt());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5035a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5035a);
    }

    @Override // com.huawei.hms.kit.awareness.status.DonateStatus
    public int getStatus() {
        return this.f5035a;
    }

    public q(int i) {
        this.f5035a = i;
    }
}
