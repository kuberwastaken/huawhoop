package com.huawei.wisesecurity.kfs.crypto.cipher;

import defpackage.wwt;

/* JADX INFO: loaded from: classes8.dex */
public interface DecryptHandler {
    DecryptHandler from(byte[] bArr) throws wwt;

    DecryptHandler fromBase64(String str) throws wwt;

    DecryptHandler fromBase64Url(String str) throws wwt;

    DecryptHandler fromHex(String str) throws wwt;

    byte[] to() throws wwt;

    String toBase64() throws wwt;

    String toHex() throws wwt;

    String toRawString() throws wwt;
}
