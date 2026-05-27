package com.huawei.ui.commonui.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes11.dex */
public class PermissionTipScrollView extends ScrollView {
    private int b;

    public PermissionTipScrollView(Context context) {
        super(context);
        a(context);
    }

    public PermissionTipScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        int i = context.getResources().getDisplayMetrics().heightPixels;
        this.b = (int) ((i * 2.0f) / 3.0f);
        LogUtil.a("PermissionTipScrollView", "init screenHeight:", Integer.valueOf(i), " maxHeight:", Integer.valueOf(this.b));
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            measureChild(childAt, i, i2);
            int measuredHeight = childAt.getMeasuredHeight();
            LogUtil.a("PermissionTipScrollView", "onMeasure contentHeight:", Integer.valueOf(measuredHeight));
            int i3 = this.b;
            if (measuredHeight >= i3) {
                i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 0);
            }
        }
        super.onMeasure(i, i2);
    }
}
