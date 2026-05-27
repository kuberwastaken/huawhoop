package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public class wuy {
    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("WearEngine_Permission_Identify_Store", 0).edit();
        editorEdit.putString("WearEnginePermissionIdentity", str);
        return editorEdit.commit();
    }

    public static String e(Context context) {
        return context == null ? "" : context.getSharedPreferences("WearEngine_Permission_Identify_Store", 0).getString("WearEnginePermissionIdentity", "");
    }
}
