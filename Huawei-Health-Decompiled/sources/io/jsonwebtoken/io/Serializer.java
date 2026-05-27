package io.jsonwebtoken.io;

import defpackage.xfh;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes11.dex */
public interface Serializer<T> {
    void serialize(T t, OutputStream outputStream) throws xfh;

    @Deprecated
    byte[] serialize(T t) throws xfh;
}
