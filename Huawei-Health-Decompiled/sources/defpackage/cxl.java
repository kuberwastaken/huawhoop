package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class cxl implements Serializable {
    private static final long serialVersionUID = 3401094552994390416L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("planId")
    private String f12073a;

    @SerializedName("lastTimestamp")
    private long b;

    @SerializedName("planEndTime")
    private long c;

    @SerializedName("lastDiastolic")
    private int d;

    @SerializedName("lastSystolic")
    private int e;

    @SerializedName("planStartTime")
    private long f;

    @SerializedName("planLocalDate")
    private int i;

    @SerializedName(ParsedFieldTag.EXCHANGE_PROPORTION)
    private float j;

    public String b() {
        return this.f12073a;
    }

    public long g() {
        return this.f;
    }

    public long d() {
        return this.c;
    }

    public float i() {
        return this.j;
    }

    public int c() {
        return this.e;
    }

    public int a() {
        return this.d;
    }

    public long e() {
        return this.b;
    }

    public String toString() {
        return "DynamicBloodPressureStatus{mPlanId='" + this.f12073a + "', mPlanStartTime=" + this.f + ", mPlanEndTime=" + this.c + ", mPlanLocalDate=" + this.i + ", mRatio=" + this.j + ", mLastSystolic=" + this.e + ", mLastDiastolic=" + this.d + ", mLastTimestamp=" + this.b + '}';
    }
}
