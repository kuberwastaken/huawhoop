package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import lib.android.paypal.com.magnessdk.g;

/* JADX INFO: loaded from: classes6.dex */
public final class mlj {
    private static final String b = "WebHelper";
    private static mls c;
    private static Context e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f15705a = new ConcurrentHashMap<>();
    private static Handler d = new Handler(Looper.myLooper()) { // from class: mlj.4
        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (message.what != 1001) {
                return;
            }
            mly.a(mlj.b, "download succ,begining copy", true);
            mlj.d(mlj.b(), mlj.e(), (String) message.obj);
        }
    };

    public static ConcurrentHashMap<String, String> a() {
        return f15705a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b() {
        try {
            return e.getDir("hwId", 0).getCanonicalPath() + "/";
        } catch (IOException e2) {
            mly.b(b, "IOException:" + e2.getClass().getSimpleName(), true);
            return "";
        }
    }

    public static String e() {
        try {
            return e.getDir(g.r1, 0).getCanonicalPath() + "/";
        } catch (IOException e2) {
            mly.b(b, "IOException:" + e2.getClass().getSimpleName(), true);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2, String str3) throws Throwable {
        mly.a(b, "handlerRequestCopyData", true);
        c.e(str, str2, str3);
    }
}
