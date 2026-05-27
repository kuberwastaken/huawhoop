package com.huawei.wisesecurity.ucs.credential.util;

import defpackage.wxc;

/* JADX INFO: loaded from: classes11.dex */
public class SecureRandomUtil {
    private static final String TAG = "SecureRandomUtil";

    public static byte[] generateRandomBytes(int i) {
        return wxc.a(i);
    }
}
