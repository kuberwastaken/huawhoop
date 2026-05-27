package com.huawei.uikit.hwdotspageindicator.widget;

/* JADX INFO: loaded from: classes8.dex */
public class HwDotsPageIndicatorInteractor {

    public interface OnClickListener {
        void onClick(int i, int i2);
    }

    public interface OnGestureListener {
        void onDragging(float f, int i, int i2);

        void onLongPress(int i);

        void onOverDrag(float f);
    }

    public interface OnMouseOperationListener {
        void onDotClick(int i, int i2);

        void onFocusAnimationProgress(float f);

        void onMoveInHotZone(int i);
    }
}
