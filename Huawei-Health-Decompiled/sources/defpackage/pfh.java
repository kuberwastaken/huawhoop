package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes7.dex */
public class pfh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16674a = 1.0f;
    private float b;
    private float c;
    private Drawable d;
    private boolean e;
    private int i;

    public boolean c() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public float d() {
        return this.f16674a;
    }

    public float e() {
        return this.c;
    }

    public void b(float f) {
        this.c = f;
    }

    public Drawable cLz_() {
        return this.d;
    }

    public void cLA_(Drawable drawable) {
        this.d = drawable;
    }

    public float b() {
        float f = this.b;
        return f == 0.0f ? pla.b(this.i) : f;
    }

    public void c(float f) {
        this.b = f;
    }

    public String toString() {
        return "CursorData{mIsShow=" + this.e + ", mAlpha=" + this.f16674a + ", mProportion=" + this.c + ", mDrawable=" + this.d + ", mVerticalOffset=" + this.b + ", mVerticalOffsetId=" + this.i + '}';
    }
}
