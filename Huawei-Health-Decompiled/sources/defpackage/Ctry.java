package defpackage;

import com.google.gson.annotations.SerializedName;
import health.compact.a.HiDateUtil;

/* JADX INFO: renamed from: try, reason: invalid class name */
/* JADX INFO: loaded from: classes8.dex */
public class Ctry {

    @SerializedName("startTime")
    private long b;

    @SerializedName("endTime")
    private long c;

    @SerializedName("type")
    private int d;

    public void c(int i) {
        this.d = i;
    }

    public void c(long j) {
        this.b = j;
    }

    public void e(long j) {
        this.c = j;
    }

    public String toString() {
        return "FastingLiteFaData{mType=" + this.d + ", mStartTime=" + HiDateUtil.d(this.b, "yyyy-MM-dd HH:mm:ss:SSS") + ", mEndTime=" + HiDateUtil.d(this.c, "yyyy-MM-dd HH:mm:ss:SSS") + '}';
    }
}
