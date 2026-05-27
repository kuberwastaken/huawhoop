package com.huawei.appgallery.agd.internal.support.log;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class AgdLog {
    public static final AgdLog LOG = new AgdLog();

    private boolean c(int i) {
        return i > 3;
    }

    public void w(String str, String str2, Throwable th) {
        d(5, str, str2, th);
    }

    public void w(String str, String str2) {
        d(5, str, str2, null);
    }

    public void i(String str, String str2, Throwable th) {
        d(4, str, str2, th);
    }

    public void i(String str, String str2) {
        d(4, str, str2, null);
    }

    public void e(String str, String str2, Throwable th) {
        d(6, str, str2, th);
    }

    public void e(String str, String str2) {
        d(6, str, str2, null);
    }

    public void d(String str, String str2, Throwable th) {
        d(3, str, str2, th);
    }

    public void d(String str, String str2) {
        d(3, str, str2, null);
    }

    private void d(int i, String str, String str2, Throwable th) {
        if (str2 == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = "[" + str + "] " + str2;
        }
        if (th != null) {
            str2 = str2 + th.getMessage();
        }
        if (c(i)) {
            Log.println(i, "AgdLog", str2.replace('\n', '_').replace('\r', '_'));
        }
    }
}
