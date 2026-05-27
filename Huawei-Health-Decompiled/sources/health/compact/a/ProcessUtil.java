package health.compact.a;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.haf.application.BaseApplication;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessUtil {
    private static String e;

    private ProcessUtil() {
    }

    public static void b() {
        List<ActivityManager.RunningAppProcessInfo> listA = a();
        if (listA == null) {
            return;
        }
        int iMyUid = Process.myUid();
        int iMyPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : listA) {
            if (runningAppProcessInfo.uid == iMyUid && runningAppProcessInfo.pid != iMyPid) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public static boolean d(String str) {
        if (d().equals(str)) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> listA = a();
        if (listA == null) {
            return false;
        }
        int iMyUid = Process.myUid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : listA) {
            if (runningAppProcessInfo.uid == iMyUid && str.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c() {
        List<ActivityManager.RunningAppProcessInfo> listA = a();
        if (listA == null) {
            return false;
        }
        int iMyUid = Process.myUid();
        String strD = BaseApplication.d();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : listA) {
            if (runningAppProcessInfo.uid == iMyUid && runningAppProcessInfo.importance == 100 && strD.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e() {
        return d().equals(BaseApplication.d());
    }

    public static String d() {
        if (TextUtils.isEmpty(e)) {
            if (Build.VERSION.SDK_INT >= 28) {
                e = BaseApplication.getProcessName();
            }
            if (TextUtils.isEmpty(e)) {
                e = d(Process.myPid());
            }
        }
        return e;
    }

    public static String d(int i) {
        String strE = e(i);
        return TextUtils.isEmpty(strE) ? "" : strE;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return BaseApplication.d();
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == ':') {
            return (BaseApplication.d() + str).intern();
        }
        if (cCharAt != '_' && cCharAt != '-') {
            return str;
        }
        return BaseApplication.d() + str;
    }

    private static String e(int i) {
        List<ActivityManager.RunningAppProcessInfo> listA = a();
        String str = null;
        if (listA == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : listA) {
            if (runningAppProcessInfo.pid == i) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str;
    }

    private static List<ActivityManager.RunningAppProcessInfo> a() {
        ActivityManager activityManagerZc_ = CommonUtils.zc_();
        if (activityManagerZc_ != null) {
            return activityManagerZc_.getRunningAppProcesses();
        }
        return null;
    }
}
