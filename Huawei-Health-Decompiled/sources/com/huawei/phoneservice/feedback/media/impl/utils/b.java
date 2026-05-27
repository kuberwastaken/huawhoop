package com.huawei.phoneservice.feedback.media.impl.utils;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    private static String c;

    public static boolean b() {
        synchronized (b.class) {
            if (c == null) {
                c = d.b("ro.build.characteristics");
            }
        }
        return "tablet".equals(c) || "car".equals(c);
    }

    private b() {
    }
}
