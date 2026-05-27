package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.config.ConfigReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
class SecurityResourcesReader implements ConfigReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f1797a = new ConcurrentHashMap();
    private final ReaderStrategy b;

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        String str3 = this.f1797a.get(str);
        if (str3 != null) {
            return str3;
        }
        String strA = this.b.a(str, str2);
        if (strA == null) {
            Log.e("SecurityResourcesReader", "value is null");
            return str2;
        }
        this.f1797a.put(str, strA);
        return strA;
    }

    SecurityResourcesReader(Context context, String str) {
        this.b = new ReaderStrategy(context, str);
    }
}
