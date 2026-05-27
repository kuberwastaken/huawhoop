package defpackage;

import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgt implements Serializable, TimeSequence {
    private static final long serialVersionUID = -1245764951606553008L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15627a;
    private long e;

    public mgt(long j, int i) {
        this.e = j;
        this.f15627a = i;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.e;
    }

    public int a() {
        return this.f15627a;
    }

    public String toString() {
        return this.e + ":" + this.f15627a;
    }
}
