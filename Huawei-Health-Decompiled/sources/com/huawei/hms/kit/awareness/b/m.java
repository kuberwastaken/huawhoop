package com.huawei.hms.kit.awareness.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.ApplicationStatus;

/* JADX INFO: loaded from: classes10.dex */
public class m implements Parcelable, ApplicationStatus {
    public static final Parcelable.Creator<m> CREATOR = new Parcelable.Creator<m>() { // from class: com.huawei.hms.kit.awareness.b.m.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i) {
            return new m[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel.readInt());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5031a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5031a);
    }

    @Override // com.huawei.hms.kit.awareness.status.ApplicationStatus
    public int getStatus() {
        return this.f5031a;
    }

    public m(int i) {
        this.f5031a = i;
    }
}
