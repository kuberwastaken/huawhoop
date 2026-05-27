package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class erd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("latestJoinTime")
    private long f12750a;

    @SerializedName("isCreatedPlan")
    private boolean b;

    @SerializedName("currentTime")
    private long c;

    @SerializedName("resultCode")
    private int d;

    public int a() {
        return this.d;
    }

    public long e() {
        return this.f12750a;
    }

    public boolean d() {
        return this.b;
    }

    public String toString() {
        return "InterventionPlanInfoResponse{mResultCode=" + this.d + ", mLatestJoinTime=" + this.f12750a + ", mCurrentTime=" + this.c + ", mIsCreatedPlan=" + this.b + '}';
    }
}
