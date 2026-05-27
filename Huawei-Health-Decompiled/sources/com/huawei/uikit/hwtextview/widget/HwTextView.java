package com.huawei.uikit.hwtextview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.huawei.health.R;
import defpackage.vpb;
import defpackage.vpd;

/* JADX INFO: loaded from: classes8.dex */
public class HwTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f11263a;
    private boolean b;
    private float c;
    private float d;
    private StaticLayout e;
    private TextPaint g;

    public HwTextView(Context context) {
        this(context, null);
    }

    private static Context a(Context context, int i) {
        return vpd.d(context, i, 2131952403);
    }

    public static HwTextView b(Context context) {
        Object objC = vpb.c(context, vpb.d(context, HwTextView.class, vpb.e(context, 15, 1)), HwTextView.class);
        if (objC instanceof HwTextView) {
            return (HwTextView) objC;
        }
        return null;
    }

    private void b(int i, int i2, int i3) {
        int maxLines;
        if (i3 != 0 && (maxLines = getMaxLines()) > 1) {
            int totalPaddingLeft = getTotalPaddingLeft();
            int totalPaddingRight = getTotalPaddingRight();
            int extendedPaddingBottom = (i - getExtendedPaddingBottom()) - getExtendedPaddingTop();
            if (extendedPaddingBottom <= 0) {
                return;
            }
            StaticLayout staticLayout = new StaticLayout(getText(), this.g, (i2 - totalPaddingLeft) - totalPaddingRight, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false);
            this.e = staticLayout;
            int lineCount = staticLayout.getLineCount();
            if (this.e.getHeight() <= extendedPaddingBottom || lineCount <= 1 || lineCount > maxLines + 1) {
                return;
            }
            setMaxLines(lineCount - 1);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        d(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2), View.MeasureSpec.getMode(i2));
        super.onMeasure(i, i2);
    }

    public void setAutoTextInfo(int i, int i2, int i3) {
        Context context = getContext();
        Resources system = context == null ? Resources.getSystem() : context.getResources();
        this.c = TypedValue.applyDimension(i3, i, system.getDisplayMetrics());
        this.f11263a = TypedValue.applyDimension(i3, i2, system.getDisplayMetrics());
    }

    public void setAutoTextSize(float f) {
        setAutoTextSize(2, f);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.c <= 0.0f || this.f11263a <= 0.0f) {
            return;
        }
        requestLayout();
    }

    public HwTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100786_res_0x7f060472);
    }

    public void setAutoTextSize(int i, float f) {
        Context context = getContext();
        this.d = TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        super.setTextSize(i, f);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
    }

    public HwTextView(Context context, AttributeSet attributeSet, int i) {
        super(a(context, i), attributeSet, i);
        a(super.getContext(), attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100367_res_0x7f0602cf, R.attr._2131100368_res_0x7f0602d0, R.attr._2131100369_res_0x7f0602d1}, i, 2131953025);
        this.c = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.f11263a = typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        this.b = typedArrayObtainStyledAttributes.getInt(2, 0) == 1;
        typedArrayObtainStyledAttributes.recycle();
        if (Float.compare(this.c, 0.0f) == 0 && Float.compare(this.f11263a, 0.0f) == 0) {
            this.c = getAutoSizeMinTextSize();
            this.f11263a = getAutoSizeStepGranularity();
            setAutoSizeTextTypeWithDefaults(0);
        }
        TextPaint textPaint = new TextPaint();
        this.g = textPaint;
        textPaint.set(getPaint());
        this.d = getTextSize();
    }

    private void d(int i, int i2, int i3) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (maxWidth != -1 && maxWidth < i) {
            i = maxWidth;
        }
        if (maxHeight != -1 && maxHeight < i2) {
            i2 = maxHeight;
        }
        int totalPaddingLeft = (i - getTotalPaddingLeft()) - getTotalPaddingRight();
        if (totalPaddingLeft < 0) {
            return;
        }
        if (this.g == null) {
            this.g = new TextPaint();
        }
        this.g.set(getPaint());
        b(i, i2, totalPaddingLeft, i3);
    }

    private void b(int i, int i2, int i3, int i4) {
        if (!(this.b && getMaxLines() == Integer.MAX_VALUE) && Float.compare(this.c, 0.0f) > 0 && Float.compare(this.f11263a, 0.0f) > 0) {
            float f = this.d;
            CharSequence text = getText();
            TransformationMethod transformationMethod = getTransformationMethod();
            if (transformationMethod != null) {
                text = transformationMethod.getTransformation(text, this);
            }
            this.g.setTextSize(f);
            float fMeasureText = this.g.measureText(text.toString());
            while (d(fMeasureText, i3, f)) {
                f -= this.f11263a;
                this.g.setTextSize(f);
                fMeasureText = this.g.measureText(text.toString());
            }
            float f2 = this.c;
            if (f < f2) {
                f = f2;
            }
            setTextSize(0, f);
            b(i2, i, i4);
        }
    }

    private boolean d(float f, int i, float f2) {
        return (!this.b || getMaxLines() == 1) ? Float.compare(f, (float) i) > 0 && Float.compare(f2, this.c) > 0 : b(i) > getMaxLines() && f2 > this.c;
    }

    private int b(int i) {
        CharSequence text = getText();
        if (text == null) {
            return 0;
        }
        return StaticLayout.Builder.obtain(text, 0, text.length(), this.g, i).build().getLineCount();
    }
}
