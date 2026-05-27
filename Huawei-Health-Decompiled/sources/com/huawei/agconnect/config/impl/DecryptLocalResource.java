package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes3.dex */
public class DecryptLocalResource implements IDecrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SecretKey f1792a;
    private final AesParam b;
    private boolean c = false;

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        StringBuilder sb;
        if (!this.c) {
            a();
        }
        if (this.f1792a == null || TextUtils.isEmpty(str)) {
            sb = new StringBuilder("decrypt exception: secretKey = ");
            sb.append(this.f1792a);
            sb.append("raw = ");
        } else {
            try {
                return new String(Keys.a(this.f1792a, Hex.decodeHexString(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e) {
                sb = new StringBuilder("decrypt exception:");
                str = e.getMessage();
            }
        }
        sb.append(str);
        Log.e("AGC_LocalResource", sb.toString());
        return str2;
    }

    private void a() {
        try {
            this.f1792a = Keys.a(this.b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.e("AGC_LocalResource", "Exception when reading the 'K&I' for 'Config'. error is " + e.getMessage());
            this.f1792a = null;
        }
        this.c = true;
    }

    public DecryptLocalResource(AesParam aesParam) {
        this.b = aesParam;
    }
}
