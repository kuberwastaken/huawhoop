package com.huawei.haf.dynamic;

import android.content.Context;
import health.compact.a.ReflectionUtils;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class DynamicApplicationLoaders {
    private static final Set<DynamicDexClassLoader> e = Collections.newSetFromMap(new ConcurrentHashMap());

    private DynamicApplicationLoaders() {
    }

    public static ClassLoader e(ClassLoader classLoader) {
        return new DynamicDelegateClassloader(classLoader);
    }

    public static void c(ClassLoader classLoader, Context context) throws DynamicLoaderException {
        ClassLoader classLoaderE = e(classLoader);
        try {
            Object obj = ReflectionUtils.e(context, "mPackageInfo").get(context);
            if (obj != null) {
                ReflectionUtils.e(obj, "mClassLoader").set(obj, classLoaderE);
                Thread.currentThread().setContextClassLoader(classLoaderE);
            }
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            throw new DynamicLoaderException("reflect PackageInfo Classloader fail.", e2);
        }
    }

    public static boolean a(ClassLoader classLoader) {
        return classLoader instanceof DynamicDelegateClassloader;
    }

    public static void e(ClassLoader classLoader, ClassNotFoundInterceptor classNotFoundInterceptor) {
        if (a(classLoader)) {
            ((DynamicDelegateClassloader) classLoader).d(classNotFoundInterceptor);
        }
    }

    public static ClassLoader c(String str, List<String> list, File file, File file2, List<String> list2) {
        return new DynamicDexClassLoader(str, list, file, file2 == null ? null : file2.getAbsolutePath(), list2);
    }

    public static void c(ClassLoader classLoader) {
        if (classLoader instanceof DynamicDexClassLoader) {
            e.add((DynamicDexClassLoader) classLoader);
        }
    }

    public static void b(ClassLoader classLoader) {
        if (classLoader instanceof DynamicDexClassLoader) {
            e.remove(classLoader);
        }
    }

    public static ClassLoader a(String str) {
        for (DynamicDexClassLoader dynamicDexClassLoader : e) {
            if (str.equals(dynamicDexClassLoader.d())) {
                return dynamicDexClassLoader;
            }
        }
        return null;
    }

    static Class<?> e(String str, List<String> list) {
        for (DynamicDexClassLoader dynamicDexClassLoader : e) {
            if (list == null || list.contains(dynamicDexClassLoader.d())) {
                try {
                    return dynamicDexClassLoader.e(str);
                } catch (ClassNotFoundException unused) {
                    continue;
                }
            }
        }
        return null;
    }

    static URL a(String str, List<String> list) {
        URL urlA = null;
        for (DynamicDexClassLoader dynamicDexClassLoader : e) {
            if (list == null || list.contains(dynamicDexClassLoader.d())) {
                urlA = dynamicDexClassLoader.a(str);
                if (urlA != null) {
                    break;
                }
            }
        }
        return urlA;
    }

    static Enumeration<URL> c(String str, List<String> list) {
        Enumeration<URL> enumerationD = null;
        for (DynamicDexClassLoader dynamicDexClassLoader : e) {
            if (list == null || list.contains(dynamicDexClassLoader.d())) {
                enumerationD = dynamicDexClassLoader.d(str);
                if (enumerationD != null) {
                    break;
                }
            }
        }
        return enumerationD;
    }

    static String b(String str, List<String> list) {
        String strB = null;
        for (DynamicDexClassLoader dynamicDexClassLoader : e) {
            if (list == null || list.contains(dynamicDexClassLoader.d())) {
                strB = dynamicDexClassLoader.b(str);
                if (strB != null) {
                    break;
                }
            }
        }
        return strB;
    }
}
