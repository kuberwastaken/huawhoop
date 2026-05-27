package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* JADX INFO: loaded from: classes6.dex */
public final class n {
    public static void b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            if (l.c(str)) {
                str = FaqConstants.COMMON_FILE;
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putString(str2, str3);
            editorEdit.apply();
        } catch (Exception e) {
            h.e("FaqSharePrefUtil", e.getMessage());
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return str3;
        }
        if (l.c(str)) {
            str = FaqConstants.COMMON_FILE;
        }
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            h.e("FaqSharePrefUtil", "delete context is null");
            return;
        }
        if (l.c(str)) {
            str = FaqConstants.COMMON_FILE;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences == null) {
            h.e("FaqSharePrefUtil", "delete sharedPreferences is null");
            return;
        }
        if (sharedPreferences.contains(str2)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                h.e("FaqSharePrefUtil", "delete editor is null");
            } else {
                editorEdit.remove(str2);
                editorEdit.apply();
            }
        }
    }

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("FAQ_MODULE_FILE_NAME", 0).edit();
                editorEdit.putString("module", str);
                editorEdit.commit();
            } catch (Exception e) {
                h.e("FaqSharePrefUtil", e.getMessage());
            }
        }
    }

    public static String a(Context context) {
        return context != null ? context.getSharedPreferences("FAQ_MODULE_FILE_NAME", 0).getString("module", "") : "";
    }

    public static void e(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("FAQ_LANGUAGE_FILE_NAME", 0).edit();
            editorEdit.putString("language", str);
            editorEdit.commit();
        }
    }

    public static String e(Context context) {
        return context != null ? context.getSharedPreferences("FAQ_LANGUAGE_FILE_NAME", 0).getString("language", "") : "";
    }
}
