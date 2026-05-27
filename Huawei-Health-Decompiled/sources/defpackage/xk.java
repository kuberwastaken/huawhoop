package defpackage;

import java.io.Writer;

/* JADX INFO: loaded from: classes9.dex */
public final class xk extends Writer {
    private final yk d;

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public xk(yd ydVar) {
        this.d = new yk(ydVar);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        String string = charSequence.toString();
        this.d.c(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        String string = charSequence.subSequence(i, i2).toString();
        this.d.c(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this.d.c(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        this.d.c(cArr, i, i2);
    }

    @Override // java.io.Writer
    public void write(int i) {
        this.d.a((char) i);
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.d.c(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        this.d.c(str, i, i2);
    }

    public String a() {
        String strB = this.d.b();
        this.d.l();
        return strB;
    }
}
