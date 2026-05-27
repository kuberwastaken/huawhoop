package com.huawei.hms.kit.awareness.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.DonateStatus;

/* JADX INFO: loaded from: classes5.dex */
public class u extends f {
    public static final Parcelable.Creator<u> CREATOR = new Parcelable.Creator<u>() { // from class: com.huawei.hms.kit.awareness.a.a.u.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u[] newArray(int i) {
            return new u[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u createFromParcel(Parcel parcel) {
            return new u(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.huawei.hms.kit.awareness.b.q f4997a;

    @Override // com.huawei.hms.kit.awareness.a.a.f, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.hms.kit.awareness.a.a.f, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4997a, i);
        parcel.writeInt(c());
    }

    public DonateStatus a() {
        return this.f4997a;
    }

    private u(Parcel parcel) {
        super(parcel);
        this.f4997a = (com.huawei.hms.kit.awareness.b.q) parcel.readParcelable(com.huawei.hms.kit.awareness.b.q.class.getClassLoader());
        a(parcel.readInt());
    }

    public u(int i) {
        this.f4997a = new com.huawei.hms.kit.awareness.b.q(i);
    }
}
