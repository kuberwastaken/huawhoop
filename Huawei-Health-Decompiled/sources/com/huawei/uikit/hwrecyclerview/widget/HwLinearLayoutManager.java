package com.huawei.uikit.hwrecyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes11.dex */
public class HwLinearLayoutManager extends HwLinearLayoutManagerEx {
    private LayoutCallback g;

    public static abstract class LayoutCallback {
        public abstract void onLayoutFinished(View view, RecyclerView recyclerView);
    }

    public HwLinearLayoutManager(Context context, LayoutCallback layoutCallback) {
        super(context, 1, false);
        this.g = layoutCallback;
    }

    private void g() {
        if (this.g == null) {
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt.getParent() instanceof RecyclerView)) {
                this.g.onLayoutFinished(childAt, (RecyclerView) childAt.getParent());
            }
        }
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManagerEx
    protected void c(RecyclerView.State state, int[] iArr) {
        super.c(state, iArr);
        iArr[0] = iArr[0] + d()[0];
        iArr[1] = iArr[1] + d()[1];
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        if (getChildCount() == 0) {
            return;
        }
        g();
    }

    @Override // com.huawei.uikit.hwrecyclerview.widget.HwLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iScrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        g();
        return iScrollVerticallyBy;
    }

    public HwLinearLayoutManager(Context context) {
        this(context, HwDeviceAdapter.a(context).d(context));
    }

    public HwLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
