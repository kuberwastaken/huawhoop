package com.huawei.wisesecurity.ucs.credential.crypto.signer;

import defpackage.wwv;
import defpackage.wzb;
import defpackage.wzf;

/* JADX INFO: loaded from: classes8.dex */
public class CredentialSignText {
    private CredentialSignAlg algId;
    private byte[] dataBytes;
    private byte[] signature;

    public void setSignature(byte[] bArr) {
        this.signature = wwv.d(bArr);
    }

    public void setDataBytes(byte[] bArr) {
        this.dataBytes = wwv.d(bArr);
    }

    public void setAlgId(CredentialSignAlg credentialSignAlg) {
        this.algId = credentialSignAlg;
    }

    public byte[] getSignature() {
        return wwv.d(this.signature);
    }

    public byte[] getDataBytes() {
        return wwv.d(this.dataBytes);
    }

    public int getAlgId() {
        return this.algId.getId();
    }

    public void checkParam(boolean z) throws wzb {
        byte[] bArr = this.dataBytes;
        if (bArr == null || bArr.length == 0) {
            throw new wzf("dataBytes data can not be empty..");
        }
        if (z) {
            return;
        }
        byte[] bArr2 = this.signature;
        if (bArr2 == null || bArr2.length == 0) {
            throw new wzf("signature data can not be empty..");
        }
    }
}
