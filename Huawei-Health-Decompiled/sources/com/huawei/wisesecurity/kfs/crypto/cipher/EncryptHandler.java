package com.huawei.wisesecurity.kfs.crypto.cipher;

import defpackage.wwt;

/* JADX INFO: loaded from: classes8.dex */
public interface EncryptHandler {
    EncryptHandler from(String str) throws wwt;

    EncryptHandler from(byte[] bArr) throws wwt;

    EncryptHandler fromBase64(String str) throws wwt;

    EncryptHandler fromBase64Url(String str) throws wwt;

    EncryptHandler fromHex(String str) throws wwt;

    byte[] to() throws wwt;

    String toBase64() throws wwt;

    String toBase64Url() throws wwt;

    String toHex() throws wwt;
}
