package io.jsonwebtoken.lang;

import defpackage.xfo;
import java.io.InputStream;
import java.lang.reflect.GenericDeclaration;
import java.net.URL;

/* JADX INFO: loaded from: classes11.dex */
public final class Classes {
    private static final ClassLoaderAccessor b = new ExceptionIgnoringAccessor() { // from class: io.jsonwebtoken.lang.Classes.3
        @Override // io.jsonwebtoken.lang.Classes.ExceptionIgnoringAccessor
        protected ClassLoader doGetClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ClassLoaderAccessor f14204a = new ExceptionIgnoringAccessor() { // from class: io.jsonwebtoken.lang.Classes.1
        @Override // io.jsonwebtoken.lang.Classes.ExceptionIgnoringAccessor
        protected ClassLoader doGetClassLoader() {
            return Classes.class.getClassLoader();
        }
    };
    private static final ClassLoaderAccessor e = new ExceptionIgnoringAccessor() { // from class: io.jsonwebtoken.lang.Classes.4
        @Override // io.jsonwebtoken.lang.Classes.ExceptionIgnoringAccessor
        protected ClassLoader doGetClassLoader() {
            return ClassLoader.getSystemClassLoader();
        }
    };

    interface ClassLoaderAccessor {
        URL getResource(String str);

        InputStream getResourceStream(String str);

        Class<?> loadClass(String str);
    }

    private Classes() {
    }

    public static <T> Class<T> d(String str) throws xfo {
        GenericDeclaration genericDeclarationLoadClass = b.loadClass(str);
        if (genericDeclarationLoadClass == null) {
            genericDeclarationLoadClass = (Class<T>) f14204a.loadClass(str);
        }
        if (genericDeclarationLoadClass == null) {
            genericDeclarationLoadClass = (Class<T>) e.loadClass(str);
        }
        if (genericDeclarationLoadClass != null) {
            return (Class<T>) genericDeclarationLoadClass;
        }
        String str2 = "Unable to load class named [" + str + "] from the thread context, current, or system/application ClassLoaders.  All heuristics have been exhausted.  Class could not be found.";
        if (str != null && str.startsWith("io.jsonwebtoken.impl")) {
            str2 = str2 + "  Have you remembered to include the jjwt-impl.jar in your runtime classpath?";
        }
        throw new xfo(str2);
    }

    static abstract class ExceptionIgnoringAccessor implements ClassLoaderAccessor {
        protected abstract ClassLoader doGetClassLoader() throws Throwable;

        private ExceptionIgnoringAccessor() {
        }

        @Override // io.jsonwebtoken.lang.Classes.ClassLoaderAccessor
        public Class<?> loadClass(String str) {
            ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                try {
                    return classLoader.loadClass(str);
                } catch (ClassNotFoundException unused) {
                }
            }
            return null;
        }

        @Override // io.jsonwebtoken.lang.Classes.ClassLoaderAccessor
        public URL getResource(String str) {
            ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                return classLoader.getResource(str);
            }
            return null;
        }

        @Override // io.jsonwebtoken.lang.Classes.ClassLoaderAccessor
        public InputStream getResourceStream(String str) {
            ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                return classLoader.getResourceAsStream(str);
            }
            return null;
        }

        protected final ClassLoader getClassLoader() {
            try {
                return doGetClassLoader();
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
