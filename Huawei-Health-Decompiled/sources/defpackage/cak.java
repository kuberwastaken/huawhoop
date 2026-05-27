package defpackage;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public class cak {
    public static void b(String str, long j) {
        SharedPreferences.Editor editorEdit = bzq.d().getSharedPreferences("code_rule_sp", 0).edit();
        editorEdit.putLong(str, j);
        editorEdit.apply();
    }

    public static long d(String str, long j) {
        return bzq.d().getSharedPreferences("code_rule_sp", 0).getLong(str, j);
    }

    public static void e(String str, String str2) {
        SharedPreferences.Editor editorEdit = bzq.d().getSharedPreferences("code_rule_sp", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static String a(String str, String str2) {
        return bzq.d().getSharedPreferences("code_rule_sp", 0).getString(str, str2);
    }
}
