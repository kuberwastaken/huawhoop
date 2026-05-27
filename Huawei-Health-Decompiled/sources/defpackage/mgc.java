package defpackage;

import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgc implements Serializable, TimeSequence {
    private static final long serialVersionUID = -6708196578480318759L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15618a;
    private float c;

    public mgc() {
    }

    public mgc(long j, float f) {
        this.f15618a = j;
        this.c = f;
    }

    public void c(long j) {
        this.f15618a = j;
    }

    public void e(float f) {
        this.c = f;
    }

    public float a() {
        return this.c;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.f15618a;
    }
}
