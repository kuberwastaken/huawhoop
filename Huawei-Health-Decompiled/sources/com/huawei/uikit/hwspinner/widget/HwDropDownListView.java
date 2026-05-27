package com.huawei.uikit.hwspinner.widget;

import android.R;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.widget.ListViewAutoScrollHelper;
import defpackage.vnl;

/* JADX INFO: loaded from: classes8.dex */
public class HwDropDownListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ListViewAutoScrollHelper f11235a;
    private boolean b;
    private boolean c;
    private int d;
    private boolean e;
    private int j;

    public HwDropDownListView(Context context, boolean z) {
        this(context, z, R.attr.dropDownListViewStyle);
    }

    private void a() {
        vnl.b(this, "setShowHoverEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE}, AbsListView.class);
    }

    private void c() {
        setPressed(false);
        vnl.b(this, "updateSelectorState", null, null, AbsListView.class);
        Object objA = vnl.a(this, "mMotionPosition", AbsListView.class);
        if (objA instanceof Integer) {
            this.d = ((Integer) objA).intValue();
        }
        View childAt = getChildAt(this.d - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
    }

    protected int c(int i, int i2) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        ListAdapter adapter = getAdapter();
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return measuredHeight;
        }
        int count = adapter.getCount();
        View view = null;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = adapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = adapter.getView(i4, view, this);
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                    view.setLayoutParams(layoutParams);
                }
                int i5 = layoutParams.height;
                view.measure(i, i5 <= 0 ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                view.forceLayout();
                int dividerHeight = (getDividerHeight() <= 0 || getDivider() == null) ? 0 : getDividerHeight();
                if (i4 > 0) {
                    measuredHeight += dividerHeight;
                }
                measuredHeight += view.getMeasuredHeight();
                if (measuredHeight >= i2) {
                    return i2;
                }
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean eEV_(android.view.MotionEvent r9, int r10) {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L11
            r3 = 2
            if (r0 == r3) goto Lf
            r10 = 3
            if (r0 == r10) goto L18
            goto L46
        Lf:
            r3 = r2
            goto L12
        L11:
            r3 = r1
        L12:
            int r10 = r9.findPointerIndex(r10)
            if (r10 >= 0) goto L1b
        L18:
            r10 = r1
            r3 = r10
            goto L48
        L1b:
            float r4 = r9.getX(r10)
            int r4 = (int) r4
            float r10 = r9.getY(r10)
            int r10 = (int) r10
            int r5 = r8.pointToPosition(r4, r10)
            r6 = -1
            if (r5 != r6) goto L2e
            r10 = r2
            goto L48
        L2e:
            int r3 = r8.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r8.getChildAt(r3)
            float r4 = (float) r4
            float r10 = (float) r10
            r8.a(r3, r5, r4, r10)
            if (r0 != r2) goto L46
            long r6 = r8.getItemIdAtPosition(r5)
            r8.performItemClick(r3, r5, r6)
        L46:
            r10 = r1
            r3 = r2
        L48:
            if (r3 == 0) goto L4c
            if (r10 == 0) goto L4f
        L4c:
            r8.c()
        L4f:
            if (r3 == 0) goto L66
            androidx.core.widget.ListViewAutoScrollHelper r10 = r8.f11235a
            if (r10 != 0) goto L5c
            androidx.core.widget.ListViewAutoScrollHelper r10 = new androidx.core.widget.ListViewAutoScrollHelper
            r10.<init>(r8)
            r8.f11235a = r10
        L5c:
            androidx.core.widget.ListViewAutoScrollHelper r10 = r8.f11235a
            r10.setEnabled(r2)
            androidx.core.widget.ListViewAutoScrollHelper r10 = r8.f11235a
            r10.onTouch(r8, r9)
        L66:
            androidx.core.widget.ListViewAutoScrollHelper r9 = r8.f11235a
            if (r9 == 0) goto L6d
            r9.setEnabled(r1)
        L6d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwspinner.widget.HwDropDownListView.eEV_(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.e || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.e || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.e || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if (isHovered() && isFocused()) {
            return false;
        }
        return (this.e && this.b) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onInterceptTouchEvent(motionEvent);
        return true;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setListSelectionHidden(boolean z) {
        this.b = z;
    }

    public void setTint(int i) {
        if (i != 0) {
            this.j = i;
        }
    }

    public HwDropDownListView(Context context, boolean z, int i) {
        super(context, null, i);
        this.b = false;
        this.d = 0;
        this.e = z;
        setDefaultFocusHighlightEnabled(false);
        a();
        setCacheColorHint(0);
    }

    private void a(View view, int i, float f, float f2) {
        drawableHotspotChanged(f, f2);
        if (!isPressed()) {
            setPressed(true);
        }
        Object objA = vnl.a(this, "mDataChanged", AdapterView.class);
        if (objA instanceof Boolean) {
            this.c = ((Boolean) objA).booleanValue();
        }
        if (this.c) {
            layoutChildren();
        }
        Object objA2 = vnl.a(this, "mMotionPosition", AbsListView.class);
        if (objA2 instanceof Integer) {
            this.d = ((Integer) objA2).intValue();
        }
        View childAt = getChildAt(this.d - getFirstVisiblePosition());
        if (childAt != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.d = i;
        view.drawableHotspotChanged(f - view.getLeft(), f2 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        Class cls = Integer.TYPE;
        vnl.b(this, "setSelectedPositionInt", new Class[]{cls}, new Object[]{Integer.valueOf(i)}, AdapterView.class);
        Class cls2 = Float.TYPE;
        vnl.b(this, "positionSelectorLikeTouch", new Class[]{cls, View.class, cls2, cls2}, new Object[]{Integer.valueOf(i), view, Float.valueOf(f), Float.valueOf(f2)}, AbsListView.class);
        refreshDrawableState();
    }
}
