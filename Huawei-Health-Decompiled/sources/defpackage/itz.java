package defpackage;

import android.graphics.Color;

/* JADX INFO: loaded from: classes5.dex */
public class itz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f14291a = Color.rgb(251, 101, 34);
    private int d = f14291a;
    private float f = 16.0f;
    private boolean e = true;
    private boolean b = false;
    private irt i = null;
    private irt c = null;
    private float j = 0.0f;

    public itz d(int i) {
        this.d = i;
        return this;
    }

    public itz b(float f) {
        this.f = f;
        return this;
    }

    public itz e(boolean z) {
        this.e = z;
        return this;
    }

    public itz a(boolean z) {
        this.b = z;
        return this;
    }

    public itz c(irt irtVar) {
        this.i = irtVar;
        return this;
    }

    public itz b(irt irtVar) {
        this.c = irtVar;
        return this;
    }

    public int d() {
        return this.d;
    }

    public float a() {
        return this.f;
    }

    public boolean g() {
        return this.b;
    }

    public irt b() {
        return this.i;
    }

    public irt c() {
        return this.c;
    }

    public boolean j() {
        return this.e;
    }

    public float e() {
        return this.j;
    }

    public void d(float f) {
        this.j = f;
    }
}
