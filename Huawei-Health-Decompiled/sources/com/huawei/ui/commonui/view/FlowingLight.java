package com.huawei.ui.commonui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.huawei.health.R;
import com.huawei.ui.commonui.R$styleable;
import defpackage.pla;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class FlowingLight extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f9338a;
    private long b;
    private ObjectAnimator c;
    private float d;
    private float e;
    private float[] f;
    private final Matrix g;
    private final Paint h;
    private boolean i;
    private LinearGradient j;
    private final RectF k;
    private float l;
    private float n;

    public FlowingLight(Context context) {
        super(context);
        this.h = new Paint(1);
        this.g = new Matrix();
        this.k = new RectF();
        cYw_(context, null);
    }

    public FlowingLight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new Paint(1);
        this.g = new Matrix();
        this.k = new RectF();
        cYw_(context, attributeSet);
    }

    public FlowingLight(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new Paint(1);
        this.g = new Matrix();
        this.k = new RectF();
        cYw_(context, attributeSet);
    }

    private void cYw_(Context context, AttributeSet attributeSet) {
        cYx_(context, attributeSet);
        a();
    }

    private void cYx_(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowingLight);
        this.i = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlowingLight_flowingLightIsClockwise, false);
        this.e = typedArrayObtainStyledAttributes.getFloat(R$styleable.FlowingLight_flowingLightAngle, 0.0f);
        this.b = typedArrayObtainStyledAttributes.getInteger(R$styleable.FlowingLight_flowingLightAnimatorDuration, 0);
        this.l = typedArrayObtainStyledAttributes.getDimension(R$styleable.FlowingLight_flowingLightWidth, pla.b(R.dimen._2131362993_res_0x7f0a04b1));
        this.n = typedArrayObtainStyledAttributes.getDimension(R$styleable.FlowingLight_flowingLightRoundCornerRadius, pla.b(R.dimen._2131363063_res_0x7f0a04f7));
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.FlowingLight_flowingLightColorArray, 0);
        if (resourceId != 0) {
            this.f9338a = pla.g(resourceId);
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.FlowingLight_flowingLightPositionArray, 0);
        if (resourceId2 != 0) {
            String[] strArrI = pla.i(resourceId2);
            int length = strArrI.length;
            this.f = new float[length];
            for (int i = 0; i < length; i++) {
                this.f[i] = Float.parseFloat(strArrI[i]);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a() {
        this.h.setStrokeWidth(this.l);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setStrokeCap(Paint.Cap.ROUND);
        this.h.setStrokeJoin(Paint.Join.ROUND);
    }

    private void d() {
        d(getWidth(), getHeight());
        postInvalidate();
    }

    private void d(int i, int i2) {
        int length;
        float f = this.l / 2.0f;
        this.k.set(f, f, i - f, i2 - f);
        this.d = this.n + f;
        int[] iArr = this.f9338a;
        if (iArr == null || (length = iArr.length) == 0) {
            return;
        }
        float[] fArr = this.f;
        if (fArr == null || fArr.length != length) {
            fArr = null;
        }
        LinearGradient linearGradient = new LinearGradient(this.k.left, this.k.top, this.k.right, this.k.bottom, this.f9338a, fArr, Shader.TileMode.CLAMP);
        this.j = linearGradient;
        this.h.setShader(linearGradient);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.j != null) {
            this.g.reset();
            this.g.setRotate(this.e, this.k.centerX(), this.k.centerY());
            this.j.setLocalMatrix(this.g);
        }
        RectF rectF = this.k;
        float f = this.d;
        canvas.drawRoundRect(rectF, f, f, this.h);
    }

    public void setAngle(float f) {
        if (Float.compare(this.e, f) == 0) {
            return;
        }
        this.e = f;
        postInvalidate();
    }

    public void setBorderWidth(int i) {
        float fB = pla.b(i);
        if (Float.compare(this.l, fB) == 0) {
            return;
        }
        this.l = fB;
        this.h.setStrokeWidth(fB);
        d();
    }

    public void setRoundCornerRadius(int i) {
        float fB = pla.b(i);
        if (Float.compare(this.n, fB) == 0) {
            return;
        }
        this.n = fB;
        d();
    }

    public void setColorArray(int[] iArr) {
        this.f9338a = iArr;
        d();
    }

    public void setPositionArray(float[] fArr) {
        if (Arrays.equals(this.f, fArr)) {
            return;
        }
        this.f = fArr;
        d();
    }

    public void e() {
        e(this.i, this.b);
    }

    public void e(boolean z, long j) {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            float[] fArr = new float[2];
            fArr[0] = z ? 0.0f : 360.0f;
            fArr[1] = z ? 360.0f : 0.0f;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "angle", fArr);
            this.c = objectAnimatorOfFloat;
            if (objectAnimatorOfFloat == null) {
                return;
            }
            objectAnimatorOfFloat.setDuration(j);
            this.c.setRepeatCount(-1);
            this.c.setInterpolator(new LinearInterpolator());
            this.c.start();
        }
    }

    public void c() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator == null) {
            return;
        }
        objectAnimator.cancel();
    }
}
