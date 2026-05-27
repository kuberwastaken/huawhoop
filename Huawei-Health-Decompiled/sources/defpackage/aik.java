package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class aik implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final aik f237a = new aik();
    private static final long serialVersionUID = 1;

    public boolean e(Class<?> cls) {
        return false;
    }

    public static aik b(Class<?>[] clsArr) {
        if (clsArr == null) {
            return f237a;
        }
        int length = clsArr.length;
        if (length == 0) {
            return f237a;
        }
        if (length == 1) {
            return new e(clsArr[0]);
        }
        return new c(clsArr);
    }

    static final class e extends aik {
        private static final long serialVersionUID = 1;
        private final Class<?> c;

        public e(Class<?> cls) {
            this.c = cls;
        }

        @Override // defpackage.aik
        public boolean e(Class<?> cls) {
            Class<?> cls2 = this.c;
            return cls == cls2 || cls2.isAssignableFrom(cls);
        }
    }

    static final class c extends aik implements Serializable {
        private static final long serialVersionUID = 1;
        private final Class<?>[] e;

        public c(Class<?>[] clsArr) {
            this.e = clsArr;
        }

        @Override // defpackage.aik
        public boolean e(Class<?> cls) {
            int length = this.e.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls2 = this.e[i];
                if (cls == cls2 || cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
    }
}
