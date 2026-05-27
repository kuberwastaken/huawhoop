package com.huawei.health.suggestion.ui.plan.util;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.ui.commonui.viewpager.pagetransformer.OverlayLayerPageTransformer;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes5.dex */
public class RecommendFoodTransformer extends OverlayLayerPageTransformer {
    private final int b;

    public RecommendFoodTransformer(OverlayLayerPageTransformer.c cVar, int i) {
        super(cVar);
        this.b = i;
    }

    @Override // com.huawei.ui.commonui.viewpager.pagetransformer.OverlayLayerPageTransformer, androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        super.transformPage(view, f);
        View viewAMJ_ = null;
        for (int i = 0; i < this.b; i++) {
            if (viewAMJ_ == null) {
                viewAMJ_ = aMJ_(view);
            } else {
                viewAMJ_ = aMJ_(viewAMJ_);
            }
        }
        if (viewAMJ_ == null) {
            LogUtil.b("RecommendFoodTransformer", "transformPage childView is null");
            return;
        }
        if (viewAMJ_.getVisibility() == 8) {
            viewAMJ_.setVisibility(0);
        }
        viewAMJ_.setAlpha(f);
    }

    private View aMJ_(View view) {
        if (view instanceof ViewGroup) {
            return ((ViewGroup) view).getChildAt(r3.getChildCount() - 1);
        }
        LogUtil.b("RecommendFoodTransformer", "getChildView view ", view);
        return view;
    }
}
