package com.huawei.skinner.internal;

import defpackage.oua;

/* JADX INFO: loaded from: classes7.dex */
public interface ISkinnableViewManager {
    oua addSkinnableView(oua ouaVar);

    void applySkin();

    void clean();

    oua removeSkinnableView(oua ouaVar);
}
