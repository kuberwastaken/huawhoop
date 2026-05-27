package com.huawei.uikit.hwdatepicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huawei.health.R;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import defpackage.vpc;

/* JADX INFO: loaded from: classes11.dex */
public class HwDatePickerDialogBottomBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HwTextView f11132a;
    private float b;
    private HwTextView c;
    private Context d;

    public HwDatePickerDialogBottomBar(Context context) {
        super(context);
        this.d = context;
    }

    private void a() {
        HwTextView hwTextView = this.c;
        if (hwTextView == null || this.f11132a == null) {
            return;
        }
        hwTextView.setTextSize(this.b);
        this.f11132a.setTextSize(this.b);
    }

    private void c() {
        this.c = (HwTextView) findViewById(R.id.hwdatepicker_dialog_negative_btn);
        this.f11132a = (HwTextView) findViewById(R.id.hwdatepicker_dialog_positive_btn);
        this.b = getResources().getDimension(R.dimen._2131364185_res_0x7f0a0959);
    }

    private void d() {
        if (vpc.c(this.d) && Float.compare(vpc.a(this.d), 1.75f) >= 0) {
            if (vpc.e(this.d)) {
                this.f11132a.setTextSize(1, 16.0f);
                this.c.setTextSize(1, 16.0f);
            } else if (Float.compare(vpc.a(this.d), 2.0f) > 0 && this.d.getResources().getConfiguration().orientation == 2) {
                this.f11132a.setTextSize(1, 32.0f);
                this.c.setTextSize(1, 32.0f);
            }
        }
    }

    private void e() {
        HwTextView hwTextView = this.c;
        if (hwTextView == null || this.f11132a == null) {
            return;
        }
        float fMin = Math.min(hwTextView.getTextSize(), this.f11132a.getTextSize());
        this.c.setTextSize(0, fMin);
        this.f11132a.setTextSize(0, fMin);
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        a();
        super.onMeasure(i, i2);
        e();
    }

    public HwDatePickerDialogBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = context;
    }

    public HwDatePickerDialogBottomBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = context;
    }
}
