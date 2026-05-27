package com.huawei.uikit.hwtimepicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huawei.health.R;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import defpackage.vpc;

/* JADX INFO: loaded from: classes11.dex */
public class HwTimePickerDialogBottomBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HwTextView f11268a;
    private Context b;
    private float d;
    private HwTextView e;

    public HwTimePickerDialogBottomBar(Context context) {
        super(context);
        this.b = context;
    }

    private void a() {
        if (vpc.c(this.b) && Float.compare(vpc.a(this.b), 1.75f) >= 0) {
            if (vpc.e(this.b)) {
                this.f11268a.setTextSize(1, 16.0f);
                this.e.setTextSize(1, 16.0f);
            } else if (Float.compare(vpc.a(this.b), 2.0f) > 0 && this.b.getResources().getConfiguration().orientation == 2) {
                this.f11268a.setTextSize(1, 32.0f);
                this.e.setTextSize(1, 32.0f);
            }
        }
    }

    private void b() {
        HwTextView hwTextView = this.e;
        if (hwTextView == null || this.f11268a == null) {
            return;
        }
        float fMin = Math.min(hwTextView.getTextSize(), this.f11268a.getTextSize());
        this.e.setTextSize(0, fMin);
        this.f11268a.setTextSize(0, fMin);
        a();
    }

    private void c() {
        this.e = (HwTextView) findViewById(R.id.hwtimepicker_negative_btn);
        this.f11268a = (HwTextView) findViewById(R.id.hwtimepicker_positive_btn);
        this.d = getResources().getDimension(R.dimen._2131364568_res_0x7f0a0ad8);
    }

    private void e() {
        HwTextView hwTextView = this.e;
        if (hwTextView == null || this.f11268a == null) {
            return;
        }
        hwTextView.setTextSize(this.d);
        this.f11268a.setTextSize(this.d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        e();
        super.onMeasure(i, i2);
        b();
    }

    public HwTimePickerDialogBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
    }

    public HwTimePickerDialogBottomBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
    }
}
