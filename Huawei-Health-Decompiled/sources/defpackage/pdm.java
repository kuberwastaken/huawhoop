package defpackage;

import android.widget.Switch;

/* JADX INFO: loaded from: classes11.dex */
public class pdm {
    private String e;
    private int f;
    private int h;
    private int j;
    private String b = Switch.class.getName();
    private boolean c = false;
    private boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16635a = false;

    public pdm(String str, int i, int i2, int i3) {
        this.e = str;
        this.j = i;
        this.h = i2;
        this.f = i3;
    }

    public String b() {
        return this.e;
    }

    public int a() {
        return this.j;
    }

    public int e() {
        return this.h;
    }

    public int c() {
        return this.f;
    }

    public boolean g() {
        return this.c;
    }

    public void e(Boolean bool) {
        this.c = bool.booleanValue();
    }

    public boolean h() {
        return this.d;
    }

    public void c(Boolean bool) {
        this.d = bool.booleanValue();
    }

    public boolean d() {
        return this.f16635a;
    }

    public void c(boolean z) {
        this.f16635a = z;
    }
}
