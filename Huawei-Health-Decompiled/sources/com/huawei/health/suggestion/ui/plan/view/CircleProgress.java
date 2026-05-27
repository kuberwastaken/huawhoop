package com.huawei.health.suggestion.ui.plan.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.health.R;
import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes10.dex */
public class CircleProgress extends View {
    private static final String b = "CircleProgress";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f3390a;
    private ValueAnimator c;
    private float d;
    private boolean e;
    private float f;
    private Paint g;
    private int[] h;
    private int[] i;
    private Paint j;
    private int k;
    private float l;
    private ProgressUpdate m;
    private Point n;
    private Context o;
    private float p;
    private RectF q;
    private float r;
    private float s;
    private float t;
    private float w;

    public interface ProgressUpdate {
        void onUpdate(int i, int i2);
    }

    public CircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new int[]{-1, -1};
        this.i = new int[]{-1, -1};
        aMP_(context, attributeSet);
    }

    private void aMP_(Context context, AttributeSet attributeSet) {
        this.o = context;
        this.k = b(context, 0.0f);
        this.c = new ValueAnimator();
        this.q = new RectF();
        this.n = new Point();
        aMQ_(attributeSet);
        e();
    }

    private void aMQ_(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.o.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131099732_res_0x7f060054, R.attr._2131099737_res_0x7f060059, R.attr._2131099740_res_0x7f06005c, R.attr._2131099742_res_0x7f06005e, R.attr._2131099803_res_0x7f06009b, R.attr._2131101567_res_0x7f06077f, R.attr._2131101626_res_0x7f0607ba});
        this.e = typedArrayObtainStyledAttributes.getBoolean(1, true);
        this.f = typedArrayObtainStyledAttributes.getDimension(3, 8.0f);
        this.r = typedArrayObtainStyledAttributes.getFloat(5, 135.0f);
        this.s = typedArrayObtainStyledAttributes.getFloat(6, 270.0f);
        this.f3390a = typedArrayObtainStyledAttributes.getInt(0, 1000);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            try {
                int[] intArray = getResources().getIntArray(resourceId);
                if (intArray.length == 0) {
                    int color = getResources().getColor(resourceId);
                    this.h = new int[]{color, color};
                } else if (intArray.length == 1) {
                    this.h = new int[]{intArray[0], intArray[0]};
                } else {
                    this.h = intArray;
                }
            } catch (Resources.NotFoundException unused) {
                LogUtil.d(b, "the give resource not found.");
            }
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        if (resourceId2 != 0) {
            try {
                int[] intArray2 = getResources().getIntArray(resourceId2);
                if (intArray2.length == 0) {
                    int color2 = getResources().getColor(resourceId2);
                    this.i = new int[]{color2, color2};
                } else if (intArray2.length == 1) {
                    this.i = new int[]{intArray2[0], intArray2[0]};
                } else {
                    this.i = intArray2;
                }
            } catch (Resources.NotFoundException unused2) {
                LogUtil.d(b, "the give resource not found.");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void e() {
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(this.e);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setStrokeWidth(this.f);
        this.j.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setAntiAlias(this.e);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(this.f);
        this.g.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(d(i, this.k), d(i2, this.k));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = (int) this.f;
        int paddingTop = getPaddingTop();
        this.t = Math.min(((i - paddingLeft) - paddingRight) - (i5 * 2), ((i2 - paddingTop) - getPaddingBottom()) - (((int) this.f) * 2)) / 2.0f;
        this.n.x = i / 2;
        this.n.y = i2 / 2;
        this.q.left = (this.n.x - this.t) - (this.f / 2.0f);
        this.q.top = (this.n.y - this.t) - (this.f / 2.0f);
        this.q.right = this.n.x + this.t + (this.f / 2.0f);
        this.q.bottom = this.n.y + this.t + (this.f / 2.0f);
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aMO_(canvas);
    }

    private void aMO_(Canvas canvas) {
        float degrees = (float) Math.toDegrees((((double) (this.f / 2.0f)) * Math.sqrt(2.0d)) / ((double) this.t));
        canvas.save();
        canvas.rotate(this.r - degrees, this.n.x, this.n.y);
        canvas.drawArc(this.q, degrees, this.s, false, this.g);
        canvas.drawArc(this.q, degrees, Math.min(this.p, 1.0f) * this.s, false, this.j);
        canvas.restore();
    }

    private void c() {
        this.j.setShader(new SweepGradient(this.n.x, this.n.y, this.h, (float[]) null));
        this.g.setShader(new SweepGradient(this.n.x, this.n.y, this.i, (float[]) null));
    }

    public void setValue(int i, int i2, boolean z) {
        float f = i2;
        this.l = f;
        float f2 = i;
        this.d = f2;
        float f3 = z ? this.p : 0.0f;
        float f4 = i2 > 0 ? f2 / f : 1.0f;
        LogUtil.a(b, "setValueWithOutCallback mMaxValue ", Float.valueOf(f), " inputValue ", Float.valueOf(this.d), " start ", Float.valueOf(f3), " end ", Float.valueOf(f4));
        d(f3, f4, 0L);
    }

    public void setValue(int i, int i2, boolean z, ProgressUpdate progressUpdate) {
        this.m = progressUpdate;
        float f = i2;
        this.l = f;
        float f2 = i;
        this.d = f2;
        float f3 = z ? this.p : 0.0f;
        float f4 = i2 > 0 ? f2 / f : 1.0f;
        LogUtil.a(b, "setValue mMaxValue ", Float.valueOf(f), " inputValue ", Float.valueOf(this.d), " start ", Float.valueOf(f3), " end ", Float.valueOf(f4));
        d(f3, f4, 1000L);
    }

    private void d(float f, float f2, long j) {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.c.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(j);
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: hft
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.c.aMR_(valueAnimator2);
            }
        });
        this.c.start();
    }

    public /* synthetic */ void aMR_(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.p = fFloatValue;
        ProgressUpdate progressUpdate = this.m;
        if (progressUpdate != null) {
            float f = this.l;
            if (f > 0.0f) {
                progressUpdate.onUpdate(Math.round(fFloatValue * f), (int) this.l);
            } else {
                this.p = 0.0f;
                progressUpdate.onUpdate(Math.round(this.d), (int) this.l);
            }
        }
        this.w = this.p * this.l;
        invalidate();
    }

    private int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + ((f >= 0.0f ? 1 : -1) * 0.5f));
    }

    private int d(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i2 = size;
        }
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }
}
