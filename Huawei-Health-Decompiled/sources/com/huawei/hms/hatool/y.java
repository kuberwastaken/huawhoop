package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class y {
    private static y b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Map<String, p0> f4808a = new HashMap();

    public p0 a(String str, long j) {
        p0 p0VarA = a(str);
        p0VarA.a(j);
        return p0VarA;
    }

    private static void b() {
        synchronized (y.class) {
            if (b == null) {
                b = new y();
            }
        }
    }

    public static y a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private p0 a(String str) {
        if (!this.f4808a.containsKey(str)) {
            this.f4808a.put(str, new p0());
        }
        return this.f4808a.get(str);
    }

    private y() {
    }
}
