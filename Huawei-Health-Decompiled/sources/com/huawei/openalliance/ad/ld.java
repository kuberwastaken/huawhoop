package com.huawei.openalliance.ad;

import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public interface ld<R> {
    long a();

    R a(int i, InputStream inputStream, long j, kq kqVar);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final le f7410a = new le();

        public static <RD> ld<RD> a(Class<RD> cls) {
            if (cls == Integer.TYPE || cls == Integer.class) {
                return new la();
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return new ky();
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return new kx();
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return new lc();
            }
            if (cls == String.class) {
                return f7410a;
            }
            if (!cls.isPrimitive()) {
                return new lb(cls);
            }
            throw new IllegalArgumentException("Response type: " + cls + " not supported!");
        }
    }
}
