package com.huawei.uikit.hwtoggle.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ToggleButton;
import com.huawei.health.R;
import defpackage.vma;
import defpackage.vpd;

/* JADX INFO: loaded from: classes8.dex */
public class HwToggleButton extends ToggleButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f11269a;
    private float b;
    private int c;
    private float d;

    public HwToggleButton(Context context) {
        this(context, null);
    }

    private void d(boolean z) {
        vma.euR_(this, z ? this.d : this.b).start();
    }

    public int getFocusPathColor() {
        return this.c;
    }

    public Drawable getFocusedDrawable() {
        return this.f11269a;
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

    @Override // android.view.View
    public void onHoverChanged(boolean z) {
        super.onHoverChanged(z);
        if (this.d == 1.0f) {
            return;
        }
        d(z);
    }

    public void setFocusPathColor(int i) {
        this.c = i;
    }

    public void setFocusedDrawable(Drawable drawable) {
        this.f11269a = drawable;
    }

    public HwToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100802_res_0x7f060482);
    }

    public HwToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(d(context, i), attributeSet, i);
        setDefaultFocusHighlightEnabled(false);
        eGd_(getContext(), attributeSet, i);
    }

    private void eGd_(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100522_res_0x7f06036a, R.attr._2131100523_res_0x7f06036b, R.attr._2131100524_res_0x7f06036c, R.attr._2131100526_res_0x7f06036e, R.attr._2131100527_res_0x7f06036f, R.attr._2131100528_res_0x7f060370, R.attr._2131100529_res_0x7f060371, R.attr._2131100800_res_0x7f060480, R.attr._2131100801_res_0x7f060481}, i, R.style.Widget_Emui_HwToggle);
        this.f11269a = typedArrayObtainStyledAttributes.getDrawable(0);
        this.c = typedArrayObtainStyledAttributes.getColor(3, 0);
        typedArrayObtainStyledAttributes.recycle();
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R.dimen._2131364591_res_0x7f0a0aef, typedValue, true);
        this.d = typedValue.getFloat();
        getResources().getValue(R.dimen._2131364590_res_0x7f0a0aee, typedValue, true);
        this.b = typedValue.getFloat();
    }

    private static Context d(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwToggle);
    }
}
