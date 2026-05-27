package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class arb {
    private static arb d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f276a;
    private boolean b;
    private boolean f;
    private boolean h;
    private boolean i;
    public static final boolean c = are.b("debug.hisight.performance", false);
    private static boolean e = false;

    public arb() {
        this.f = false;
        this.b = false;
        this.h = true;
        this.i = true;
        this.f276a = false;
        if (arf.a()) {
            this.f = false;
            this.b = true;
            this.h = true;
            this.i = true;
            this.f276a = true;
        }
    }

    public static arb d() {
        arb arbVar;
        synchronized (arb.class) {
            if (d == null) {
                d = new arb();
                Log.d("IICLOG", "user type is beta : " + arf.a() + ",remote diagnosis is " + e);
            }
            arbVar = d;
        }
        return arbVar;
    }

    public void a(String str, String str2) {
        if (this.b || c || e) {
            Log.i(str, a(str2));
        }
    }

    public void e(String str, String str2) {
        Log.i(str, a(str2));
    }

    public void c(String str, String str2) {
        if (this.h) {
            Log.w(str, a(str2));
        }
    }

    public void b(String str, String str2) {
        if (this.i) {
            Log.e(str, a(str2));
        }
    }

    private String a(String str) {
        if (str != null && str.length() > 1000) {
            str = str.substring(0, 1000);
            Log.w("IICLOG", "msg length bigger than 1000");
        }
        StringBuilder sb = new StringBuilder(str != null ? 50 + str.length() : 50);
        if (this.f276a) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length > 4) {
                sb.append("[ ");
                sb.append(stackTrace[4].getFileName());
                sb.append(": ");
                sb.append(stackTrace[4].getLineNumber());
                sb.append("]");
            }
        }
        sb.append(str);
        return sb.toString();
    }
}
