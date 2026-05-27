package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class bax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static bax f397a;
    private String d;
    private int e;

    public String a() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public static bax c() {
        bax baxVar;
        synchronized (bax.class) {
            if (f397a == null) {
                f397a = new bax();
            }
            baxVar = f397a;
        }
        return baxVar;
    }

    private String b() {
        return bbb.a("ro.build.version.emui", "");
    }

    private String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length == 2) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    private bax() {
        this.e = 0;
        this.d = "";
        this.e = bbb.a("ro.build.hw_emui_api_level", 0);
        this.d = d(b());
    }
}
