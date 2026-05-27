package defpackage;

import com.huawei.hms.android.SystemUtils;

/* JADX INFO: loaded from: classes3.dex */
public class cai {
    private static final String c = cad.a(SystemUtils.PRODUCT_BRAND, "");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f557a = cad.a("ro.product.manufacturer", "");

    public static boolean d() {
        return "honor".equalsIgnoreCase(c) && "honor".equalsIgnoreCase(f557a);
    }

    public static boolean a() {
        return d() && e();
    }

    public static boolean e() {
        return cad.b("ro.build.version.sdk", 0) >= 31;
    }
}
