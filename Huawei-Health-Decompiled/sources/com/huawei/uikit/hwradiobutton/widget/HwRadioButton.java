package com.huawei.uikit.hwradiobutton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.huawei.health.R;
import defpackage.vpd;

/* JADX INFO: loaded from: classes8.dex */
public class HwRadioButton extends RadioButton {
    public HwRadioButton(Context context) {
        this(context, null);
    }

    private static Context b(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwRadioButton);
    }

    public HwRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100672_res_0x7f060400);
    }

    public HwRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(b(context, i), attributeSet, i);
        setDefaultFocusHighlightEnabled(false);
    }
}
