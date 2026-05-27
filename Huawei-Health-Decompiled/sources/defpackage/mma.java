package defpackage;

import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class mma {
    public static void a(Window window) {
        bXQ_(window, "addHwFlags");
    }

    public static void b(Window window) {
        bXQ_(window, "clearHwFlags");
    }

    private static void bXQ_(Window window, String str) {
        try {
            mly.a("ScreenShotUtils", "invokeScreenShot flags==" + str, true);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            Object objNewInstance = cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes);
            Method method = cls.getMethod(str, Integer.TYPE);
            method.invoke(objNewInstance, 4096);
            method.invoke(objNewInstance, 8192);
            window.clearFlags(0);
        } catch (ClassNotFoundException e) {
            mly.b("ScreenShotUtils", "ClassNotFoundException--" + e.getClass().getSimpleName(), true);
        } catch (IllegalAccessException e2) {
            mly.b("ScreenShotUtils", "IllegalAccessException--" + e2.getClass().getSimpleName(), true);
        } catch (InstantiationException e3) {
            mly.b("ScreenShotUtils", "InstantiationException--" + e3.getClass().getSimpleName(), true);
        } catch (NoClassDefFoundError e4) {
            mly.b("ScreenShotUtils", "NoClassDefFoundError--" + e4.getClass().getSimpleName(), true);
        } catch (NoSuchMethodException e5) {
            mly.b("ScreenShotUtils", "NoSuchMethodException--" + e5.getClass().getSimpleName(), true);
        } catch (InvocationTargetException e6) {
            mly.b("ScreenShotUtils", "InvocationTargetException--" + e6.getClass().getSimpleName(), true);
        } catch (Exception e7) {
            mly.b("ScreenShotUtils", "Exception--" + e7.getClass().getSimpleName(), true);
        }
    }
}
