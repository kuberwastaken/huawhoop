package defpackage;

import android.content.Context;
import android.os.Binder;
import com.huawei.hidatamanager.util.LogUtils;
import health.compact.a.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public class kif {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f14690a = new Object();
    private static final List<String> b;
    private static final String c = "PackageNameUtil";
    private static Map<Integer, String> e;

    static {
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        e = new ConcurrentHashMap();
        arrayList.add("com.huawei.health.h5.cycle-calendar");
        arrayList.add("com.huawei.health.h5.ecgce");
        arrayList.add("com.huawei.health.h5.ppg");
        arrayList.add("com.huawei.health.h5.sleeping-music");
        arrayList.add("com.huawei.health.h5.vascular-health");
        arrayList.add("com.huawei.health.h5.sleepdetection");
        arrayList.add("com.huawei.audioaccessorymanager");
        arrayList.add("com.huawei.study.hiresearch");
    }

    public static void d(Context context, String str) {
        String str2 = c;
        LogUtils.i(str2, "saveCallingPackageName enter");
        if (context == null) {
            LogUtils.w(str2, "saveCallingPackageName fail: context is null");
            return;
        }
        if (str == null) {
            LogUtils.w(str2, "saveCallingPackageName fail: packageName is null");
            return;
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (packagesForUid != null) {
            for (String str3 : packagesForUid) {
                if (str3.equals(str)) {
                    e.put(Integer.valueOf(Binder.getCallingPid()), str);
                    LogUtils.i(c, "saveCallingPackageName successed");
                    return;
                }
            }
        }
        LogUtils.w(c, "saveCallingPackageName fail");
    }

    public static String b(Context context) {
        String str = c;
        LogUtils.i(str, "getCallingPackageName enter");
        if (context == null) {
            LogUtils.w(str, "getCallingPackageName fail: context is null");
            return "";
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (packagesForUid == null) {
            return "";
        }
        if (packagesForUid.length == 1) {
            return packagesForUid[0];
        }
        String str2 = e.get(Integer.valueOf(Binder.getCallingPid()));
        for (String str3 : packagesForUid) {
            if (str3.equals(str2)) {
                return str3;
            }
        }
        return "";
    }

    public static String c(String str, boolean z) {
        return "com.huawei.health.h5.ecg".equals(str) ? "com.huawei.health.ecg.collection" : (str.startsWith("com.huawei.health.device") || b.contains(str) || z) ? "com.huawei.health" : str;
    }

    public static String d(String str) {
        return (!StringUtils.f(str) && b.contains(str)) ? "com.huawei.health" : str;
    }
}
