package com.huawei.hms.kit.awareness.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.status.BehaviorStatus;

/* JADX INFO: loaded from: classes10.dex */
public class d extends f {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.huawei.hms.kit.awareness.a.a.d.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BehaviorStatus f4985a;

    @Override // com.huawei.hms.kit.awareness.a.a.f, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.hms.kit.awareness.a.a.f, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4985a, i);
        parcel.writeInt(c());
    }

    public BehaviorStatus a() {
        return this.f4985a;
    }

    public d(BehaviorStatus behaviorStatus) {
        this.f4985a = behaviorStatus;
    }

    private d(Parcel parcel) {
        super(parcel);
        this.f4985a = (BehaviorStatus) parcel.readParcelable(BehaviorStatus.class.getClassLoader());
        a(parcel.readInt());
    }
}
