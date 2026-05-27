package com.huawei.health.suggestion.ui.fitness.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes10.dex */
public class FitnessDummyViewHolder extends AbsFitnessViewHolder<View> {
    private ViewGroup d;

    @Override // com.huawei.health.suggestion.ui.fitness.viewholder.AbsFitnessViewHolder
    /* JADX INFO: renamed from: aIK_, reason: merged with bridge method [inline-methods] */
    public void init(View view) {
        ViewParent parent;
        if (view == null || this.d == null || (parent = view.getParent()) == this.d) {
            return;
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        this.d.addView(view);
    }
}
