package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgb implements Serializable {
    private static final long serialVersionUID = 8124564522666712928L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15617a;
    private long c;

    public mgb() {
    }

    public mgb(long j, int i) {
        this.c = j;
        this.f15617a = i;
    }

    public long e() {
        return this.c;
    }

    public int d() {
        return this.f15617a;
    }

    public String toString() {
        return this.c + "," + this.f15617a;
    }
}
