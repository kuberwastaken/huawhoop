package com.huawei.hmf.orb.bridge;

import com.huawei.hmf.orb.Releasable;
import com.huawei.hmf.taskstream.Disposable;

/* JADX INFO: loaded from: classes10.dex */
public class ReleasableDisposable implements Releasable, Disposable {
    private final Disposable mDisposable;

    public ReleasableDisposable(Disposable disposable) {
        this.mDisposable = disposable;
    }

    @Override // com.huawei.hmf.orb.Releasable
    public void release() {
        dispose();
    }

    @Override // com.huawei.hmf.taskstream.Disposable
    public void dispose() {
        this.mDisposable.dispose();
    }
}
