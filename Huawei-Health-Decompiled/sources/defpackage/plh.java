package defpackage;

import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes11.dex */
public class plh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16756a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int g;
    private int j;

    public void g(int i) {
        this.j = i;
    }

    public int d(int i) {
        return i / 3600;
    }

    public int b(int i) {
        return (i / 60) % 60;
    }

    public int a(int i) {
        return i % 60;
    }

    public int c(int i) {
        return Math.max(Math.min(i, this.d), this.g);
    }

    public int e(int i) {
        int iB = b(this.j);
        return i == 1 ? iB - this.f16756a : iB + 5;
    }

    public int a() {
        int iD = d(this.j);
        if (iD == this.c) {
            return 1;
        }
        return iD == this.e ? 3 : 2;
    }

    public int e() {
        int i = this.j;
        int i2 = this.g;
        int i3 = (i - i2) / 60;
        int i4 = (this.d - i2) / 60;
        if (i3 == 0) {
            return 1;
        }
        return i3 == i4 ? 3 : 2;
    }

    public int f(int i) {
        int iA = a(this.j);
        return i == 1 ? iA - this.b : iA + 5;
    }

    public int b() {
        return d(this.j) - this.c;
    }

    public String d(String[] strArr, int i) {
        if (strArr != null) {
            return (i < 0 || i >= strArr.length) ? "" : strArr[i];
        }
        LogUtil.b("TimeDialogUtils", "the valid value array is null");
        return null;
    }
}
