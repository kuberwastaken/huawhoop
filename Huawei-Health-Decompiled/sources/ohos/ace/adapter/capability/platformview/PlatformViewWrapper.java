package ohos.ace.adapter.capability.platformview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class PlatformViewWrapper extends FrameLayout {
    private static final String LOG_TAG = "PlatformViewWrapper";
    private int bufferHeight;
    private int bufferWidth;
    private Context context;
    private int left;
    private Surface surface;
    private int top;

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public PlatformViewWrapper(Context context) {
        super(context);
        this.bufferWidth = 0;
        this.bufferHeight = 0;
        setWillNotDraw(false);
        this.surface = null;
        this.context = context;
    }

    public void displayPlatformView() {
        FrameLayout.LayoutParams layoutParamsBuildLayoutParams = buildLayoutParams(this.left, this.top, this.bufferWidth, this.bufferHeight);
        setLayoutParams(layoutParamsBuildLayoutParams);
        Activity activity = (Activity) this.context;
        setZ(-1.0f);
        activity.addContentView(this, layoutParamsBuildLayoutParams);
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public void setLayoutparams(FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.left = layoutParams.leftMargin;
        this.top = layoutParams.topMargin;
    }

    public void resize(int i, int i2) {
        this.bufferWidth = i;
        this.bufferHeight = i2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Surface surface = this.surface;
        if (surface == null) {
            super.draw(canvas);
            ALog.e(LOG_TAG, "PlatformView cannot be composed without a Render.");
            return;
        }
        Canvas canvasLockHardwareCanvas = surface.lockHardwareCanvas();
        if (canvasLockHardwareCanvas == null) {
            invalidate();
            return;
        }
        try {
            canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(canvasLockHardwareCanvas);
        } finally {
            this.surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
        }
    }

    private FrameLayout.LayoutParams buildLayoutParams(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, i3, i4);
        return layoutParams;
    }
}
