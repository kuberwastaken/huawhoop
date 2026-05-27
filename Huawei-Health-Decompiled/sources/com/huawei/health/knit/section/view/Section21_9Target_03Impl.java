package com.huawei.health.knit.section.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Section21_9Target_03Impl {
    protected Context mContext;

    public abstract void bindParamsToView(HashMap<String, Object> map);

    public abstract String getLogTag();

    public abstract View onCreateView(Context context, ViewGroup viewGroup);

    public Section21_9Target_03Impl(Context context) {
        this.mContext = context;
    }
}
