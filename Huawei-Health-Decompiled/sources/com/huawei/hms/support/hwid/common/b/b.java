package com.huawei.hms.support.hwid.common.b;

import android.text.TextUtils;
import com.huawei.hms.support.hwid.common.e.g;
import com.huawei.secure.android.common.encrypt.rsa.RSAEncrypt;
import com.huawei.secure.android.common.util.SafeBase64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.eclipse.californium.elements.util.JceNames;

/* JADX INFO: loaded from: classes10.dex */
public class b {
    public static PublicKey a(String str) throws Exception {
        return KeyFactory.getInstance(JceNames.RSA).generatePublic(new X509EncodedKeySpec(a.a(str)));
    }

    public static String a(String str, String str2) {
        byte[] bArrDecode;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String strEncrypt = RSAEncrypt.encrypt(str, a(str2));
            return (TextUtils.isEmpty(strEncrypt) || (bArrDecode = SafeBase64.decode(strEncrypt, 0)) == null) ? "" : a.a(bArrDecode);
        } catch (Exception unused) {
            g.b("HwIdEncrypter", "rsaEncrpter Exception");
            return "";
        }
    }
}
