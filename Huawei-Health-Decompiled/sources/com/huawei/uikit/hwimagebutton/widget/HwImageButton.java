package com.huawei.uikit.hwimagebutton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.huawei.health.R;
import defpackage.vpd;

/* JADX INFO: loaded from: classes11.dex */
public class HwImageButton extends ImageButton {
    private int d;

    public HwImageButton(Context context) {
        this(context, null);
    }

    private static Context a(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwImageButton);
    }

    public int getFocusPathColor() {
        return this.d;
    }

    public void setClickAnimationEnabled(boolean z) {
    }

    public void setFocusPathColor(int i) {
        this.d = i;
    }

    public void setWaitingEnable(boolean z) {
    }

    public HwImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100559_res_0x7f06038f);
    }

    private void eBr_(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100438_res_0x7f060316, R.attr._2131100523_res_0x7f06036b, R.attr._2131100524_res_0x7f06036c, R.attr._2131100526_res_0x7f06036e, R.attr._2131100527_res_0x7f06036f, R.attr._2131100528_res_0x7f060370, R.attr._2131100529_res_0x7f060371, R.attr._2131100560_res_0x7f060390}, i, 0);
        this.d = typedArrayObtainStyledAttributes.getColor(3, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public HwImageButton(Context context, AttributeSet attributeSet, int i) {
        super(a(context, i), attributeSet, i);
        eBr_(super.getContext(), attributeSet, i);
    }
}
