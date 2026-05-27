package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.huawei.codevalueplatform.coderule.bean.basebean.Rule;
import com.huawei.codevalueplatform.coderule.model.CodeRulesUpdater;
import com.huawei.hms.network.NetworkKit;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class bzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f553a = 250;
    private static String b = "";
    private static boolean c = false;
    private static Application d = null;
    private static boolean e = false;

    public static void rb_(Application application, String str) {
        d = application;
        b = str;
        NetworkKit.init(application, new NetworkKit.Callback() { // from class: bzq.1
            @Override // com.huawei.hms.network.NetworkKit.Callback
            public void onResult(boolean z) {
                cal.d("CodeValuePlatform", "NetworkKit init isSuccess: " + z);
            }
        });
    }

    public static void g() {
        e = true;
    }

    public static boolean b() {
        return e;
    }

    public static boolean i() {
        return c;
    }

    public static int c() {
        return f553a;
    }

    public static Context d() {
        return d;
    }

    public static String a() {
        return b;
    }

    public static void a(String str, CodeRulesUpdater.UpdateCallback updateCallback) {
        new CodeRulesUpdater().d(str, updateCallback);
    }

    public static List<Rule> e() {
        return new CodeRulesUpdater().e();
    }

    public static Intent rc_(String str, List<Rule> list) {
        return new bzu().ro_(str, list);
    }
}
