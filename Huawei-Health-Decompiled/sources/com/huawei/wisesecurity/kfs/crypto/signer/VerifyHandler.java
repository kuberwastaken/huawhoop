package com.huawei.wisesecurity.kfs.crypto.signer;

import defpackage.wwt;

/* JADX INFO: loaded from: classes8.dex */
public interface VerifyHandler {
    VerifyHandler fromBase64Data(String str) throws wwt;

    VerifyHandler fromBase64UrlData(String str) throws wwt;

    VerifyHandler fromData(String str) throws wwt;

    VerifyHandler fromData(byte[] bArr) throws wwt;

    VerifyHandler fromHexData(String str) throws wwt;

    boolean verify(String str) throws wwt;

    boolean verify(byte[] bArr) throws wwt;

    boolean verifyBase64(String str) throws wwt;

    boolean verifyBase64Url(String str) throws wwt;

    boolean verifyHex(String str) throws wwt;
}
