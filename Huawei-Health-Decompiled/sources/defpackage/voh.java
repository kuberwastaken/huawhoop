package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes8.dex */
public class voh extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f18694a;
    private Paint b;
    private float c;
    private float d;
    private float e;
    private int h;
    private long l;
    private LinearGradient n;
    private int j = 1728053247;
    private boolean i = true;
    private float g = 0.0f;
    private boolean f = false;
    private Runnable o = new e();

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            voh.this.invalidateSelf();
        }
    }

    public voh() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        this.f18694a = 0.0f;
        this.e = 0.0f;
        c(2);
    }

    private void d(long j) {
        this.l = j;
    }

    private void f() {
        this.g = (this.e + this.c) / 2000.0f;
        if (this.i) {
            this.i = false;
        }
    }

    private boolean g() {
        return this.f && this.i;
    }

    private void h() {
        int i = this.j;
        int i2 = 16777215 & i;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.e, 0.0f, new int[]{i2, i, i2}, new float[]{0.0f, 0.93f, 1.0f}, Shader.TileMode.CLAMP);
        this.n = linearGradient;
        this.b.setShader(linearGradient);
    }

    private void i() {
        this.d = -this.e;
    }

    private boolean j() {
        return this.h == 2;
    }

    public boolean a() {
        return this.h != 2;
    }

    public void b() {
        i();
        c(2);
    }

    public void b(int i) {
        if (this.j != i) {
            this.j = i;
            h();
        }
    }

    public void d() {
        if (this.h == 0) {
            return;
        }
        this.f = false;
        d(System.currentTimeMillis());
        scheduleSelf(this.o, 0L);
        c(0);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (j()) {
            this.f = false;
            return;
        }
        f();
        float fC = this.d + (this.g * c());
        if (Float.compare(fC, this.c) > 0) {
            int i = (int) this.c;
            if (i != 0) {
                fC = (fC % i) - this.e;
            }
            this.i = true;
        }
        this.d = fC;
        canvas.save();
        canvas.translate(fC, 0.0f);
        Rect bounds = getBounds();
        float f = Float.compare(this.e + fC, this.c) > 0 ? this.c - fC : this.e;
        if (Float.compare(fC, 0.0f) < 0) {
            float f2 = bounds.left - fC;
            canvas.clipRect(f2, bounds.top, f2 + f, bounds.bottom);
        }
        float f3 = bounds.left;
        canvas.drawRect(f3, bounds.top, f3 + f, bounds.bottom, this.b);
        canvas.restore();
        scheduleSelf(this.o, 0L);
        if (g()) {
            this.f = false;
            b();
        }
    }

    public void e() {
        if (this.h == 1) {
            return;
        }
        this.f = true;
        c(1);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        this.c = (this.f18694a * i) / 10000.0f;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        d(rect.left, rect.right);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    private long c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.l;
        d(jCurrentTimeMillis);
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        d(i, i3);
    }

    private void c(int i) {
        this.h = i;
    }

    private void d(float f, float f2) {
        float f3 = f2 - f;
        this.f18694a = f3;
        float level = (f3 * getLevel()) / 10000.0f;
        this.c = level;
        float f4 = this.f18694a * 0.3f;
        this.e = f4;
        this.g = (f4 + level) / 2000.0f;
        i();
        h();
    }
}
