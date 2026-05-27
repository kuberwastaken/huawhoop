package defpackage;

import android.app.Activity;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes9.dex */
public class vlw {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean b(T t) {
        if (t == 0) {
            return false;
        }
        if (t instanceof Activity) {
            Activity activity = (Activity) t;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return false;
            }
        }
        if (t instanceof Fragment) {
            return ((Fragment) t).isAdded();
        }
        return true;
    }
}
