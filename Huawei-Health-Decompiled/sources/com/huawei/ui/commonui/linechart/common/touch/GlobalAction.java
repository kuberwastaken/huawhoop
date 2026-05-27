package com.huawei.ui.commonui.linechart.common.touch;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes7.dex */
public interface GlobalAction {
    boolean handleActionCancel(MotionEvent motionEvent);

    boolean handleActionDown(MotionEvent motionEvent);

    boolean handleActionMove(MotionEvent motionEvent);

    boolean inMode();

    boolean isModeInterceptMove(MotionEvent motionEvent);

    void reset();
}
