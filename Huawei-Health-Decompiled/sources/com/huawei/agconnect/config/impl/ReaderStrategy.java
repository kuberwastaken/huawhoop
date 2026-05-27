package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.AesDecrypt;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
public class ReaderStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AesDecrypt f1796a;

    public String a(String str, String str2) {
        return this.f1796a.decrypt(str, str2);
    }

    private String a(Context context, String str) {
        String strA = ResourcesUtils.a(context, str, "agc_plugin_", "crypto");
        if (strA == null) {
            return null;
        }
        try {
            return new String(Hex.decodeHexString(strA), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            Log.e("ReaderStrategy", "UnsupportedEncodingException" + e.getMessage());
            return null;
        }
    }

    public ReaderStrategy(Context context, String str) {
        this.f1796a = !TextUtils.isEmpty(a(context, str)) ? new FlexibleDecrypt(context, str) : new FixedDecrypt(context, str);
    }
}
