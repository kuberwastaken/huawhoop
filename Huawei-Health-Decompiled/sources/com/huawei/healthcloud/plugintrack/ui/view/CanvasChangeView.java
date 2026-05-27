package com.huawei.healthcloud.plugintrack.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes5.dex */
public class CanvasChangeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f3906a;
    private Canvas c;

    public CanvasChangeView(Context context) {
        super(context);
        this.f3906a = new Object();
        b();
    }

    public CanvasChangeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3906a = new Object();
        b();
    }

    private void b() {
        setWillNotDraw(false);
        e();
    }

    private void e() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: iug
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    return this.b.a();
                }
            });
        }
    }

    public /* synthetic */ boolean a() {
        if (!isDirty()) {
            return true;
        }
        invalidate();
        return true;
    }

    public void setCanvas(Canvas canvas) {
        synchronized (this.f3906a) {
            this.c = canvas;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        synchronized (this.f3906a) {
            Canvas canvas2 = this.c;
            if (canvas2 != null) {
                super.dispatchDraw(canvas2);
            } else {
                super.dispatchDraw(canvas);
            }
        }
    }
}
