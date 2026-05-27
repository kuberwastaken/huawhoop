package com.huawei.uikit.phone.hwcheckbox.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes8.dex */
public class HwCheckBox extends com.huawei.uikit.hwcheckbox.widget.HwCheckBox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11284a;
    private boolean c;

    public HwCheckBox(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f11284a) {
            setGravity(8388659);
        } else {
            setGravity(8388627);
        }
        super.onDraw(canvas);
    }

    public HwCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100437_res_0x7f060315);
    }

    public HwCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100370_res_0x7f0602d2, R.attr._2131100372_res_0x7f0602d4, R.attr._2131100526_res_0x7f06036e}, i, 0);
        this.f11284a = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.c = typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
