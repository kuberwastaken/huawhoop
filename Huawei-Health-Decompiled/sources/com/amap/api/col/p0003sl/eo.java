package com.amap.api.col.p0003sl;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class eo {
    private boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<a> f942a = new ArrayList<>();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        r4 = r3.b.getClass();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.b     // Catch: java.lang.Throwable -> Laf
            r1 = 1
            if (r0 != r1) goto L8
            monitor-exit(r8)
            return
        L8:
            r8.b = r1     // Catch: java.lang.Throwable -> Laf
            r0 = 0
            r2 = r0
        Lc:
            java.util.ArrayList<com.amap.api.col.3sl.eo$a> r3 = r8.f942a     // Catch: java.lang.Throwable -> Laf
            int r3 = r3.size()     // Catch: java.lang.Throwable -> Laf
            if (r2 >= r3) goto La8
            java.util.ArrayList<com.amap.api.col.3sl.eo$a> r3 = r8.f942a     // Catch: java.lang.Throwable -> Laf
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> Laf
            com.amap.api.col.3sl.eo$a r3 = (com.amap.api.col.3sl.eo.a) r3     // Catch: java.lang.Throwable -> Laf
            java.lang.Object r4 = com.amap.api.col.3sl.eo.a.a(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            if (r4 != 0) goto L24
            goto La4
        L24:
            java.lang.Object r4 = com.amap.api.col.3sl.eo.a.a(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            java.lang.Class r4 = r4.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            if (r4 != 0) goto L30
            goto La4
        L30:
            java.lang.String r5 = com.amap.api.col.3sl.eo.a.b(r3)     // Catch: java.lang.NoSuchMethodException -> L3d java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.Throwable -> Laf
            java.lang.Class[] r6 = com.amap.api.col.3sl.eo.a.c(r3)     // Catch: java.lang.NoSuchMethodException -> L3d java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.Throwable -> Laf
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r5, r6)     // Catch: java.lang.NoSuchMethodException -> L3d java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.Throwable -> Laf
            goto L7b
        L3d:
            java.lang.Class[] r5 = com.amap.api.col.3sl.eo.a.c(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            int r5 = r5.length     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            if (r5 <= 0) goto L7a
            java.lang.Class[] r5 = com.amap.api.col.3sl.eo.a.c(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            int r5 = r5.length     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            r6 = r0
        L4c:
            java.lang.Class[] r7 = com.amap.api.col.3sl.eo.a.c(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            int r7 = r7.length     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            if (r6 >= r7) goto L71
            java.lang.Class[] r7 = com.amap.api.col.3sl.eo.a.c(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            r7 = r7[r6]     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            java.lang.Class[] r7 = r7.getInterfaces()     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            int r7 = r7.length     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            if (r7 <= 0) goto L6e
            java.lang.Class[] r7 = com.amap.api.col.3sl.eo.a.c(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            r7 = r7[r6]     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            java.lang.Class[] r7 = r7.getInterfaces()     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            r7 = r7[r0]     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            r5[r6] = r7     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
        L6e:
            int r6 = r6 + 1
            goto L4c
        L71:
            java.lang.String r6 = com.amap.api.col.3sl.eo.a.b(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r5)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            goto L7b
        L7a:
            r4 = 0
        L7b:
            if (r4 == 0) goto La4
            r4.setAccessible(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            java.lang.Object r5 = com.amap.api.col.3sl.eo.a.a(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            java.lang.Object[] r3 = com.amap.api.col.3sl.eo.a.d(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            r4.invoke(r5, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L8c java.lang.IllegalArgumentException -> L91 java.lang.IllegalAccessException -> L96 java.lang.SecurityException -> L9b java.lang.NoSuchMethodException -> La0 java.lang.Throwable -> Laf
            goto La4
        L8c:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> Laf
            goto La4
        L91:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> Laf
            goto La4
        L96:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> Laf
            goto La4
        L9b:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> Laf
            goto La4
        La0:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> Laf
        La4:
            int r2 = r2 + 1
            goto Lc
        La8:
            java.util.ArrayList<com.amap.api.col.3sl.eo$a> r0 = r8.f942a     // Catch: java.lang.Throwable -> Laf
            r0.clear()     // Catch: java.lang.Throwable -> Laf
            monitor-exit(r8)
            return
        Laf:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.eo.a():void");
    }

    public final void a(Object obj, Object... objArr) {
        synchronized (this) {
            try {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.f942a.add(new a(obj, stackTrace[3].getMethodName(), objArr));
                }
            } catch (Throwable unused) {
            }
            this.b = false;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f943a;
        private Object b;
        private Class<?>[] c;
        private Object[] d;

        public a(Object obj, String str, Object... objArr) {
            this.b = obj;
            this.f943a = str;
            if (objArr == null || objArr.length <= 0) {
                return;
            }
            this.c = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                this.c[i] = objArr[i].getClass();
            }
            this.d = new Object[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                this.d[i2] = objArr[i2];
            }
        }
    }
}
