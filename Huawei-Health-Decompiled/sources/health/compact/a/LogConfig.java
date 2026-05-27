package health.compact.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.haf.application.BroadcastManager;
import health.compact.a.LogConfig;

/* JADX INFO: loaded from: classes.dex */
public final class LogConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f13762a = 2;
    private static boolean b = true;
    private static boolean c = true;
    private static boolean d = false;
    private static boolean e = false;
    private static BroadcastReceiver f;

    private LogConfig() {
    }

    static void c(boolean z, int i, boolean z2, boolean z3) {
        c = z;
        b = z3;
        if (i < 0 || i > 4) {
            i = 2;
        }
        f13762a = i;
        e = false;
        d = false;
        if (!z2) {
            BroadcastReceiver broadcastReceiver = f;
            if (broadcastReceiver != null) {
                BroadcastManager.ya_(broadcastReceiver);
                f = null;
                return;
            }
            return;
        }
        if (f != null) {
            return;
        }
        BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.huawei.haf.common.log.LogConfig$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("com.huawei.haf.intent.action.DEBUG_SWITCH_LOG".equals(intent.getAction())) {
                    int unused = LogConfig.f13762a = intent.getIntExtra("level", 2);
                    boolean unused2 = LogConfig.e = intent.getBooleanExtra("force", false);
                    boolean unused3 = LogConfig.d = intent.getBooleanExtra("origina", false);
                }
            }
        };
        f = broadcastReceiver2;
        BroadcastManager.xM_(broadcastReceiver2);
    }

    static boolean b(int i, String str) {
        if (b || e || !a(i) || TextUtils.isEmpty(str)) {
            return b;
        }
        return str.startsWith("HAF_", 0) || str.startsWith("Bundle_", 0);
    }

    public static boolean a(int i) {
        return c && i >= f13762a;
    }

    public static int e() {
        return f13762a;
    }

    public static boolean c() {
        return e;
    }

    public static boolean b() {
        return d;
    }
}
