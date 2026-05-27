package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes5.dex */
public class iub {
    private float h = 0.0f;
    private irt d = null;
    private float e = 0.0f;
    private Bitmap c = null;
    private float b = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14293a = true;

    public float c() {
        return this.h;
    }

    public iub e(float f) {
        this.h = f;
        return this;
    }

    public irt b() {
        return this.d;
    }

    public iub a(irt irtVar) {
        this.d = irtVar;
        return this;
    }

    public float a() {
        return this.e;
    }

    public iub b(float f) {
        this.e = f;
        return this;
    }

    public Bitmap bnL_() {
        return this.c;
    }

    public iub bnM_(Bitmap bitmap) {
        this.c = bitmap;
        return this;
    }

    public float d() {
        return this.b;
    }

    public iub d(float f) {
        this.b = f;
        return this;
    }

    public boolean j() {
        return this.f14293a;
    }

    public iub b(boolean z) {
        this.f14293a = z;
        return this;
    }
}
