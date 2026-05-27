package com.huawei.agconnect.core.impl;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class AGCInitFinishManagerImpl extends AGCInitFinishManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> f1800a = new CopyOnWriteArrayList();

    @Override // com.huawei.agconnect.AGCInitFinishManager
    public void addAGCInitFinishCallback(AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback) {
        if (aGCInitFinishCallback != null) {
            f1800a.add(aGCInitFinishCallback);
        }
    }

    public static void a() {
        Iterator<AGCInitFinishManager.AGCInitFinishCallback> it = f1800a.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }
}
