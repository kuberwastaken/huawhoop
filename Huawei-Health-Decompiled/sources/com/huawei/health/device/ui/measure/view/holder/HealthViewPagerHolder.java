package com.huawei.health.device.ui.measure.view.holder;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public interface HealthViewPagerHolder<T> {
    View createView(Context context);

    void onBind(Context context, int i, T t);
}
