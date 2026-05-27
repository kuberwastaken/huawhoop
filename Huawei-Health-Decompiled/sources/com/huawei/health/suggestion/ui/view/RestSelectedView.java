package com.huawei.health.suggestion.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.health.R;
import health.compact.a.LanguageUtil;

/* JADX INFO: loaded from: classes10.dex */
public class RestSelectedView extends LinearLayout {
    public RestSelectedView(Context context) {
        super(context);
    }

    public RestSelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RestSelectedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        if (LanguageUtil.i(context)) {
            LayoutInflater.from(context).inflate(R.layout.sug_reset_selected_chinese, (ViewGroup) this, true);
        } else if (LanguageUtil.n(context)) {
            LayoutInflater.from(context).inflate(R.layout.sug_reset_selected_german, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.sug_reset_selected_not_chinese, (ViewGroup) this, true);
        }
    }
}
