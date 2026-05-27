package defpackage;

import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgn implements Serializable, TimeSequence {
    private static final long serialVersionUID = 4279729944497991314L;
    private int c;
    private long e;

    public mgn(long j, int i) {
        this.e = j;
        this.c = i;
    }

    public int e() {
        return this.c;
    }

    public String toString() {
        return this.e + ":" + this.c;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.e;
    }
}
