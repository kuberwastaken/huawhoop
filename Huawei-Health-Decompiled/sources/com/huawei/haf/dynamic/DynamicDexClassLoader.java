package com.huawei.haf.dynamic;

import android.text.TextUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class DynamicDexClassLoader extends BaseDexClassLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f2146a;
    private final String c;

    DynamicDexClassLoader(String str, List<String> list, File file, String str2, List<String> list2) {
        super(list == null ? "" : TextUtils.join(File.pathSeparator, list), file, str2, DynamicDexClassLoader.class.getClassLoader());
        this.c = str;
        this.f2146a = list2 == null ? Collections.EMPTY_LIST : list2;
    }

    String d() {
        return this.c;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> clsE;
        try {
            return super.findClass(str);
        } catch (ClassNotFoundException e) {
            if (this.f2146a.isEmpty() || (clsE = DynamicApplicationLoaders.e(str, this.f2146a)) == null) {
                throw e;
            }
            return clsE;
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        String strFindLibrary = super.findLibrary(str);
        if (strFindLibrary == null && !this.f2146a.isEmpty()) {
            strFindLibrary = DynamicApplicationLoaders.b(str, this.f2146a);
        }
        if (strFindLibrary != null) {
            return strFindLibrary;
        }
        ClassLoader parent = getParent();
        return parent instanceof BaseDexClassLoader ? ((BaseDexClassLoader) parent).findLibrary(str) : strFindLibrary;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Enumeration<URL> findResources(String str) {
        Enumeration<URL> enumerationFindResources = super.findResources(str);
        return (enumerationFindResources != null || this.f2146a.isEmpty()) ? enumerationFindResources : DynamicApplicationLoaders.c(str, this.f2146a);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected URL findResource(String str) {
        URL urlFindResource = super.findResource(str);
        return (urlFindResource != null || this.f2146a.isEmpty()) ? urlFindResource : DynamicApplicationLoaders.a(str, this.f2146a);
    }

    URL a(String str) {
        return super.findResource(str);
    }

    Enumeration<URL> d(String str) {
        return super.findResources(str);
    }

    String b(String str) {
        return super.findLibrary(str);
    }

    Class<?> e(String str) throws ClassNotFoundException {
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        return clsFindLoadedClass != null ? clsFindLoadedClass : super.findClass(str);
    }
}
