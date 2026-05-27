package defpackage;

import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import com.huawei.hwfoundationmodel.trackmodel.ValueSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgf implements Serializable, TimeSequence, ValueSequence {
    private static final long serialVersionUID = 4068195580731601439L;
    private long b;
    private int d;

    public mgf() {
    }

    public mgf(long j, int i) {
        this.d = i;
        this.b = j;
    }

    public int b() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public void e(long j) {
        this.b = j;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof mgf) && this.b == ((mgf) obj).b;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.ValueSequence
    public int acquireValue() {
        return this.d;
    }
}
