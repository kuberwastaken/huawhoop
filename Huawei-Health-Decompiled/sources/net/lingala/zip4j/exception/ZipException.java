package net.lingala.zip4j.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public class ZipException extends IOException {
    private static final long serialVersionUID = 1;
    private Type e;

    public enum Type {
        WRONG_PASSWORD,
        TASK_CANCELLED_EXCEPTION,
        CHECKSUM_MISMATCH,
        UNKNOWN_COMPRESSION_METHOD,
        FILE_NOT_FOUND,
        UNSUPPORTED_ENCRYPTION,
        UNKNOWN
    }

    public ZipException(String str) {
        super(str);
        this.e = Type.UNKNOWN;
    }

    public ZipException(Exception exc) {
        super(exc);
        this.e = Type.UNKNOWN;
    }

    public ZipException(String str, Exception exc) {
        super(str, exc);
        this.e = Type.UNKNOWN;
    }

    public ZipException(String str, Type type) {
        super(str);
        Type type2 = Type.UNKNOWN;
        this.e = type;
    }

    public ZipException(String str, Throwable th, Type type) {
        super(str, th);
        Type type2 = Type.UNKNOWN;
        this.e = type;
    }
}
