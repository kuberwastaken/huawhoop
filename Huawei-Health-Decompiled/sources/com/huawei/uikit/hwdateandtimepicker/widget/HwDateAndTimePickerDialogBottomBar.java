package com.huawei.uikit.hwdateandtimepicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huawei.health.R;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import defpackage.vpc;

/* JADX INFO: loaded from: classes11.dex */
public class HwDateAndTimePickerDialogBottomBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f11127a;
    private Context b;
    private HwTextView d;
    private HwTextView e;

    public HwDateAndTimePickerDialogBottomBar(Context context) {
        super(context);
        this.b = context;
    }

    private void b() {
        if (vpc.c(this.b) && Float.compare(vpc.a(this.b), 1.75f) >= 0) {
            if (vpc.e(this.b)) {
                this.d.setTextSize(1, 16.0f);
                this.e.setTextSize(1, 16.0f);
            } else if (Float.compare(vpc.a(this.b), 2.0f) > 0 && this.b.getResources().getConfiguration().orientation == 2) {
                this.d.setTextSize(1, 32.0f);
                this.e.setTextSize(1, 32.0f);
            }
        }
    }

    private void c() {
        HwTextView hwTextView = this.e;
        if (hwTextView == null || this.d == null) {
            return;
        }
        float fMin = Math.min(hwTextView.getTextSize(), this.d.getTextSize());
        this.e.setTextSize(0, fMin);
        this.d.setTextSize(0, fMin);
        b();
    }

    private void d() {
        this.e = (HwTextView) findViewById(R.id.hwdateandtimepicker_dialog_negative_btn);
        this.d = (HwTextView) findViewById(R.id.hwdateandtimepicker_dialog_positive_btn);
        this.f11127a = getResources().getDimension(R.dimen._2131364153_res_0x7f0a0939);
    }

    private void e() {
        HwTextView hwTextView = this.e;
        if (hwTextView == null || this.d == null) {
            return;
        }
        hwTextView.setTextSize(this.f11127a);
        this.d.setTextSize(this.f11127a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        e();
        super.onMeasure(i, i2);
        c();
    }

    public HwDateAndTimePickerDialogBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
    }

    public HwDateAndTimePickerDialogBottomBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
    }
}
