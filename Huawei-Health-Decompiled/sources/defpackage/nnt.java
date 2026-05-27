package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class nnt {
    private static final ConcurrentHashMap<String, SharedPreferences> b = new ConcurrentHashMap<>();

    private static SharedPreferences cmt_(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            nni.b("SpUtils", "getSharedPreferences sharedFile is null.");
            return null;
        }
        ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = b;
        SharedPreferences sharedPreferences = concurrentHashMap.get(str);
        if (sharedPreferences == null && (sharedPreferences = b(context).getSharedPreferences(str, 0)) != null) {
            concurrentHashMap.put(str, sharedPreferences);
        }
        return sharedPreferences;
    }

    private static Context b(Context context) {
        return context.isDeviceProtectedStorage() ? context : context.createDeviceProtectedStorageContext();
    }

    public static String b(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferencesCmt_ = cmt_(context, str3);
        if (sharedPreferencesCmt_ == null) {
            nni.b("SpUtils", "get key:" + str + " from " + str3 + " error. SharedPreferences is null.");
            return str2;
        }
        return sharedPreferencesCmt_.getString(str, str2);
    }

    public static void e(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferencesCmt_ = cmt_(context, str3);
        if (sharedPreferencesCmt_ == null) {
            nni.b("SpUtils", "put key:" + str + " into " + str3 + " error. SharedPreferences is null.");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesCmt_.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
