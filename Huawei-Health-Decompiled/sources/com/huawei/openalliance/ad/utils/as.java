package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.hq;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public abstract class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7876a = "as";

    public static String a(String str, String str2) {
        String str3;
        String str4;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str.getBytes("UTF-8"), "HmacSHA256"));
            return aq.a(mac.doFinal(str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            str3 = f7876a;
            str4 = "fail to cipher UnsupportedEncodingException";
            hq.d(str3, str4);
            return null;
        } catch (InvalidKeyException unused2) {
            str3 = f7876a;
            str4 = "fail to cipher InvalidKeyException";
            hq.d(str3, str4);
            return null;
        } catch (NoSuchAlgorithmException unused3) {
            str3 = f7876a;
            str4 = "fail to cipher NoSuchAlgorithmException";
            hq.d(str3, str4);
            return null;
        }
    }
}
