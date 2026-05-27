package com.huawei.hms.support.hwid.common.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hwid.common.e.g;
import java.util.UUID;

/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6183a = "";

    public static String a() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    public static String b() {
        if (TextUtils.isEmpty(f6183a)) {
            String string = UUID.randomUUID().toString();
            f6183a = string;
            if (TextUtils.isEmpty(string)) {
                return "NULL";
            }
        }
        return f6183a;
    }

    public static String a(Context context) {
        g.a("TerminalInfo", "generateUuid start.", true);
        String strB = com.huawei.hms.support.hwid.common.d.a.a(context).b("UUID", "");
        if (!TextUtils.isEmpty(strB)) {
            return strB;
        }
        g.a("TerminalInfo", "uuid is null.", true);
        String strB2 = b();
        com.huawei.hms.support.hwid.common.d.a.a(context).c("UUID", strB2);
        return strB2;
    }
}
