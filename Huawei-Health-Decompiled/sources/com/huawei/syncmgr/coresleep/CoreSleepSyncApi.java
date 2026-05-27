package com.huawei.syncmgr.coresleep;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.syncmgr.SyncOption;

/* JADX INFO: loaded from: classes7.dex */
public interface CoreSleepSyncApi {
    boolean isSyncing();

    void registerProgressListener(IBaseResponseCallback iBaseResponseCallback);

    void startSynCoreSleep(SyncOption syncOption, IBaseResponseCallback iBaseResponseCallback);
}
