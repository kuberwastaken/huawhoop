package com.huawei.openalliance.ad.ipc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.openalliance.ad.hq;
import com.huawei.openalliance.ad.utils.dn;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC0209a f7322a;
    private final String b = "unbindTask" + hashCode();
    private int c = 0;
    private String d;
    private Context e;

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.ipc.a$a, reason: collision with other inner class name */
    public interface InterfaceC0209a {
        void a();
    }

    public void b() {
        synchronized (this) {
            int i = this.c - 1;
            this.c = i;
            if (i < 0) {
                this.c = 0;
            }
            hq.a(c(), "dec count: %d", Integer.valueOf(this.c));
            if (this.c <= 0) {
                dn.a(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.e();
                    }
                }, this.b, d());
            }
        }
    }

    public void a() {
        synchronized (this) {
            this.c++;
            dn.a(this.b);
            hq.b(c(), "inc count: " + this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        hq.b(c(), "unbindService");
        this.f7322a.a();
    }

    private int d() {
        return TextUtils.equals(Constants.HW_INTELLIEGNT_PACKAGE, this.e.getPackageName()) ? 0 : 60000;
    }

    private String c() {
        return "Monitor_" + this.d;
    }

    public a(Context context, String str, InterfaceC0209a interfaceC0209a) {
        this.e = context.getApplicationContext();
        this.d = str;
        this.f7322a = interfaceC0209a;
    }
}
