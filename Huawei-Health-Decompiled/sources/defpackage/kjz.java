package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class kjz implements Serializable {
    private static final long serialVersionUID = -2450042604654189808L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f14716a;
    private int d;
    private int e;

    public kjz(long j, int i, int i2) {
        this.f14716a = j;
        this.e = i;
        this.d = i2;
    }

    public long b() {
        return this.f14716a;
    }

    public int e() {
        return this.e;
    }

    public int c() {
        return this.d;
    }
}
