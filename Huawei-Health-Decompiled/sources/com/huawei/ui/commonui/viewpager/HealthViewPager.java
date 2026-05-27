package com.huawei.ui.commonui.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import com.huawei.operation.utils.Constants;
import com.huawei.uikit.hwviewpager.widget.HwPagerAdapter;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import defpackage.plt;
import health.compact.a.LanguageUtil;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HealthViewPager extends HwViewPager {
    private Context c;
    private float d;
    private float e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private boolean j;
    private float k;
    private boolean l;
    private boolean m;
    private boolean n;
    private float o;
    private int r;
    private float s;
    private OnViewPagerTouchEvent t;

    /* JADX INFO: loaded from: classes.dex */
    public interface OnPageChangeListener extends HwViewPager.OnPageChangeListener {
    }

    public interface OnViewPagerTouchEvent {
        void onTouchDown(MotionEvent motionEvent);

        void onTouchUp(MotionEvent motionEvent);

        void setIsViewTouch(Boolean bool);
    }

    public interface PageTransformer extends HwViewPager.PageTransformer {
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager, android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    public HealthViewPager(Context context) {
        super(context);
        this.j = true;
        this.m = true;
        this.l = true;
        this.n = false;
        this.h = false;
        this.g = false;
        this.f = false;
        this.e = 0.0f;
        this.d = 0.0f;
        this.o = 0.0f;
        this.s = 0.0f;
        this.k = 0.0f;
        this.r = 0;
        this.i = 0;
        this.c = context;
    }

    public HealthViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        this.m = true;
        this.l = true;
        this.n = false;
        this.h = false;
        this.g = false;
        this.f = false;
        this.e = 0.0f;
        this.d = 0.0f;
        this.o = 0.0f;
        this.s = 0.0f;
        this.k = 0.0f;
        this.r = 0;
        this.i = 0;
        this.c = context;
    }

    public void setIsScroll(boolean z) {
        this.j = z;
    }

    public void setIsScrollToLeft(boolean z) {
        this.m = z;
    }

    public void setIsScrollToRight(boolean z) {
        this.l = z;
    }

    public void setIsCompatibleScrollView(boolean z) {
        this.n = z;
    }

    public void setIsAutoHeight(boolean z) {
        this.h = z;
    }

    public void setIsAutoCurrentItemHeight(boolean z) {
        this.g = z;
    }

    public void setIsAutoWidthAndHeight(boolean z) {
        this.f = z;
    }

    public void setScrollHeightArea(int i) {
        this.i = plt.b(this.c, i);
    }

    public void setOnViewPagerTouchEventListener(OnViewPagerTouchEvent onViewPagerTouchEvent) {
        this.t = onViewPagerTouchEvent;
    }

    public void setYScrollMoveThreshold(int i) {
        this.r = i;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight = 0;
        if (this.h) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight2 = childAt.getMeasuredHeight();
                if (measuredHeight2 > i3) {
                    i3 = measuredHeight2;
                }
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            return;
        }
        if (this.g) {
            int currentItem = getCurrentItem();
            HwPagerAdapter adapter = getAdapter();
            if (adapter == null) {
                return;
            }
            Object objInstantiateItem = adapter.instantiateItem(this, currentItem);
            if (objInstantiateItem instanceof View) {
                View view = (View) objInstantiateItem;
                view.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                measuredHeight = view.getMeasuredHeight();
                adapter.destroyItem(this, currentItem, objInstantiateItem);
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            return;
        }
        if (this.f) {
            int iMax = 0;
            int iMax2 = 0;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt2 = getChildAt(i5);
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
                iMax2 = Math.max(iMax2, childAt2.getMeasuredHeight());
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMax, 1073741824), View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824));
            return;
        }
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i), ViewGroup.getDefaultSize(0, i2));
        super.onMeasure(i, i2);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.j) {
            return false;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && this.j && motionEvent.getY() > this.i) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (action >= motionEvent.getPointerCount()) {
            ReleaseLogUtil.a("R_HealthViewPager", "pointerIndex out of range: ", Integer.valueOf(action), " (pointerCount: ", Integer.valueOf(motionEvent.getPointerCount()), Constants.RIGHT_BRACKET_ONLY);
            return false;
        }
        cZf_(motionEvent);
        if (this.n) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
                this.e = motionEvent.getY();
                this.d = motionEvent.getX();
            } else if (action2 == 2) {
                this.o = motionEvent.getX();
                this.s = motionEvent.getY();
                if ((Math.abs(this.o - this.d) >= Math.abs(this.s - this.e) && plt.b(this.c, 180.0f) >= this.s) || plt.b(this.c, 180.0f) < this.s || plt.b(this.c, this.r) > Math.abs(this.o - this.d)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
        if (!this.m && cZg_(motionEvent)) {
            return true;
        }
        if (this.l || !cZh_(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    private boolean cZg_(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.k = motionEvent.getX();
        } else if (action == 2) {
            float x = motionEvent.getX() - this.k;
            boolean zAy = LanguageUtil.ay(getContext());
            if (!zAy && x < 0.0f) {
                return true;
            }
            if (zAy && x > 0.0f) {
                return true;
            }
        }
        return false;
    }

    private boolean cZh_(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.k = motionEvent.getX();
        } else if (action == 2) {
            float x = motionEvent.getX() - this.k;
            boolean zAy = LanguageUtil.ay(getContext());
            if (!zAy && x > 0.0f) {
                return true;
            }
            if (zAy && x < 0.0f) {
                return true;
            }
        }
        return false;
    }

    private void cZf_(MotionEvent motionEvent) {
        if (this.t == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.t.onTouchDown(motionEvent);
            return;
        }
        if (action == 1) {
            this.t.onTouchUp(motionEvent);
            return;
        }
        if (action != 2) {
            return;
        }
        this.o = motionEvent.getX();
        this.s = motionEvent.getY();
        if ((Math.abs(this.o - this.d) >= Math.abs(this.s - this.e) && plt.b(this.c, 180.0f) >= this.s) || plt.b(this.c, 180.0f) < this.s || plt.b(this.c, this.r) > Math.abs(this.o - this.d)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }
}
