package com.huawei.wisesecurity.kfs.crypto.cipher;

import defpackage.wwt;

/* JADX INFO: loaded from: classes8.dex */
public interface KfsCipher {
    DecryptHandler getDecryptHandler() throws wwt;

    EncryptHandler getEncryptHandler() throws wwt;
}
