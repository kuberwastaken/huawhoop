package com.huawei.updatesdk.b.a.b;

import android.content.pm.PackageInfo;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.huawei.updatesdk.a.a.d.h;
import com.huawei.updatesdk.b.a.b.a;
import com.huawei.updatesdk.b.a.b.c;
import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, com.huawei.updatesdk.b.a.b.a> f11328a;

    public List<String> a(PackageInfo packageInfo) {
        String str;
        if (packageInfo == null || (str = packageInfo.applicationInfo.sourceDir) == null) {
            return null;
        }
        long jLastModified = new File(str).lastModified();
        com.huawei.updatesdk.b.a.b.a aVar = a().f11328a.get(packageInfo.packageName);
        if (aVar == null || aVar.b() != jLastModified) {
            return b(packageInfo);
        }
        if (aVar.a() == null) {
            return null;
        }
        return aVar.a().a();
    }

    private static ArrayList<String> b(PackageInfo packageInfo) {
        ArraySet<String> arraySet;
        com.huawei.updatesdk.b.a.b.a aVar = new com.huawei.updatesdk.b.a.b.a();
        aVar.a(packageInfo.packageName);
        File file = new File(packageInfo.applicationInfo.sourceDir);
        if (!file.exists()) {
            return null;
        }
        aVar.a(file.lastModified());
        c.a aVarA = c.a(file);
        ArrayMap<String, ArraySet<PublicKey>> arrayMap = aVarA.f11330a;
        if (arrayMap == null || arrayMap.isEmpty() || (arraySet = aVarA.b) == null || arraySet.isEmpty()) {
            a(aVar);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, ArraySet<PublicKey>> entry : aVarA.f11330a.entrySet()) {
            if (aVarA.b.contains(entry.getKey())) {
                Iterator<PublicKey> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(h.a(it.next().getEncoded()));
                }
            }
        }
        a.C0295a c0295a = new a.C0295a();
        c0295a.a(arrayList);
        aVar.a(c0295a);
        a(aVar);
        return arrayList;
    }

    private static void a(com.huawei.updatesdk.b.a.b.a aVar) {
        a().f11328a.put(aVar.c(), aVar);
    }

    /* JADX INFO: renamed from: com.huawei.updatesdk.b.a.b.b$b, reason: collision with other inner class name */
    static class C0296b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f11329a = new b();
    }

    public static b a() {
        return C0296b.f11329a;
    }

    private b() {
        this.f11328a = new HashMap();
    }
}
