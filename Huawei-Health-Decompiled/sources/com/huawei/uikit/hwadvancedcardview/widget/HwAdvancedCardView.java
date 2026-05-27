package com.huawei.uikit.hwadvancedcardview.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import androidx.cardview.widget.CardView;
import com.huawei.health.R;
import defpackage.vnc;
import defpackage.vnv;
import defpackage.vpb;
import defpackage.vpd;

/* JADX INFO: loaded from: classes8.dex */
public class HwAdvancedCardView extends CardView {
    private static final int q = 7;
    private static final String r = "HwAdvancedCardView";
    private static final float s = 0.5f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11086a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private Context g;
    private AnimatorSet h;
    private AnimatorSet i;
    private vnv j;
    private Path k;
    private Paint l;
    private boolean m;
    private Paint n;
    private Path o;
    private boolean p;

    public HwAdvancedCardView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100357_res_0x7f0602c5, R.attr._2131100531_res_0x7f060373, R.attr._2131100729_res_0x7f060439, R.attr._2131100730_res_0x7f06043a, R.attr._2131100821_res_0x7f060495}, i, R.style.Widget_Emui_HwAdvancedCardView);
        this.f = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.p = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.e = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.f11086a = typedArrayObtainStyledAttributes.getInt(4, 0);
        this.b = typedArrayObtainStyledAttributes.getInt(3, 4);
        typedArrayObtainStyledAttributes.recycle();
        vnv vnvVar = new vnv(this.g, this, this.b, this.f11086a);
        this.j = vnvVar;
        vnvVar.c(this.e);
    }

    public static HwAdvancedCardView instantiate(Context context) {
        Object objC = vpb.c(context, vpb.d(context, HwAdvancedCardView.class, vpb.e(context, 7, 1)), HwAdvancedCardView.class);
        if (objC instanceof HwAdvancedCardView) {
            return (HwAdvancedCardView) objC;
        }
        return null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        if (!this.p) {
            super.draw(canvas);
        } else {
            if (this.k == null) {
                return;
            }
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            super.draw(canvas);
            this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPath(this.k, this.l);
            canvas.restoreToCount(iSaveLayer);
            this.l.setXfermode(null);
        }
        if (this.m) {
            canvas.drawPath(this.o, this.n);
        }
    }

    public boolean getClickAnimationEnable() {
        return this.f;
    }

    public int getClickAnimationType() {
        return this.d;
    }

    public boolean getForceClipRoundCorner() {
        return this.p;
    }

    public int getShadowSize() {
        return this.j == null ? this.c : this.b;
    }

    public int getShadowStyle() {
        return this.j == null ? this.c : this.f11086a;
    }

    public boolean isShadowEnabled() {
        return this.e;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.p) {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            float radius = super.getRadius();
            Path path = new Path();
            path.addRoundRect(rectF, radius, radius, Path.Direction.CW);
            Path path2 = new Path();
            this.k = path2;
            path2.addRect(rectF, Path.Direction.CW);
            this.k.op(path, Path.Op.DIFFERENCE);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
        a(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            Log.w(r, "onTouchEvent: MotionEvent motionEvent is null!");
            return false;
        }
        if (!this.f) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            AnimatorSet animatorSet = this.i;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSetEyX_ = vnc.eyX_(this, this.d);
            this.h = animatorSetEyX_;
            animatorSetEyX_.start();
        } else if (action == 1 || action == 3) {
            AnimatorSet animatorSet2 = this.h;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSetEyY_ = vnc.eyY_(this, this.d);
            this.i = animatorSetEyY_;
            animatorSetEyY_.start();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClickAnimationEnable(boolean z) {
        this.f = z;
    }

    public void setClickAnimationType(int i) {
        this.d = i;
    }

    public void setForceClipRoundCorner(boolean z) {
        this.p = z;
    }

    public void setInsideShadowClip(boolean z) {
        vnv vnvVar = this.j;
        if (vnvVar != null) {
            vnvVar.b(z);
        }
    }

    public void setShadowEnabled(boolean z) {
        this.e = z;
        if (this.j == null) {
            this.j = new vnv(this.g, this, this.b, this.f11086a);
        }
        this.j.c(this.e);
    }

    public void setShadowSize(int i) {
        if (this.b == i) {
            return;
        }
        this.b = i;
        vnv vnvVar = this.j;
        if (vnvVar != null) {
            vnvVar.e(i);
            if (this.e) {
                this.j.a();
            }
        }
    }

    public void setShadowStyle(int i) {
        if (this.f11086a == i) {
            return;
        }
        this.f11086a = i;
        vnv vnvVar = this.j;
        if (vnvVar != null) {
            vnvVar.b(i);
            if (this.e) {
                this.j.a();
            }
        }
    }

    public HwAdvancedCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100358_res_0x7f0602c6);
    }

    public HwAdvancedCardView(Context context, AttributeSet attributeSet, int i) {
        super(a(context, i), attributeSet, i);
        this.c = -1;
        this.d = 1;
        this.e = false;
        this.f = true;
        this.h = null;
        this.i = null;
        this.m = false;
        this.p = false;
        this.g = super.getContext();
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        this.l.setColor(-1);
        a(this.g, attributeSet, i);
        boolean z = this.g.getResources().getBoolean(R.bool._2131230722_res_0x7f080002);
        this.m = z;
        if (z) {
            int dimensionPixelSize = this.g.getResources().getDimensionPixelSize(R.dimen._2131362579_res_0x7f0a0313) + a(context, 0.5f);
            if (dimensionPixelSize > 0) {
                Paint paint2 = new Paint(5);
                this.n = paint2;
                paint2.setStyle(Paint.Style.STROKE);
                this.n.setColor(getContext().getResources().getColor(R.color._2131297598_res_0x7f09053e));
                this.n.setStrokeWidth(dimensionPixelSize);
                return;
            }
            this.m = false;
        }
    }

    private static Context a(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwAdvancedCardView);
    }

    private void a(int i, int i2) {
        if (this.m) {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            float radius = super.getRadius();
            Path path = new Path();
            this.o = path;
            path.addRoundRect(rectF, radius, radius, Path.Direction.CW);
        }
    }

    private int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
