package com.huawei.hihealthservice.sync.syncdata;

import defpackage.kgm;

/* JADX INFO: loaded from: classes9.dex */
public interface HiSyncBase {
    void pullDataByTime(long j, long j2) throws kgm;

    void pullDataByVersion() throws kgm;

    void pushData() throws kgm;
}
