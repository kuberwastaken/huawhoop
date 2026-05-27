package io.jsonwebtoken.io;

import defpackage.xff;
import defpackage.xfn;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AbstractDeserializer<T> implements Deserializer<T> {
    private static final byte[] EMPTY_BYTES = new byte[0];
    protected static final int EOF = -1;

    protected abstract T doDeserialize(Reader reader) throws Exception;

    @Override // io.jsonwebtoken.io.Deserializer
    public final T deserialize(byte[] bArr) throws xff {
        if (bArr == null) {
            bArr = EMPTY_BYTES;
        }
        return deserialize(new InputStreamReader(new ByteArrayInputStream(bArr), StandardCharsets.UTF_8));
    }

    @Override // io.jsonwebtoken.io.Deserializer
    public final T deserialize(Reader reader) throws xff {
        xfn.e(reader, "Reader argument cannot be null.");
        try {
            return doDeserialize(reader);
        } catch (Throwable th) {
            if (th instanceof xff) {
                throw th;
            }
            throw new xff("Unable to deserialize: " + th.getMessage(), th);
        }
    }
}
