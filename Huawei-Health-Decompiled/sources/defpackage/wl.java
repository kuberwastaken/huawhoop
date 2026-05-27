package defpackage;

import android.content.Context;
import androidx.core.content.PermissionChecker;

/* JADX INFO: loaded from: classes3.dex */
public class wl {
    public static boolean c(Context context, String... strArr) {
        for (String str : strArr) {
            if (PermissionChecker.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }
}
