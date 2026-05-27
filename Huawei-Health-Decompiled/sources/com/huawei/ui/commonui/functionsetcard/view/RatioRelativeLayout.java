package com.huawei.ui.commonui.functionsetcard.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.ui.commonui.R$styleable;

/* JADX INFO: loaded from: classes7.dex */
public class RatioRelativeLayout extends RelativeLayout {
    private int b;
    private int e;

    public RatioRelativeLayout(Context context) {
        this(context, null);
    }

    public RatioRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.b = 0;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.RatioRelativeLayout, i, 0);
        this.b = typedArrayObtainStyledAttributes.getInt(R$styleable.RatioRelativeLayout_width_weight, 0);
        this.e = typedArrayObtainStyledAttributes.getInt(R$styleable.RatioRelativeLayout_height_weight, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setWeight(int i, int i2) {
        this.b = i;
        this.e = i2;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.e == 0 || this.b == 0) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            int i3 = this.e;
            int i4 = this.b;
            int i5 = size * i3;
            int i6 = size2 * i4;
            if (i5 >= i6) {
                size2 = i5 / i4;
            } else {
                size = i6 / i3;
            }
        } else if (mode == 1073741824 && mode2 == 1073741824) {
            int i7 = this.e;
            int i8 = this.b;
            int i9 = size * i7;
            int i10 = size2 * i8;
            if (i9 <= i10) {
                size2 = i9 / i8;
            } else {
                size = i10 / i7;
            }
        } else if (mode == 1073741824) {
            size2 = Math.max((this.e * size) / this.b, getMinimumHeight());
        } else if (mode2 == 1073741824) {
            size = Math.max((this.b * size2) / this.e, getMinimumWidth());
        } else {
            size = 0;
            size2 = 0;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }
}
