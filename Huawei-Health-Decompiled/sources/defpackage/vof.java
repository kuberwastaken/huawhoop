package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.media3.ui.DefaultTimeBar;

/* JADX INFO: loaded from: classes8.dex */
public class vof extends Drawable {
    private Paint d;
    private float e;
    private RectF f;
    private long i;
    private Paint l;
    private ValueAnimator n;
    private float c = -80.0f;
    private int b = DefaultTimeBar.DEFAULT_UNPLAYED_COLOR;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f18692a = true;
    private float h = 0.0f;
    private int j = 2;
    private boolean g = false;
    private boolean m = false;
    private boolean o = false;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (vof.this.m) {
                vof.this.i();
                vof.this.m = false;
            }
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e("HwFlickerDrawable", "onAnimationUpdate: animation is null.");
            } else if (vof.this.g()) {
                vof.this.n();
                vof.this.invalidateSelf();
            }
        }
    }

    public vof(RectF rectF, int i, Paint paint) {
        this.f = rectF;
        this.l = paint;
        e(i);
        j();
    }

    private boolean h() {
        return this.j == 1;
    }

    private void k() {
        if (this.f18692a || this.o) {
            float f = this.e;
            this.h = (80.0f + f) / 2000.0f;
            if (Float.compare(f, 0.0f) != 0) {
                this.f18692a = false;
            }
        }
    }

    private void l() {
        setLevel(0);
        this.f18692a = true;
        this.j = 2;
    }

    private void m() {
        int i = this.b;
        int i2 = 16777215 & i;
        this.d.setShader(new SweepGradient(this.f.centerX(), this.f.centerY(), new int[]{i2, i, i2, i2}, new float[]{0.0f, 0.11f, 0.222f, 1.0f}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        k();
        float f = this.c + (this.h * f());
        this.c = f;
        if (Float.compare(f, this.e) > 0) {
            int i = (int) this.e;
            if (i != 0) {
                this.c = (this.c % i) - 80.0f;
            }
            this.f18692a = true;
        }
    }

    private boolean o() {
        return this.j == 2;
    }

    public float a() {
        return this.c;
    }

    public void a(int i) {
        if (this.b != i) {
            this.b = i;
            m();
        }
    }

    public void b() {
        this.g = false;
        e();
    }

    public void c() {
        this.g = true;
        this.j = 1;
    }

    public void c(int i) {
        Paint paint = this.d;
        if (paint != null) {
            paint.setStrokeWidth(i);
        }
    }

    public boolean d() {
        return this.n.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f18692a && (Float.compare(this.e, 360.0f) == 0 || h())) {
            this.m = true;
            return;
        }
        canvas.save();
        eBS_(canvas, this.c);
        canvas.rotate(this.c, this.f.centerX(), this.f.centerY());
        float fMin = Float.compare(this.c + 80.0f, this.e) > 0 ? this.e - this.c : 80.0f;
        float f = this.c;
        if (f < 0.0f) {
            fMin = Math.min(this.e, f + fMin);
        }
        float f2 = fMin;
        float f3 = this.c;
        float f4 = f3 < 0.0f ? -f3 : 0.0f;
        m();
        canvas.drawArc(this.f, f4, f2, false, this.d);
        canvas.restore();
    }

    public void e() {
        this.j = 0;
        this.m = false;
        if (d()) {
            return;
        }
        e(System.currentTimeMillis());
        this.c = -80.0f;
        this.n.start();
        this.n.setRepeatCount(-1);
    }

    public void e(boolean z) {
        this.o = z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void i() {
        if (d()) {
            this.n.cancel();
            l();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        this.e = (i * 360.0f) / 10000.0f;
        if (i < 10000) {
            if (!h()) {
                this.g = false;
            }
            if (o()) {
                this.j = 0;
            }
        } else {
            this.g = true;
            if (this.f18692a) {
                l();
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        boolean z;
        if (o() || (h() && this.f18692a)) {
            this.g = false;
            z = false;
        } else {
            z = true;
        }
        if (!this.g || !this.f18692a) {
            return z;
        }
        this.g = false;
        l();
        return false;
    }

    private void j() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.n = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new c());
        this.n.addListener(new a());
    }

    private void e(int i) {
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setStrokeWidth(i);
        this.d.setStrokeCap(Paint.Cap.SQUARE);
        this.d.setStyle(Paint.Style.STROKE);
        m();
    }

    private void eBS_(Canvas canvas, float f) {
        Path path = new Path();
        float fMin = Math.min(Math.max(0.0f, f), 360.0f);
        path.addArc(this.f, fMin, Float.compare(f, 0.0f) < 0 ? Math.min(80.0f, this.e) : this.e - fMin);
        this.l.getFillPath(path, path);
        canvas.clipPath(path);
    }

    private void e(long j) {
        this.i = j;
    }

    private long f() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.i;
        e(jCurrentTimeMillis);
        return Math.max(0L, jCurrentTimeMillis - j);
    }
}
