package com.huawei.hms.kit.awareness.barrier.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.kit.awareness.barrier.BarrierStatus;
import com.huawei.hms.kit.awareness.internal.communication.Constants;

/* JADX INFO: loaded from: classes5.dex */
public class d extends BarrierStatus implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5053a;
    private int b;
    private long c;
    private final String d;

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatus, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5053a);
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
    }

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatus
    public int getPresentStatus() {
        return this.f5053a;
    }

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatus
    public int getLastStatus() {
        return this.b;
    }

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatus
    public long getLastBarrierUpdateTime() {
        return this.c;
    }

    @Override // com.huawei.hms.kit.awareness.barrier.BarrierStatus
    public String getBarrierLabel() {
        return this.d;
    }

    public Intent c() {
        return b(null);
    }

    public Intent b(String str) {
        Intent intent = new Intent();
        if (!com.huawei.hms.kit.awareness.barrier.internal.f.c.a(str)) {
            intent.setAction(Constants.ACTION_INNER_BARRIER_TRIGGER);
            intent.setPackage(str);
        }
        intent.putExtra("context_barrier_current_state", this.f5053a);
        intent.putExtra("context_barrier_previous_state", this.b);
        intent.putExtra("context_barrier_last_updated_time", getLastBarrierUpdateTime());
        intent.putExtra("context_barrier_key", getBarrierLabel());
        return intent;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(int i) {
        this.b = this.f5053a;
        this.f5053a = i;
    }

    public static d a(String str) {
        return new d(2, 2, System.currentTimeMillis(), str);
    }

    public static d a(Parcel parcel) {
        return new d(parcel);
    }

    public static d a(int i, int i2, long j, String str) {
        return new d(i, i2, j, str);
    }

    private d(Parcel parcel) {
        int i = parcel.readInt();
        int i2 = parcel.readInt();
        this.f5053a = i;
        this.b = i2;
        this.c = parcel.readLong();
        this.d = parcel.readString();
    }

    private d(int i, int i2, long j, String str) {
        this.f5053a = i;
        this.b = i2;
        this.c = j;
        this.d = str;
    }
}
