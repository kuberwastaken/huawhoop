package com.huawei.secure.android.common.detect;

import com.huawei.secure.android.common.detect.utils.c;

/* JADX INFO: loaded from: classes7.dex */
public class SecurityDetect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8915a = "SecurityDetect";

    public static boolean idj() {
        try {
            return SD.idj();
        } catch (Throwable th) {
            c.b(f8915a, "idj: " + th.getMessage());
            return false;
        }
    }

    public static boolean iej() {
        try {
            return SD.iej();
        } catch (Throwable th) {
            c.b(f8915a, "iej: " + th.getMessage());
            return false;
        }
    }

    public static boolean irpj() {
        try {
            return SD.irpj();
        } catch (Throwable th) {
            c.b(f8915a, "irpj: " + th.getMessage());
            return false;
        }
    }
}
