package com.huawei.uikit.hwprogressindicator.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import androidx.media3.ui.DefaultTimeBar;
import com.huawei.health.R;
import com.huawei.uikit.hwprogressindicator.graphics.drawable.HwLoadingDrawable;
import defpackage.vof;
import defpackage.vpd;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public class HwProgressIndicator extends View {
    private static final DecelerateInterpolator e = new DecelerateInterpolator(0.8f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private vof f11178a;
    private Paint aa;
    private int ab;
    private boolean ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private ArgbEvaluator ai;
    private Paint aj;
    private int ak;
    private float al;
    private Paint am;
    private boolean an;
    private boolean b;
    private boolean c;
    private int d;
    private boolean f;
    private HwLoadingDrawable g;
    private boolean h;
    private int i;
    private int j;
    private long k;
    private ObjectAnimator l;
    private float m;
    private boolean n;
    private OnSmoothProgressDurationListener o;
    private int p;
    private RectF q;
    private RectF r;
    private float s;
    private final Property<HwProgressIndicator, Float> t;
    private int u;
    private int v;
    private int w;
    private float[] x;
    private int[] y;
    private int z;

    public interface OnSmoothProgressDurationListener {
        long getAnimationDuration(float f);
    }

    class b implements HwLoadingDrawable.OnLoadingListener {
        b() {
        }

        @Override // com.huawei.uikit.hwprogressindicator.graphics.drawable.HwLoadingDrawable.OnLoadingListener
        public void onLoadingFinish() {
            HwProgressIndicator.this.h = true;
            if (HwProgressIndicator.this.f11178a != null && HwProgressIndicator.this.a()) {
                HwProgressIndicator.this.f11178a.e();
            }
            HwProgressIndicator.this.b();
        }

        @Override // com.huawei.uikit.hwprogressindicator.graphics.drawable.HwLoadingDrawable.OnLoadingListener
        public void onLoadingStart() {
            HwProgressIndicator.this.h = false;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HwProgressIndicator.this.l();
        }
    }

    public HwProgressIndicator(Context context) {
        this(context, null);
    }

    private void eCq_(Resources resources) {
        int iECd_ = eCd_(resources);
        if (iECd_ == 0) {
            return;
        }
        int iECj_ = (int) ((this.ad * eCj_(resources)) / iECd_);
        setPadding(iECj_, iECj_, iECj_, iECj_);
    }

    private void eCs_(Resources resources) {
        eCq_(resources);
        int height = getHeight();
        int width = getWidth();
        int iMin = Math.min((height - getPaddingBottom()) - getPaddingTop(), (width - getPaddingLeft()) - getPaddingRight());
        this.q.set((width - iMin) / 2, (height - iMin) / 2, r1 + iMin, r0 + iMin);
        this.aa.setStrokeWidth(this.ad);
        this.aj.setStrokeWidth(this.ad);
        float f = this.ad / 2.0f;
        HwLoadingDrawable hwLoadingDrawable = this.g;
        if (hwLoadingDrawable != null) {
            hwLoadingDrawable.e(f);
        }
        vof vofVar = this.f11178a;
        if (vofVar != null) {
            vofVar.c(this.ad);
        }
        if (this.v != 0) {
            return;
        }
        eCt_(resources);
        j();
    }

    private void eCt_(Resources resources) {
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen._2131364357_res_0x7f0a0a05);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen._2131364359_res_0x7f0a0a07);
        int i = this.ad;
        if ((i != dimensionPixelSize || this.ag != dimensionPixelSize2) && dimensionPixelSize != 0) {
            float f = dimensionPixelSize;
            this.ag = (int) ((i * dimensionPixelSize2) / f);
            this.ah = (int) ((this.ad * resources.getDimensionPixelSize(R.dimen._2131364358_res_0x7f0a0a06)) / f);
            this.af = (int) ((this.ad * resources.getDimensionPixelSize(R.dimen._2131364355_res_0x7f0a0a03)) / f);
            this.ae = (int) ((this.ad * resources.getDimensionPixelSize(R.dimen._2131364356_res_0x7f0a0a04)) / f);
            return;
        }
        if (this.ag == -1) {
            this.ag = dimensionPixelSize2;
        }
        if (this.ah <= 0) {
            this.ah = resources.getDimensionPixelSize(R.dimen._2131364358_res_0x7f0a0a06);
        }
        if (this.af == -1) {
            this.af = resources.getDimensionPixelSize(R.dimen._2131364355_res_0x7f0a0a03);
        }
        if (this.ae == -1) {
            this.ae = resources.getDimensionPixelSize(R.dimen._2131364356_res_0x7f0a0a04);
        }
    }

    private void f() {
        vof vofVar = this.f11178a;
        if (vofVar == null || !vofVar.d()) {
            return;
        }
        this.f11178a.setLevel((int) (this.m * 10000.0f));
    }

    private void g() {
        r();
        p();
    }

    private void k() {
        m();
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.n) {
            this.c = false;
            o();
            this.n = false;
        }
    }

    private void m() {
        HwLoadingDrawable hwLoadingDrawable = this.g;
        if (hwLoadingDrawable == null || !hwLoadingDrawable.d()) {
            return;
        }
        this.g.c();
    }

    private void n() {
        vof vofVar = this.f11178a;
        if (vofVar == null || !vofVar.d()) {
            return;
        }
        this.f11178a.i();
    }

    private void o() {
        if (this.f11178a == null) {
            return;
        }
        if (a()) {
            this.f11178a.b();
        } else {
            this.f11178a.c();
        }
    }

    private void p() {
        vof vofVar = this.f11178a;
        if (vofVar == null) {
            return;
        }
        if (this.p == 0) {
            vofVar.i();
        } else if (this.h && a()) {
            this.f11178a.e();
        }
    }

    private void q() {
        if (this.p == 0) {
            ObjectAnimator objectAnimator = this.l;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.l.cancel();
            }
            this.m = 0.0f;
        }
    }

    private void r() {
        HwLoadingDrawable hwLoadingDrawable;
        if (this.p != 0) {
            m();
        } else {
            if (!d() || (hwLoadingDrawable = this.g) == null) {
                return;
            }
            hwLoadingDrawable.b();
        }
    }

    private void s() {
        this.s = this.m * 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisualProgress(float f) {
        this.m = f;
        s();
        invalidate();
    }

    private void t() {
        int iE = e(this.s, 135.0f);
        int iE2 = e(this.s, 225.0f);
        int[] iArr = this.y;
        if (iArr == null) {
            int i = this.z;
            this.y = new int[]{iE, iE2, i, i};
        } else {
            iArr[0] = iE;
            iArr[1] = iE2;
        }
        float f = ((this.s - 225.0f) / 360.0f) + 0.25f;
        float[] fArr = this.x;
        if (fArr == null) {
            this.x = new float[]{0.0f, 0.25f, f, 1.0f};
        } else {
            fArr[2] = f;
        }
    }

    public boolean a() {
        return this.c;
    }

    public boolean d() {
        return this.b;
    }

    public boolean e() {
        return this.f;
    }

    public int getBackGroundColor() {
        return this.ak;
    }

    public int[] getIndicatorColors() {
        return new int[]{this.ab, this.z};
    }

    public int getProgress() {
        return this.p;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        super.invalidateDrawable(drawable);
        if (drawable == this.f11178a || drawable == this.g) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        i();
        h();
        c();
        canvas.rotate(-90.0f, this.q.centerX(), this.q.centerY());
        eCn_(canvas);
        if (this.p <= 0 || !this.h) {
            eCr_(canvas);
        } else {
            eCh_(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent == null) {
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setContentDescription(String.format(Locale.ROOT, "%d%%", Integer.valueOf(this.p)));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        String str = String.format(Locale.ROOT, "%d%%", Integer.valueOf(this.p));
        accessibilityNodeInfo.setHintText(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo.setContentDescription(str);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSizeAndState(this.w, i, 0), View.resolveSizeAndState(this.u, i2, 0));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int iECm_;
        Resources resources = getResources();
        if (resources == null || (iECm_ = eCm_(resources)) == 0) {
            return;
        }
        int iECd_ = eCd_(resources);
        if (this.ac) {
            this.ad = (int) ((iECd_ * Math.min(i, i2)) / iECm_);
            this.ad = Math.min(this.ad, (int) (resources.getDisplayMetrics().density * 32.0f));
        }
        eCs_(resources);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            g();
        } else {
            k();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        super.sendAccessibilityEvent(i);
    }

    public void setBackGroundColor(int i) {
        this.ak = i;
        Paint paint = this.aj;
        if (paint != null) {
            paint.setColor(i);
        }
        invalidate();
    }

    public void setBlurEnabled(boolean z) {
        if (this.v != 0) {
            Log.w("HwProgressIndicator", "setBlurEnabled: in consideration of the style, do not support to change.");
        } else {
            this.an = z;
            invalidate();
        }
    }

    public void setFlickerAnimationEnabled(boolean z) {
        ObjectAnimator objectAnimator;
        if (this.c == z) {
            return;
        }
        if (this.p == 100) {
            this.c = z;
            return;
        }
        if (this.f11178a == null) {
            this.c = z;
            invalidate();
            return;
        }
        if (z || (objectAnimator = this.l) == null || !objectAnimator.isRunning()) {
            this.c = z;
            o();
        } else {
            this.n = true;
        }
        invalidate();
    }

    public void setIndicatorColors(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            Log.e("HwProgressIndicator", "setIndicatorColors: input parameters is wrong.");
            return;
        }
        this.ab = iArr[0];
        int i = iArr[1];
        this.z = i;
        int[] iArr2 = this.y;
        if (iArr2 != null && iArr2.length > 3) {
            iArr2[2] = i;
            iArr2[3] = i;
        }
        invalidate();
    }

    public void setProgress(int i) {
        if (this.p == i) {
            return;
        }
        this.p = Math.max(0, Math.min(100, i));
        r();
        p();
        q();
        if (this.h) {
            b();
        }
        if (!e()) {
            this.m = this.p / 100.0f;
        }
        s();
        this.k = this.p == 100 ? 0L : System.currentTimeMillis();
        invalidate();
    }

    public void setSmoothProgressDurationListener(OnSmoothProgressDurationListener onSmoothProgressDurationListener) {
        this.o = onSmoothProgressDurationListener;
    }

    public void setSmoothProgressEnabled(boolean z) {
        if (this.f == z) {
            return;
        }
        if (!z) {
            this.m = this.p / 100.0f;
            s();
        }
        this.f = z;
        vof vofVar = this.f11178a;
        if (vofVar != null) {
            vofVar.e(z);
        }
    }

    public void setWaitingAnimationEnabled(boolean z) {
        if (this.b == z) {
            return;
        }
        HwLoadingDrawable hwLoadingDrawable = this.g;
        if (hwLoadingDrawable == null) {
            this.b = z;
            if (this.p <= 0) {
                invalidate();
                return;
            }
            return;
        }
        if (!z) {
            hwLoadingDrawable.c();
        } else if (this.p <= 0) {
            hwLoadingDrawable.b();
        }
        this.b = z;
        invalidate();
    }

    class e extends Property<HwProgressIndicator, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(HwProgressIndicator hwProgressIndicator, Float f) {
            if (hwProgressIndicator == null) {
                return;
            }
            hwProgressIndicator.setVisualProgress(f.floatValue());
            hwProgressIndicator.m = f.floatValue();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float get(HwProgressIndicator hwProgressIndicator) {
            return Float.valueOf(hwProgressIndicator.m);
        }
    }

    public HwProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100667_res_0x7f0603fb);
    }

    private int eCm_(Resources resources) {
        int i = this.v;
        return i != 1 ? i != 2 ? resources.getDimensionPixelSize(R.dimen._2131364362_res_0x7f0a0a0a) : resources.getDimensionPixelSize(R.dimen._2131364372_res_0x7f0a0a14) : resources.getDimensionPixelSize(R.dimen._2131364366_res_0x7f0a0a0e);
    }

    private void eCo_(Resources resources) {
        int i = this.v;
        if (i == 0) {
            this.u = resources.getDimensionPixelSize(R.dimen._2131364360_res_0x7f0a0a08);
            this.w = resources.getDimensionPixelSize(R.dimen._2131364362_res_0x7f0a0a0a);
        } else if (i == 1) {
            this.u = resources.getDimensionPixelSize(R.dimen._2131364364_res_0x7f0a0a0c);
            this.w = resources.getDimensionPixelSize(R.dimen._2131364366_res_0x7f0a0a0e);
        } else {
            this.u = resources.getDimensionPixelSize(R.dimen._2131364370_res_0x7f0a0a12);
            this.w = resources.getDimensionPixelSize(R.dimen._2131364372_res_0x7f0a0a14);
        }
    }

    public HwProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(d(context, i), attributeSet, i);
        this.p = 0;
        this.q = new RectF();
        this.r = new RectF();
        this.v = 0;
        this.w = -1;
        this.u = -1;
        this.aa = new Paint();
        this.ai = null;
        this.an = false;
        this.aj = new Paint();
        this.f11178a = null;
        this.h = true;
        this.g = null;
        this.m = 0.0f;
        this.n = false;
        this.k = 0L;
        this.t = new e(Float.class, "visual_progress");
        eCe_(getContext(), attributeSet, i);
    }

    private int eCj_(Resources resources) {
        int i = this.v;
        if (i == 1) {
            return resources.getDimensionPixelSize(R.dimen._2131364365_res_0x7f0a0a0d);
        }
        if (i != 2) {
            return resources.getDimensionPixelSize(R.dimen._2131364361_res_0x7f0a0a09);
        }
        return resources.getDimensionPixelSize(R.dimen._2131364371_res_0x7f0a0a13);
    }

    private static Context d(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwProgressIndicator);
    }

    private void eCe_(Context context, AttributeSet attributeSet, int i) {
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100376_res_0x7f0602d8, R.attr._2131100377_res_0x7f0602d9, R.attr._2131100379_res_0x7f0602db, R.attr._2131100385_res_0x7f0602e1, R.attr._2131100387_res_0x7f0602e3, R.attr._2131100388_res_0x7f0602e4, R.attr._2131100389_res_0x7f0602e5, R.attr._2131100390_res_0x7f0602e6, R.attr._2131100391_res_0x7f0602e7, R.attr._2131100508_res_0x7f06035c, R.attr._2131100509_res_0x7f06035d, R.attr._2131100664_res_0x7f0603f8, R.attr._2131100665_res_0x7f0603f9, R.attr._2131100666_res_0x7f0603fa, R.attr._2131100668_res_0x7f0603fc, R.attr._2131100669_res_0x7f0603fd, R.attr._2131100670_res_0x7f0603fe, R.attr._2131100735_res_0x7f06043f}, i, R.style.Widget_Emui_HwProgressIndicator);
        this.v = typedArrayObtainStyledAttributes.getInt(17, 0);
        eCo_(resources);
        eCg_(typedArrayObtainStyledAttributes, resources);
        eCl_(typedArrayObtainStyledAttributes, resources);
        eCk_(typedArrayObtainStyledAttributes);
        eCf_(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void j() {
        this.am.setMaskFilter(null);
        if (this.ah <= 0) {
            return;
        }
        try {
            this.am.setMaskFilter(new BlurMaskFilter(this.ah, BlurMaskFilter.Blur.NORMAL));
            this.am.setStrokeWidth(this.ag);
        } catch (IllegalArgumentException unused) {
            Log.w("HwProgressIndicator", "IllegalArgumentException");
        }
    }

    private void h() {
        if (d() && this.g == null) {
            HwLoadingDrawable hwLoadingDrawable = new HwLoadingDrawable(this.q, this.j, this.i, this.ad / 2.0f);
            this.g = hwLoadingDrawable;
            hwLoadingDrawable.setCallback(this);
            this.g.b(new b());
            if (this.p <= 0) {
                this.g.b();
            }
        }
    }

    private void eCn_(Canvas canvas) {
        if (!this.h) {
            canvas.drawArc(this.q, 0.0f, 360.0f, false, this.aj);
            return;
        }
        RectF rectF = this.q;
        float f = this.s;
        canvas.drawArc(rectF, f, 360.0f - f, false, this.aj);
    }

    private void eCl_(TypedArray typedArray, Resources resources) {
        if (this.v != 0) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            setLayerType(1, null);
        }
        this.an = typedArray.getBoolean(4, true);
        this.ag = typedArray.getDimensionPixelSize(8, -1);
        this.ah = typedArray.getDimensionPixelSize(7, -1);
        this.af = typedArray.getDimensionPixelSize(5, -1);
        this.ae = typedArray.getDimensionPixelSize(6, -1);
        this.al = typedArray.getFloat(3, R.dimen._2131364354_res_0x7f0a0a02);
        eCt_(resources);
        Paint paint = new Paint();
        this.am = paint;
        paint.setAntiAlias(true);
        this.am.setMaskFilter(new BlurMaskFilter(this.ah, BlurMaskFilter.Blur.NORMAL));
        this.am.setStrokeWidth(this.ag);
        this.am.setStrokeCap(Paint.Cap.ROUND);
        this.am.setStyle(Paint.Style.STROKE);
        this.am.setAlpha((int) (this.al * 255.0f));
    }

    private void eCr_(Canvas canvas) {
        HwLoadingDrawable hwLoadingDrawable = this.g;
        if (hwLoadingDrawable == null || this.h) {
            return;
        }
        hwLoadingDrawable.draw(canvas);
    }

    private void i() {
        int iE;
        float f;
        if (this.p <= 0) {
            return;
        }
        if (Float.compare(this.s, 225.0f) <= 0) {
            iE = this.z;
            f = this.s / 360.0f;
        } else {
            iE = e(this.s, 225.0f);
            f = 0.625f;
        }
        int iE2 = this.ab;
        if (Float.compare(this.s, 90.0f) < 0) {
            iE2 = e(90.0f, 90.0f - this.s);
        }
        int[] iArr = {iE2, iE, iE2};
        float[] fArr = {0.0f, f, 1.0f};
        this.aa.setShader(new SweepGradient(this.q.centerX(), this.q.centerY(), iArr, fArr));
        if (this.an) {
            this.r.set(this.q);
            this.r.offset(-this.ae, this.af);
            this.am.setShader(new SweepGradient(this.r.centerX(), this.r.centerY(), iArr, fArr));
        }
    }

    private int eCd_(Resources resources) {
        int i = this.v;
        if (i == 1) {
            return resources.getDimensionPixelSize(R.dimen._2131364363_res_0x7f0a0a0b);
        }
        if (i != 2) {
            return resources.getDimensionPixelSize(R.dimen._2131364357_res_0x7f0a0a05);
        }
        return resources.getDimensionPixelSize(R.dimen._2131364369_res_0x7f0a0a11);
    }

    private void eCp_(Canvas canvas) {
        f();
        vof vofVar = this.f11178a;
        if (vofVar != null) {
            vofVar.draw(canvas);
        }
    }

    private void eCg_(TypedArray typedArray, Resources resources) {
        this.ad = typedArray.getDimensionPixelSize(1, -1);
        this.ab = typedArray.getColor(11, -7945729);
        this.z = typedArray.getColor(12, -14331913);
        this.ac = typedArray.getBoolean(0, true);
        if (this.ad == -1) {
            this.ad = eCd_(resources);
        }
        this.aa.setAntiAlias(true);
        this.aa.setStrokeWidth(this.ad);
        this.aa.setStrokeCap(Paint.Cap.ROUND);
        this.aa.setStyle(Paint.Style.STROKE);
    }

    private void eCk_(TypedArray typedArray) {
        this.ak = typedArray.getColor(2, 134217728);
        this.aj.setAntiAlias(true);
        this.aj.setStyle(Paint.Style.STROKE);
        this.aj.setStrokeWidth(this.ad);
        this.aj.setStrokeCap(Paint.Cap.ROUND);
        this.aj.setColor(this.ak);
    }

    private void c() {
        if (a() && this.f11178a == null) {
            vof vofVar = new vof(this.q, this.ad, this.aa);
            this.f11178a = vofVar;
            vofVar.a(this.d);
            this.f11178a.e(this.f);
            this.f11178a.setCallback(this);
            if (this.h) {
                this.f11178a.e();
            }
        }
    }

    private void eCf_(TypedArray typedArray) {
        this.c = typedArray.getBoolean(10, true);
        this.d = typedArray.getColor(9, DefaultTimeBar.DEFAULT_UNPLAYED_COLOR);
        this.b = typedArray.getBoolean(15, true);
        this.j = typedArray.getColor(14, 8831487);
        this.i = typedArray.getColor(16, -14331913);
        this.f = typedArray.getBoolean(13, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.p == 0 || !e()) {
            return;
        }
        float f = this.p / 100.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, this.t, f);
        this.l = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setAutoCancel(true);
        this.l.setDuration(e(f));
        this.l.setInterpolator(e);
        this.l.addListener(new d());
        this.l.start();
    }

    private long e(float f) {
        OnSmoothProgressDurationListener onSmoothProgressDurationListener = this.o;
        if (onSmoothProgressDurationListener != null) {
            return onSmoothProgressDurationListener.getAnimationDuration(f);
        }
        long jAbs = Float.compare(f, this.m) != 0 ? (long) (Math.abs(f - this.m) * 2000.0f) : 0L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.p == 100) {
            return Math.min(500L, jAbs);
        }
        long j = this.k;
        return j != 0 ? Math.min(5000L, Math.max(jAbs, jCurrentTimeMillis - j)) : jAbs;
    }

    private void eCh_(Canvas canvas) {
        if (Float.compare(this.s, 225.0f) <= 0) {
            if (this.an) {
                canvas.drawArc(this.r, 0.0f, this.s, false, this.am);
            }
            canvas.drawArc(this.q, 0.0f, this.s, false, this.aa);
            eCp_(canvas);
            return;
        }
        t();
        if (this.an) {
            eCi_(this.r, this.am, canvas, false);
        }
        eCi_(this.q, this.aa, canvas, true);
    }

    private void eCi_(RectF rectF, Paint paint, Canvas canvas, boolean z) {
        canvas.drawArc(rectF, 0.0f, 225.0f, false, paint);
        vof vofVar = this.f11178a;
        float fA = vofVar != null ? vofVar.a() : 0.0f;
        if (z && Float.compare(fA, 90.0f) < 0) {
            eCp_(canvas);
        }
        canvas.save();
        canvas.rotate(-225.0f, rectF.centerX(), rectF.centerY());
        paint.setShader(new SweepGradient(rectF.centerX(), rectF.centerY(), this.y, this.x));
        canvas.drawArc(rectF, 90.0f, this.s - 225.0f, false, paint);
        canvas.restore();
        if (!z || Float.compare(fA, 90.0f) < 0) {
            return;
        }
        eCp_(canvas);
    }

    private int e(float f, float f2) {
        if (this.ai == null) {
            this.ai = new ArgbEvaluator();
        }
        if (Float.compare(f, 0.0f) == 0) {
            return this.ab;
        }
        return ((Integer) this.ai.evaluate(f2 / f, Integer.valueOf(this.ab), Integer.valueOf(this.z))).intValue();
    }
}
