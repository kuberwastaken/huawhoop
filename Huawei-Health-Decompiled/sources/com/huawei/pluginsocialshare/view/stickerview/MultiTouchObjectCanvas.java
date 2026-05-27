package com.huawei.pluginsocialshare.view.stickerview;

import defpackage.olh;
import defpackage.oli;

/* JADX INFO: loaded from: classes7.dex */
public interface MultiTouchObjectCanvas<T> {
    void canvasTouched(olh olhVar);

    void deselectAll();

    T getDraggableObjectAtPoint(olh olhVar);

    void getPositionAndScale(T t, oli oliVar);

    boolean pointInObjectGrabArea(olh olhVar, T t);

    void selectObject(T t, olh olhVar);

    boolean setPositionAndScale(T t, oli oliVar, olh olhVar);
}
