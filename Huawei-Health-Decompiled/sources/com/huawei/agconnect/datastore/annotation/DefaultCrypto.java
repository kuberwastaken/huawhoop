package com.huawei.agconnect.datastore.annotation;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultCrypto implements ICrypto {
    @Override // com.huawei.agconnect.datastore.annotation.ICrypto, com.huawei.agconnect.common.datastore.ICrypto
    public String decrypt(String str) {
        return str;
    }

    @Override // com.huawei.agconnect.datastore.annotation.ICrypto, com.huawei.agconnect.common.datastore.ICrypto
    public String encrypt(String str) {
        return str;
    }
}
