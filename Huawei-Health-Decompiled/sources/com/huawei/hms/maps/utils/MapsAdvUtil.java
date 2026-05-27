package com.huawei.hms.maps.utils;

/* JADX INFO: loaded from: classes5.dex */
public class MapsAdvUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5221a = "";

    public static void setAccessToken(String str) {
        f5221a = str;
    }

    public static String getAccessToken() {
        return f5221a;
    }

    public static boolean containsMapsBasic() {
        return a("com.huawei.hms.maps.provider.inhuawei.MapViewDelegate");
    }

    public static boolean containsMapsAdvance() {
        return a("com.huawei.hms.maps.HuaweiMapEx");
    }

    private static boolean a(String str) {
        try {
            Class.forName(str, false, MapsAdvUtil.class.getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            LogM.d("MapsAdvUtil", "The class:" + str + " not found.");
            return false;
        }
    }
}
