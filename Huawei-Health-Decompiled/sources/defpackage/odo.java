package defpackage;

import android.net.Uri;
import com.huawei.haf.application.BaseApplication;
import com.huawei.haf.bundle.extension.ComponentInfo;
import health.compact.a.utils.StringUtils;

/* JADX INFO: loaded from: classes7.dex */
class odo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16304a;
    private String b;
    private String c;
    private String d;
    private int e;

    odo() {
    }

    public String a() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public String c() {
        return this.f16304a;
    }

    public String b() {
        return this.c;
    }

    public boolean e() {
        return (StringUtils.f(this.b) || StringUtils.f(this.d) || StringUtils.f(this.f16304a) || StringUtils.f(this.c) || this.e > BaseApplication.c() || this.e == 0 || !this.b.equals("opencard") || !ComponentInfo.PluginPay_A_119.equals(Uri.parse(this.c).getQueryParameter("classPath"))) ? false : true;
    }
}
