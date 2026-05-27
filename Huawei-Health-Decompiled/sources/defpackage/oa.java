package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.alipay.sdk.m.s0.b;
import defpackage.oa;

/* JADX INFO: loaded from: classes9.dex */
public class oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f16255a = null;
    public static volatile b b = null;
    public static boolean c = false;
    public static String d;
    public static volatile oa e;
    public static od f;
    public static HandlerThread g;
    public static od h;
    public static Object i = new Object();
    public static od j;
    public static String k;
    public static String l;
    public static String m;
    public static Handler n;
    public static String o;

    public static void e() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        g = handlerThread;
        handlerThread.start();
        final Looper looper = g.getLooper();
        n = new Handler(looper) { // from class: com.alipay.sdk.m.s0.c$a
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    Log.e("VMS_IDLG_SDK_Client", "message type valid");
                    return;
                }
                String unused = oa.o = oa.b.e(message.getData().getInt("type"), message.getData().getString("appid"));
                synchronized (oa.i) {
                    oa.i.notify();
                }
            }
        };
    }

    public String a() {
        if (!h()) {
            return null;
        }
        String str = k;
        if (str != null) {
            return str;
        }
        c(0, null);
        if (f == null) {
            b(f16255a, 0, null);
        }
        return k;
    }

    public boolean h() {
        return c;
    }

    public static oa b(Context context) {
        if (e == null) {
            synchronized (oa.class) {
                f16255a = context.getApplicationContext();
                e = new oa();
            }
        }
        if (b == null) {
            synchronized (oa.class) {
                f16255a = context.getApplicationContext();
                e();
                b = new b(f16255a);
                d();
            }
        }
        return e;
    }

    public static void d() {
        c = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    public final void a(int i2, String str) {
        Message messageObtainMessage = n.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        n.sendMessage(messageObtainMessage);
    }

    public void c(int i2, String str) {
        synchronized (i) {
            a(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                i.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                Log.d("VMS_IDLG_SDK_Client", "query timeout");
            } else if (i2 == 0) {
                k = o;
                o = null;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    String str2 = o;
                    if (str2 != null) {
                        l = str2;
                        o = null;
                    } else {
                        Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                    }
                } else if (i2 != 4) {
                }
                d = o;
                o = null;
            } else {
                String str3 = o;
                if (str3 != null) {
                    m = str3;
                    o = null;
                } else {
                    Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                }
            }
        }
    }

    public static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void b(Context context, int i2, String str) {
        if (i2 == 0) {
            f = new od(e, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f);
            return;
        }
        if (i2 == 1) {
            h = new od(e, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, h);
            return;
        }
        if (i2 != 2) {
            return;
        }
        j = new od(e, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, j);
    }
}
