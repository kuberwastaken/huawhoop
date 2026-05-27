package com.huawei.uikit.hwsubtab.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.health.R;
import com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView;
import defpackage.vme;
import defpackage.vnm;
import defpackage.vpb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class HwSubTabViewContainer extends HwHorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11248a;
    private int b;
    private SlidingTabStrip c;
    private int d;
    private ValueAnimator e;
    private boolean f;
    private int g;
    private int h;
    private boolean i;
    private int j;
    private a k;
    private int l;
    private boolean n;
    private int o;

    public static class SlidingTabStrip extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11249a;
        private int b;
        private Drawable c;
        float d;
        int e;
        private final Paint f;
        private int g;
        private int h;
        private ValueAnimator i;
        private int j;
        private boolean k;
        private d o;

        class d extends AnimatorListenerAdapter {
            final /* synthetic */ int e;

            d(int i) {
                this.e = i;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SlidingTabStrip slidingTabStrip = SlidingTabStrip.this;
                slidingTabStrip.e = this.e;
                slidingTabStrip.d = 0.0f;
            }
        }

        SlidingTabStrip(Context context) {
            super(context);
            this.e = -1;
            this.j = -1;
            this.h = -1;
            this.g = -1;
            this.k = true;
            setWillNotDraw(false);
            this.f = new Paint();
            this.c = ContextCompat.getDrawable(context, R.drawable._2131429793_res_0x7f0b09a1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null && childAt.getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        private void c() {
            int left;
            int right;
            if (this.o == null) {
                Log.e("HwSubTabViewContainer", "updateIndicatorPosition mSlidingTabStripClient is empty");
                return;
            }
            View childAt = getChildAt(this.e);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft() + this.o.eFm_(childAt);
                right = childAt.getRight() - this.o.eFn_(childAt);
                if (this.d > 0.0f && this.e < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.e + 1);
                    int left2 = childAt2.getLeft();
                    int iEFm_ = this.o.eFm_(childAt2);
                    int right2 = childAt2.getRight();
                    int iEFn_ = this.o.eFn_(childAt2);
                    float f = this.d;
                    float f2 = left2 + iEFm_;
                    float f3 = 1.0f - f;
                    left = (int) ((f2 * f) + (left * f3));
                    right = (int) ((f * (right2 - iEFn_)) + (f3 * right));
                }
            }
            e(left, right);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
            View childAt = getChildAt(this.e);
            if (hasFocus() || childAt == null) {
                super.addFocusables(arrayList, i, i2);
            } else if (!childAt.isFocusable()) {
                super.addFocusables(arrayList, i, i2);
            } else if (arrayList != null) {
                arrayList.add(childAt);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void draw(android.graphics.Canvas r6) {
            /*
                r5 = this;
                super.draw(r6)
                if (r6 != 0) goto Ld
                java.lang.String r6 = "HwSubTabViewContainer"
                java.lang.String r0 = "Parameter canvas of draw should not be null."
                android.util.Log.w(r6, r0)
                return
            Ld:
                int r0 = r5.e
                r1 = -1
                r2 = 0
                if (r0 == r1) goto L2b
                android.view.View r0 = r5.getChildAt(r0)
                boolean r1 = r0 instanceof android.widget.TextView
                if (r1 == 0) goto L2b
                android.widget.TextView r0 = (android.widget.TextView) r0
                android.text.Layout r1 = r0.getLayout()
                if (r1 == 0) goto L2b
                int r0 = r0.getTotalPaddingBottom()
                int r1 = r5.f11249a
                int r0 = r0 - r1
                goto L2c
            L2b:
                r0 = r2
            L2c:
                int r1 = r5.h
                if (r1 < 0) goto L56
                int r3 = r5.g
                if (r3 <= r1) goto L56
                android.graphics.drawable.Drawable r4 = r5.c
                int r3 = r3 - r1
                int r1 = r5.b
                r4.setBounds(r2, r2, r3, r1)
                r6.save()
                int r1 = r5.h
                float r1 = (float) r1
                int r2 = r5.getHeight()
                int r3 = r5.b
                int r2 = r2 - r3
                int r2 = r2 - r0
                float r0 = (float) r2
                r6.translate(r1, r0)
                android.graphics.drawable.Drawable r0 = r5.c
                r0.draw(r6)
                r6.restore()
            L56:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwsubtab.widget.HwSubTabViewContainer.SlidingTabStrip.draw(android.graphics.Canvas):void");
        }

        public int getSelectedIndicatorHeight() {
            return this.b;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                c();
                return;
            }
            this.i.cancel();
            c(this.e, Math.round((1.0f - this.i.getAnimatedFraction()) * this.i.getDuration()));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
        }

        void setSelectedIndicatorHeight(int i) {
            if (this.b != i) {
                this.b = i;
                a();
            }
        }

        void setSelectedIndicatorMargin(int i) {
            if (this.f11249a != i) {
                this.f11249a = i;
                a();
            }
        }

        public void setSlidingTabStripClient(d dVar) {
            this.o = dVar;
        }

        private void a() {
            if (!this.k) {
                postInvalidate();
            } else {
                postInvalidateOnAnimation();
            }
        }

        void e(int i, int i2) {
            if (i == this.h && i2 == this.g) {
                return;
            }
            this.h = i;
            this.g = i2;
            a();
        }

        public void setSelectedIndicatorColor(int i) {
            this.c.setTint(i);
            this.f.setColor(i);
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, float f) {
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
            }
            this.e = i;
            this.d = f;
            c();
        }

        void c(int i, int i2) {
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
                this.e = i;
            }
            View childAt = getChildAt(i);
            if (childAt == null) {
                c();
                return;
            }
            if (this.o == null) {
                Log.e("HwSubTabViewContainer", "animateIndicatorToPosition mSlidingTabStripClient is empty");
                return;
            }
            int left = childAt.getLeft();
            int iEFm_ = this.o.eFm_(childAt);
            int right = childAt.getRight();
            int iEFn_ = this.o.eFn_(childAt);
            int left2 = childAt.getLeft();
            int iEFm_2 = this.o.eFm_(childAt);
            int right2 = childAt.getRight();
            int iEFn_2 = this.o.eFn_(childAt);
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.i = valueAnimator2;
            valueAnimator2.setInterpolator(new vme());
            this.i.setDuration(i2);
            this.i.setFloatValues(0.0f, 1.0f);
            final int i3 = left2 + iEFm_2;
            final int i4 = left + iEFm_;
            final int i5 = right2 - iEFn_2;
            final int i6 = right - iEFn_;
            this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: vph
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    this.b.eFl_(i3, i4, i5, i6, valueAnimator3);
                }
            });
            this.i.addListener(new d(i));
            this.i.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void eFl_(int i, int i2, int i3, int i4, ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.w("HwSubTabViewContainer", "Object animator in animateIndicatorToPosition should not be null.");
            } else {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                e(e(i, i2, animatedFraction), e(i3, i4, animatedFraction));
            }
        }

        int e(int i, int i2, float f) {
            return i + Math.round(f * (i2 - i));
        }
    }

    public class a {
        public a() {
        }

        public void eHl_(View view) {
            view.setPadding(HwSubTabViewContainer.this.b - HwSubTabViewContainer.this.f11248a, 0, HwSubTabViewContainer.this.d - HwSubTabViewContainer.this.f11248a, 0);
        }

        public void eHm_(View view, boolean z) {
            if (z && HwSubTabViewContainer.this.n) {
                int i = HwSubTabViewContainer.this.d - HwSubTabViewContainer.this.f11248a;
                view.setPadding(i, 0, i, 0);
            } else {
                int i2 = -HwSubTabViewContainer.this.f11248a;
                view.setPadding(i2, 0, i2, 0);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.w("HwSubTabViewContainer", "Object animator in method ensureScrollAnimator should not be null.");
            } else {
                HwSubTabViewContainer.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        }
    }

    public class d {
        public d() {
        }

        public int eFm_(View view) {
            return view.getPaddingLeft();
        }

        public int eFn_(View view) {
            return view.getPaddingRight();
        }
    }

    public HwSubTabViewContainer(Context context) {
        this(context, null);
    }

    protected void a() {
        this.k = new a();
    }

    @Override // android.widget.HorizontalScrollView
    public boolean arrowScroll(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        if (FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i) == null) {
            return false;
        }
        return super.arrowScroll(i);
    }

    public boolean b() {
        View childAt = getChildAt(0);
        ViewParent parent = getParent();
        if (childAt == null || !(parent instanceof ViewGroup)) {
            return false;
        }
        return getMeasuredWidth() < (childAt.getMeasuredWidth() + getPaddingStart()) + getPaddingEnd() || getMeasuredWidth() > ((ViewGroup) parent).getMeasuredWidth();
    }

    public void c(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() == null || this.c.b()) {
            setScrollPosition(i, 0.0f);
            return;
        }
        int scrollX = getScrollX();
        int iD = d(i, 0.0f);
        if (!this.i) {
            scrollTo(iD, 0);
            setScrollPosition(i, 0.0f);
            return;
        }
        if (scrollX != iD) {
            j();
            this.e.setIntValues(scrollX, iD);
            this.e.start();
        }
        this.c.c(i, 200);
    }

    public int getFadingMargin() {
        return this.d;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getLeftFadingEdgeStrength() {
        int i = this.g;
        return (i == 0 || i == 1) ? 1.0f : 0.0f;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getRightFadingEdgeStrength() {
        int i = this.g;
        return (i == 0 || i == 1) ? 1.0f : 0.0f;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.h;
    }

    public int getStartOriginPadding() {
        return this.b;
    }

    public int getStartScrollPadding() {
        return this.j;
    }

    public int getSubTabItemMargin() {
        return this.f11248a;
    }

    public SlidingTabStrip getTabStrip() {
        return this.c;
    }

    protected void i() {
        this.c.setSlidingTabStripClient(new d());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f) {
            vnm.ezl_(getParent());
        }
    }

    @Override // com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView, android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getOverScroller() == null || (getOverScroller().isFinished() && !d())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        if (!isLaidOut() && f()) {
            int iMax = Math.max(0, childAt.getMeasuredWidth() - (((i3 - i) - getPaddingLeft()) - getPaddingRight()));
            if (getScrollX() != iMax || this.o == 0) {
                int i5 = this.o;
                if (i5 != -1) {
                    scrollTo(i5, getScrollY());
                } else {
                    scrollTo(iMax, getScrollY());
                }
            }
        }
        if (this.g == 1) {
            this.k.eHl_(childAt);
            if (!b()) {
                setHorizontalFadingEdgeEnabled(false);
                return;
            } else {
                setHorizontalFadingEdgeEnabled(true);
                setFadingEdgeLength(this.d);
                return;
            }
        }
        if (!b()) {
            setHorizontalFadingEdgeEnabled(false);
            this.k.eHm_(childAt, false);
        } else {
            this.k.eHm_(childAt, true);
            setHorizontalFadingEdgeEnabled(true);
            setFadingEdgeLength(this.d);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        this.o = i;
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (f()) {
            scrollTo(getScrollX() - (i - i3), getScrollY());
        }
    }

    @Override // com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView, android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (b()) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setAnimationEnabled(boolean z) {
        this.i = z;
        SlidingTabStrip slidingTabStrip = this.c;
        if (slidingTabStrip != null) {
            slidingTabStrip.k = z;
        }
    }

    protected void setAppearance(int i) {
        this.g = i;
    }

    public void setChildPaddingClient(a aVar) {
        this.k = aVar;
    }

    public void setFadingMargin(int i) {
        this.d = i;
    }

    public void setItemPadding(int i, int i2) {
        this.b = i;
        this.l = i2;
    }

    public void setMirrorScrollX(int i) {
        this.o = i;
    }

    public void setOverScreen(boolean z) {
        this.n = z;
    }

    public void setScrollPosition(int i, float f) {
        setScrollPosition(i, f, true);
    }

    public void setStartOriginPadding(int i) {
        this.b = i;
    }

    public void setStartScrollPadding(int i) {
        this.j = i;
    }

    public void setSubTabFaddingEdgeColor(int i) {
        this.h = i;
    }

    void setSubTabItemMargin(int i) {
        this.f11248a = i;
        View childAt = getChildAt(0);
        if (this.g == 1) {
            int i2 = this.b;
            int i3 = this.f11248a;
            childAt.setPadding(i2 - i3, 0, this.d - i3, 0);
        } else if (b()) {
            int i4 = this.d - this.f11248a;
            childAt.setPadding(i4, 0, i4, 0);
        }
    }

    public HwSubTabViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.i = true;
        this.j = 20;
        this.g = 0;
        this.o = -1;
        this.l = 0;
        this.n = false;
        a(context);
    }

    private void a(Context context) {
        setHorizontalScrollBarEnabled(false);
        setOverScrollMode(0);
        a();
        this.c = new SlidingTabStrip(context);
        i();
        super.addView(this.c, 0, new FrameLayout.LayoutParams(-2, -1));
        this.d = getResources().getDimensionPixelSize(R.dimen._2131364510_res_0x7f0a0a9e);
        this.b = getResources().getDimensionPixelSize(R.dimen._2131364531_res_0x7f0a0ab3);
        if (vpb.e(context) == 2) {
            this.f = true;
        }
    }

    private boolean f() {
        return getLayoutDirection() == 1;
    }

    public void setScrollPosition(int i, float f, boolean z) {
        int iRound = Math.round(i + f);
        if (iRound < 0 || iRound >= this.c.getChildCount()) {
            return;
        }
        if (z) {
            this.c.b(i, f);
        }
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.e.cancel();
        }
        scrollTo(d(i, f), 0);
    }

    private void j() {
        if (this.e == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.e = valueAnimator;
            valueAnimator.setInterpolator(new vme());
            this.e.setDuration(200L);
            this.e.addUpdateListener(new b());
        }
    }

    private int d(int i, float f) {
        int i2;
        float f2;
        int left;
        int width;
        View childAt = this.c.getChildAt(i);
        int i3 = i + 1;
        View childAt2 = i3 < this.c.getChildCount() ? this.c.getChildAt(i3) : null;
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        TextView textView2 = childAt2 instanceof TextView ? (TextView) childAt2 : null;
        int left2 = 0;
        int width2 = textView != null ? textView.getWidth() : 0;
        int width3 = textView2 != null ? textView2.getWidth() : 0;
        if (textView != null) {
            if (this.g == 1) {
                if (f()) {
                    int right = textView.getRight();
                    int iA = a(this.j);
                    int i4 = this.f11248a;
                    left = right + iA + i4 + i4;
                    width = getWidth();
                } else {
                    left = textView.getLeft() - a(this.j);
                    int i5 = this.f11248a;
                    width = i5 + i5;
                }
                left2 = left - width;
                int i6 = this.f11248a;
                f2 = width2 + i6 + i6;
            } else {
                left2 = (textView.getLeft() + (width2 / 2)) - (getWidth() / 2);
                int i7 = this.f11248a;
                f2 = ((width2 + width3) * 0.5f) + i7 + i7;
            }
            i2 = (int) (f2 * f);
        } else {
            i2 = 0;
        }
        return getLayoutDirection() == 0 ? left2 + i2 : left2 - i2;
    }

    public HwSubTabViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
        this.i = true;
        this.j = 20;
        this.g = 0;
        this.o = -1;
        this.l = 0;
        this.n = false;
        a(context);
    }

    int a(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }
}
