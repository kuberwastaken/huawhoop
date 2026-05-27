package com.huawei.uikit.hwrecyclerview.layoutmanager;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes8.dex */
public class HwFloatingBubbleLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Region f11183a;
    private boolean b;
    private int c;
    private Path d;
    private int e;
    private float f;
    private OnSelectedListener i;

    public interface OnSelectedListener {
        void onSelectedChanged(ViewGroup viewGroup, boolean z);
    }

    public HwFloatingBubbleLayout(Context context) {
        super(context);
        this.b = false;
        this.d = new Path();
        this.f = 1.0f;
        b();
    }

    private void b() {
        this.f = (new SecureRandom().nextInt(10) / 100.0f) + 0.9f;
    }

    private void c() {
        this.f11183a = new Region();
        this.d.reset();
        float f = this.e / 2.0f;
        this.d.addCircle(f, this.c / 2.0f, f, Path.Direction.CW);
        this.f11183a.setPath(this.d, new Region(0, 0, this.e, this.c));
    }

    public OnSelectedListener getOnSelectedListener() {
        return this.i;
    }

    public float getRandomFactor() {
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        eCv_(getParent());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = i;
        this.c = i2;
        c();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.f11183a.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.i = onSelectedListener;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z != this.b) {
            OnSelectedListener onSelectedListener = this.i;
            if (onSelectedListener != null) {
                onSelectedListener.onSelectedChanged(this, z);
            }
            this.b = z;
        }
    }

    private void eCv_(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    public HwFloatingBubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.d = new Path();
        this.f = 1.0f;
        b();
    }

    public HwFloatingBubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.d = new Path();
        this.f = 1.0f;
        b();
    }
}
