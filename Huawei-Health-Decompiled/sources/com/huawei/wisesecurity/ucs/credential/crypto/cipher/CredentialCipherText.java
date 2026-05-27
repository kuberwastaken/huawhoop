package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import defpackage.wwv;
import defpackage.wzf;

/* JADX INFO: loaded from: classes11.dex */
public class CredentialCipherText {
    private CredentialCipherAlg algId;
    private byte[] cipherBytes;
    private byte[] iv;
    private byte[] plainBytes;

    public void setPlainBytes(byte[] bArr) {
        this.plainBytes = wwv.d(bArr);
    }

    public void setIv(byte[] bArr) {
        this.iv = wwv.d(bArr);
    }

    public void setCipherBytes(byte[] bArr) {
        this.cipherBytes = wwv.d(bArr);
    }

    public void setAlgId(CredentialCipherAlg credentialCipherAlg) {
        this.algId = credentialCipherAlg;
    }

    public byte[] getPlainBytes() {
        return wwv.d(this.plainBytes);
    }

    public byte[] getIv() {
        return wwv.d(this.iv);
    }

    public byte[] getCipherBytes() {
        return wwv.d(this.cipherBytes);
    }

    public int getAlgId() {
        return this.algId.getId();
    }

    public void checkParam(boolean z) throws wzf {
        byte[] bArr = this.iv;
        if (bArr == null || (this.algId == CredentialCipherAlg.AES_GCM && bArr.length != 12)) {
            throw new wzf("illegal iv param..");
        }
        if (z) {
            byte[] bArr2 = this.plainBytes;
            if (bArr2 == null || bArr2.length == 0) {
                throw new wzf("plainBytes data can not be empty..");
            }
            return;
        }
        byte[] bArr3 = this.cipherBytes;
        if (bArr3 == null || bArr3.length == 0) {
            throw new wzf("cipherBytes data can not be empty..");
        }
    }
}
