package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes9.dex */
public class gll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13516a;
    private glf b;
    private int c;
    private int d;
    private String e;

    public gll(glf glfVar) {
        this.b = glfVar;
        if (glfVar == null) {
            return;
        }
        String strJ = glfVar.j();
        if (TextUtils.isEmpty(strJ)) {
            return;
        }
        this.d = gla.c(strJ, "\\.", 0);
        this.c = gla.c(strJ, "\\.", 1);
    }

    public int b() {
        return this.d;
    }

    public int a() {
        return this.c;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public String c() {
        return this.f13516a;
    }

    public void b(String str) {
        this.f13516a = str;
    }
}
