package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.kn;
import defpackage.ko;
import defpackage.lk;

/* JADX INFO: loaded from: classes9.dex */
public class g {
    public static void b(Context context, String str) {
        synchronized (g.class) {
        }
    }

    public static void a(Context context, String str, String str2) {
        synchronized (g.class) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (editorEdit != null) {
                    editorEdit.putString("openApi" + str, ko.b(ko.e(), str2));
                    editorEdit.commit();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        synchronized (g.class) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (editorEdit != null) {
                editorEdit.clear();
                editorEdit.commit();
            }
        }
    }

    public static String a(Context context, String str) {
        synchronized (g.class) {
            String strC = lk.c(context, "openapi_file_pri", "openApi" + str, "");
            if (kn.a(strC)) {
                return "";
            }
            String strD = ko.d(ko.e(), strC);
            return kn.a(strD) ? "" : strD;
        }
    }
}
