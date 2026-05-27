package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public final class ahi implements Comparable<ahi>, Serializable {
    private static final long serialVersionUID = 1;
    private Class<?> b;
    private String c;
    private int d;

    public ahi() {
        this.b = null;
        this.c = null;
        this.d = 0;
    }

    public ahi(Class<?> cls) {
        this.b = cls;
        String name = cls.getName();
        this.c = name;
        this.d = name.hashCode();
    }

    public void a(Class<?> cls) {
        this.b = cls;
        String name = cls.getName();
        this.c = name;
        this.d = name.hashCode();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(ahi ahiVar) {
        return this.c.compareTo(ahiVar.c);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == getClass() && ((ahi) obj).b == this.b;
    }

    public int hashCode() {
        return this.d;
    }

    public String toString() {
        return this.c;
    }
}
