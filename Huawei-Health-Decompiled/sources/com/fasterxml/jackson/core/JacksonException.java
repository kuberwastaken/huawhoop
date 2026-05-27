package com.fasterxml.jackson.core;

import defpackage.ws;
import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public abstract class JacksonException extends IOException {
    private static final long serialVersionUID = 123;

    public abstract ws getLocation();

    public abstract String getOriginalMessage();

    public abstract Object getProcessor();

    public JacksonException(String str) {
        super(str);
    }

    protected JacksonException(Throwable th) {
        super(th);
    }

    public JacksonException(String str, Throwable th) {
        super(str, th);
    }
}
