package com.huawei.ui.main.stories.settings.activity.heartrate;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.health.R;
import defpackage.kqx;
import defpackage.uvf;
import health.compact.a.LanguageUtil;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class HeartRateZoneSeekBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10935a;
    private float b;
    private float c;
    private uvf d;
    private float e;
    private Path f;
    private int g;
    private boolean h;
    private float i;
    private Paint j;
    private float k;
    private int m;
    private float n;

    public HeartRateZoneSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10935a = false;
        this.h = false;
        this.j = new Paint();
        this.f = new Path();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100119_res_0x7f0601d7, R.attr._2131100120_res_0x7f0601d8, R.attr._2131101127_res_0x7f0605c7, R.attr._2131101268_res_0x7f060654, R.attr._2131101484_res_0x7f06072c, R.attr._2131101756_res_0x7f06083c, R.attr._2131101757_res_0x7f06083d, R.attr._2131101789_res_0x7f06085d});
        this.b = typedArrayObtainStyledAttributes.getDimension(4, getResources().getDimension(R.dimen._2131362040_res_0x7f0a00f8));
        this.n = typedArrayObtainStyledAttributes.getDimension(3, getResources().getDimension(R.dimen._2131365487_res_0x7f0a0e6f));
        this.h = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.m = typedArrayObtainStyledAttributes.getColor(6, getResources().getColor(R.color._2131299850_res_0x7f090e0a));
        this.g = typedArrayObtainStyledAttributes.getColor(5, getResources().getColor(R.color._2131298836_res_0x7f090a14));
        this.e = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.c = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        float dimension = typedArrayObtainStyledAttributes.getDimension(2, 0.0f);
        this.i = dimension;
        this.k = this.b + this.n + this.e + dimension;
        this.f10935a = LanguageUtil.ay(getContext());
        typedArrayObtainStyledAttributes.recycle();
    }

    public void c() {
        postInvalidate();
    }

    public void e(uvf uvfVar) {
        this.d = uvfVar;
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.d == null) {
            return;
        }
        this.j.setStyle(Paint.Style.FILL);
        if (this.f10935a) {
            eof_(canvas);
        } else {
            eoe_(canvas);
        }
        if (!this.h || this.d.e() == null || this.d.e().length <= 0) {
            return;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.n);
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.m);
        eoh_(canvas, textPaint);
    }

    private void eof_(Canvas canvas) {
        float measuredWidth = getMeasuredWidth();
        float f = this.b / 2.0f;
        this.j.setColor(this.d.b());
        if (!this.d.h()) {
            eod_(canvas, measuredWidth, f);
            return;
        }
        uvf.c cVar = this.d.a().get(0);
        uvf.c cVar2 = this.d.a().get(this.d.a().size() - 1);
        float fC = (measuredWidth - this.b) / (this.d.c() - this.d.d());
        if (this.d.c() - cVar2.a() < 0.01f) {
            this.j.setColor(cVar2.b());
            float f2 = this.b;
            canvas.drawArc(0.0f, 0.0f, f2, f2, -90.0f, -180.0f, true, this.j);
        } else {
            this.j.setColor(this.d.b());
            float f3 = this.b;
            canvas.drawArc(0.0f, 0.0f, f3, f3, -90.0f, -180.0f, true, this.j);
            eog_(canvas, f, ((this.d.c() - cVar2.a()) * fC) + f, this.d.b());
        }
        List<uvf.c> listA = this.d.a();
        for (int size = listA.size() - 1; size >= 0; size--) {
            uvf.c cVar3 = listA.get(size);
            float fC2 = ((this.d.c() - cVar3.a()) * fC) + f;
            eog_(canvas, fC2, ((cVar3.a() - cVar3.e()) * fC) + fC2, cVar3.b());
        }
        if (cVar.e() - this.d.d() < 0.01f) {
            this.j.setColor(cVar.b());
            float f4 = this.b;
            canvas.drawArc(measuredWidth - f4, 0.0f, measuredWidth, f4, 270.0f, 180.0f, true, this.j);
        } else {
            eog_(canvas, ((this.d.c() - cVar.e()) * fC) + f, measuredWidth - f, this.d.b());
            float f5 = this.b;
            canvas.drawArc(measuredWidth - f5, 0.0f, measuredWidth, f5, 270.0f, 180.0f, true, this.j);
        }
    }

    private void eog_(Canvas canvas, float f, float f2, int i) {
        this.j.setColor(i);
        this.f.reset();
        this.f.moveTo(f, 0.0f);
        this.f.lineTo(f2, 0.0f);
        this.f.lineTo(f2, this.b);
        this.f.lineTo(f, this.b);
        this.f.lineTo(f, 0.0f);
        canvas.drawPath(this.f, this.j);
    }

    private void eod_(Canvas canvas, float f, float f2) {
        eog_(canvas, f2, f - f2, this.d.b());
        float f3 = this.b;
        canvas.drawArc(0.0f, 0.0f, f3, f3, -90.0f, -180.0f, true, this.j);
        float f4 = this.b;
        canvas.drawArc(f - f4, 0.0f, f, f4, 270.0f, 180.0f, true, this.j);
    }

    private void eoh_(Canvas canvas, TextPaint textPaint) {
        float fD;
        float width = (getWidth() - this.b) / (this.d.c() - this.d.d());
        Rect rect = new Rect();
        for (float f : this.d.e()) {
            if (this.f10935a) {
                fD = this.d.c() - f;
            } else {
                fD = f - this.d.d();
            }
            float f2 = fD * width;
            this.j.setColor(this.g);
            this.j.setStrokeWidth(this.c);
            float f3 = this.b;
            float f4 = f2 + (f3 / 2.0f);
            canvas.drawLine(f4, f3 + 0.1f, f4, f3 + this.e, this.j);
            String strD = kqx.d(f, 2, 0);
            textPaint.getTextBounds(strD, 0, strD.length(), rect);
            textPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(strD, ((float) rect.width()) + f2 < ((float) getWidth()) ? f2 + (rect.width() / 2.0f) : (getWidth() - (rect.width() / 2)) - 2, this.b + rect.height() + this.e + this.i, textPaint);
        }
    }

    private void eoe_(Canvas canvas) {
        float measuredWidth = getMeasuredWidth();
        float f = this.b / 2.0f;
        this.j.setColor(this.d.b());
        if (!this.d.h()) {
            eod_(canvas, measuredWidth, f);
            return;
        }
        uvf.c cVar = this.d.a().get(0);
        uvf.c cVar2 = this.d.a().get(this.d.a().size() - 1);
        float fC = (measuredWidth - this.b) / (this.d.c() - this.d.d());
        if (cVar.e() - this.d.d() < 0.01f) {
            this.j.setColor(cVar.b());
            float f2 = this.b;
            canvas.drawArc(0.0f, 0.0f, f2, f2, -90.0f, -180.0f, true, this.j);
        } else {
            this.j.setColor(this.d.b());
            float f3 = this.b;
            canvas.drawArc(0.0f, 0.0f, f3, f3, -90.0f, -180.0f, true, this.j);
            eog_(canvas, f, ((cVar.e() - this.d.d()) * fC) + f, this.d.b());
        }
        for (uvf.c cVar3 : this.d.a()) {
            float fE = ((cVar3.e() - this.d.d()) * fC) + f;
            eog_(canvas, fE, ((cVar3.a() - cVar3.e()) * fC) + fE, cVar3.b());
        }
        if (this.d.c() - cVar2.a() < 0.01f) {
            this.j.setColor(cVar2.b());
            float f4 = this.b;
            canvas.drawArc(measuredWidth - f4, 0.0f, measuredWidth, f4, 270.0f, 180.0f, true, this.j);
        } else {
            eog_(canvas, ((cVar2.a() - this.d.d()) * fC) + f, measuredWidth - f, this.d.b());
            float f5 = this.b;
            canvas.drawArc(measuredWidth - f5, 0.0f, measuredWidth, f5, 270.0f, 180.0f, true, this.j);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        float f;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            f = this.k;
        } else {
            if (mode != Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                f = this.k;
            }
            setMeasuredDimension(size, size2);
        }
        size2 = (int) f;
        setMeasuredDimension(size, size2);
    }
}
