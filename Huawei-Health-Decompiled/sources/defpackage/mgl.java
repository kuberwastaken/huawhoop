package defpackage;

import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgl implements Serializable, TimeSequence {
    private static final long serialVersionUID = 7290174584790198637L;
    private int c;
    private long d;

    public mgl(long j, int i) {
        this.d = j;
        this.c = i;
    }

    public int a() {
        return this.c;
    }

    public String toString() {
        return this.d + ":" + this.c;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.d;
    }
}
