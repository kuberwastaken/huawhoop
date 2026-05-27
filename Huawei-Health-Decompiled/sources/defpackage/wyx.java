package defpackage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class wyx<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<wyy> f18983a;
    private final String d;

    private void a(Class<?> cls) throws www {
        if (cls == null) {
            return;
        }
        a(cls.getSuperclass());
        for (Field field : cls.getDeclaredFields()) {
            wyy wyyVar = new wyy(this.d, field);
            if (wyyVar.b()) {
                this.f18983a.add(wyyVar);
            }
        }
    }

    public wyx(Class<T> cls) throws www {
        this(null, cls);
    }

    public wyx(String str, Class<?> cls) throws www {
        String simpleName;
        this.f18983a = new ArrayList();
        if (str != null) {
            simpleName = str + "." + cls.getSimpleName();
        } else {
            simpleName = cls.getSimpleName();
        }
        this.d = simpleName;
        a(cls);
    }

    public boolean e() {
        return this.f18983a.size() > 0;
    }

    public void e(T t) throws www {
        if (t == null) {
            return;
        }
        for (wyy wyyVar : this.f18983a) {
            if (wyyVar.b()) {
                wyyVar.a(t);
            }
        }
    }
}
