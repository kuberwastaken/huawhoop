package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.jsoperation.JsUtil;

/* JADX INFO: loaded from: classes4.dex */
public class gby {

    @SerializedName("endTime")
    private long b;

    @SerializedName(JsUtil.SCORE)
    private int d;

    @SerializedName("grade")
    private int e;

    public void b(long j) {
        this.b = j;
    }

    public int c() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public String toString() {
        return "PressureMeasureBean{mStressEndTime=" + this.b + ", mStressScore=" + this.d + ", mStressGrade=" + this.e + '}';
    }
}
