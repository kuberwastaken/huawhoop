package defpackage;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes3.dex */
public class fp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f13068a;
    private final PointF c;
    private final PointF e;

    public fp() {
        this.e = new PointF();
        this.c = new PointF();
        this.f13068a = new PointF();
    }

    public fp(PointF pointF, PointF pointF2, PointF pointF3) {
        this.e = pointF;
        this.c = pointF2;
        this.f13068a = pointF3;
    }

    public void a(float f, float f2) {
        this.e.set(f, f2);
    }

    public PointF ad_() {
        return this.e;
    }

    public void d(float f, float f2) {
        this.c.set(f, f2);
    }

    public PointF ae_() {
        return this.c;
    }

    public void e(float f, float f2) {
        this.f13068a.set(f, f2);
    }

    public PointF af_() {
        return this.f13068a;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f13068a.x), Float.valueOf(this.f13068a.y), Float.valueOf(this.e.x), Float.valueOf(this.e.y), Float.valueOf(this.c.x), Float.valueOf(this.c.y));
    }
}
