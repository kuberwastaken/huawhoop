package com.huawei.hianalytics.framework;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f4007a;

    public static l a() {
        if (f4007a == null) {
            synchronized (l.class) {
                if (f4007a == null) {
                    f4007a = new l();
                }
            }
        }
        return f4007a;
    }
}
