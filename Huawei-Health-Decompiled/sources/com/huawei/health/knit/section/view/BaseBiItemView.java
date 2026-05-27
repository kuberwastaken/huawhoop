package com.huawei.health.knit.section.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class BaseBiItemView extends FrameLayout {
    protected Context c;
    protected Map<String, Object> e;

    public void d() {
    }

    public BaseBiItemView(Context context, int i) {
        super(context);
        this.c = context;
        e(context, i);
    }

    private void e(Context context, int i) {
        LayoutInflater.from(context).inflate(i, (ViewGroup) this, true);
    }

    public void d(Map<String, Object> map) {
        this.e = map;
    }
}
