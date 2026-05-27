package defpackage;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes8.dex */
public final class ycw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19240a;
    private final int b;
    private final Object e;

    public ycw(int i, Object obj) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("MID must be a 16 bit unsigned int: " + i);
        }
        if (obj == null) {
            throw new NullPointerException("peer must not be null");
        }
        this.b = i;
        this.e = obj;
        this.f19240a = (i * 31) + obj.hashCode();
    }

    public Object d() {
        return this.e;
    }

    public int hashCode() {
        return this.f19240a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ycw ycwVar = (ycw) obj;
        if (this.b != ycwVar.b) {
            return false;
        }
        return this.e.equals(ycwVar.e);
    }

    public String toString() {
        Object objD = this.e;
        if (objD instanceof InetSocketAddress) {
            objD = ygp.d((InetSocketAddress) objD);
        }
        return "KeyMID[" + objD + '-' + this.b + ']';
    }
}
