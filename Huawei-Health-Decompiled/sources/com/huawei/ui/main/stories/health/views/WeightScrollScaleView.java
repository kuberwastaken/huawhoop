package com.huawei.ui.main.stories.health.views;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.health.R;
import com.huawei.ui.commonui.scrollview.ScrollScaleView;

/* JADX INFO: loaded from: classes8.dex */
public class WeightScrollScaleView extends ScrollScaleView {
    public WeightScrollScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public WeightScrollScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }

    private void d() {
        setCustomStartColor(getContext().getColor(R.color._2131300004_res_0x7f090ea4));
        this.c = -1;
    }

    @Override // com.huawei.ui.commonui.scrollview.ScrollScaleView
    public void setSelectedPosition(int i) {
        super.setSelectedPosition(e(i));
    }

    public int e(int i) {
        if (i < 0) {
            i = 0;
        }
        return i > getSumScale() + (-1) ? getSumScale() - 1 : i;
    }
}
