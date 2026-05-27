package defpackage;

import com.google.gson.annotations.SerializedName;
import health.compact.a.HiDateUtil;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class thy implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("startTime")
    private long f17994a;

    @SerializedName("preStartTime")
    private long b;

    @SerializedName("title")
    private String c;

    @SerializedName("endTime")
    private long d;

    @SerializedName("plan")
    private String e;

    @SerializedName("type")
    private int g;

    public int d() {
        return this.g;
    }

    public void e(int i) {
        this.g = i;
    }

    public void c(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public long e() {
        return this.b;
    }

    public void d(long j) {
        this.b = j;
    }

    public long b() {
        return this.f17994a;
    }

    public void a(long j) {
        this.f17994a = j;
    }

    public long a() {
        return this.d;
    }

    public void c(long j) {
        this.d = j;
    }

    public String toString() {
        return "FastingLiteViewBean{mType=" + this.g + ", mTitle='" + this.c + "', mPlan='" + this.e + "', mPreStartTime=" + HiDateUtil.d(this.b, "yyyy-MM-dd HH:mm:ss:SSS") + ", mStartTime=" + HiDateUtil.d(this.f17994a, "yyyy-MM-dd HH:mm:ss:SSS") + ", mEndTime=" + HiDateUtil.d(this.d, "yyyy-MM-dd HH:mm:ss:SSS") + '}';
    }
}
