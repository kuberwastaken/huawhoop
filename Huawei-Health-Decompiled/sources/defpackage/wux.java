package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes11.dex */
public class wux {
    public static boolean e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("WearEngine_Package_Name_Store", 0);
        Set<String> stringSet = sharedPreferences.getStringSet("WearEnginePackageNameIdentity", new TreeSet());
        stringSet.add(str);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putStringSet("WearEnginePackageNameIdentity", stringSet);
        return editorEdit.commit();
    }

    public static Set<String> b(Context context) {
        if (context == null) {
            return new TreeSet();
        }
        return context.getSharedPreferences("WearEngine_Package_Name_Store", 0).getStringSet("WearEnginePackageNameIdentity", new TreeSet());
    }
}
