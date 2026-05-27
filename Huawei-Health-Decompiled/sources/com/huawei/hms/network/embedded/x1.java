package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.SecurityRandomHelper;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;

/* JADX INFO: loaded from: classes10.dex */
public class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5752a = "KeyGen";
    public static final String b = "RestClient_8.0.1.316_apple";
    public static final int c = 16;

    public static String b(String str) {
        return AesGcmKS.encrypt(b, str);
    }

    public static byte[] a() {
        return SecurityRandomHelper.getInstance().generateSecureRandom(16);
    }

    public static String a(String str) {
        return AesGcmKS.decrypt(b, str);
    }
}
