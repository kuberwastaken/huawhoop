package com.huawei.phoneservice.feedback.mvp.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;
import com.huawei.health.R;
import com.huawei.phoneservice.faq.base.util.FaqRefectUtils;

/* JADX INFO: loaded from: classes11.dex */
public class FeedbackFootOverScrollListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8561a;
    private int b;
    private int c;
    private float d;
    private boolean e;
    private int f;
    private a g;
    private boolean i;

    /* JADX INFO: loaded from: classes6.dex */
    public interface a {
        void a(int i, int i2, int i3, int i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.ListView
    public void setOverscrollFooter(Drawable drawable) {
        super.setOverscrollFooter(drawable);
        if (drawable instanceof a) {
            a aVar = (a) drawable;
            this.g = aVar;
            aVar.a(getWidth(), getHeight(), getWidth(), getHeight());
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        super.setOnScrollListener(onScrollListener);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        if (this.e) {
            this.e = false;
        }
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, this.c, z);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (motionEvent.getAction() == 0) {
            int i = this.f8561a;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                int iPointToPosition = pointToPosition((int) motionEvent.getX(iFindPointerIndex), (int) motionEvent.getY(iFindPointerIndex));
                this.f = iPointToPosition;
                if (iPointToPosition == -1) {
                    FaqRefectUtils.e(this, AbsListView.class, "mTouchMode", 5);
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        this.e = true;
    }

    @Override // android.widget.AbsListView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (i2 < 0 && !this.i) {
            i2 = 0;
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.onInterceptTouchEvent(r6)
            int r1 = r6.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            if (r1 == 0) goto L3c
            r2 = 1
            r3 = -1
            if (r1 == r2) goto L37
            r4 = 2
            if (r1 == r4) goto L17
            r2 = 3
            if (r1 == r2) goto L37
            goto L49
        L17:
            int r1 = r5.f8561a
            if (r1 != r3) goto L1c
            goto L49
        L1c:
            int r1 = r6.findPointerIndex(r1)
            if (r1 != r3) goto L23
            goto L49
        L23:
            r5.f8561a = r1
            float r1 = r6.getY(r1)
            int r1 = (int) r1
            float r3 = r5.d
            int r3 = (int) r3
            int r1 = r1 - r3
            int r1 = java.lang.Math.abs(r1)
            int r3 = r5.b
            if (r1 <= r3) goto L49
            return r2
        L37:
            r5.f8561a = r3
            r5.f = r3
            goto L49
        L3c:
            float r1 = r6.getY()
            r5.d = r1
            r1 = 0
            int r1 = r6.getPointerId(r1)
            r5.f8561a = r1
        L49:
            if (r0 != 0) goto L4e
            r5.onTouchEvent(r6)
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedback.mvp.base.FeedbackFootOverScrollListView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    private void b(Context context) {
        this.b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.c = (int) (context.getResources().getDisplayMetrics().density * 140.0f);
        setOverScrollMode(0);
    }

    public FeedbackFootOverScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8561a = -1;
        this.e = false;
        this.i = true;
        this.f = -1;
        b(context);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100221_res_0x7f06023d});
            this.i = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public FeedbackFootOverScrollListView(Context context) {
        super(context);
        this.f8561a = -1;
        this.e = false;
        this.i = true;
        this.f = -1;
        b(context);
    }
}
