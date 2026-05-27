package com.huawei.health.h5pro.utils;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes4.dex */
public class AdjustResizeWithSoftInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2495a;
    public View b;
    public FrameLayout c;
    public FrameLayout.LayoutParams d;

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZ_(Activity activity) {
        Rect rect = new Rect();
        this.c.getWindowVisibleDisplayFrame(rect);
        int iMin = Math.min(rect.bottom, this.c.getMeasuredHeight());
        if (iMin != this.f2495a) {
            this.d.height = iMin;
            this.b.requestLayout();
            this.f2495a = iMin;
        }
    }

    public static boolean isFullscreen(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 256) == 256;
    }

    public static void assistActivity(Activity activity) {
        if (activity == null) {
            return;
        }
        new AdjustResizeWithSoftInput(activity);
    }

    public AdjustResizeWithSoftInput(final Activity activity) {
        if (!isFullscreen(activity)) {
            LogUtil.i("H5PRO_AdjustResizeWithSoftInput", "AdjustResizeWithSoftInput: isFullscreen");
        }
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        this.c = frameLayout;
        if (frameLayout == null || frameLayout.getChildAt(0) == null) {
            return;
        }
        View childAt = this.c.getChildAt(0);
        this.b = childAt;
        if (childAt == null) {
            return;
        }
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.health.h5pro.utils.AdjustResizeWithSoftInput.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AdjustResizeWithSoftInput.this.ZZ_(activity);
            }
        });
        this.d = (FrameLayout.LayoutParams) this.b.getLayoutParams();
    }
}
