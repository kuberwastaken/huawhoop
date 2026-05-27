package defpackage;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes8.dex */
public class yct {
    private final Object b;
    private final int d;
    private final ycn e;

    public yct(ycn ycnVar, Object obj) {
        this.e = ycnVar;
        this.b = obj;
        int iHashCode = ycnVar.hashCode();
        this.d = obj != null ? iHashCode + (obj.hashCode() * 31) : iHashCode;
    }

    public final int hashCode() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        yct yctVar = (yct) obj;
        if (this.d != yctVar.d || !this.e.equals(yctVar.e)) {
            return false;
        }
        Object obj2 = this.b;
        Object obj3 = yctVar.b;
        if (obj2 == obj3) {
            return true;
        }
        if (obj2 == null) {
            return false;
        }
        return obj2.equals(obj3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KeyToken[");
        Object objD = this.b;
        if (objD != null) {
            if (objD instanceof InetSocketAddress) {
                objD = ygp.d((InetSocketAddress) objD);
            }
            sb.append(objD);
            sb.append('-');
        }
        sb.append(this.e.d());
        sb.append(']');
        return sb.toString();
    }
}
