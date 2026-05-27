package com.huawei.haf.dynamic;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class DynamicDelegateClassloader extends PathClassLoader {
    private ClassNotFoundInterceptor b;
    private final ClassLoader e;

    DynamicDelegateClassloader(ClassLoader classLoader) {
        super("", classLoader);
        this.e = classLoader;
    }

    void d(ClassNotFoundInterceptor classNotFoundInterceptor) {
        this.b = classNotFoundInterceptor;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> clsFindClass;
        try {
            return this.e.loadClass(str);
        } catch (ClassNotFoundException e) {
            ClassNotFoundInterceptor classNotFoundInterceptor = this.b;
            if (classNotFoundInterceptor == null || (clsFindClass = classNotFoundInterceptor.findClass(str)) == null) {
                throw e;
            }
            return clsFindClass;
        }
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        return this.e.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) throws IOException {
        return this.e.getResources(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected URL findResource(String str) {
        URL urlFindResource = super.findResource(str);
        return urlFindResource == null ? DynamicApplicationLoaders.a(str, null) : urlFindResource;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Enumeration<URL> findResources(String str) {
        Enumeration<URL> enumerationFindResources = super.findResources(str);
        return enumerationFindResources == null ? DynamicApplicationLoaders.c(str, (List<String>) null) : enumerationFindResources;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        return findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        ClassLoader classLoader = this.e;
        String strFindLibrary = classLoader instanceof BaseDexClassLoader ? ((BaseDexClassLoader) classLoader).findLibrary(str) : null;
        return strFindLibrary == null ? DynamicApplicationLoaders.b(str, null) : strFindLibrary;
    }
}
