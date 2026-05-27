package com.fasterxml.jackson.core.io;

import defpackage.xb;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: classes9.dex */
public abstract class OutputDecorator implements Serializable {
    public abstract OutputStream decorate(xb xbVar, OutputStream outputStream) throws IOException;

    public abstract Writer decorate(xb xbVar, Writer writer) throws IOException;
}
