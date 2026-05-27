package defpackage;

import com.fasterxml.jackson.databind.JavaType;

/* JADX INFO: loaded from: classes9.dex */
public class ail {
    protected boolean b;
    protected Class<?> c;
    protected JavaType d;
    protected int e;

    public ail() {
    }

    public ail(Class<?> cls, boolean z) {
        this.c = cls;
        this.d = null;
        this.b = z;
        this.e = z ? b(cls) : a(cls);
    }

    public ail(JavaType javaType, boolean z) {
        this.d = javaType;
        this.c = null;
        this.b = z;
        this.e = z ? a(javaType) : b(javaType);
    }

    public static final int a(Class<?> cls) {
        return cls.getName().hashCode();
    }

    public static final int b(Class<?> cls) {
        return cls.getName().hashCode() + 1;
    }

    public static final int b(JavaType javaType) {
        return javaType.hashCode() - 1;
    }

    public static final int a(JavaType javaType) {
        return javaType.hashCode() - 2;
    }

    public boolean a() {
        return this.b;
    }

    public Class<?> e() {
        return this.c;
    }

    public JavaType c() {
        return this.d;
    }

    public final int hashCode() {
        return this.e;
    }

    public final String toString() {
        if (this.c != null) {
            return "{class: " + this.c.getName() + ", typed? " + this.b + "}";
        }
        return "{type: " + this.d + ", typed? " + this.b + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        ail ailVar = (ail) obj;
        if (ailVar.b != this.b) {
            return false;
        }
        Class<?> cls = this.c;
        if (cls != null) {
            return ailVar.c == cls;
        }
        return this.d.equals(ailVar.d);
    }
}
