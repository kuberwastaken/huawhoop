package com.huawei.wisesecurity.kfs.crypto;

import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import defpackage.wws;
import defpackage.wwt;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AsymmetricBuilder<T> {
    protected final KeyStoreProvider keyStoreProvider;
    protected AlgorithmParameterSpec parameterSpec;
    protected PrivateKey privateKey;
    protected PublicKey publicKey;

    public abstract T build() throws wwt;

    public AsymmetricBuilder(KeyStoreProvider keyStoreProvider) {
        this.keyStoreProvider = keyStoreProvider;
    }

    public AsymmetricBuilder<T> withKey(Key key) {
        if (key instanceof PrivateKey) {
            this.privateKey = (PrivateKey) key;
        } else if (key instanceof PublicKey) {
            this.publicKey = (PublicKey) key;
        }
        return this;
    }

    public AsymmetricBuilder<T> withPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public AsymmetricBuilder<T> withPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public AsymmetricBuilder<T> withKeyStoreAlias(String str) throws wws {
        try {
            KeyStore keyStore = KeyStore.getInstance(this.keyStoreProvider.getName());
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (!(key instanceof PrivateKey)) {
                throw new wws("bad private key type");
            }
            this.privateKey = (PrivateKey) key;
            this.publicKey = keyStore.getCertificate(str).getPublicKey();
            return this;
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e) {
            throw new wws("keystore get key with alias failed, " + e.getMessage());
        }
    }

    public AsymmetricBuilder<T> withParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
        this.parameterSpec = algorithmParameterSpec;
        return this;
    }
}
