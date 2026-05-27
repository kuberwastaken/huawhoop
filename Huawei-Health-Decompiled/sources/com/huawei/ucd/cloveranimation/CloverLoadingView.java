package com.huawei.ucd.cloveranimation;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.health.R;
import defpackage.pcd;
import defpackage.pce;

/* JADX INFO: loaded from: classes11.dex */
public class CloverLoadingView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AddFrameListener f9080a;
    private Runnable b;
    private AddFrameListener c;
    private boolean d;
    private boolean e;
    private float f;
    private RectF g;
    private float h;
    private pce i;
    private float j;
    private Paint k;
    private Paint l;
    private Bitmap m;
    private Bitmap n;
    private float o;
    private float p;
    private Bitmap q;
    private float t;

    public CloverLoadingView(Context context) {
        this(context, null);
    }

    public CloverLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloverLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = 1.0f;
        this.j = 0.74f;
        this.h = 0.74f;
        this.f = 0.74f;
        this.m = null;
        this.q = null;
        this.n = null;
        this.d = false;
        this.b = new Runnable() { // from class: com.huawei.ucd.cloveranimation.CloverLoadingView.3
            @Override // java.lang.Runnable
            public void run() {
                CloverLoadingView cloverLoadingView = CloverLoadingView.this;
                cloverLoadingView.m = cloverLoadingView.cFE_(R.drawable._2131428603_res_0x7f0b04fb);
                CloverLoadingView cloverLoadingView2 = CloverLoadingView.this;
                cloverLoadingView2.q = cloverLoadingView2.cFE_(R.drawable._2131428601_res_0x7f0b04f9);
                CloverLoadingView cloverLoadingView3 = CloverLoadingView.this;
                cloverLoadingView3.n = cloverLoadingView3.cFE_(R.drawable._2131428602_res_0x7f0b04fa);
                CloverLoadingView.this.d = true;
                CloverLoadingView.this.postInvalidate();
                if (CloverLoadingView.this.c != null) {
                    CloverLoadingView.this.c.onFinished();
                }
            }
        };
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap cFE_(int i) {
        Bitmap bitmapCFC_ = cFC_(i);
        Matrix matrix = new Matrix();
        float f = this.o;
        matrix.preScale(f, f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCFC_, 0, 0, bitmapCFC_.getWidth(), bitmapCFC_.getHeight(), matrix, true);
        if (bitmapCFC_.isRecycled()) {
            bitmapCFC_.recycle();
        }
        return bitmapCreateBitmap;
    }

    private Bitmap cFC_(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeStream(getResources().openRawResource(i), null, options);
    }

    public void setAddFrameListener(AddFrameListener addFrameListener) {
        this.c = addFrameListener;
    }

    public void setLoadingEndListener(AddFrameListener addFrameListener) {
        this.f9080a = addFrameListener;
    }

    public void setCustom(boolean z) {
        this.e = z;
    }

    public pce getCloverData() {
        return this.i;
    }

    private void e() {
        this.i = new pce();
        this.k = new Paint(1);
        this.g = new RectF();
        this.l = new Paint(1);
    }

    private void c() {
        new Thread(this.b).start();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        float f = i;
        float f2 = i2;
        this.g.set(0.0f, 0.0f, f, f2);
        this.t = (f / 2.0f) - (this.i.g() / 2.0f);
        this.p = (f2 * 0.56f) - this.i.h();
        this.o = Math.min(i, i2) / (Math.max(this.i.g(), this.i.h()) * 2.0f);
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.k.setShader(null);
        this.k.setAlpha(255);
        cFz_(canvas);
        cFx_(canvas);
    }

    private void cFB_(Canvas canvas, int i, int i2, float f) {
        canvas.save();
        this.l.setAlpha(255);
        if (this.m == null) {
            return;
        }
        float f2 = this.j;
        canvas.scale(f2, f2, getWidth() / 2.0f, getHeight() * 0.56f);
        canvas.drawBitmap(this.m, (getWidth() - i) / 2.0f, ((getHeight() * 0.56f) - i2) - f, this.l);
        canvas.restore();
    }

    private void cFy_(Canvas canvas, int i, int i2, float f) {
        if (this.n == null) {
            return;
        }
        canvas.save();
        this.l.setAlpha(255);
        float f2 = this.h;
        canvas.scale(f2, f2, getWidth() / 2.0f, getHeight() * 0.56f);
        canvas.drawBitmap(this.n, ((getWidth() / 2.0f) - i) - f, ((getHeight() * 0.56f) - (i2 * 0.211f)) + f, this.l);
        canvas.restore();
    }

    private void cFA_(Canvas canvas, int i, float f) {
        if (this.q == null) {
            return;
        }
        canvas.save();
        this.l.setAlpha(255);
        float f2 = this.f;
        canvas.scale(f2, f2, getWidth() / 2.0f, getHeight() * 0.56f);
        canvas.drawBitmap(this.q, (getWidth() / 2.0f) + f, ((getHeight() * 0.56f) - (i * 0.211f)) + f, this.l);
        canvas.restore();
    }

    private void cFx_(Canvas canvas) {
        Bitmap bitmap;
        if (!this.d || (bitmap = this.m) == null || this.n == null || this.q == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = this.m.getHeight();
        float height2 = getHeight() * 0.03f;
        cFB_(canvas, width, height, height2);
        float f = height2 * 0.707f;
        cFA_(canvas, height, f);
        cFy_(canvas, width, height, f);
    }

    private void setPetalBackgroundColor(LinearGradient linearGradient) {
        if (this.e) {
            this.k.setShader(linearGradient);
        } else {
            this.k.setShader(this.i.cFk_());
        }
    }

    private void cFz_(Canvas canvas) {
        canvas.save();
        float f = this.h * this.o;
        canvas.scale(f, f, getWidth() / 2.0f, getHeight() * 0.56f);
        setPetalBackgroundColor(this.i.cFm_());
        canvas.translate(this.t, this.p);
        canvas.rotate(-120.0f, this.i.cFq_().x, this.i.cFq_().y);
        canvas.drawPath(this.i.cFp_(), this.k);
        canvas.restore();
        canvas.save();
        float f2 = this.f * this.o;
        canvas.scale(f2, f2, getWidth() / 2.0f, getHeight() * 0.56f);
        setPetalBackgroundColor(this.i.cFs_());
        canvas.translate(this.t, this.p);
        canvas.rotate(120.0f, this.i.cFq_().x, this.i.cFq_().y);
        canvas.drawPath(this.i.cFp_(), this.k);
        canvas.restore();
        canvas.save();
        float f3 = this.j * this.o;
        canvas.scale(f3, f3, getWidth() / 2.0f, getHeight() * 0.56f);
        setPetalBackgroundColor(this.i.cFo_());
        canvas.translate(this.t, this.p);
        canvas.drawPath(this.i.cFp_(), this.k);
        canvas.restore();
    }

    private PropertyValuesHolder cFD_(pcd pcdVar) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.74f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.1875f, 1.0f);
        keyframeOfFloat2.setInterpolator(pcdVar);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.375f, 0.74f);
        keyframeOfFloat3.setInterpolator(pcdVar);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.5f, 1.0f);
        keyframeOfFloat4.setInterpolator(pcdVar);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.625f, 0.74f);
        keyframeOfFloat5.setInterpolator(pcdVar);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(0.8125f, 1.0f);
        keyframeOfFloat6.setInterpolator(pcdVar);
        Keyframe keyframeOfFloat7 = Keyframe.ofFloat(1.0f, 0.74f);
        keyframeOfFloat7.setInterpolator(pcdVar);
        return PropertyValuesHolder.ofKeyframe("scale", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6, keyframeOfFloat7);
    }

    private ValueAnimator getScaleValueAnimator() {
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(cFD_(new pcd()));
        valueAnimatorOfPropertyValuesHolder.setInterpolator(new pcd());
        valueAnimatorOfPropertyValuesHolder.setDuration(2667L);
        valueAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return valueAnimatorOfPropertyValuesHolder;
    }
}
