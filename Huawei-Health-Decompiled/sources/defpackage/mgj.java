package defpackage;

import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgj implements Serializable, TimeSequence {
    private static final long serialVersionUID = 7816239952862604274L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15623a;
    private int d;

    public mgj() {
    }

    public mgj(long j, int i) {
        this.d = i;
        this.f15623a = j;
    }

    public int b() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.f15623a = j;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.f15623a;
    }
}
