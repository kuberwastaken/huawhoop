package com.huawei.healthcloud.plugintrack.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class AutoNextLineLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Integer> f3903a;
    private int b;
    private int c;
    private List<List<View>> d;
    private List<Integer> e;
    private int h;

    public AutoNextLineLinearLayout(Context context) {
        super(context);
        this.d = new ArrayList();
        this.f3903a = new ArrayList();
        this.c = (int) Utils.convertDpToPixel(8.0f);
        this.h = (int) Utils.convertDpToPixel(4.0f);
        this.e = new ArrayList();
    }

    public AutoNextLineLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList();
        this.f3903a = new ArrayList();
        this.c = (int) Utils.convertDpToPixel(8.0f);
        this.h = (int) Utils.convertDpToPixel(4.0f);
        this.e = new ArrayList();
    }

    public AutoNextLineLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new ArrayList();
        this.f3903a = new ArrayList();
        this.c = (int) Utils.convertDpToPixel(8.0f);
        this.h = (int) Utils.convertDpToPixel(4.0f);
        this.e = new ArrayList();
    }

    public int getLineHeight() {
        return this.b;
    }

    public List<List<View>> getLines() {
        return this.d;
    }

    public List<Integer> getLineHeights() {
        return this.f3903a;
    }

    public int getHorizontalSpacing() {
        return this.c;
    }

    public int getVerticalSpacing() {
        return this.h;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        this.d.clear();
        this.f3903a.clear();
        this.e.clear();
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        int size3 = 0;
        int iMax = 0;
        int i9 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            int visibility = childAt.getVisibility();
            if (visibility == 8 || visibility == 4) {
                i3 = size2;
                i4 = childCount;
            } else {
                if (i8 == 0) {
                    i6 = i;
                    i7 = i2;
                    i5 = 0;
                } else {
                    i5 = this.c;
                    i6 = i;
                    i7 = i2;
                }
                measureChild(childAt, i6, i7);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                i3 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin + i5;
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = layoutParams.topMargin;
                int i11 = layoutParams.bottomMargin;
                i4 = childCount;
                if (i9 + measuredWidth > (size - getPaddingLeft()) - getPaddingRight()) {
                    size3 += iMax;
                    this.d.add(arrayList);
                    this.e.add(Integer.valueOf(i9));
                    this.f3903a.add(Integer.valueOf(iMax));
                    arrayList = new ArrayList();
                    iMax = 0;
                    i9 = 0;
                }
                arrayList.add(childAt);
                i9 += measuredWidth;
                iMax = Math.max(iMax, measuredHeight + i10 + i11);
            }
            i8++;
            size2 = i3;
            childCount = i4;
        }
        int i12 = size2;
        if (!arrayList.isEmpty()) {
            this.d.add(arrayList);
            this.f3903a.add(Integer.valueOf(iMax));
            size3 += iMax;
            this.e.add(Integer.valueOf(i9));
        }
        if (this.d.size() > 1) {
            size3 += (this.d.size() - 1) * this.h;
        }
        if (mode != 1073741824) {
            size = size + getPaddingLeft() + getPaddingRight();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i12 : size3 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop = getPaddingTop();
        int iAbs = Math.abs(i3 - i);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = 0;
        while (i5 < this.d.size()) {
            List<View> list = this.d.get(i5);
            int iIntValue = this.f3903a.get(i5).intValue();
            int paddingLeft2 = getPaddingLeft();
            int iIntValue2 = (((iAbs - paddingLeft) - paddingRight) - (this.e.get(i5).intValue() - ((list.size() - 1) * this.c))) / (list.size() + 1);
            if (iIntValue2 > this.c) {
                paddingLeft2 += iIntValue2;
            }
            for (View view : list) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft2;
                int i7 = layoutParams.topMargin + paddingTop;
                view.layout(i6, i7, i6 + measuredWidth, measuredHeight + i7);
                paddingLeft2 += measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + Math.max(iIntValue2, this.c);
                iAbs = iAbs;
            }
            paddingTop += iIntValue + this.h;
            i5++;
            iAbs = iAbs;
        }
    }
}
