package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes8.dex */
public class HwGenericEventDetector {
    private float g;
    private float h;
    private int j;
    private View l;
    private OnChangePageListener d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnChangeProgressListener f11270a = null;
    private OnScrollListener e = null;
    private float c = -1.0f;
    private float b = -1.0f;
    private float f = 0.0f;
    private float i = 0.0f;
    private float o = 1.0f;

    public interface OnChangePageListener {
        boolean onChangePage(float f, MotionEvent motionEvent);
    }

    public interface OnChangeProgressListener {
        boolean onChangeProgress(int i, int i2, MotionEvent motionEvent);
    }

    /* JADX INFO: loaded from: classes11.dex */
    public interface OnChangeProgressListener2 extends OnChangeProgressListener {
        boolean onBegin();

        boolean onEnd(float f);
    }

    public interface OnScrollListener {
        boolean onScrollBy(float f, float f2, MotionEvent motionEvent);
    }

    /* JADX INFO: loaded from: classes11.dex */
    public interface OnScrollListener2 extends OnScrollListener {
        boolean onBegin();

        boolean onEnd(float f);
    }

    public HwGenericEventDetector(Context context) {
        this.g = 0.0f;
        this.h = 0.0f;
        this.j = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.g = viewConfiguration.getScaledHorizontalScrollFactor();
        this.h = viewConfiguration.getScaledVerticalScrollFactor();
        this.j = viewConfiguration.getScaledTouchSlop();
    }

    private boolean eGi_(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f = this.c;
        float f2 = this.f;
        if (f - f2 > x || x > f + f2) {
            return true;
        }
        float f3 = this.b;
        return f3 - f2 > y || y > f3 + f2;
    }

    public float b() {
        return this.o;
    }

    public void b(OnChangePageListener onChangePageListener) {
        this.d = onChangePageListener;
    }

    public float c() {
        return this.g * this.o;
    }

    public float d() {
        return this.h * this.o;
    }

    public void d(float f) {
        this.o = f;
    }

    public void d(HwRotaryConverter hwRotaryConverter) {
        Log.d("HwGenericEventDetector", "Implement setRotaryConverter in the watch package.");
    }

    public float e() {
        return 0.0f;
    }

    public void e(int i) {
        if (i == 0) {
            this.o = 1.0f;
        } else if (i == 2) {
            this.o = 0.6f;
        } else {
            this.o = 1.0f;
        }
    }

    public void e(OnChangeProgressListener onChangeProgressListener) {
        this.f11270a = onChangeProgressListener;
    }

    public boolean eGj_(MotionEvent motionEvent) {
        if (this.e == null) {
            return false;
        }
        if (Float.compare(this.c, -1.0f) == 0 && Float.compare(this.b, -1.0f) == 0) {
            return false;
        }
        if (!eGi_(motionEvent)) {
            return eGk_(motionEvent);
        }
        this.c = -1.0f;
        this.b = -1.0f;
        return false;
    }

    public boolean eGk_(MotionEvent motionEvent) {
        if (motionEvent.isFromSource(2) && motionEvent.getAction() == 8) {
            float axisValue = motionEvent.getAxisValue(10);
            float axisValue2 = motionEvent.getAxisValue(9);
            if (Float.compare(axisValue, 0.0f) == 0 && Float.compare(axisValue2, 0.0f) == 0) {
                return false;
            }
            float f = Float.compare(axisValue, 0.0f) == 0 ? -axisValue2 : axisValue;
            OnChangePageListener onChangePageListener = this.d;
            if (onChangePageListener != null && onChangePageListener.onChangePage(f, motionEvent)) {
                return true;
            }
            OnChangeProgressListener onChangeProgressListener = this.f11270a;
            if (onChangeProgressListener != null && onChangeProgressListener.onChangeProgress((int) (-axisValue), (int) axisValue2, motionEvent)) {
                return true;
            }
            if (this.e != null) {
                if (this.e.onScrollBy(Math.round(axisValue * c()), Math.round((-axisValue2) * d()), motionEvent)) {
                    if (this.c < 0.0f || this.b < 0.0f) {
                        this.c = motionEvent.getX();
                        this.b = motionEvent.getY();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void eGl_(View view, OnScrollListener onScrollListener) {
        this.e = onScrollListener;
        this.l = view;
    }
}
