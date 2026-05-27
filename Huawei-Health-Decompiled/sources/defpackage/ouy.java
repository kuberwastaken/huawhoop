package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes7.dex */
public class ouy {
    private Method b;
    private Field c;
    private Constructor d;
    Class<?> e;

    ouy() {
    }

    public static ouy c(Class<?> cls) {
        ouy ouyVar = new ouy();
        ouyVar.e = cls;
        return ouyVar;
    }

    protected Object e(Object obj) throws c {
        if (obj == null || this.e.isInstance(obj)) {
            return obj;
        }
        throw new c("Caller [" + obj + "] is not a instance of type [" + this.e + "]!");
    }

    protected void a(Object obj, Member member, String str) throws c {
        if (member == null) {
            throw new c(str + " was null!");
        }
        if (obj == null && !Modifier.isStatic(member.getModifiers())) {
            throw new c("Need a caller!");
        }
        e(obj);
    }

    public ouy e(String str) throws c {
        try {
            Field fieldB = b(str);
            this.c = fieldB;
            fieldB.setAccessible(true);
            this.d = null;
            this.b = null;
            return this;
        } catch (Throwable th) {
            throw new c("Oops!", th);
        }
    }

    protected Field b(String str) throws NoSuchFieldException {
        try {
            return this.e.getField(str);
        } catch (NoSuchFieldException e) {
            for (Class<?> superclass = this.e; superclass != null; superclass = superclass.getSuperclass()) {
                try {
                    return superclass.getDeclaredField(str);
                } catch (NoSuchFieldException unused) {
                }
            }
            throw e;
        }
    }

    public ouy b(Object obj, Object obj2) throws c {
        a(obj, this.c, "Field");
        try {
            this.c.set(obj, obj2);
            return this;
        } catch (Throwable th) {
            throw new c("Oops!", th);
        }
    }

    public static class c extends Exception {
        public c(String str) {
            super(str);
        }

        public c(String str, Throwable th) {
            super(str, th);
        }
    }
}
