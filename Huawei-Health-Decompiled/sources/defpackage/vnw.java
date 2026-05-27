package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes8.dex */
public class vnw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f18684a;
    private static final Method ab;
    private static final Method ac;
    private static final Method ad;
    private static final Method b;
    private static Object c;
    private static final Method d;
    private static final Method e;
    private static final Method f;
    private static final Method g;
    private static final Method h;
    private static vnw i = new vnw();
    private static final Method j;
    private static final Method k;
    private static final Method l;
    private static final Method m;
    private static final Method n;
    private static final Method o;
    private static final Method p;
    private static final Method q;
    private static final Method r;
    private static final Method s;
    private static final Method t;
    private static final Method u;
    private static final Method v;
    private static final Method w;
    private static final Method x;
    private static final Method y;
    private static final Method z;

    static {
        Class<?> cls;
        if (Build.VERSION.SDK_INT < 28) {
            g = null;
            f = null;
            h = null;
            j = null;
            l = null;
            k = null;
            n = null;
            o = null;
            m = null;
            r = null;
            t = null;
            q = null;
            s = null;
            p = null;
            w = null;
            x = null;
            v = null;
            y = null;
            u = null;
            ab = null;
            ad = null;
            ac = null;
            z = null;
            d = null;
            f18684a = null;
            b = null;
            e = null;
            return;
        }
        try {
            cls = Class.forName("huawei.android.widget.effect.engine.HwBlurEngine$BlurType");
        } catch (ClassNotFoundException unused) {
            Log.e("HwBlurEngine", "BlurType class not found");
            cls = null;
        }
        g = vnl.e("getInstance", null, "huawei.android.widget.effect.engine.HwBlurEngine");
        f = vnl.e("getInstance", new Class[]{View.class, cls}, "huawei.android.widget.effect.engine.HwBlurEngine");
        h = vnl.e("isEnable", null, "huawei.android.widget.effect.engine.HwBlurEngine");
        Class cls2 = Boolean.TYPE;
        j = vnl.e("setGlobalEnable", new Class[]{cls2}, "huawei.android.widget.effect.engine.HwBlurEngine");
        l = vnl.e("setEnable", new Class[]{cls2}, "huawei.android.widget.effect.engine.HwBlurEngine");
        k = vnl.e("onAttachedToWindow", null, "huawei.android.widget.effect.engine.HwBlurEngine");
        n = vnl.e("onDetachedFromWindow", null, "huawei.android.widget.effect.engine.HwBlurEngine");
        o = vnl.e("draw", new Class[]{Canvas.class}, "huawei.android.widget.effect.engine.HwBlurEngine");
        m = vnl.e("draw", new Class[]{Canvas.class, View.class}, "huawei.android.widget.effect.engine.HwBlurEngine");
        r = vnl.e("setBlurEnable", new Class[]{cls2}, "huawei.android.widget.effect.engine.HwBlurEngine");
        t = vnl.e("isBlurEnable", null, "huawei.android.widget.effect.engine.HwBlurEngine");
        q = vnl.e("isShowHwBlur", null, "huawei.android.widget.effect.engine.HwBlurEngine");
        s = vnl.e("isShowHwBlur", new Class[]{View.class}, "huawei.android.widget.effect.engine.HwBlurEngine");
        p = vnl.e("onWindowVisibilityChanged", new Class[]{View.class, cls2, cls2}, "huawei.android.widget.effect.engine.HwBlurEngine");
        w = vnl.e("onWindowVisibilityChanged", new Class[]{View.class, cls2}, "huawei.android.widget.effect.engine.HwBlurEngine");
        x = vnl.e("onWindowFocusChanged", new Class[]{View.class, cls2, cls2}, "huawei.android.widget.effect.engine.HwBlurEngine");
        Class cls3 = Integer.TYPE;
        v = vnl.e("blur", new Class[]{View.class, cls3, cls3}, "huawei.android.widget.effect.engine.HwBlurEngine");
        y = vnl.e("blur", new Class[]{Bitmap.class, cls3, cls3}, "huawei.android.widget.effect.engine.HwBlurEngine");
        u = vnl.e("addBlurTargetView", new Class[]{View.class, cls}, "huawei.android.widget.effect.engine.HwBlurEngine");
        ab = vnl.e("removeBlurTargetView", new Class[]{View.class}, "huawei.android.widget.effect.engine.HwBlurEngine");
        ad = vnl.e("isDrawingViewSelf", null, "huawei.android.widget.effect.engine.HwBlurEngine");
        ac = vnl.e("setTargetViewCornerRadius", new Class[]{View.class, cls3}, "huawei.android.widget.effect.engine.HwBlurEngine");
        z = vnl.e("setTargetViewBlurEnable", new Class[]{View.class, cls2}, "huawei.android.widget.effect.engine.HwBlurEngine");
        d = vnl.e("setTargetViewOverlayColor", new Class[]{View.class, cls3}, "huawei.android.widget.effect.engine.HwBlurEngine");
        f18684a = vnl.e("isShowBlur", new Class[]{Context.class}, "huawei.android.widget.effect.engine.HwBlurEngine");
        b = vnl.e("isThemeSupportedBlurEffect", new Class[]{Context.class}, "huawei.android.widget.effect.engine.HwBlurEngine");
        e = vnl.e("isSettingEnabledBlurEffect", new Class[]{Context.class}, "huawei.android.widget.effect.engine.HwBlurEngine");
    }

    private static Object d(int i2) {
        try {
            Object[] enumConstants = Class.forName("huawei.android.widget.effect.engine.HwBlurEngine$BlurType").getEnumConstants();
            int i3 = i2 - 1;
            if (enumConstants == null || i3 < 0 || i3 >= enumConstants.length) {
                return null;
            }
            return enumConstants[i3];
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public boolean d() {
        Method method;
        Object obj = c;
        if (obj == null || (method = q) == null) {
            return false;
        }
        return a(vnl.b(obj, method));
    }

    public void eAX_(View view, int i2) {
        Method method;
        if (c == null || (method = u) == null) {
            return;
        }
        vnl.b(c, method, new Object[]{view, d(i2)});
    }

    public void eBa_(View view) {
        Method method;
        Object obj = c;
        if (obj == null || (method = ab) == null) {
            return;
        }
        vnl.b(obj, method, new Object[]{view});
    }

    public void eBb_(View view, boolean z2) {
        Method method;
        Object obj = c;
        if (obj == null || (method = z) == null) {
            return;
        }
        vnl.b(obj, method, new Object[]{view, Boolean.valueOf(z2)});
    }

    public void eBc_(View view, int i2) {
        Method method;
        Object obj = c;
        if (obj == null || (method = d) == null) {
            return;
        }
        vnl.b(obj, method, new Object[]{view, Integer.valueOf(i2)});
    }

    public void eAY_(Canvas canvas, View view) {
        Method method;
        Object obj = c;
        if (obj == null || (method = m) == null) {
            return;
        }
        vnl.b(obj, method, new Object[]{canvas, view});
    }

    public boolean eAZ_(View view) {
        Method method;
        Object obj = c;
        if (obj == null || (method = s) == null) {
            return false;
        }
        return a(vnl.b(obj, method, new Object[]{view}));
    }

    private static boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static vnw b() {
        vnw vnwVar;
        synchronized (vnw.class) {
            Method method = g;
            if (method != null && c == null) {
                c = vnl.d(method);
            }
            vnwVar = i;
        }
        return vnwVar;
    }
}
