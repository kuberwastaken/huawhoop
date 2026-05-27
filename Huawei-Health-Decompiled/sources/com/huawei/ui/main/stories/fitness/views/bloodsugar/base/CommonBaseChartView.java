package com.huawei.ui.main.stories.fitness.views.bloodsugar.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.ui.main.stories.fitness.activity.bloodoxygen.base.CommonBaseView;

/* JADX INFO: loaded from: classes8.dex */
public abstract class CommonBaseChartView extends LinearLayout implements CommonBaseView {
    protected View mView;

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView(View view);

    public CommonBaseChartView(Context context) {
        super(context);
        this.mView = null;
    }

    public CommonBaseChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mView = null;
    }

    public CommonBaseChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mView = null;
    }

    protected View initLayout(Context context, ViewGroup viewGroup) {
        if (this.mView == null) {
            View viewInflate = LayoutInflater.from(context).inflate(getLayoutId(), viewGroup);
            this.mView = viewInflate;
            initView(viewInflate);
            initData();
        }
        return this.mView;
    }
}
