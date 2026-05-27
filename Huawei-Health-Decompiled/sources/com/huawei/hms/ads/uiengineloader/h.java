package com.huawei.hms.ads.uiengineloader;

import dalvik.system.DexClassLoader;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends DexClassLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4569a = "h";

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                af.c(f4569a, "Cannot find The class:".concat(String.valueOf(str)));
            }
        }
        return super.loadClass(str, z);
    }

    public h(String str, String str2, ClassLoader classLoader) {
        super(str, str2, null, classLoader);
    }
}
