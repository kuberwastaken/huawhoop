package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.huawei.health.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes11.dex */
public class vpf extends Drawable {
    private int f;
    private int i;
    private Interpolator m;
    private Animator n;
    private int d = 0;
    private Paint b = new Paint(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RectF f18710a = new RectF();
    private int e = 8;
    private int c = 8;
    private boolean g = false;
    private int h = 0;
    private int j = 0;
    private int l = 255;
    private float o = 0.0f;
    private boolean k = false;
    private long t = 150;
    private long q = 150;

    public vpf() {
        this.b.setStyle(Paint.Style.FILL);
    }

    private boolean d(boolean z) {
        if (this.k == z) {
            return false;
        }
        this.k = z;
        return true;
    }

    private int e(int i, int i2) {
        return ((((i2 >>> 24) * (i + (i >> 7))) >> 8) << 24) | ((i2 << 8) >>> 8);
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.t = j;
    }

    public void b(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.q = j;
    }

    public void c(int i) {
        this.j = i;
    }

    public void d(int i) {
        this.c = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i = this.j;
        int i2 = this.h;
        if (i2 != 0) {
            i = i2;
        }
        this.b.setColor(e(this.l, i));
        RectF rectF = this.f18710a;
        Rect bounds = getBounds();
        if (c()) {
            float f = bounds.left + this.d;
            rectF.left = f;
            rectF.right = f + this.i;
        } else {
            float f2 = bounds.right - this.d;
            rectF.right = f2;
            rectF.left = f2 - this.i;
        }
        rectF.top = bounds.top;
        rectF.bottom = bounds.bottom;
        float fWidth = this.o;
        if (Float.compare(fWidth, 0.0f) <= 0) {
            fWidth = rectF.width() * 0.5f;
        }
        canvas.drawRoundRect(rectF, fWidth, fWidth, this.b);
    }

    public void e(int i) {
        if (this.i != i) {
            this.i = i;
            invalidateSelf();
        }
    }

    public void eEG_(Interpolator interpolator) {
        this.m = interpolator;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (this.h >>> 24) == 255 ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayEED_ = eED_(resources, theme, attributeSet, new int[]{R.attr._2131100687_res_0x7f06040f, R.attr._2131100688_res_0x7f060410, R.attr._2131100689_res_0x7f060411, R.attr._2131100690_res_0x7f060412, R.attr._2131100691_res_0x7f060413, R.attr._2131100692_res_0x7f060414, R.attr._2131100693_res_0x7f060415});
        eEE_(null, typedArrayEED_);
        typedArrayEED_.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z;
        if (d(iArr)) {
            this.f = this.c;
            z = true;
        } else {
            this.f = this.e;
            z = false;
        }
        if (!d(z)) {
            return false;
        }
        Animator animator = this.n;
        if (animator != null && animator.isRunning()) {
            this.n.cancel();
        }
        Animator animatorA = a(z);
        this.n = animatorA;
        animatorA.start();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.l != i) {
            this.l = i;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.g = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        this.h = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    private boolean d(int[] iArr) {
        return a(iArr, android.R.attr.state_pressed);
    }

    private boolean c() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    private Animator a(boolean z) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "scrollbarWidth", this.i, this.f);
        Interpolator interpolator = this.m;
        if (interpolator != null) {
            objectAnimatorOfInt.setInterpolator(interpolator);
        }
        if (z) {
            objectAnimatorOfInt.setDuration(this.t);
        } else {
            objectAnimatorOfInt.setDuration(this.q);
        }
        return objectAnimatorOfInt;
    }

    public void eEF_(Context context, AttributeSet attributeSet, int i) {
        if (context == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100687_res_0x7f06040f, R.attr._2131100688_res_0x7f060410, R.attr._2131100689_res_0x7f060411, R.attr._2131100690_res_0x7f060412, R.attr._2131100691_res_0x7f060413, R.attr._2131100692_res_0x7f060414, R.attr._2131100693_res_0x7f060415}, i, R.style.Widget_Emui_HwScrollbarDrawable);
        eEE_(context, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean a(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void eEE_(Context context, TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(4, 8);
        a(dimensionPixelSize);
        e(dimensionPixelSize);
        d(typedArray.getDimensionPixelSize(0, 8));
        b(typedArray.getDimensionPixelSize(2, 8));
        c(typedArray.getColor(1, 0));
        int resourceId = typedArray.getResourceId(3, android.R.anim.linear_interpolator);
        if (resourceId > 0 && context != null) {
            eEG_(AnimationUtils.loadInterpolator(context, resourceId));
        }
        a(typedArray.getInt(5, 150));
        b(typedArray.getInt(6, 150));
    }

    private TypedArray eED_(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
