package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes3.dex */
public class cgn {
    public static String a(String str, Context context) {
        if (str == null || context == null) {
            LogUtil.a("CommandPackage", "getKeyFromSharedPreferences with parameter incorrect.");
            return "";
        }
        String string = context.getSharedPreferences("btsdk_sharedpreferences_name4", 0).getString(str, "");
        LogUtil.a("CommandPackage", "getKeyFromSharedPreferences ok");
        return string;
    }

    public static void c(String str, String str2, String str3, Context context) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str3, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
        LogUtil.a("CommandPackage", "putInfoToSharedPreferences ok");
    }

    public static String e(String str, Context context) {
        if (str == null || context == null) {
            LogUtil.a("CommandPackage", "getBindIdFromSharedPreferences with parameter incorrect.");
            return "";
        }
        String string = context.getSharedPreferences("btsdk_sharedpreferences_bindid", 0).getString(str, "");
        LogUtil.a("CommandPackage", "getBindIdFromSharedPreferences ok, bindId: ", chj.e(string));
        return string;
    }
}
