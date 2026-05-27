package com.huawei.hms.kit.awareness.barrier.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import com.huawei.hms.kit.awareness.barrier.BarrierStatus;
import com.huawei.hms.kit.awareness.barrier.BarrierStatusMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class e implements Parcelable, BarrierStatusMap {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.huawei.hms.kit.awareness.barrier.internal.e.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, d> f5066a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f5066a);
    }

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatusMap
    public BarrierStatus getBarrierStatus(String str) {
        return this.f5066a.get(str);
    }

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatusMap
    public Set<String> getBarrierLabels() {
        return this.f5066a.keySet();
    }

    public void a(String str, d dVar) {
        this.f5066a.put(str, dVar);
    }

    public static e a() {
        return new e();
    }

    private e(Parcel parcel) {
        ArrayMap arrayMap = new ArrayMap();
        this.f5066a = arrayMap;
        parcel.readMap(arrayMap, d.class.getClassLoader());
    }

    private e() {
        this.f5066a = new ArrayMap();
    }
}
