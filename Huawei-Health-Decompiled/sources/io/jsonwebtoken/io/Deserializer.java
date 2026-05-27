package io.jsonwebtoken.io;

import defpackage.xff;
import java.io.Reader;

/* JADX INFO: loaded from: classes11.dex */
public interface Deserializer<T> {
    T deserialize(Reader reader) throws xff;

    @Deprecated
    T deserialize(byte[] bArr) throws xff;
}
