package com.huawei.wisesecurity.kfs.crypto.digest;

import defpackage.wwt;

/* JADX INFO: loaded from: classes11.dex */
public interface DigestHandler {
    byte[] digest() throws wwt;

    String digestBase64() throws wwt;

    String digestBase64Url() throws wwt;

    String digestHex() throws wwt;

    DigestHandler from(String str) throws wwt;

    DigestHandler from(byte[] bArr) throws wwt;

    DigestHandler fromBase64(String str) throws wwt;

    DigestHandler fromBase64Url(String str) throws wwt;

    DigestHandler fromHex(String str) throws wwt;
}
