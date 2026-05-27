package com.huawei.updatesdk.b.d;

import android.text.TextUtils;
import java.io.File;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes8.dex */
public class d {
    public HttpURLConnection a(String str) {
        HttpURLConnection httpURLConnectionA = com.huawei.updatesdk.a.a.b.b.a(str, com.huawei.updatesdk.a.b.a.a.c().a());
        httpURLConnectionA.setConnectTimeout(7000);
        httpURLConnectionA.setReadTimeout(10000);
        httpURLConnectionA.setUseCaches(false);
        httpURLConnectionA.setDoInput(true);
        httpURLConnectionA.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnectionA.setInstanceFollowRedirects(true);
        return httpURLConnectionA;
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f11338a = new d();
    }

    public static String b() {
        String strB = com.huawei.updatesdk.a.b.a.a.c().b();
        if (TextUtils.isEmpty(strB)) {
            return "";
        }
        String str = strB + "/updatesdk";
        File file = new File(str);
        return (file.exists() || file.mkdirs()) ? str : "";
    }

    public static d a() {
        return a.f11338a;
    }
}
