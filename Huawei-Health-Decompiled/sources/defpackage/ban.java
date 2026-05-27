package defpackage;

import android.text.TextUtils;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ban {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, InstallCallback> f394a = new ConcurrentHashMap();
    private static Map<String, MarketInfo> e = new ConcurrentHashMap();

    public static void a(String str) {
        if (str == null) {
            return;
        }
        e.remove(str);
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f394a.remove(str);
    }

    public static MarketInfo e(String str) {
        if (str == null) {
            return null;
        }
        return e.get(str);
    }

    public static void b(String str, MarketInfo marketInfo) {
        if (str == null) {
            return;
        }
        e.put(str, marketInfo);
    }

    public static String a(InstallCallback installCallback) {
        if (installCallback == null) {
            return "";
        }
        String string = UUID.randomUUID().toString();
        f394a.put(string, installCallback);
        return string;
    }

    public static InstallCallback c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f394a.get(str);
    }
}
