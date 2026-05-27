package defpackage;

import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class lns {
    private int b;
    private int d;
    private long e;

    public long b() {
        return this.e;
    }

    public void a(long j) {
        this.e = (j / 60) * 60;
    }

    public int d() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int a() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public String toString() {
        return "DataRawSleepData{startTime=" + new Date(this.e * 1000) + ", currentStatus=" + this.b + ", totalCalorie=" + this.d + '}';
    }
}
