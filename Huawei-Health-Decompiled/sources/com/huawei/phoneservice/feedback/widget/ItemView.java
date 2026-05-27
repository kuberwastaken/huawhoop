package com.huawei.phoneservice.feedback.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.phoneservice.faq.base.util.m;
import com.huawei.uikit.hwresources.R$dimen;

/* JADX INFO: loaded from: classes6.dex */
public class ItemView extends RelativeLayout {
    private Context e;

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m.cjG_(this, this.e.getResources().getDimensionPixelOffset(R$dimen.emui_dimens_max_start));
    }

    public ItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = context;
    }

    public ItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemView(Context context) {
        this(context, null);
    }
}
