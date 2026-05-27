package defpackage;

import com.huawei.appgallery.marketinstallerservice.a.c;
import com.huawei.appgallery.marketinstallerservice.b.a.a.a;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class baw {
    private static Map<Class, Object> b;

    public static boolean a(Class cls, a aVar) {
        String str;
        if (cls == null) {
            str = "class is null.";
        } else if (aVar == null) {
            str = "Impl is null.";
        } else {
            if (cls.isAssignableFrom(aVar.getClass())) {
                b.put(cls, aVar);
                return true;
            }
            str = "Impl is not extends right class:" + cls + Constants.LINK + aVar.getClass();
        }
        bbf.c("MarketInstallApiRegiste", str);
        return false;
    }

    public static Object a(Class cls) {
        if (cls == null) {
            bbf.c("MarketInstallApiRegiste", "apiClass can not be null");
            return null;
        }
        Object obj = b.get(cls);
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return null;
        }
        return obj;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        b = concurrentHashMap;
        if (concurrentHashMap.size() <= 0) {
            a(c.class, new bao());
        }
    }
}
