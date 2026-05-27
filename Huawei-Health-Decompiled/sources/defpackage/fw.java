package defpackage;

import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes3.dex */
public class fw<T> {
    T b;
    T c;

    public void b(T t, T t2) {
        this.c = t;
        this.b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return d(pair.first, this.c) && d(pair.second, this.b);
    }

    private static boolean d(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T t = this.c;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.c + " " + this.b + "}";
    }
}
