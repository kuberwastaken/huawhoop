package com.huawei.hwencryptmodel.rsa;

import health.compact.a.EncoderException;

/* JADX INFO: loaded from: classes.dex */
public interface BinaryEncoder extends Encoder {
    byte[] encode(byte[] bArr) throws EncoderException;
}
