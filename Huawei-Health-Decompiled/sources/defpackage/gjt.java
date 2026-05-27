package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class gjt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mTime")
    private long f13499a = -1;

    @SerializedName("mCadence")
    private int d = -1;

    @SerializedName("mDeltaCircle")
    private long b = -1;

    @SerializedName("mSumCircle")
    private long e = -1;

    public void d(long j) {
        this.f13499a = j;
    }

    public int a() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public long e() {
        return this.f13499a;
    }

    public String toString() {
        return "RidePostureDataInfo {mCadence = " + this.d + "mDeltaCircle = " + this.b + "mSumCircle = " + this.e + "}";
    }
}
