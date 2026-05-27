package com.huawei.phoneservice.faq.base.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.phoneservice.faq.base.util.m;
import com.huawei.uikit.hwresources.R$dimen;

/* JADX INFO: loaded from: classes6.dex */
public class ListItemRelativeLayout extends RelativeLayout {
    private Context b;

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        m.cjF_(this, this.b.getResources().getDimensionPixelSize(R$dimen.emui_dimens_max_start), this.b.getResources().getDimensionPixelSize(R$dimen.emui_dimens_max_end));
        super.onConfigurationChanged(configuration);
    }

    private void d(Context context) {
        this.b = context;
    }

    public ListItemRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context);
    }

    public ListItemRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListItemRelativeLayout(Context context) {
        this(context, null);
    }
}
