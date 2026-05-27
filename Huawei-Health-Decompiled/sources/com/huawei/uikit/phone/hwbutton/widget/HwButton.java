package com.huawei.uikit.phone.hwbutton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.health.R;
import com.huawei.uikit.hwbutton.R$dimen;
import defpackage.vpc;

/* JADX INFO: loaded from: classes8.dex */
public class HwButton extends com.huawei.uikit.hwbutton.widget.HwButton {
    public HwButton(Context context) {
        this(context, null);
    }

    private void eGZ_(Canvas canvas) {
        Drawable focusedDrawable;
        if (isFocusable() && hasWindowFocus() && (focusedDrawable = getFocusedDrawable()) != null && isFocused()) {
            canvas.translate(getScrollX(), getScrollY());
            focusedDrawable.setBounds((-getFocusedPathPadding()) - getFocusedPathWidth(), (-getFocusedPathPadding()) - getFocusedPathWidth(), getWidth() + getFocusedPathPadding() + getFocusedPathWidth(), getHeight() + getFocusedPathPadding() + getFocusedPathWidth());
            focusedDrawable.draw(canvas);
            canvas.translate(-getScrollX(), -getScrollY());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        eGZ_(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (getFocusedDrawable() != null) {
            invalidate();
        }
    }

    public HwButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100405_res_0x7f0602f5);
    }

    public HwButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100371_res_0x7f0602d3, R.attr._2131100404_res_0x7f0602f4, R.attr._2131100406_res_0x7f0602f6, R.attr._2131100407_res_0x7f0602f7, R.attr._2131100408_res_0x7f0602f8, R.attr._2131100409_res_0x7f0602f9, R.attr._2131100410_res_0x7f0602fa, R.attr._2131100411_res_0x7f0602fb, R.attr._2131100438_res_0x7f060316, R.attr._2131100522_res_0x7f06036a, R.attr._2131100523_res_0x7f06036b, R.attr._2131100524_res_0x7f06036c, R.attr._2131100526_res_0x7f06036e, R.attr._2131100527_res_0x7f06036f, R.attr._2131100529_res_0x7f060371, R.attr._2131100551_res_0x7f060387}, i, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(0, true) && Float.compare(vpc.a(context), 1.75f) >= 0) {
            setMaxLines(2);
            int i2 = typedArrayObtainStyledAttributes.getInt(2, 0);
            if (i2 == 0) {
                setAutoTextInfo(13, 1, 2);
                int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.hwbutton_big_padding_top_or_bottom);
                setPadding(getPaddingLeft(), dimensionPixelSize, getPaddingRight(), dimensionPixelSize);
            }
            if (i2 == 1) {
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.hwbutton_small_padding_top_or_bottom);
                setPadding(getPaddingLeft(), dimensionPixelSize2, getPaddingRight(), dimensionPixelSize2);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
