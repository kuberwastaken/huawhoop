package com.huawei.ui.commonui.linechart.common;

import defpackage.pgb;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface IHwHealthDataRender {
    void disableFocusArea();

    void focusArea(List<pgb> list);

    boolean hasData();

    boolean isUsePaintAsBackground();

    void usePaintAsBackground(boolean z);
}
