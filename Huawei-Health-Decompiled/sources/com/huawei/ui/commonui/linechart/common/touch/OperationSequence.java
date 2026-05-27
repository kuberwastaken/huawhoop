package com.huawei.ui.commonui.linechart.common.touch;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes7.dex */
public interface OperationSequence {
    boolean canSeqStart(MotionEvent motionEvent);

    boolean isSeqInterrupted();

    void onTouchEvent(MotionEvent motionEvent);

    void prepare();

    void release();
}
