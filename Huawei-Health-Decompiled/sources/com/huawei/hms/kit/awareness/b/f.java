package com.huawei.hms.kit.awareness.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.HeadsetStatus;

/* JADX INFO: loaded from: classes10.dex */
public class f implements Parcelable, HeadsetStatus {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.huawei.hms.kit.awareness.b.f.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i) {
            return new f[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel.readInt());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5024a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5024a);
    }

    @Override // com.huawei.hms.kit.awareness.status.HeadsetStatus
    public int getStatus() {
        return this.f5024a;
    }

    public f(int i) {
        this.f5024a = i;
    }
}
