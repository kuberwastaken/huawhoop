package com.huawei.uikit.hwcardview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class HwCardButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11108a;
    private boolean b;
    private Comparator<b> e;

    class b {
        int d;
        int e;

        b(int i, int i2) {
            this.d = i;
            this.e = i2;
        }
    }

    class c implements Comparator<b> {
        c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.e - bVar2.e;
        }
    }

    public HwCardButtonBarLayout(Context context) {
        this(context, null);
    }

    private void e(int i, boolean z) {
        for (int i2 = 0; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                LinearLayout.LayoutParams layoutParams = childAt.getLayoutParams() instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) childAt.getLayoutParams() : null;
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                if (z) {
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                } else {
                    layoutParams.width = -2;
                    layoutParams.weight = 0.0f;
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.b && b()) {
            c(i, i2, i3, i4);
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, getSuggestedMinimumHeight());
        int childCount = getChildCount();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != null && childAt.getVisibility() != 8) {
                i3++;
            }
        }
        int measuredWidth = i3 == 0 ? (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd() : ((getMeasuredWidth() - getPaddingStart()) - getPaddingEnd()) / i3;
        ArrayList arrayList = new ArrayList(childCount);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            if (childAt2 != null && childAt2.getVisibility() != 8) {
                childAt2.measure(iMakeMeasureSpec, i2);
                int measuredWidth2 = childAt2.getMeasuredWidth();
                arrayList.add(new b(i6, measuredWidth2));
                if (measuredWidth2 > measuredWidth) {
                    i5++;
                }
            }
        }
        if (i5 >= i3) {
            e(childCount, true);
            super.onMeasure(i, i2);
        } else if (i5 == 0) {
            e(childCount, false);
            super.onMeasure(i, i2);
        } else {
            this.b = true;
            this.f11108a = getMeasuredHeight();
            c(arrayList, i3, measuredWidth);
            setMeasuredDimension(size, this.f11108a);
        }
    }

    public HwCardButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new c();
        setOrientation(0);
    }

    private void c(List<b> list, int i, int i2) {
        Collections.sort(list, this.e);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int i3 = 0;
        for (b bVar : list) {
            View childAt = getChildAt(bVar.d);
            if (childAt != null) {
                LinearLayout.LayoutParams layoutParams = childAt.getLayoutParams() instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) childAt.getLayoutParams() : null;
                int i4 = layoutParams != null ? layoutParams.leftMargin + layoutParams.rightMargin : 0;
                int i5 = bVar.e;
                if (i5 <= i2) {
                    i3++;
                    measuredWidth -= i5 + i4;
                } else {
                    int i6 = i - i3;
                    bVar.e = i6 == 0 ? measuredWidth - i4 : (measuredWidth / i6) - i4;
                }
            }
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 0);
        for (b bVar2 : list) {
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(bVar2.e, Integer.MIN_VALUE);
            View childAt2 = getChildAt(bVar2.d);
            if (childAt2 != null) {
                childAt2.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
                int measuredHeight = childAt2.getMeasuredHeight();
                int i7 = this.f11108a;
                if (measuredHeight <= i7) {
                    measuredHeight = i7;
                }
                this.f11108a = measuredHeight;
            }
        }
    }

    private void c(int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingStart = i3 - getPaddingStart();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    int marginStart = paddingStart - layoutParams2.getMarginStart();
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (layoutParams2.gravity == 16) {
                        paddingTop = getPaddingTop() + (((((i4 - i2) - measuredHeight) - getPaddingTop()) - getPaddingBottom()) / 2);
                    }
                    childAt.layout(marginStart - measuredWidth, paddingTop, marginStart, measuredHeight + paddingTop);
                    paddingStart = marginStart - (measuredWidth + layoutParams2.getMarginEnd());
                }
            }
        }
    }

    private boolean b() {
        return getLayoutDirection() == 1;
    }
}
