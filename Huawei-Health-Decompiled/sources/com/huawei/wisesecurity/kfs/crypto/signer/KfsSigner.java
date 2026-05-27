package com.huawei.wisesecurity.kfs.crypto.signer;

import defpackage.wwt;

/* JADX INFO: loaded from: classes8.dex */
public interface KfsSigner {
    SignHandler getSignHandler() throws wwt;

    VerifyHandler getVerifyHandler() throws wwt;
}
