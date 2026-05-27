package defpackage;

import android.view.View;
import com.huawei.skinner.theme.ThemeServiceInterceptor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class oul {
    private static oul c = new oul();
    private final Map<Class<? extends View>, ThemeServiceInterceptor> b = new HashMap();

    private oul() {
    }

    public static oul a() {
        return c;
    }

    public ThemeServiceInterceptor b(Class<? extends View> cls) {
        ThemeServiceInterceptor themeServiceInterceptor = this.b.get(cls);
        if (themeServiceInterceptor != null) {
            return themeServiceInterceptor;
        }
        Class<? extends View> superclass = cls.getSuperclass();
        if (superclass != Object.class) {
            return b(superclass);
        }
        return null;
    }
}
