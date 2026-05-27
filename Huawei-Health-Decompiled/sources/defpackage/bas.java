package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class bas {
    public static <T> T b(Class<T> cls) {
        T t = (T) baw.a(cls);
        if (t == null || !cls.isAssignableFrom(t.getClass())) {
            return null;
        }
        return t;
    }
}
