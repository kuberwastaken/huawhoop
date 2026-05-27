package com.huawei.hms.kit.awareness.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.DarkModeStatus;

/* JADX INFO: loaded from: classes10.dex */
public class r extends f {
    public static final Parcelable.Creator<r> CREATOR = new Parcelable.Creator<r>() { // from class: com.huawei.hms.kit.awareness.a.a.r.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r[] newArray(int i) {
            return new r[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r createFromParcel(Parcel parcel) {
            return new r(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.huawei.hms.kit.awareness.b.n f4994a;

    @Override // com.huawei.hms.kit.awareness.a.a.f, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4994a, i);
        parcel.writeInt(c());
    }

    public DarkModeStatus a() {
        return this.f4994a;
    }

    private r(Parcel parcel) {
        super(parcel);
        this.f4994a = (com.huawei.hms.kit.awareness.b.n) parcel.readParcelable(com.huawei.hms.kit.awareness.b.n.class.getClassLoader());
        a(parcel.readInt());
    }

    public r(int i) {
        this.f4994a = new com.huawei.hms.kit.awareness.b.n(i);
    }
}
