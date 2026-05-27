package defpackage;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes6.dex */
public class mcm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15607a;
    private final long c;
    private final long d;
    private long e = SystemClock.elapsedRealtime();

    public mcm(long j, long j2, long j3) {
        this.d = j;
        this.c = j2;
        this.f15607a = Math.min(j3, j2);
    }

    public boolean a() {
        synchronized (this) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMin = Math.min(this.c, this.f15607a + (((jElapsedRealtime - this.e) / 1000) * this.d));
            this.f15607a = jMin;
            this.e = jElapsedRealtime;
            if (jMin < 1) {
                return false;
            }
            this.f15607a = jMin - 1;
            return true;
        }
    }

    public long e() {
        return this.f15607a;
    }

    public long b() {
        return this.e;
    }
}
