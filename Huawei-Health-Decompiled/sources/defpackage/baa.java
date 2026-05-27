package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.h;
import com.huawei.hms.framework.network.grs.GrsApp;

/* JADX INFO: loaded from: classes3.dex */
public class baa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f391a = new Object();
    private static baa c;
    private String e = "";
    private String d = "";

    public void d(Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (this.e.equals(str)) {
            return;
        }
        this.e = str;
        new h(context).b("hc", str);
    }

    public String c(Context context) {
        String strA = new h(context).a("hc", "");
        this.e = strA;
        if (TextUtils.isEmpty(strA)) {
            this.e = GrsApp.getInstance().getIssueCountryCode(context);
        }
        return this.e;
    }

    public void b(Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (this.d.equals(str)) {
            return;
        }
        this.d = str;
        new h(context).b("grs_app_name", str);
    }

    public String d(Context context) {
        String strA = new h(context).a("grs_app_name", "");
        this.d = strA;
        return strA;
    }

    public static baa a() {
        baa baaVar;
        synchronized (f391a) {
            if (c == null) {
                c = new baa();
            }
            baaVar = c;
        }
        return baaVar;
    }

    private baa() {
    }
}
