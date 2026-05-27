package com.huawei.hms.feature.dynamic.e;

import android.util.Log;
import dalvik.system.PathClassLoader;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends PathClassLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4700a = "a";

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                Log.w(f4700a, "Cannot find The class:" + str);
            }
        }
        return super.loadClass(str, z);
    }

    public a(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }
}
