package defpackage;

import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgp implements Serializable, TimeSequence {
    private static final long serialVersionUID = -5697764361487114883L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15624a;
    private int c;

    public mgp() {
    }

    public mgp(long j, int i) {
        this.c = i;
        this.f15624a = j;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public void a(long j) {
        this.f15624a = j;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.f15624a;
    }
}
