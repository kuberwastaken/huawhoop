package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class pdp {
    private boolean b;
    private boolean c;
    private boolean d;

    public pdp() {
    }

    public pdp(boolean z, boolean z2) {
        this.d = z;
        this.b = z2;
    }

    public pdp(boolean z, boolean z2, boolean z3) {
        this.d = z;
        this.b = z2;
        this.c = z3;
    }

    public pdp a(boolean z) {
        this.d = z;
        return this;
    }

    public boolean b() {
        return this.d;
    }

    public pdp d(boolean z) {
        this.b = z;
        return this;
    }

    public boolean e() {
        return this.b;
    }

    public pdp b(boolean z) {
        this.c = z;
        return this;
    }

    public boolean c() {
        return this.c;
    }
}
