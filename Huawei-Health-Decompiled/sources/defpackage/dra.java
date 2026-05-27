package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class dra {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12378a;
    private String b;
    private String c;
    private String d;
    private long e;

    public dra(String str) {
        this.b = str;
    }

    public dra() {
    }

    public void a() {
        this.e = System.currentTimeMillis();
    }

    public void c() {
        dna.b(false, "AddDeviceLogger", "this ", Long.valueOf(System.currentTimeMillis()), " last ", Long.valueOf(this.e), " dis ", Long.valueOf(System.currentTimeMillis() - this.e));
        this.f12378a = (int) (((System.currentTimeMillis() - this.e) / 1000) + 1);
        d();
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.d = str;
        c();
    }

    public void a(String str, String str2) {
        this.d = str;
        this.c = str2;
        c();
    }

    private void d() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("WiFi Config  Mode ");
        sb.append(this.b);
        sb.append(" Time ");
        sb.append(this.f12378a);
        sb.append("s Result ");
        sb.append(this.d);
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(" Fail Result: ");
            sb.append(this.c);
            dna.d(false, "AddDeviceLogger", sb.toString());
            return;
        }
        dna.a(false, "AddDeviceLogger", sb.toString());
    }
}
