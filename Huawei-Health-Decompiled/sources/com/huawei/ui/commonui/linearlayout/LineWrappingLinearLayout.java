package com.huawei.ui.commonui.linearlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public class LineWrappingLinearLayout extends LinearLayout {
    private int c;

    public LineWrappingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int size = View.MeasureSpec.getSize(i);
        boolean z = false;
        if (size > this.c && d()) {
            setStacked(false);
        }
        this.c = size;
        if (d() || View.MeasureSpec.getMode(i) != 1073741824) {
            iMakeMeasureSpec = i;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        if (!d() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
        } else if (!z) {
            return;
        }
        super.onMeasure(i, i2);
    }

    private void setStacked(boolean z) {
        if (z == d()) {
            return;
        }
        setOrientation(z ? 1 : 0);
    }

    public boolean d() {
        return getOrientation() == 1;
    }
}
