package defpackage;

import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class kvz {
    private int b;
    private long c;
    private int d;

    public long a() {
        return this.c;
    }

    public void b(long j) {
        this.c = (j / 60) * 60;
    }

    public int d() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public int c() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public String toString() {
        return "DataRawSleepData{startTime=" + new Date(this.c * 1000) + ", currentStatus=" + this.d + ", totalCalorie=" + this.b + '}';
    }
}
