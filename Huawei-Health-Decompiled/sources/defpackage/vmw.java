package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.Log;
import com.huawei.health.R;
import com.huawei.openalliance.ad.constant.OsType;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* JADX INFO: loaded from: classes8.dex */
public class vmw extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Rect f18668a;
    protected int b;
    private Drawable c;
    private Drawable d;
    private Context e;
    private ValueAnimator f;
    private int g;
    private int h;
    private ValueAnimator i;
    private int j;
    private ValueAnimator.AnimatorUpdateListener k;
    private Path m;
    private int n;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.w("ComplexDrawable", "onAnimationUpdate: Param valueAnimator is null");
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null || !(animatedValue instanceof Integer)) {
                return;
            }
            vmw.this.a(((Integer) animatedValue).intValue());
        }
    }

    public vmw(Context context, Drawable drawable) {
        this(context, drawable, 0);
    }

    private void ewS_(Drawable drawable, int i) {
        this.h = this.e.getResources().getInteger(R.integer._2131623964_res_0x7f0e001c);
        if (i == 0) {
            this.b = this.e.getResources().getDimensionPixelSize(R.dimen._2131364014_res_0x7f0a08ae);
        } else {
            this.b = i;
        }
        b();
        ewR_(drawable);
        this.k = new a();
        this.m = new Path();
        e();
    }

    public void a(int i) {
        this.g = i;
        invalidateSelf();
    }

    public void a(boolean z, boolean z2) {
        if (z2) {
            d(z);
        } else {
            a(z ? (int) (this.b * 1.42f) : 0);
        }
    }

    protected void b() {
        int i = this.b;
        this.f18668a = new Rect(0, 0, i, i);
    }

    public void b(int i) {
        Drawable drawable = this.d;
        if (drawable == null) {
            return;
        }
        this.j = i;
        drawable.setTint(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            Log.w("ComplexDrawable", "draw: Param canvas is null");
            return;
        }
        this.m.reset();
        this.m.addCircle(a() ? this.f18668a.right : this.f18668a.left, this.f18668a.bottom, this.g, Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(this.m, Region.Op.DIFFERENCE);
        if (this.c.isAutoMirrored() && a()) {
            Rect rect = this.f18668a;
            canvas.translate(rect.right + rect.left, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.c.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.clipPath(this.m);
        if (this.c.isAutoMirrored() && a()) {
            Rect rect2 = this.f18668a;
            canvas.translate(rect2.right + rect2.left, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.d.draw(canvas);
        canvas.restore();
    }

    public void e(int i) {
        Drawable drawable = this.c;
        if (drawable == null) {
            return;
        }
        this.n = i;
        drawable.setTint(i);
        invalidateSelf();
    }

    public Drawable ewT_() {
        return this.c;
    }

    public void ewU_(Drawable drawable) {
        ewR_(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setAlpha(i);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
    }

    public vmw(Context context, Drawable drawable, int i) {
        this.g = 0;
        this.e = context;
        ewS_(drawable, i);
    }

    private boolean a() {
        return getLayoutDirection() == 1;
    }

    private void e() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) (this.b * 1.42f));
        this.i = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.h);
        this.i.addUpdateListener(this.k);
        this.i.setInterpolator(new HwCubicBezierInterpolator(0.2f, 0.0f, 0.2f, 1.0f));
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt((int) (this.b * 1.42f), 0);
        this.f = valueAnimatorOfInt2;
        valueAnimatorOfInt2.setDuration(this.h);
        this.f.addUpdateListener(this.k);
        this.f.setInterpolator(new HwCubicBezierInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
    }

    public void c(int i) {
        this.b = i;
        this.f18668a.set(0, 0, i, i);
        this.i.setIntValues(0, (int) (this.b * 1.42f));
        this.f.setIntValues((int) (this.b * 1.42f), 0);
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setBounds(this.f18668a);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setBounds(this.f18668a);
        }
        invalidateSelf();
    }

    private void ewR_(Drawable drawable) {
        Drawable drawableEwQ_;
        if (!(drawable instanceof StateListDrawable)) {
            if (drawable != null) {
                a(drawable, drawable.getConstantState().newDrawable().mutate());
                return;
            }
            return;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        int identifier = this.e.getResources().getIdentifier("state_selected", "attr", OsType.ANDROID);
        int[] iArr = new int[0];
        int[] iArr2 = {identifier};
        int[] iArr3 = {~identifier};
        Drawable drawableEwQ_2 = null;
        if (Build.VERSION.SDK_INT >= 29) {
            int iFindStateDrawableIndex = stateListDrawable.findStateDrawableIndex(iArr3);
            drawableEwQ_ = iFindStateDrawableIndex != -1 ? stateListDrawable.getStateDrawable(iFindStateDrawableIndex) : null;
            int iFindStateDrawableIndex2 = stateListDrawable.findStateDrawableIndex(iArr2);
            if (iFindStateDrawableIndex2 != -1) {
                drawableEwQ_2 = stateListDrawable.getStateDrawable(iFindStateDrawableIndex2);
            }
        } else {
            int iA = a(stateListDrawable, iArr3);
            drawableEwQ_ = iA != -1 ? ewQ_(stateListDrawable, iA) : null;
            int iA2 = a(stateListDrawable, iArr2);
            if (iA2 != -1) {
                drawableEwQ_2 = ewQ_(stateListDrawable, iA2);
            }
        }
        if (drawableEwQ_ == null && drawableEwQ_2 == null) {
            a(drawable, drawable.getConstantState().newDrawable().mutate());
            return;
        }
        if (drawableEwQ_ != null && drawableEwQ_2 != null) {
            a(drawableEwQ_, drawableEwQ_2);
            return;
        }
        if (a(stateListDrawable, iArr) != -1) {
            int iA3 = a(stateListDrawable, iArr);
            if (drawableEwQ_ == null) {
                drawableEwQ_ = ewQ_(stateListDrawable, iA3);
            }
            if (drawableEwQ_2 == null) {
                drawableEwQ_2 = ewQ_(stateListDrawable, iA3);
            }
            a(drawableEwQ_, drawableEwQ_2);
            return;
        }
        throw new IllegalArgumentException("no resource available to provide");
    }

    private Drawable ewQ_(StateListDrawable stateListDrawable, int i) {
        Object objB = vnl.b(stateListDrawable, "getStateDrawable", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)}, StateListDrawable.class);
        if (objB != null) {
            return (Drawable) objB;
        }
        return null;
    }

    private int a(StateListDrawable stateListDrawable, int[] iArr) {
        Object objB = vnl.b(stateListDrawable, "getStateDrawableIndex", new Class[]{iArr.getClass()}, new Object[]{iArr}, StateListDrawable.class);
        if (objB != null) {
            return ((Integer) objB).intValue();
        }
        return -1;
    }

    private void a(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable2 == null) {
            return;
        }
        this.c = drawable;
        drawable.setBounds(this.f18668a);
        this.d = drawable2;
        drawable2.setBounds(this.f18668a);
        invalidateSelf();
    }

    private void d(boolean z) {
        ValueAnimator valueAnimator = z ? this.f : this.i;
        ValueAnimator valueAnimator2 = z ? this.i : this.f;
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator2.start();
        }
    }
}
