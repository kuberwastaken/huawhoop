package com.huawei.hms.kit.awareness.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.BluetoothStatus;

/* JADX INFO: loaded from: classes10.dex */
public class j implements Parcelable, BluetoothStatus {
    public static final Parcelable.Creator<j> CREATOR = new Parcelable.Creator<j>() { // from class: com.huawei.hms.kit.awareness.b.j.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i) {
            return new j[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel.readInt());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5028a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5028a);
    }

    @Override // com.huawei.hms.kit.awareness.status.BluetoothStatus
    public int getStatus() {
        return this.f5028a;
    }

    public j(int i) {
        this.f5028a = i;
    }
}
