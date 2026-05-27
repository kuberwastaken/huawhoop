package defpackage;

import android.graphics.Canvas;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes11.dex */
public class vnz {
    private static final Method b;
    private static final Method c;
    private static final Method d;
    private static final Method e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f18687a;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            e = vnl.e("isDeviceSupport", null, "huawei.android.widget.effect.engine.HwShadowEngine");
            b = vnl.e("setEnable", new Class[]{Boolean.TYPE}, "huawei.android.widget.effect.engine.HwShadowEngine");
            c = vnl.e("isEnable", null, "huawei.android.widget.effect.engine.HwShadowEngine");
            d = vnl.e("renderShadow", new Class[]{Canvas.class}, "huawei.android.widget.effect.engine.HwShadowEngine");
            return;
        }
        e = null;
        b = null;
        c = null;
        d = null;
    }

    private static boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public boolean b() {
        Object obj;
        Method method = c;
        if (method == null || (obj = this.f18687a) == null) {
            return false;
        }
        return b(vnl.b(obj, method));
    }

    public void eBd_(Canvas canvas) {
        Object obj;
        Method method = d;
        if (method == null || (obj = this.f18687a) == null) {
            return;
        }
        vnl.b(obj, method, new Object[]{canvas});
    }

    public vnz(ViewGroup viewGroup, int i) {
        Class<?> cls;
        Object obj = null;
        try {
            cls = Class.forName("huawei.android.widget.effect.engine.HwShadowEngine$ShadowType");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        try {
            Object[] enumConstants = cls.getEnumConstants();
            int i2 = i - 1;
            if (enumConstants != null && i2 >= 0 && i2 < enumConstants.length) {
                obj = enumConstants[i2];
            }
        } catch (ClassNotFoundException unused2) {
            Log.e("HwShadowEngine", "ShadowType class not found");
        }
        if (cls == null || obj == null) {
            return;
        }
        try {
            Constructor<?> constructor = Class.forName("huawei.android.widget.effect.engine.HwShadowEngine").getConstructor(ViewGroup.class, cls);
            constructor.setAccessible(true);
            this.f18687a = constructor.newInstance(viewGroup, obj);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused3) {
            Log.e("HwShadowEngine", "HwShadowEngine init failed");
        }
    }
}
