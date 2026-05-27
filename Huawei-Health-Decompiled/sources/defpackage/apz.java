package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class apz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f259a;
    private int b;
    private StringBuilder d;

    public int a() {
        return this.f259a;
    }

    public void b(int i) {
        this.f259a = i;
    }

    public String b() {
        StringBuilder sb = this.d;
        if (sb == null) {
            return null;
        }
        return sb.toString();
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = this.d;
        if (sb == null) {
            this.d = new StringBuilder(str);
        } else {
            sb.append("|");
            sb.append(str);
        }
    }

    public void c(int i) {
        this.b = i;
    }

    public int e() {
        return this.b;
    }
}
