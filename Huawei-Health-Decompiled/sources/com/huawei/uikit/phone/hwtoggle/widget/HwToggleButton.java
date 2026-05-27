package com.huawei.uikit.phone.hwtoggle.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.huawei.health.R;
import defpackage.vpc;

/* JADX INFO: loaded from: classes8.dex */
public class HwToggleButton extends com.huawei.uikit.hwtoggle.widget.HwToggleButton {
    private int b;
    private int c;

    public HwToggleButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        Drawable focusedDrawable = getFocusedDrawable();
        if (isFocused() && focusedDrawable != null && hasWindowFocus()) {
            canvas.translate(getScrollX(), getScrollY());
            int i = (-this.b) - this.c;
            focusedDrawable.setBounds(i, i, getWidth() + this.b + this.c, getHeight() + this.b + this.c);
            focusedDrawable.draw(canvas);
            canvas.translate(-getScrollX(), -getScrollY());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (getFocusedDrawable() != null) {
            invalidate();
        }
    }

    public HwToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100802_res_0x7f060482);
    }

    public HwToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (int) getResources().getDimension(R.dimen._2131364585_res_0x7f0a0ae9);
        this.c = (int) getResources().getDimension(R.dimen._2131364587_res_0x7f0a0aeb);
        if (Float.compare(vpc.a(context), 1.75f) >= 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen._2131364584_res_0x7f0a0ae8);
            setPadding(getPaddingLeft(), dimensionPixelSize, getPaddingRight(), dimensionPixelSize);
        }
    }
}
