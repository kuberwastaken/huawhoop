package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class equ {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("startTime")
    private int f12743a;

    @SerializedName("id")
    private int b;

    @SerializedName("timestamp")
    private long c;

    @SerializedName("endTime")
    private int e;

    public int b() {
        return this.b;
    }

    public int a() {
        return this.f12743a;
    }

    public void a(int i) {
        this.f12743a = i;
    }

    public int c() {
        return this.e;
    }

    public String toString() {
        return "HealthLifeChallengeBean{mId=" + this.b + ", mStartTime=" + this.f12743a + ", mEndTime=" + this.e + ", mTimestamp=" + this.c + "}";
    }
}
