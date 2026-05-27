package com.huawei.wisesecurity.ucs.credential.crypto.signer;

/* JADX INFO: loaded from: classes8.dex */
public enum CredentialSignAlg {
    HMAC_SHA256(0);

    private int id;

    public int getId() {
        return this.id;
    }

    CredentialSignAlg(int i) {
        this.id = i;
    }
}
