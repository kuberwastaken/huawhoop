package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hihealth.dictionary.utils.DicDataTypeUtil;
import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class gjq implements Serializable, TimeSequence {
    private static final long serialVersionUID = -5570737047355306335L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("time")
    private long f13496a;

    @SerializedName("deltaCircle")
    private long b;

    @SerializedName("sumCircle")
    private long c;

    @SerializedName("cadence")
    private int d;

    public gjq() {
        this.f13496a = -1L;
        this.d = -1;
        this.b = -1L;
        this.c = -1L;
    }

    public gjq(long j, int i) {
        this.b = -1L;
        this.c = -1L;
        this.f13496a = j;
        this.d = i;
    }

    public void c(long j) {
        this.f13496a = j;
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.f13496a;
    }

    public void d(long j) {
        this.b = j;
    }

    public long d() {
        return this.c;
    }

    public void e(long j) {
        this.c = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof gjq) && this.f13496a == ((gjq) obj).f13496a;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void b(int i, double d) {
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_CADENCE.value()) {
            a((int) d);
        } else if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_DELTA_CIRCLE.value()) {
            d((int) d);
        } else if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_SUM_CIRCLE.value()) {
            e((int) d);
        }
    }
}
