package health.compact.a;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class SystemPropertiesReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f13783a;
    private final Method b;
    private final Method c;
    private final Method e;

    SystemPropertiesReader(String str) throws NoSuchMethodException, ClassNotFoundException {
        Class<?> clsB = ReflectionUtils.b(str);
        this.c = ReflectionUtils.a(clsB, "get", (Class<?>[]) new Class[]{String.class, String.class});
        this.f13783a = ReflectionUtils.a(clsB, "getBoolean", (Class<?>[]) new Class[]{String.class, Boolean.TYPE});
        this.e = ReflectionUtils.a(clsB, "getInt", (Class<?>[]) new Class[]{String.class, Integer.TYPE});
        this.b = ReflectionUtils.a(clsB, "getLong", (Class<?>[]) new Class[]{String.class, Long.TYPE});
    }

    public String c(String str, String str2) {
        Method method;
        if (TextUtils.isEmpty(str) || (method = this.c) == null) {
            return str2;
        }
        Object objD = ReflectionUtils.d(method, null, str, str2);
        return objD instanceof String ? (String) objD : str2;
    }

    public boolean c(String str, boolean z) {
        Method method;
        if (TextUtils.isEmpty(str) || (method = this.f13783a) == null) {
            return z;
        }
        Object objD = ReflectionUtils.d(method, null, str, Boolean.valueOf(z));
        return objD instanceof Boolean ? ((Boolean) objD).booleanValue() : z;
    }

    public int c(String str, int i) {
        Method method;
        if (TextUtils.isEmpty(str) || (method = this.e) == null) {
            return i;
        }
        Object objD = ReflectionUtils.d(method, null, str, Integer.valueOf(i));
        return objD instanceof Integer ? ((Integer) objD).intValue() : i;
    }
}
