package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes6.dex */
public class mxu {
    private static int b = Build.VERSION.SDK_INT;

    public static boolean d(String str, Context context) {
        if (TextUtils.isEmpty(str) || context == null) {
            mza.c("ContentValues", "Permission is empty or context is null");
            return false;
        }
        Hashtable hashtable = new Hashtable();
        if (b < 23) {
            return true;
        }
        if (!hashtable.containsKey(str) || ((Integer) hashtable.get(str)).intValue() == -1) {
            hashtable.put(str, Integer.valueOf(context.checkSelfPermission(str)));
        }
        return ((Integer) hashtable.get(str)).intValue() == 0;
    }

    public static void cdT_(Activity activity, String[] strArr, int i) {
        if (b <= 23) {
            return;
        }
        cdU_(strArr, activity, i);
    }

    public static void cdU_(String[] strArr, Activity activity, int i) {
        mza.e("ContentValues", "requestPermissions enter");
        if (activity == null) {
            mza.c("ContentValues", "activity is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (activity.checkSelfPermission(str) != 0) {
                mza.e("ContentValues", "needRequestPermissionList.add(permission)");
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            mza.c("ContentValues", "needRequestPermissionList is empty");
        } else {
            activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i);
        }
    }
}
