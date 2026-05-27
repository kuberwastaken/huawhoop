package com.huawei.health.marketing.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.ui.commonui.imageview.HealthImageView;

/* JADX INFO: loaded from: classes10.dex */
public class FullImageView extends HealthImageView {
    public FullImageView(Context context) {
        super(context);
    }

    public FullImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (getDrawable() != null) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), (int) Math.ceil((r3 * r0.getIntrinsicHeight()) / r0.getIntrinsicWidth()));
        } else {
            super.onMeasure(i, i2);
        }
    }
}
