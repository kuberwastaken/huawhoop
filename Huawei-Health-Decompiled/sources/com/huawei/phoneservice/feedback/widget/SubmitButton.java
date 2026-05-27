package com.huawei.phoneservice.feedback.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.phoneservice.faq.base.util.d;
import com.huawei.phoneservice.faq.base.util.h;

/* JADX INFO: loaded from: classes11.dex */
public class SubmitButton extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8596a;

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        StringBuilder sb;
        Configuration configuration = getResources().getConfiguration();
        h.e("widthMeasureSpec", i + "<<<<<<qian");
        WindowManager windowManager = (WindowManager) this.f8596a.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        if (2 != configuration.orientation || !d.d()) {
            if (1 == configuration.orientation && d.d()) {
                i = View.MeasureSpec.makeMeasureSpec(i3 / 2, View.MeasureSpec.getMode(i));
                sb = new StringBuilder();
            }
            super.onMeasure(i, i2);
        }
        i = View.MeasureSpec.makeMeasureSpec(i3 / 3, View.MeasureSpec.getMode(i));
        sb = new StringBuilder();
        sb.append(i);
        sb.append("<<<<<<<<hou");
        h.e("widthMeasureSpec", sb.toString());
        super.onMeasure(i, i2);
    }

    public SubmitButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8596a = context;
    }

    public SubmitButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubmitButton(Context context) {
        this(context, null);
    }
}
