package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class ee<V> {
    private final V c;
    private final Throwable e;

    public ee(V v) {
        this.c = v;
        this.e = null;
    }

    public ee(Throwable th) {
        this.e = th;
        this.c = null;
    }

    public V a() {
        return this.c;
    }

    public Throwable e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ee)) {
            return false;
        }
        ee eeVar = (ee) obj;
        if (a() != null && a().equals(eeVar.a())) {
            return true;
        }
        if (e() == null || eeVar.e() == null) {
            return false;
        }
        return e().toString().equals(e().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{a(), e()});
    }
}
