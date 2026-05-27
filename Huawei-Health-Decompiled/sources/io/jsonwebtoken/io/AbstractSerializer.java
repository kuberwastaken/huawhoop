package io.jsonwebtoken.io;

import defpackage.xfh;
import defpackage.xfp;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AbstractSerializer<T> implements Serializer<T> {
    protected abstract void doSerialize(T t, OutputStream outputStream) throws Exception;

    @Override // io.jsonwebtoken.io.Serializer
    public final byte[] serialize(T t) throws xfh {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serialize(t, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // io.jsonwebtoken.io.Serializer
    public final void serialize(T t, OutputStream outputStream) throws xfh {
        try {
            doSerialize(t, outputStream);
        } catch (Throwable th) {
            if (th instanceof xfh) {
                throw th;
            }
            throw new xfh("Unable to serialize object of type " + xfp.d(t) + ": " + th.getMessage(), th);
        }
    }
}
