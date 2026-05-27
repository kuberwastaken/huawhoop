package defpackage;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class gkr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13505a;
    private int b;
    private int d;

    public gkr(int i, int i2, int i3) {
        d(i);
        b(i2);
        a(i3);
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public int c() {
        return this.f13505a;
    }

    public void b(int i) {
        this.f13505a = i;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gkr gkrVar = (gkr) obj;
        return this.d == gkrVar.d && this.f13505a == gkrVar.f13505a && this.b == gkrVar.b;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.d), Integer.valueOf(this.f13505a), Integer.valueOf(this.b));
    }
}
