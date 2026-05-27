package com.huawei.ui.commonui.tablewidget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import androidx.core.view.GestureDetectorCompat;
import com.huawei.haf.common.exception.ExceptionUtils;
import health.compact.a.ReleaseLogUtil;

/* JADX INFO: loaded from: classes7.dex */
public class ScrollHelper implements GestureDetector.OnGestureListener {
    private ScrollHelperListener c;
    private final GestureDetectorCompat d;

    public interface ScrollHelperListener {
        boolean onActionUp(MotionEvent motionEvent);

        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    public ScrollHelper(Context context) {
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(context, this);
        this.d = gestureDetectorCompat;
        gestureDetectorCompat.setIsLongpressEnabled(true);
    }

    public void b(ScrollHelperListener scrollHelperListener) {
        this.c = scrollHelperListener;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        ScrollHelperListener scrollHelperListener = this.c;
        return scrollHelperListener == null || scrollHelperListener.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        ScrollHelperListener scrollHelperListener = this.c;
        return scrollHelperListener != null && scrollHelperListener.onSingleTapUp(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        ScrollHelperListener scrollHelperListener = this.c;
        return scrollHelperListener != null && scrollHelperListener.onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        ScrollHelperListener scrollHelperListener = this.c;
        if (scrollHelperListener != null) {
            scrollHelperListener.onLongPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        ScrollHelperListener scrollHelperListener = this.c;
        return scrollHelperListener == null || scrollHelperListener.onFling(motionEvent, motionEvent2, f, f2);
    }

    public boolean cRz_(MotionEvent motionEvent) {
        ScrollHelperListener scrollHelperListener;
        if (motionEvent.getAction() == 1 && (scrollHelperListener = this.c) != null) {
            scrollHelperListener.onActionUp(motionEvent);
        }
        return this.d.onTouchEvent(motionEvent);
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Scroller f9319a;
        private final View c;
        private int d;
        private int e;

        c(View view) {
            this.c = view;
            this.f9319a = new Scroller(view.getContext());
        }

        void e(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f9319a.fling(i, i2, i3, i4, 0, i5, 0, i6);
            this.e = i;
            this.d = i2;
            this.c.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9319a.isFinished()) {
                return;
            }
            try {
                boolean zComputeScrollOffset = this.f9319a.computeScrollOffset();
                int currX = this.f9319a.getCurrX();
                int currY = this.f9319a.getCurrY();
                int i = this.e - currX;
                int i2 = this.d - currY;
                if (i != 0 || i2 != 0) {
                    this.c.scrollBy(i, i2);
                    this.e = currX;
                    this.d = currY;
                }
                if (zComputeScrollOffset) {
                    this.c.post(this);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                ReleaseLogUtil.a("R_ScrollHelper", "Scroller ArrayIndexOutOfBoundsException:", ExceptionUtils.a(e));
                this.f9319a.abortAnimation();
            }
        }

        boolean a() {
            return this.f9319a.isFinished();
        }

        void d() {
            if (this.f9319a.isFinished()) {
                return;
            }
            this.f9319a.forceFinished(true);
        }
    }
}
