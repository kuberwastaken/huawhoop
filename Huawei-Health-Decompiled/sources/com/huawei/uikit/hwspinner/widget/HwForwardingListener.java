package com.huawei.uikit.hwspinner.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;
import defpackage.vnl;

/* JADX INFO: loaded from: classes8.dex */
public abstract class HwForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {
    private static final int h = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f11236a;
    private final int b;
    private final int c;
    private final View d;
    private Runnable e;
    private Runnable f;
    private int g;
    protected boolean mIstransmitting;

    class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = HwForwardingListener.this.d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    class d implements Runnable {
        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwForwardingListener.this.b();
        }
    }

    public HwForwardingListener(View view) {
        this.d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f11236a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.b = tapTimeout;
        this.c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public abstract ShowableListMenu getPopup();

    protected boolean onForwardingStarted() {
        ShowableListMenu popup = getPopup();
        if (popup == null || popup.isShowing()) {
            return true;
        }
        popup.show();
        return true;
    }

    protected boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.mIstransmitting;
        if (z2) {
            z = a(motionEvent) || !onForwardingStopped();
        } else {
            z = b(motionEvent) && onForwardingStarted();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.mIstransmitting = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.mIstransmitting = false;
        this.g = -1;
        Runnable runnable = this.e;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
        }
    }

    private void a() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.e;
        if (runnable2 != null) {
            this.d.removeCallbacks(runnable2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r7.getActionMasked()
            if (r1 == 0) goto L66
            r3 = 1
            if (r1 == r3) goto L62
            r4 = 2
            if (r1 == r4) goto L1b
            r7 = 3
            if (r1 == r7) goto L62
            goto L93
        L1b:
            int r1 = r6.g
            int r1 = r7.findPointerIndex(r1)
            if (r1 < 0) goto L93
            float r4 = r7.getX(r1)
            float r7 = r7.getY(r1)
            java.lang.Class r1 = java.lang.Float.TYPE
            java.lang.Class[] r1 = new java.lang.Class[]{r1, r1, r1}
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            float r5 = r6.f11236a
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.Object[] r7 = new java.lang.Object[]{r4, r7, r5}
            java.lang.String r4 = "pointInView"
            java.lang.Class<android.view.View> r5 = android.view.View.class
            java.lang.Object r7 = defpackage.vnl.b(r0, r4, r1, r7, r5)
            boolean r1 = r7 instanceof java.lang.Boolean
            if (r1 == 0) goto L57
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L93
        L57:
            r6.a()
            android.view.ViewParent r7 = r0.getParent()
            r7.requestDisallowInterceptTouchEvent(r3)
            return r3
        L62:
            r6.a()
            goto L93
        L66:
            int r7 = r7.getPointerId(r2)
            r6.g = r7
            java.lang.Runnable r7 = r6.e
            r1 = 0
            if (r7 != 0) goto L78
            com.huawei.uikit.hwspinner.widget.HwForwardingListener$c r7 = new com.huawei.uikit.hwspinner.widget.HwForwardingListener$c
            r7.<init>()
            r6.e = r7
        L78:
            java.lang.Runnable r7 = r6.e
            int r3 = r6.b
            long r3 = (long) r3
            r0.postDelayed(r7, r3)
            java.lang.Runnable r7 = r6.f
            if (r7 != 0) goto L8b
            com.huawei.uikit.hwspinner.widget.HwForwardingListener$d r7 = new com.huawei.uikit.hwspinner.widget.HwForwardingListener$d
            r7.<init>()
            r6.f = r7
        L8b:
            java.lang.Runnable r7 = r6.f
            int r1 = r6.c
            long r3 = (long) r1
            r0.postDelayed(r7, r3)
        L93:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwspinner.widget.HwForwardingListener.b(android.view.MotionEvent):boolean");
    }

    private boolean a(MotionEvent motionEvent) {
        HwDropDownListView hwDropDownListView;
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing() || !(popup.getListView() instanceof HwDropDownListView) || (hwDropDownListView = (HwDropDownListView) popup.getListView()) == null || !hwDropDownListView.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        vnl.b(this.d, "toGlobalMotionEvent", new Class[]{MotionEvent.class}, new Object[]{motionEventObtainNoHistory}, View.class);
        vnl.b(hwDropDownListView, "toLocalMotionEvent", new Class[]{MotionEvent.class}, new Object[]{motionEventObtainNoHistory}, View.class);
        boolean zEEV_ = hwDropDownListView.eEV_(motionEventObtainNoHistory, this.g);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zEEV_ && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a();
        View view = this.d;
        if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
            if (view.getParent() != null) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.mIstransmitting = true;
        }
    }
}
