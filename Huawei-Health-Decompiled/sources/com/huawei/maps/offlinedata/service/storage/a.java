package com.huawei.maps.offlinedata.service.storage;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import com.huawei.maps.offlinedata.utils.g;
import com.huawei.maps.offlinedata.utils.j;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6762a;

    private a() {
    }

    public static a a() {
        if (f6762a == null) {
            synchronized (a.class) {
                if (f6762a == null) {
                    f6762a = new a();
                }
            }
        }
        return f6762a;
    }

    public long b() {
        try {
            String strF = f();
            if (TextUtils.isEmpty(strF)) {
                g.d("StorageService", "getAvailableStorageSize failed , basePath exception.");
                return -1L;
            }
            StatFs statFs = new StatFs(strF);
            return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / 1048576;
        } catch (IllegalArgumentException unused) {
            g.d("StorageService", "getAvailableStorageSize failed , IllegalArgumentException");
            return -1L;
        }
    }

    public String c() {
        String strF = f();
        if (TextUtils.isEmpty(strF)) {
            g.d("StorageService", "getOfflineDataDir failed , basePath exception.");
            return null;
        }
        return strF + File.separator + "offlineData" + File.separator;
    }

    public String d() {
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        return strC + "download" + File.separator;
    }

    public String e() {
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        return strC + "decompress" + File.separator;
    }

    private String f() {
        Context contextA = com.huawei.maps.offlinedata.utils.a.a();
        String canonicalPath = null;
        if (contextA == null) {
            g.d("StorageService", "getBaseDir failed , context is null.");
            return null;
        }
        String strA = j.a("offline_storage_file_path", "", contextA);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        try {
            File filesDir = contextA.getFilesDir();
            if (filesDir != null) {
                canonicalPath = filesDir.getCanonicalPath();
            }
        } catch (IOException unused) {
            g.d("StorageService", "getExternalFileDir failed.");
        }
        if (!TextUtils.isEmpty(canonicalPath)) {
            j.b("offline_storage_file_path", canonicalPath, contextA);
        }
        return canonicalPath;
    }
}
