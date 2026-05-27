package com.huawei.phoneservice.feedback.media.impl.wiget.pictureview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes11.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VelocityTracker f8555a;
    private final float c;
    private final ScaleGestureDetector d;
    private boolean f;
    private float g;
    private final float h;
    private final c i;
    private float j;
    private int b = -1;
    private int e = 0;

    public boolean c(MotionEvent motionEvent) {
        try {
            this.d.onTouchEvent(motionEvent);
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public boolean b() {
        return this.d.isInProgress();
    }

    public boolean e() {
        return this.f;
    }

    private void cky_(MotionEvent motionEvent) {
        this.b = -1;
        if (this.f && this.f8555a != null) {
            this.j = a(motionEvent);
            this.g = cku_(motionEvent);
            this.f8555a.addMovement(motionEvent);
            this.f8555a.computeCurrentVelocity(1000);
            float xVelocity = this.f8555a.getXVelocity();
            float yVelocity = this.f8555a.getYVelocity();
            if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.h) {
                this.i.a(this.j, this.g, -xVelocity, -yVelocity);
            }
        }
        VelocityTracker velocityTracker = this.f8555a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f8555a = null;
        }
    }

    private void ckx_(MotionEvent motionEvent) {
        int iE = m.e(motionEvent.getAction());
        if (motionEvent.getPointerId(iE) == this.b) {
            int i = iE == 0 ? 1 : 0;
            this.b = motionEvent.getPointerId(i);
            this.j = motionEvent.getX(i);
            this.g = motionEvent.getY(i);
        }
    }

    private void ckw_(MotionEvent motionEvent) {
        float fA = a(motionEvent);
        float fCku_ = cku_(motionEvent);
        float f = fA - this.j;
        float f2 = fCku_ - this.g;
        if (!this.f) {
            this.f = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.c);
        }
        if (this.f) {
            this.i.a(f, f2);
            this.j = fA;
            this.g = fCku_;
            VelocityTracker velocityTracker = this.f8555a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }
    }

    private void ckv_(MotionEvent motionEvent) {
        this.b = motionEvent.getPointerId(0);
        VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
        this.f8555a = velocityTrackerObtain;
        if (velocityTrackerObtain != null) {
            velocityTrackerObtain.addMovement(motionEvent);
        }
        this.j = a(motionEvent);
        this.g = cku_(motionEvent);
        this.f = false;
    }

    private boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            ckv_(motionEvent);
        } else if (action == 1) {
            cky_(motionEvent);
        } else if (action == 2) {
            ckw_(motionEvent);
        } else if (action == 3) {
            d();
        } else if (action != 6) {
            com.huawei.phoneservice.faq.base.util.h.e("GestureDetector", "processTouchEvent default!!!");
        } else {
            ckx_(motionEvent);
        }
        int i = this.b;
        if (i == -1) {
            i = 0;
        }
        this.e = motionEvent.findPointerIndex(i);
        return true;
    }

    private void d() {
        this.b = -1;
        VelocityTracker velocityTracker = this.f8555a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f8555a = null;
        }
    }

    class e implements ScaleGestureDetector.OnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f8556a;
        private float e = 0.0f;

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f8556a = scaleGestureDetector.getFocusX();
            this.e = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            b.this.i.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getFocusX() - this.f8556a, scaleGestureDetector.getFocusY() - this.e);
            this.f8556a = scaleGestureDetector.getFocusX();
            this.e = scaleGestureDetector.getFocusY();
            return true;
        }

        e() {
        }
    }

    private float cku_(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.e);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.e);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.h = viewConfiguration.getScaledMinimumFlingVelocity();
        this.c = viewConfiguration.getScaledTouchSlop();
        this.i = cVar;
        this.d = new ScaleGestureDetector(context, new e());
    }
}
