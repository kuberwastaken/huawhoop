package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public class HwRotaryEventTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MotionEvent f11272a;
    private View b;
    private MotionEvent e;
    private long c = -1;
    private a d = new a();
    private float g = 0.0f;

    public interface OnRotaryListener {
        boolean onBeginScroll(MotionEvent motionEvent);

        boolean onEndScroll(MotionEvent motionEvent);

        boolean onMiddleScroll(MotionEvent motionEvent);
    }

    class a implements Runnable {
        private OnRotaryListener b;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            HwRotaryEventTracker.this.eGs_(null, this.b);
        }
    }

    public HwRotaryEventTracker(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eGs_(MotionEvent motionEvent, OnRotaryListener onRotaryListener) throws Throwable {
        Throwable th;
        MotionEvent motionEvent2;
        this.c = -1L;
        this.b.removeCallbacks(this.d);
        try {
            if (motionEvent != null) {
                boolean zOnEndScroll = onRotaryListener.onEndScroll(motionEvent);
                MotionEvent motionEvent3 = this.f11272a;
                if (motionEvent3 != null) {
                    motionEvent3.recycle();
                    this.f11272a = null;
                }
                MotionEvent motionEvent4 = this.e;
                if (motionEvent4 != null) {
                    motionEvent4.recycle();
                    this.e = null;
                }
                return zOnEndScroll;
            }
            motionEvent2 = this.f11272a;
            float f = 0.0f;
            try {
                if (motionEvent2 != null && this.e != null) {
                    float axisValue = motionEvent2.getAxisValue(26);
                    float axisValue2 = this.e.getAxisValue(26);
                    float eventTime = this.f11272a.getEventTime();
                    float eventTime2 = this.e.getEventTime();
                    float f2 = (axisValue * axisValue2 < 0.0f || Float.compare(eventTime, eventTime2) >= 0) ? 0.0f : (((axisValue2 - axisValue) / (eventTime2 - eventTime)) * 50.0f) + axisValue2;
                    if (axisValue2 * f2 >= 0.0f) {
                        f = f2;
                    }
                    MotionEvent motionEventEGq_ = eGq_(f);
                    boolean zOnEndScroll2 = onRotaryListener.onEndScroll(motionEventEGq_);
                    MotionEvent motionEvent5 = this.f11272a;
                    if (motionEvent5 != null) {
                        motionEvent5.recycle();
                        this.f11272a = null;
                    }
                    MotionEvent motionEvent6 = this.e;
                    if (motionEvent6 != null) {
                        motionEvent6.recycle();
                        this.e = null;
                    }
                    if (motionEventEGq_ != null) {
                        motionEventEGq_.recycle();
                    }
                    return zOnEndScroll2;
                }
                if (motionEvent2 != null || this.e == null) {
                    Log.e("HwRotaryEventTracker", "onEnd: event is null");
                    MotionEvent motionEvent7 = this.f11272a;
                    if (motionEvent7 != null) {
                        motionEvent7.recycle();
                        this.f11272a = null;
                    }
                    MotionEvent motionEvent8 = this.e;
                    if (motionEvent8 == null) {
                        return false;
                    }
                    motionEvent8.recycle();
                    this.e = null;
                    return false;
                }
                MotionEvent motionEventEGq_2 = eGq_(0.0f);
                boolean zOnEndScroll3 = onRotaryListener.onEndScroll(motionEventEGq_2);
                MotionEvent motionEvent9 = this.f11272a;
                if (motionEvent9 != null) {
                    motionEvent9.recycle();
                    this.f11272a = null;
                }
                MotionEvent motionEvent10 = this.e;
                if (motionEvent10 != null) {
                    motionEvent10.recycle();
                    this.e = null;
                }
                if (motionEventEGq_2 != null) {
                    motionEventEGq_2.recycle();
                }
                return zOnEndScroll3;
            } catch (Throwable th2) {
                th = th2;
                MotionEvent motionEvent11 = this.f11272a;
                if (motionEvent11 != null) {
                    motionEvent11.recycle();
                    this.f11272a = null;
                }
                MotionEvent motionEvent12 = this.e;
                if (motionEvent12 != null) {
                    motionEvent12.recycle();
                    this.e = null;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            motionEvent2 = null;
        }
    }

    private MotionEvent eGq_(float f) {
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = 0.0f;
        pointerCoords.y = 0.0f;
        pointerCoords.setAxisValue(26, f);
        MotionEvent.PointerCoords[] pointerCoordsArr = {pointerCoords};
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = 0;
        long jUptimeMillis = SystemClock.uptimeMillis();
        return MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 8, 1, new MotionEvent.PointerProperties[]{pointerProperties}, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, 4194304, 0);
    }
}
