package com.huawei.ui.commonui.gridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.huawei.ui.commonui.R$styleable;
import health.compact.a.util.LogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class HealthGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9190a;
    private boolean c;
    private boolean d;

    public HealthGridView(Context context) {
        super(context);
        this.c = false;
        this.f9190a = 0;
        cLd_(context, null, 0, 0);
    }

    public HealthGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.f9190a = 0;
        cLd_(context, attributeSet, 0, 0);
    }

    public HealthGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        this.f9190a = 0;
        cLd_(context, attributeSet, i, 0);
    }

    private void cLd_(Context context, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HealthGridView);
            this.d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HealthGridView_isOnlyItemSameHeight, false);
            this.c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HealthGridView_needsExactCalculateHeight, false);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.f9190a;
        if (i3 > 0 && !this.d) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        if (this.c) {
            this.c = this.d;
            post(new Runnable() { // from class: pez
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int childCount = getChildCount();
        int numColumns = getNumColumns();
        if (childCount == 0 || numColumns <= 0) {
            LogUtil.c("HealthGridView", "calculateAndSetExactHeight childCount: ", Integer.valueOf(childCount), ", numColumns: ", Integer.valueOf(numColumns));
            return;
        }
        this.c = false;
        int iCeil = (int) Math.ceil(((double) getAdapter().getCount()) / ((double) numColumns));
        ArrayList<View> arrayList = new ArrayList<>();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            arrayList.add(childAt);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(childAt.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i) {
                i = measuredHeight;
            }
            if (i2 % numColumns == numColumns - 1 || i2 == childCount - 1) {
                this.f9190a += i;
                c(arrayList, i);
                i = 0;
            }
        }
        this.f9190a += (getVerticalSpacing() * Math.max(0, iCeil - 1)) + getPaddingTop() + getPaddingBottom();
        requestLayout();
    }

    private void c(ArrayList<View> arrayList, int i) {
        while (!arrayList.isEmpty()) {
            View viewRemove = arrayList.remove(0);
            ViewGroup.LayoutParams layoutParams = viewRemove.getLayoutParams();
            layoutParams.height = i;
            viewRemove.setLayoutParams(layoutParams);
        }
    }
}
