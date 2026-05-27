package defpackage;

import com.google.gson.annotations.SerializedName;
import health.compact.a.HiDateUtil;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class hzo implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("endTime")
    private long f14009a;

    @SerializedName("startTime")
    private long b;

    @SerializedName("title")
    private String c;

    @SerializedName("preStartTime")
    private long d;

    @SerializedName("plan")
    private String e;

    @SerializedName("type")
    private int j;

    public int d() {
        return this.j;
    }

    public long c() {
        return this.f14009a;
    }

    public String toString() {
        return "FastingLiteViewBean{mType=" + this.j + ", mTitle='" + this.c + "', mPlan='" + this.e + "', mPreStartTime=" + HiDateUtil.d(this.d, "yyyy-MM-dd HH:mm:ss:SSS") + ", mStartTime=" + HiDateUtil.d(this.b, "yyyy-MM-dd HH:mm:ss:SSS") + ", mEndTime=" + HiDateUtil.d(this.f14009a, "yyyy-MM-dd HH:mm:ss:SSS") + '}';
    }
}
