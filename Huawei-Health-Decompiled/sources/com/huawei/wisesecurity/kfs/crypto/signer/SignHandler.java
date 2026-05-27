package com.huawei.wisesecurity.kfs.crypto.signer;

import defpackage.wwt;

/* JADX INFO: loaded from: classes8.dex */
public interface SignHandler {
    SignHandler from(String str) throws wwt;

    SignHandler from(byte[] bArr) throws wwt;

    SignHandler fromBase64(String str) throws wwt;

    SignHandler fromBase64Url(String str) throws wwt;

    SignHandler fromHex(String str) throws wwt;

    byte[] sign() throws wwt;

    String signBase64() throws wwt;

    String signBase64Url() throws wwt;

    String signHex() throws wwt;
}
