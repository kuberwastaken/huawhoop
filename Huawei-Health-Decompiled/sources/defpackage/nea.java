package defpackage;

import android.content.Context;
import com.huawei.hms.support.log.KitLog;
import com.huawei.openplatform.abl.log.util.d;
import com.huawei.openplatform.abl.log.util.g;

/* JADX INFO: loaded from: classes6.dex */
public class nea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f16019a = new byte[0];
    private static volatile nea c;
    private boolean b = false;
    private int d = 4;
    private KitLog e;

    public void a(String str, String str2, Object... objArr) {
        if (this.e != null) {
            a(str, g.a(str2, objArr));
        }
    }

    public void a(String str, String str2) {
        KitLog kitLog = this.e;
        if (kitLog != null) {
            kitLog.w(str, str2);
        }
    }

    public void c(String str, String str2, Object... objArr) {
        if (this.e != null) {
            c(str, g.a(str2, objArr));
        }
    }

    public void c(String str, String str2) {
        KitLog kitLog = this.e;
        if (kitLog != null) {
            kitLog.i(str, str2);
        }
    }

    public void d(String str, String str2, Object... objArr) {
        if (this.e != null) {
            d(str, g.a(str2, objArr));
        }
    }

    public void d(String str, String str2) {
        KitLog kitLog = this.e;
        if (kitLog != null) {
            kitLog.e(str, str2);
        }
    }

    public boolean d(int i) {
        return this.b && i >= this.d;
    }

    public void b(String str, String str2, Object... objArr) {
        if (this.e != null) {
            b(str, g.a(str2, objArr));
        }
    }

    public void b(String str, String str2) {
        KitLog kitLog = this.e;
        if (kitLog != null) {
            kitLog.d(str, str2);
        }
    }

    public void e(Context context, int i, String str) {
        KitLog kitLog = this.e;
        if (kitLog != null && context != null) {
            kitLog.init(context.getApplicationContext(), i, str);
        }
        this.d = i;
        this.b = true;
    }

    public static nea a() {
        if (c == null) {
            synchronized (f16019a) {
                if (c == null) {
                    c = new nea();
                }
            }
        }
        return c;
    }

    private nea() {
        if (d.a("com.huawei.hms.support.log.KitLog")) {
            this.e = new KitLog();
        }
    }
}
