package defpackage;

import com.huawei.openalliance.ad.constant.JsbMapKeyNames;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes8.dex */
public class wxb {
    private static volatile wxb d;

    private wxb() throws wws {
        b();
    }

    private void b() throws wws {
        try {
            Method method = Class.forName("com.huawei.security.keystore.HwUniversalKeyStoreProvider").getMethod(JsbMapKeyNames.H5_TEXT_DOWNLOAD_INSTALL, new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new wws("install HwKeyStore fail:" + e.getMessage());
        }
    }

    public static wxb d() throws wws {
        if (d == null) {
            synchronized (wxb.class) {
                if (d == null) {
                    d = new wxb();
                }
            }
        }
        return d;
    }
}
