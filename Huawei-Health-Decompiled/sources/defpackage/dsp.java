package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dsp extends dsx {
    private long c = -1;
    private List<dst> d = new ArrayList(5);
    private int b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12404a = Integer.MAX_VALUE;

    public int e() {
        return this.f12404a;
    }

    public void b(int i) {
        this.f12404a = i;
    }

    public long b() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    public List<dst> a() {
        return this.d;
    }

    public void c(List<dst> list) {
        this.d = list;
    }

    public void e(int i) {
        this.b = i;
    }

    @Override // defpackage.dsx
    public String toString() {
        return "SamplePoint{mSrcPkgName=" + getSrcPkgName() + ", mWearPkgName=" + getWearPkgName() + ", mCommandId=" + getCommandId() + ", mDictTypeId=" + this.c + this.d + '}';
    }
}
