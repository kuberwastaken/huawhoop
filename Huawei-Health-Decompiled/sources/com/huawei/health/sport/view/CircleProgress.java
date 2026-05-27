package com.huawei.health.sport.view;

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
    private boolean f3074a;
    private long c;
    private float d;
    private ValueAnimator e;
    private int[] f;
    private int[] g;
    private Paint h;
    private Paint i;
    private float j;
    private float k;
    private int l;
    private Point m;
    private Context n;
    private ProgressUpdate o;
    private RectF p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float y;

    public interface ProgressUpdate {
        void onUpdate(int i, int i2);
    }

    public CircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new int[]{-1, -1};
        this.g = new int[]{-1, -1};
        aAm_(context, attributeSet);
    }

    private void aAm_(Context context, AttributeSet attributeSet) {
        this.n = context;
        this.l = e(context, 0.0f);
        this.e = new ValueAnimator();
        this.p = new RectF();
        this.m = new Point();
        aAn_(attributeSet);
        d();
    }

    private void aAn_(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.n.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131099732_res_0x7f060054, R.attr._2131099737_res_0x7f060059, R.attr._2131099740_res_0x7f06005c, R.attr._2131099742_res_0x7f06005e, R.attr._2131099803_res_0x7f06009b, R.attr._2131101567_res_0x7f06077f, R.attr._2131101626_res_0x7f0607ba});
        this.f3074a = typedArrayObtainStyledAttributes.getBoolean(1, true);
        this.j = typedArrayObtainStyledAttributes.getDimension(3, 8.0f);
        this.r = typedArrayObtainStyledAttributes.getFloat(5, 135.0f);
        this.s = typedArrayObtainStyledAttributes.getFloat(6, 270.0f);
        this.c = typedArrayObtainStyledAttributes.getInt(0, 1000);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            try {
                int[] intArray = getResources().getIntArray(resourceId);
                if (intArray.length == 0) {
                    int color = getResources().getColor(resourceId);
                    this.f = new int[]{color, color};
                } else if (intArray.length == 1) {
                    this.f = new int[]{intArray[0], intArray[0]};
                } else {
                    this.f = intArray;
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
                    this.g = new int[]{color2, color2};
                } else if (intArray2.length == 1) {
                    this.g = new int[]{intArray2[0], intArray2[0]};
                } else {
                    this.g = intArray2;
                }
            } catch (Resources.NotFoundException unused2) {
                LogUtil.d(b, "the give resource not found.");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void d() {
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(this.f3074a);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(this.j);
        this.i.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(this.f3074a);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setStrokeWidth(this.j);
        this.h.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(b(i, this.l), b(i2, this.l));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = (int) this.j;
        int paddingTop = getPaddingTop();
        this.q = Math.min(((i - paddingLeft) - paddingRight) - (i5 * 2), ((i2 - paddingTop) - getPaddingBottom()) - (((int) this.j) * 2)) / 2.0f;
        this.m.x = i / 2;
        this.m.y = i2 / 2;
        this.p.left = (this.m.x - this.q) - (this.j / 2.0f);
        this.p.top = (this.m.y - this.q) - (this.j / 2.0f);
        this.p.right = this.m.x + this.q + (this.j / 2.0f);
        this.p.bottom = this.m.y + this.q + (this.j / 2.0f);
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aAl_(canvas);
    }

    private void aAl_(Canvas canvas) {
        float degrees = (float) Math.toDegrees((((double) (this.j / 2.0f)) * Math.sqrt(2.0d)) / ((double) this.q));
        canvas.save();
        canvas.rotate(this.r - degrees, this.m.x, this.m.y);
        canvas.drawArc(this.p, degrees, this.s, false, this.h);
        canvas.drawArc(this.p, degrees, Math.min(this.t, 1.0f) * this.s, false, this.i);
        canvas.rotate(-this.r, this.m.x, this.m.y);
        canvas.restore();
    }

    private void c() {
        this.i.setShader(new SweepGradient(this.m.x, this.m.y, this.f, (float[]) null));
        this.h.setShader(new SweepGradient(this.m.x, this.m.y, this.g, (float[]) null));
    }

    public void setValue(int i, int i2, boolean z, ProgressUpdate progressUpdate) {
        this.o = progressUpdate;
        float f = i2;
        this.k = f;
        float f2 = i;
        this.d = f2;
        float f3 = z ? this.t : 0.0f;
        float f4 = i2 > 0 ? f2 / f : 1.0f;
        LogUtil.a(b, "setValue mMaxValue ", Float.valueOf(f), " inputValue ", Float.valueOf(this.d), " start ", Float.valueOf(f3), " end ", Float.valueOf(f4));
        a(f3, f4, 1000L);
    }

    private void a(float f, float f2, long j) {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.e.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.e = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(j);
        this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: gks
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.b.aAo_(valueAnimator2);
            }
        });
        this.e.start();
    }

    public /* synthetic */ void aAo_(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.t = fFloatValue;
        ProgressUpdate progressUpdate = this.o;
        if (progressUpdate != null) {
            float f = this.k;
            if (f > 0.0f) {
                progressUpdate.onUpdate(Math.round(fFloatValue * f), (int) this.k);
            } else {
                this.t = 0.0f;
                progressUpdate.onUpdate(Math.round(this.d), (int) this.k);
            }
        }
        this.y = this.t * this.k;
        invalidate();
    }

    private int e(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + ((f >= 0.0f ? 1 : -1) * 0.5f));
    }

    private int b(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i2 = size;
        }
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }
}
