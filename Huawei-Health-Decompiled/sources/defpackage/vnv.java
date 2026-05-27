package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes8.dex */
public class vnv {
    private static final Method b;
    private static final Method d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f18683a;
    private View c;
    private boolean e = false;
    private int g = 0;
    private int j = 0;
    private int i = 0;

    static {
        Class cls = Integer.TYPE;
        b = e("setShadowStyle", new Class[]{cls, cls, cls}, "android.view.View");
        d = e("setShadowClip", new Class[]{Boolean.TYPE}, "android.view.View");
    }

    private void a(int i) {
        if (i < 0 || i > 2) {
            return;
        }
        this.j = i;
    }

    private void d(int i) {
        if (i < 0 || i > 6) {
            return;
        }
        this.g = i;
    }

    private void e() {
        int i = this.j;
        if (i == 2) {
            this.i = 2;
        } else if (i == 1 || d()) {
            this.i = 1;
        } else {
            this.i = 0;
        }
    }

    public void a() {
        View view;
        e();
        Method method = b;
        if (method == null || (view = this.c) == null) {
            Log.w("HwShadowEngine", "Method or target view is null!");
        } else if (this.e) {
            a(view, method, new Object[]{Integer.valueOf(this.g), Integer.valueOf(this.i), Integer.valueOf(b())});
        } else {
            a(view, method, new Object[]{-1, -1, -1});
        }
    }

    public void b(int i) {
        a(i);
    }

    public void b(boolean z) {
        View view;
        Method method = d;
        if (method == null || (view = this.c) == null) {
            Log.w("HwShadowEngine", "Method or target view is null!");
        } else {
            a(view, method, new Object[]{Boolean.valueOf(z)});
        }
    }

    public void c(boolean z) {
        if (this.e != z) {
            this.e = z;
            a();
        }
    }

    public void e(int i) {
        d(i);
    }

    public vnv(Context context, View view, int i, int i2) {
        this.f18683a = context;
        this.c = view;
        d(i);
        a(i2);
    }

    private boolean d() {
        return (this.f18683a.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Method e(String str, Class[] clsArr, String str2) {
        try {
            Method declaredMethod = Class.forName(str2).getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (ClassNotFoundException unused) {
            Log.e("HwShadowEngine", "ClassNotFoundException in reflect call " + str);
            return null;
        } catch (NoSuchMethodException unused2) {
            Log.e("HwShadowEngine", "there is no " + str + " method");
            return null;
        }
    }

    private Object a(Object obj, Method method, Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            Log.e("HwShadowEngine", "IllegalAccessException in reflect call " + method.getName());
            return null;
        } catch (InvocationTargetException unused2) {
            Log.e("HwShadowEngine", "InvocationTargetException in reflect call " + method.getName());
            return null;
        }
    }

    private int b() {
        return this.f18683a.getResources().getConfiguration().uiMode & 15;
    }
}
