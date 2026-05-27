package com.huawei.hms.scankit.p;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes10.dex */
public abstract class n6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SecureRandom f6024a = new SecureRandom();

    public static int a(int i) {
        return f6024a.nextInt(i);
    }

    public static float a(float f) {
        return f6024a.nextFloat() * f;
    }
}
