package io.jsonwebtoken;

import defpackage.xev;
import io.jsonwebtoken.io.CompressionAlgorithm;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated
public interface CompressionCodec extends CompressionAlgorithm {
    @Deprecated
    byte[] compress(byte[] bArr) throws xev;

    @Deprecated
    byte[] decompress(byte[] bArr) throws xev;

    @Deprecated
    String getAlgorithmName();
}
