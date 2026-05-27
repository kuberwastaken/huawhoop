package com.huawei.hms.network.file.core.util;

import android.os.Process;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class e {
    private static volatile e b;
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g f5828a = new g(Process.myPid(), new SecureRandom().nextInt(16));

    public long a() {
        return this.f5828a.a();
    }

    public static e b() {
        if (b != null) {
            return b;
        }
        synchronized (c) {
            if (b == null) {
                b = new e();
            }
        }
        return b;
    }

    private e() {
    }
}
