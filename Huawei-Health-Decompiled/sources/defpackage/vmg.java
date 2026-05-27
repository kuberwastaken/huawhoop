package defpackage;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.huawei.uikit.animations.drawable.HwEclipseClipDrawable;

/* JADX INFO: loaded from: classes8.dex */
public class vmg extends HwEclipseClipDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f18661a;
    private RectF b;
    private RectF c;
    private float d;
    private Path e;
    private float f;
    private Rect j;

    public vmg(Drawable drawable, int i, int i2) {
        super(drawable, i, i2);
        this.e = new Path();
        this.b = new RectF();
        this.c = new RectF();
        a();
    }

    private void a() {
        Rect bounds = getBounds();
        this.j = bounds;
        b(bounds.left, bounds.top, r1 + bounds.height(), this.j.bottom);
        this.f = b(this.j.height());
    }

    private float b(float f) {
        return f / 2.0f;
    }

    private void c(float f) {
        this.e.reset();
        this.e.addArc(this.b, 90.0f, 180.0f);
        Rect rect = this.j;
        float f2 = rect.left;
        float f3 = this.f;
        float fWidth = rect.width();
        Rect rect2 = this.j;
        this.e.addRect(f2 + f3, rect2.top, (fWidth * f) + rect2.left, rect2.bottom, Path.Direction.CCW);
    }

    private void d(float f) {
        this.d = f;
    }

    private void e(float f) {
        this.e.reset();
        this.e.addArc(this.b, 90.0f, 180.0f);
        float fC = Float.compare(c(), 0.0f) != 0 ? (f / c()) * this.f : 0.0f;
        Rect rect = this.j;
        float fHeight = rect.left + rect.height();
        RectF rectF = this.c;
        Rect rect2 = this.j;
        rectF.set(rect2.left + fC, rect2.top, fHeight - fC, rect2.bottom);
        this.e.addArc(this.c, 270.0f, -180.0f);
    }

    private void h(float f) {
        this.e.reset();
        this.e.addArc(this.b, 90.0f, 180.0f);
        float f2 = this.j.right - this.f;
        if (Float.compare(c(), d()) != 0) {
            Path path = this.e;
            Rect rect = this.j;
            path.addRect(this.f + rect.left, rect.top, f2, rect.bottom, Path.Direction.CCW);
        }
        float fD = Float.compare(c(), 0.0f) != 0 ? ((f - d()) / c()) * this.f : 0.0f;
        RectF rectF = this.c;
        Rect rect2 = this.j;
        rectF.set(f2 - fD, rect2.top, f2 + fD, rect2.bottom);
        this.e.addArc(this.c, 270.0f, 180.0f);
    }

    void b(float f, float f2, float f3, float f4) {
        this.b.set(f, f2, f3, f4);
    }

    protected float c() {
        return this.d;
    }

    protected float d() {
        return this.f18661a;
    }

    @Override // com.huawei.uikit.animations.drawable.HwEclipseClipDrawable
    public Path getClipPath(int i) {
        float f = i / 10000.0f;
        if (Float.compare(f, c()) < 0) {
            e(f);
        } else if (Float.compare(f, d()) < 0) {
            c(f);
        } else {
            h(f);
        }
        return this.e;
    }

    @Override // com.huawei.uikit.animations.drawable.HwEclipseClipDrawable, android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        c(i, i2, i3, i4);
        int i5 = i3 - i;
        if (i5 != 0) {
            d(this.f / i5);
            a(1.0f - c());
        }
    }

    void c(int i, int i2, int i3, int i4) {
        this.j.set(i, i2, i3, i4);
        b(i, i2, i + r4, i4);
        this.f = b(i4 - i2);
    }

    private void a(float f) {
        this.f18661a = f;
    }
}
