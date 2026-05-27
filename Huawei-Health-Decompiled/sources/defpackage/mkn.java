package defpackage;

import android.content.Intent;
import com.huawei.hwidauth.e.b;

/* JADX INFO: loaded from: classes6.dex */
public class mkn {
    private static mkn e;
    private b d;

    private mkn() {
    }

    public static mkn c() {
        mkn mknVar;
        synchronized (mkn.class) {
            if (e == null) {
                d(new mkn());
            }
            mknVar = e;
        }
        return mknVar;
    }

    private static void d(mkn mknVar) {
        synchronized (mkn.class) {
            e = mknVar;
        }
    }

    public void e(b bVar) {
        synchronized (this) {
            mly.a("WeixinAuthLogin", "WeixinAuthLogin register:", true);
            this.d = bVar;
        }
    }

    public void bXs_(Intent intent) {
        synchronized (this) {
            mly.a("WeixinAuthLogin", "WeixinAuthLogin send:", true);
            b bVar = this.d;
            if (bVar != null) {
                bVar.a(intent);
            } else {
                mly.b("WeixinAuthLogin", "mWeixinObserver is null.", true);
            }
        }
    }

    public void a() {
        synchronized (this) {
            mly.a("WeixinAuthLogin", "WeixinAuthLogin unregister:", true);
            if (this.d != null) {
                this.d = null;
            }
        }
    }
}
