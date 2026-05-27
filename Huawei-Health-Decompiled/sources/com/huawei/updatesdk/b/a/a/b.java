package com.huawei.updatesdk.b.a.a;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.d.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, com.huawei.updatesdk.b.a.a.a> f11324a;

    public String a(PackageInfo packageInfo) throws Throwable {
        if (packageInfo == null || packageInfo.packageName == null || TextUtils.isEmpty(packageInfo.applicationInfo.sourceDir)) {
            return null;
        }
        com.huawei.updatesdk.b.a.a.a aVar = this.f11324a.get(packageInfo.packageName);
        if (aVar != null && aVar.b() == packageInfo.lastUpdateTime && aVar.c() == packageInfo.versionCode) {
            return aVar.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(packageInfo.lastUpdateTime);
        sb.append(packageInfo.versionCode);
        sb.append(packageInfo.packageName);
        String str = "packagekey" + packageInfo.packageName;
        String str2 = "fileshakey" + packageInfo.packageName;
        boolean z = !TextUtils.equals(sb.toString(), com.huawei.updatesdk.b.b.a.d().a(str));
        if (z) {
            com.huawei.updatesdk.b.b.a.d().a(str, sb.toString());
        }
        String strA = com.huawei.updatesdk.b.b.a.d().a(str2);
        if (TextUtils.isEmpty(strA) || z) {
            strA = d.a(packageInfo.applicationInfo.sourceDir, "SHA-256");
            com.huawei.updatesdk.b.b.a.d().a(str2, strA);
        }
        com.huawei.updatesdk.b.a.a.a aVar2 = new com.huawei.updatesdk.b.a.a.a();
        aVar2.a(strA);
        aVar2.a(packageInfo.lastUpdateTime);
        aVar2.a(packageInfo.versionCode);
        this.f11324a.put(packageInfo.packageName, aVar2);
        return strA;
    }

    /* JADX INFO: renamed from: com.huawei.updatesdk.b.a.a.b$b, reason: collision with other inner class name */
    static class C0294b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f11325a = new b();
    }

    public static b a() {
        return C0294b.f11325a;
    }

    private b() {
        this.f11324a = new HashMap();
    }
}
