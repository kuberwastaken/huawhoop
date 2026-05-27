package com.huawei.hwcloudjs.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hwcloudjs.service.auth.bean.AuthBean;
import java.io.File;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6400a = "AuthCache";
    private static final String b = "jssdkcache";
    private static final long c = 86400000;

    public AuthBean b(String str) {
        String strD = d(str);
        if (strD != null && new File(strD).exists()) {
            return (AuthBean) new f(strD).b();
        }
        return null;
    }

    public void a(AuthBean authBean) throws Throwable {
        String strD = d(authBean.getAppId());
        if (strD == null) {
            return;
        }
        new f(strD).a(authBean);
    }

    public AuthBean a(String str) {
        com.huawei.hwcloudjs.f.d.c(f6400a, "getValidCache begin", false);
        AuthBean authBeanB = b(str);
        if (authBeanB == null) {
            return null;
        }
        if (!b(authBeanB)) {
            return authBeanB;
        }
        e(str);
        return null;
    }

    private void e(String str) {
        String strD = d(str);
        if (strD == null) {
            return;
        }
        File file = new File(strD);
        if (!file.exists() || file.delete()) {
            return;
        }
        com.huawei.hwcloudjs.f.d.b(f6400a, "removeFile error", true);
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strC = c(str);
        if (TextUtils.isEmpty(strC)) {
            return str;
        }
        return a(com.huawei.hwcloudjs.b.a.a(), b) + strC;
    }

    private String c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    private boolean b(AuthBean authBean) {
        long jCurrentTimeMillis = System.currentTimeMillis() - authBean.getTimestamp();
        return jCurrentTimeMillis >= 86400000 || jCurrentTimeMillis < 0;
    }

    private String a(Context context, String str) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        File file = new File(cacheDir.getPath() + File.separator + str + File.separator);
        if (!file.exists() && !file.mkdir()) {
            com.huawei.hwcloudjs.f.d.b(f6400a, "getCacheDir mkdir error", true);
        }
        return file.getAbsolutePath() + File.separator;
    }
}
