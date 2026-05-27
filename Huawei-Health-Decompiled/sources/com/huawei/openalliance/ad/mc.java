package com.huawei.openalliance.ad;

/* JADX INFO: loaded from: classes6.dex */
public class mc {
    public static boolean a(String str) {
        try {
            Class.forName(str);
            hq.b("OMSDKCheckUtil", str);
            return true;
        } catch (ClassNotFoundException unused) {
            hq.b("OMSDKCheckUtil", str + " is not avaliable");
            return false;
        }
    }
}
