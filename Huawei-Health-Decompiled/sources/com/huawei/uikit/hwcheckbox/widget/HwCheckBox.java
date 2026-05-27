package com.huawei.uikit.hwcheckbox.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.huawei.health.R;
import defpackage.vpd;

/* JADX INFO: loaded from: classes8.dex */
public class HwCheckBox extends CheckBox {
    public HwCheckBox(Context context) {
        this(context, null);
    }

    private static Context e(Context context, int i) {
        return vpd.d(context, i, 2131952372);
    }

    public HwCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100437_res_0x7f060315);
    }

    public HwCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(e(context, i), attributeSet, i);
        setDefaultFocusHighlightEnabled(false);
    }
}
