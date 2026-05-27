package defpackage;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes7.dex */
public class pew {
    private boolean b;
    private String c;
    private int d;
    private int i;
    private Rect g = new Rect();
    private int e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16665a = -1;

    public pew() {
    }

    public pew(int i, String str, int i2) {
        this.d = i;
        this.c = str;
        this.i = i2;
    }

    public int e() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public int h() {
        return this.i;
    }

    public Rect cLa_() {
        return this.g;
    }

    public boolean g() {
        return this.b;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public int d() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int b() {
        return this.f16665a;
    }

    public void a(int i) {
        this.f16665a = i;
    }

    public String toString() {
        return "TagInfo{itemId = " + this.d + "'itemName = " + this.c + "'}";
    }
}
