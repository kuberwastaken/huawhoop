package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class bbr {
    public static final bbr b = new bbr();
    private boolean e;

    public void b(String str, String str2) {
        if (this.e) {
            bbq.d.w(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public void e(String str, String str2) {
        if (this.e) {
            bbq.d.i(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public void b(String str, String str2, Throwable th) {
        if (this.e) {
            bbq.d.e(str, str2, th);
        } else {
            Log.e(str, str2, th);
        }
    }

    public void d(String str, String str2) {
        if (this.e) {
            bbq.d.e(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    private bbr() {
        try {
            Class.forName("com.huawei.appgallery.log.LogAdaptor");
            this.e = true;
        } catch (ClassNotFoundException unused) {
            this.e = false;
        }
    }
}
