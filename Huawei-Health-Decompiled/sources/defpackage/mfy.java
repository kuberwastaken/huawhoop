package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.huawei.hwfabengine.FloatingActionButtonAnimationListener;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public class mfy extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15613a;
    private int b;
    private Drawable c;
    private boolean d;
    private int e;
    private FloatingActionButtonAnimationListener f;
    private Drawable.Callback g;
    private boolean h;
    private HashMap<String, Drawable> i;
    private mfu j;
    private final FloatingActionButtonAnimationListener l;
    private ValueAnimator.AnimatorUpdateListener m;
    private final FloatingActionButtonAnimationListener n;

    private boolean j() {
        return false;
    }

    public void a() {
        if (j()) {
            return;
        }
        this.h = true;
        if (this.f15613a) {
            f();
        }
    }

    public void b() {
        if (!j() && this.d) {
            if (this.j == null) {
                Log.e("FloatingActionButtonDrawable", "The paramaters are null, start down animation failed!");
                return;
            }
            this.f15613a = false;
            this.d = false;
            this.h = false;
            Log.i("FloatingActionButtonDrawable", "It starts down animation!");
            bWu_(this.i.get(this.j.e()));
            d(this.l, null);
            c();
        }
    }

    public void b(FloatingActionButtonAnimationListener floatingActionButtonAnimationListener) {
        this.f = floatingActionButtonAnimationListener;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public FloatingActionButtonAnimationListener e() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i < 0) {
            this.c.setAlpha(0);
        } else if (i > 255) {
            this.c.setAlpha(255);
        } else {
            this.c.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    private void f() {
        if (this.j == null || this.f == null) {
            Log.e("FloatingActionButtonDrawable", "The parameters are null, start up animation failed!");
            return;
        }
        Log.i("FloatingActionButtonDrawable", "It starts up animation!");
        this.d = false;
        this.f15613a = false;
        bWu_(this.i.get(this.j.i()));
        d(this.f, this.n);
        d();
    }

    private void bWu_(Drawable drawable) {
        this.c = drawable;
        if (drawable == null) {
            Log.i("FloatingActionButtonDrawable", "The drawable is null!");
            return;
        }
        if (this.b == 0 || this.e == 0) {
            this.b = drawable.getIntrinsicHeight();
            this.e = this.c.getIntrinsicWidth();
        }
        this.c.setBounds(0, 0, this.e, this.b);
        this.c.setCallback(this.g);
    }

    private void d() {
        mfu mfuVar = this.j;
        if (mfuVar != null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(mfuVar.a(), this.j.c());
            valueAnimatorOfFloat.setDuration(this.j.d());
            valueAnimatorOfFloat.setInterpolator(this.j.bWt_());
            valueAnimatorOfFloat.addUpdateListener(this.m);
            valueAnimatorOfFloat.start();
        }
    }

    private void d(FloatingActionButtonAnimationListener floatingActionButtonAnimationListener, FloatingActionButtonAnimationListener floatingActionButtonAnimationListener2) {
        mfv.bWw_(this.c, floatingActionButtonAnimationListener, floatingActionButtonAnimationListener2);
    }

    private void c() {
        mfu mfuVar = this.j;
        if (mfuVar != null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(mfuVar.c(), this.j.a());
            valueAnimatorOfFloat.setDuration(this.j.d());
            valueAnimatorOfFloat.setInterpolator(this.j.bWt_());
            valueAnimatorOfFloat.addUpdateListener(this.m);
            valueAnimatorOfFloat.start();
        }
    }
}
