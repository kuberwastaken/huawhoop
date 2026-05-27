package com.huawei.phoneservice.feedback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import defpackage.xka;
import defpackage.xkd;

/* JADX INFO: loaded from: classes11.dex */
public final class SquareLayout extends RelativeLayout {
    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    public /* synthetic */ SquareLayout(Context context, AttributeSet attributeSet, int i, int i2, xka xkaVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        xkd.d(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SquareLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        xkd.d(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SquareLayout(Context context) {
        this(context, null, 0, 6, null);
        xkd.d(context, "");
    }
}
