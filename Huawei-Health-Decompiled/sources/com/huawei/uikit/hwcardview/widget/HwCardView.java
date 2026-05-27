package com.huawei.uikit.hwcardview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.huawei.health.R;
import defpackage.vpd;

/* JADX INFO: loaded from: classes11.dex */
public class HwCardView extends CardView {
    public HwCardView(Context context) {
        this(context, null);
    }

    private static Context a(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwCardView);
    }

    public HwCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100414_res_0x7f0602fe);
    }

    public HwCardView(Context context, AttributeSet attributeSet, int i) {
        super(a(context, i), attributeSet, i);
    }
}
