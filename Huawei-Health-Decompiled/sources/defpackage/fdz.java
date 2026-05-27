package defpackage;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class fdz {
    private int b;
    private long c;
    private long d;

    public fdz() {
        this.b = -1;
        this.d = -1L;
    }

    public fdz(long j, int i) {
        this.d = -1L;
        this.c = j;
        this.b = i;
    }

    public fdz(long j, long j2) {
        this.b = -1;
        this.c = j;
        this.d = j2;
    }

    public int e() {
        return this.b;
    }

    public long a() {
        return this.d;
    }

    public long b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fdz fdzVar = (fdz) obj;
        return this.c == fdzVar.c && this.b == fdzVar.b && this.d == fdzVar.d;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.c), Integer.valueOf(this.b), Long.valueOf(this.d));
    }
}
