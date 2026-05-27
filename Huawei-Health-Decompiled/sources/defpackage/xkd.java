package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class xkd {
    public static int c(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int d(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private xkd() {
    }

    public static void d(Object obj) {
        if (obj == null) {
            a();
        }
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            d(str);
        }
    }

    public static void d() {
        throw ((xgc) e(new xgc()));
    }

    public static void a() {
        throw ((NullPointerException) e(new NullPointerException()));
    }

    public static void d(String str) {
        throw ((NullPointerException) e(new NullPointerException(str)));
    }

    public static void c(String str) {
        throw ((xgo) e(new xgo(str)));
    }

    public static void b(String str) {
        c("lateinit property " + str + " has not been initialized");
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) e(new IllegalStateException(str + " must not be null")));
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) e(new NullPointerException(str + " must not be null")));
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            h(str);
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            g(str);
        }
    }

    private static void h(String str) {
        throw ((IllegalArgumentException) e(new IllegalArgumentException(e(str))));
    }

    private static void g(String str) {
        throw ((NullPointerException) e(new NullPointerException(e(str))));
    }

    private static String e(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = xkd.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void b() {
        a("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void a(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void b(int i, String str) {
        b();
    }

    private static <T extends Throwable> T e(T t) {
        return (T) b((Throwable) t, xkd.class.getName());
    }

    static <T extends Throwable> T b(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
