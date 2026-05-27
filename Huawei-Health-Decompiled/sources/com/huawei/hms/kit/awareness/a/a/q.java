package com.huawei.hms.kit.awareness.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.ApplicationStatus;

/* JADX INFO: loaded from: classes10.dex */
public class q extends f {
    public static final Parcelable.Creator<q> CREATOR = new Parcelable.Creator<q>() { // from class: com.huawei.hms.kit.awareness.a.a.q.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q[] newArray(int i) {
            return new q[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.huawei.hms.kit.awareness.b.m f4993a;

    @Override // com.huawei.hms.kit.awareness.a.a.f, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.hms.kit.awareness.a.a.f, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4993a, i);
        parcel.writeInt(c());
    }

    public ApplicationStatus a() {
        return this.f4993a;
    }

    private q(Parcel parcel) {
        super(parcel);
        this.f4993a = (com.huawei.hms.kit.awareness.b.m) parcel.readParcelable(q.class.getClassLoader());
        a(parcel.readInt());
    }

    public q(int i) {
        this.f4993a = new com.huawei.hms.kit.awareness.b.m(i);
    }
}
