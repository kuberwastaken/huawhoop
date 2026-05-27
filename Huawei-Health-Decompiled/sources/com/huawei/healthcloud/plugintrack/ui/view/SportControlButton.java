package com.huawei.healthcloud.plugintrack.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes10.dex */
public class SportControlButton extends ImageView {
    private int d;

    public SportControlButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = getResources().getDimensionPixelOffset(R.dimen._2131363897_res_0x7f0a0839);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.d;
        setMeasuredDimension(i3, i3);
    }
}
