package defpackage;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class igg {
    public static boolean d(Context context, String str) {
        if (context == null || str == null || !(context.getSystemService("activity") instanceof ActivityManager)) {
            return false;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        ComponentName componentName = mgx.e(runningTasks) ? runningTasks.get(0).topActivity : null;
        if (componentName == null) {
            return false;
        }
        return componentName.getClassName().contains(str);
    }
}
