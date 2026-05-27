package com.huawei.healthcloud.plugintrack.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes5.dex */
public class ShowProgress extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3927a;
    private int[] b;
    private String c;
    private float d;
    private float e;
    private float f;
    private Paint g;
    private String h;
    private float[] i;
    private float j;
    private float k;
    private Paint l;
    private boolean m;
    private boolean n;
    private boolean o;
    private float p;
    private float r;
    private RectF s;
    private float t;

    public ShowProgress(Context context) {
        super(context);
        float[] fArr = {0.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.5f};
        this.i = fArr;
        this.f = fArr[5];
        this.j = fArr[0];
        this.b = new int[]{Color.parseColor("#1F8DFF"), Color.parseColor("#75DF3E"), Color.parseColor("#E6D420"), Color.parseColor("#F5A623"), Color.parseColor("#FF3320")};
        this.e = 0.0f;
        this.d = 0.0f;
        this.n = true;
        this.m = false;
        this.o = true;
        a();
    }

    public ShowProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float[] fArr = {0.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.5f};
        this.i = fArr;
        this.f = fArr[5];
        this.j = fArr[0];
        this.b = new int[]{Color.parseColor("#1F8DFF"), Color.parseColor("#75DF3E"), Color.parseColor("#E6D420"), Color.parseColor("#F5A623"), Color.parseColor("#FF3320")};
        this.e = 0.0f;
        this.d = 0.0f;
        this.n = true;
        this.m = false;
        this.o = true;
        a();
    }

    public ShowProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float[] fArr = {0.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.5f};
        this.i = fArr;
        this.f = fArr[5];
        this.j = fArr[0];
        this.b = new int[]{Color.parseColor("#1F8DFF"), Color.parseColor("#75DF3E"), Color.parseColor("#E6D420"), Color.parseColor("#F5A623"), Color.parseColor("#FF3320")};
        this.e = 0.0f;
        this.d = 0.0f;
        this.n = true;
        this.m = false;
        this.o = true;
        a();
    }

    private void a() {
        this.s = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.l = new Paint(1);
        this.g = new Paint(1);
        this.l.setTextSize(a(11.0f));
        this.l.setTextAlign(Paint.Align.CENTER);
        this.l.setColor(getResources().getColor(R.color._2131299850_res_0x7f090e0a));
        this.t = e(6.0f);
        this.f3927a = e(2.0f);
        this.p = e(4.0f);
        this.r = e(6.0f);
        this.h = getResources().getString(R.string._2130839907_res_0x7f020963);
        this.c = getResources().getString(R.string._2130840162_res_0x7f020a62);
        this.o = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.k = e(1.0f);
        this.s.set(getPaddingStart(), this.t + boN_(this.l) + (this.p * 2.0f), (i - (this.k * (this.i.length - 2))) - getPaddingEnd(), this.t + boN_(this.l) + (this.p * 3.0f));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        float fBoN_ = (this.t * 2.0f) + ((boN_(this.l) + this.r) * 2.0f) + this.p;
        if (!this.n) {
            fBoN_ -= boN_(this.l) + (this.t != 0.0f ? this.r : 0.0f);
        }
        setMeasuredDimension(size, Math.round(fBoN_));
    }

    private int[] b(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = iArr[(iArr.length - i) - 1];
        }
        return iArr2;
    }

    private float[] e(float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[(fArr.length - i) - 1];
        }
        return fArr2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.m) {
            boM_(canvas, b(this.b));
        } else {
            boM_(canvas, this.b);
        }
        boL_(canvas);
    }

    private void boL_(Canvas canvas) {
        float f = this.e;
        float f2 = this.f;
        if (f >= f2 && f2 > 10.0f) {
            this.e = f2 - 1.0f;
        }
        float f3 = this.e;
        float f4 = this.j;
        if (f3 <= f4 && f4 > 10.0f) {
            this.e = 1.0f + f4;
        }
        float f5 = this.e;
        if (f5 < f4) {
            f5 = f4;
        } else if (f5 > f2) {
            f5 = f2;
        }
        this.e = f5;
        float f6 = this.d;
        if (f6 < f4) {
            f2 = f4;
        } else if (f6 <= f2) {
            f2 = f6;
        }
        this.d = f2;
        boJ_(canvas);
        if (this.n) {
            boI_(canvas);
        }
    }

    private void boJ_(Canvas canvas) {
        float fB;
        canvas.save();
        if (this.m) {
            fB = b(this.e) - b(this.f);
        } else {
            fB = b(this.e);
        }
        canvas.translate(fB, 0.0f);
        boH_(canvas, fB, false);
    }

    private void boI_(Canvas canvas) {
        float fB;
        canvas.save();
        if (this.m) {
            fB = b(this.d) - b(this.f);
        } else {
            fB = b(this.d);
        }
        canvas.translate(fB, 0.0f);
        boH_(canvas, fB, true);
    }

    private void boH_(Canvas canvas, float f, boolean z) {
        String str = z ? this.c : this.h;
        if (f < this.l.measureText(str) / 2.0f) {
            boO_(canvas, str, z, f);
        } else if (f >= this.s.right - (this.l.measureText(str) / 2.0f)) {
            boQ_(canvas, str, z, f);
        } else {
            boP_(canvas, str, z);
        }
    }

    private void boP_(Canvas canvas, String str, boolean z) {
        float f;
        float f2;
        float fBoN_;
        if (z) {
            f = this.s.bottom + this.f3927a;
            f2 = this.p + f;
            fBoN_ = boN_(this.l) + f2;
        } else {
            f = this.s.top - this.f3927a;
            f2 = f - this.p;
            fBoN_ = f2 - this.l.getFontMetrics().descent;
        }
        boK_(canvas, new b(this.s.left - 2.0f, f), new b((this.s.left - this.f3927a) - 2.0f, f2), new b((this.s.left + this.f3927a) - 2.0f, f2));
        canvas.drawText(str, this.s.left, fBoN_, this.l);
        canvas.restore();
    }

    private void boQ_(Canvas canvas, String str, boolean z, float f) {
        float f2;
        float fBoN_;
        if (z) {
            float f3 = this.s.bottom + this.f3927a;
            float f4 = this.s.right;
            float fMeasureText = this.l.measureText(this.h) / 2.0f;
            float f5 = this.p;
            f2 = (f4 - fMeasureText) + f5;
            float f6 = f5 + f3;
            fBoN_ = boN_(this.l) + f6;
            canvas.restore();
            boK_(canvas, new b(f2, f3), new b(f2 - this.f3927a, f6), new b(this.f3927a + f2, f6));
        } else {
            float f7 = this.s.top - this.f3927a;
            float f8 = this.s.right;
            float fMeasureText2 = this.l.measureText(this.h) / 2.0f;
            float f9 = this.p;
            float f10 = f7 - f9;
            float f11 = f10 - this.l.getFontMetrics().descent;
            canvas.restore();
            boK_(canvas, new b(f, f7), new b(f - this.f3927a, f10), new b(f + this.f3927a, f10));
            f2 = (f8 - fMeasureText2) + f9;
            fBoN_ = f11;
        }
        canvas.drawText(str, f2, fBoN_, this.l);
    }

    private void boO_(Canvas canvas, String str, boolean z, float f) {
        float fBoN_;
        float fMeasureText;
        if (z) {
            float f2 = this.s.bottom + this.f3927a;
            fMeasureText = (this.l.measureText(this.h) / 2.0f) + this.f3927a;
            float f3 = this.p + f2;
            fBoN_ = boN_(this.l) + f3;
            canvas.restore();
            boK_(canvas, new b(fMeasureText, f2), new b(this.f3927a + fMeasureText, f3), new b(fMeasureText - this.f3927a, f3));
        } else {
            float f4 = this.s.top - this.f3927a;
            float fMeasureText2 = this.l.measureText(this.h) / 2.0f;
            float f5 = f4 - this.p;
            float f6 = this.l.getFontMetrics().descent;
            canvas.restore();
            boK_(canvas, new b(f, f4), new b(f - this.f3927a, f5), new b(f + this.f3927a, f5));
            fBoN_ = f5 - f6;
            fMeasureText = fMeasureText2;
        }
        canvas.drawText(str, fMeasureText, fBoN_, this.l);
    }

    private void boK_(Canvas canvas, b bVar, b bVar2, b bVar3) {
        Path path = new Path();
        path.moveTo(bVar.c(), bVar.b());
        path.lineTo(bVar2.c(), bVar2.b());
        path.lineTo(bVar3.c(), bVar3.b());
        path.close();
        canvas.drawPath(path, this.l);
    }

    private void boM_(Canvas canvas, int[] iArr) {
        if (this.m && this.o) {
            this.o = false;
            float[] fArrE = e(this.i);
            this.i = fArrE;
            this.j = fArrE[fArrE.length - 1];
            this.f = fArrE[0];
        }
        float f = 0.0f;
        for (int i = 0; i < this.i.length - 1; i++) {
            if (iArr.length > i) {
                this.g.setColor(iArr[i]);
                float[] fArr = this.i;
                float f2 = (((fArr[i + 1] - fArr[i]) * 1.0f) / (fArr[fArr.length - 1] - fArr[0])) * (this.s.right - this.s.left);
                if (i == 0) {
                    Path path = new Path();
                    path.addRoundRect(new RectF(this.s.left, this.s.top, this.s.left + f2, this.s.bottom), new float[]{(this.s.bottom - this.s.top) / 2.0f, (this.s.bottom - this.s.top) / 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, (this.s.bottom - this.s.top) / 2.0f, (this.s.bottom - this.s.top) / 2.0f}, Path.Direction.CCW);
                    canvas.drawPath(path, this.g);
                    f = this.s.left + f2 + this.k;
                } else if (i == this.i.length - 2) {
                    Path path2 = new Path();
                    path2.addRoundRect(new RectF(f, this.s.top, f2 + f, this.s.bottom), new float[]{0.0f, 0.0f, (this.s.bottom - this.s.top) / 2.0f, (this.s.bottom - this.s.top) / 2.0f, (this.s.bottom - this.s.top) / 2.0f, (this.s.bottom - this.s.top) / 2.0f, 0.0f, 0.0f}, Path.Direction.CCW);
                    canvas.drawPath(path2, this.g);
                    f = 0.0f;
                } else {
                    canvas.drawRect(f, this.s.top, f + f2, this.s.bottom, this.g);
                    f += f2 + this.k;
                }
            }
        }
    }

    private float b(float f) {
        float[] fArr = this.i;
        float f2 = fArr[0];
        return (((f - f2) * 1.0f) / (fArr[fArr.length - 1] - f2)) * ((this.s.right - this.s.left) + (this.k * (this.i.length - 1)));
    }

    public ShowProgress d(float... fArr) {
        this.i = fArr;
        return this;
    }

    public ShowProgress d(Integer... numArr) {
        this.i = new float[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            this.i[i] = numArr[i].intValue();
        }
        float[] fArr = this.i;
        this.f = fArr[fArr.length - 1];
        this.j = fArr[0];
        return this;
    }

    public ShowProgress e(int... iArr) {
        this.b = iArr;
        return this;
    }

    private float e(float f) {
        return TypedValue.applyDimension(1, f, getContext().getResources().getDisplayMetrics());
    }

    private float a(float f) {
        return TypedValue.applyDimension(2, f, getContext().getResources().getDisplayMetrics());
    }

    private float boN_(Paint paint) {
        return -paint.getFontMetrics().ascent;
    }

    public ShowProgress c(float f) {
        this.e = f;
        return this;
    }

    public ShowProgress d(float f) {
        this.d = f;
        return this;
    }

    public ShowProgress e(boolean z) {
        this.n = z;
        return this;
    }

    public ShowProgress e(int i) {
        this.t = i;
        return this;
    }

    public ShowProgress b(int i) {
        this.l.setColor(i);
        return this;
    }

    public ShowProgress a(boolean z) {
        this.m = z;
        invalidate();
        return this;
    }

    public ShowProgress c(String str) {
        if (str != null) {
            this.h = str;
        }
        return this;
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f3928a;
        private float e;

        b(float f, float f2) {
            this.f3928a = f;
            this.e = f2;
        }

        public float c() {
            return this.f3928a;
        }

        public float b() {
            return this.e;
        }
    }
}
