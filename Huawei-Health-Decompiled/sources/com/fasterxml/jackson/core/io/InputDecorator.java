package com.fasterxml.jackson.core.io;

import defpackage.xb;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public abstract class InputDecorator implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract InputStream decorate(xb xbVar, InputStream inputStream) throws IOException;

    public abstract InputStream decorate(xb xbVar, byte[] bArr, int i, int i2) throws IOException;

    public abstract Reader decorate(xb xbVar, Reader reader) throws IOException;

    public DataInput decorate(xb xbVar, DataInput dataInput) throws IOException {
        throw new UnsupportedOperationException();
    }
}
