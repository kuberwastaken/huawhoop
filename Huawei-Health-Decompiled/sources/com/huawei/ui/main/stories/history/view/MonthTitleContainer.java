package com.huawei.ui.main.stories.history.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import health.compact.a.LanguageUtil;

/* JADX INFO: loaded from: classes8.dex */
public class MonthTitleContainer extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10785a;
    private boolean b;
    private int c;
    private int d;

    public MonthTitleContainer(Context context) {
        super(context);
        this.d = 4;
        this.f10785a = false;
        this.c = 0;
        this.b = LanguageUtil.ay(context);
    }

    public MonthTitleContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 4;
        this.f10785a = false;
        this.c = 0;
        this.b = LanguageUtil.ay(context);
    }

    public MonthTitleContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 4;
        this.f10785a = false;
        this.c = 0;
        this.b = LanguageUtil.ay(context);
    }

    public void c(int i) {
        this.d = i;
    }

    public void setExpandStatus(boolean z) {
        this.f10785a = z;
        requestLayout();
        invalidate();
    }

    public boolean getExpandStatus() {
        return this.f10785a;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        measureChildren(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            measuredWidth = this.c;
            if (measuredWidth == 0) {
                measuredWidth = getChildAt(0).getMeasuredWidth() * this.d;
            }
        } else {
            measuredWidth = 0;
        }
        int i3 = this.d;
        int i4 = (i3 - 1) + i3;
        int i5 = childCount / i4;
        if (childCount % i4 != 0) {
            i5++;
        }
        if (i5 > 2 && !this.f10785a) {
            i5 = 2;
        }
        setMeasuredDimension(measuredWidth, getChildAt(0) != null ? getChildAt(0).getMeasuredHeight() * i5 : 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.b) {
            b();
        } else {
            c();
        }
    }

    private void b() {
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            if (i4 > 13 && !this.f10785a) {
                return;
            }
            View childAt = getChildAt(i4);
            int measuredWidth2 = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i2 >= measuredWidth) {
                i3 += i;
                i = 0;
                i2 = 0;
            }
            int i5 = measuredWidth - i2;
            i2 += measuredWidth2;
            if (measuredHeight > i) {
                i = measuredHeight;
            }
            childAt.layout(i5 - measuredWidth2, i3, i5, measuredHeight + i3);
        }
    }

    private void c() {
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < childCount) {
            if (i > 13 && !this.f10785a) {
                return;
            }
            View childAt = getChildAt(i);
            int measuredWidth2 = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i3 >= measuredWidth) {
                i4 += i2;
                i2 = 0;
                i3 = 0;
            }
            int i5 = measuredWidth2 + i3;
            if (measuredHeight > i2) {
                i2 = measuredHeight;
            }
            childAt.layout(i3, i4, i5, measuredHeight + i4);
            i++;
            i3 = i5;
        }
    }
}
