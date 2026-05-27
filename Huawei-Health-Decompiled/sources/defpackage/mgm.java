package defpackage;

import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgm implements Serializable, TimeSequence {
    private static final long serialVersionUID = 3734895889084885412L;
    private double d;
    private long e;

    public mgm(long j, double d) {
        this.e = j;
        this.d = d;
    }

    public double c() {
        return this.d;
    }

    public String toString() {
        return this.e + ":" + this.d;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.e;
    }
}
