package com.huawei.wisesecurity.kfs.crypto.key;

import defpackage.wwh;
import defpackage.wws;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes8.dex */
public interface KfsKeyManager {
    void generate(wwh wwhVar) throws wws;

    Certificate[] getCertificateChain(String str) throws wws;

    Key getKey(String str) throws wws;

    PrivateKey getPrivateKey(String str) throws wws;

    PublicKey getPublicKey(String str) throws wws;

    boolean hasAlias(String str) throws wws;
}
