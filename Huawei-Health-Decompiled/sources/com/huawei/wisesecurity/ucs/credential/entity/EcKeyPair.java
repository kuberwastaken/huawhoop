package com.huawei.wisesecurity.ucs.credential.entity;

import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import defpackage.www;
import defpackage.wxe;
import defpackage.wzb;
import defpackage.wzf;
import defpackage.wzk;

/* JADX INFO: loaded from: classes8.dex */
public class EcKeyPair {
    public byte[] privateKey;
    public byte[] publicKey;

    public static final class Builder {

        @KfsNotNull
        private byte[] privateKey;

        @KfsNotNull
        private byte[] publicKey;

        public Builder publicKey(byte[] bArr) {
            this.publicKey = bArr;
            return this;
        }

        public Builder privateKey(byte[] bArr) {
            this.privateKey = bArr;
            return this;
        }

        public EcKeyPair build() throws wzb {
            try {
                wxe.c(this);
                return new EcKeyPair(this);
            } catch (www e) {
                StringBuilder sbB = wzk.b("EcKeyPair build check param error : ");
                sbB.append(e.getMessage());
                throw new wzf(sbB.toString());
            }
        }

        private Builder() {
        }
    }

    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public byte[] getPrivateKey() {
        return this.privateKey;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private EcKeyPair(Builder builder) {
        this.publicKey = builder.publicKey;
        this.privateKey = builder.privateKey;
    }
}
