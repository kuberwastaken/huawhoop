package defpackage;

import com.huawei.operation.utils.Constants;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: classes9.dex */
public class xo extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f19068a;
    protected final boolean b;
    protected final xb c;
    protected int d;
    protected byte[] e;
    protected char f = 0;
    protected final boolean g;
    protected int h;
    protected int i;
    protected InputStream j;
    protected char[] k;

    public xo(xb xbVar, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        this.c = xbVar;
        this.j = inputStream;
        this.e = bArr;
        this.h = i;
        this.i = i2;
        this.b = z;
        this.g = inputStream != null;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.j;
        if (inputStream != null) {
            this.j = null;
            c();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.k == null) {
            this.k = new char[1];
        }
        if (read(this.k, 0, 1) < 1) {
            return -1;
        }
        return this.k[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ce A[LOOP:0: B:24:0x003d->B:41:0x00ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc A[SYNTHETIC] */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(char[] r11, int r12, int r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xo.read(char[], int, int):int");
    }

    private void a(int i, int i2) throws IOException {
        int i3 = this.d;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + this.f19068a + ", byte #" + (i3 + i) + Constants.RIGHT_BRACKET_ONLY);
    }

    private void c(int i, int i2, String str) throws IOException {
        int i3 = this.d;
        int i4 = this.h;
        int i5 = this.f19068a;
        StringBuilder sb = new StringBuilder("Invalid UTF-32 character 0x");
        sb.append(Integer.toHexString(i));
        sb.append(str);
        sb.append(" at char #");
        sb.append(i5 + i2);
        sb.append(", byte #");
        sb.append((i3 + i4) - 1);
        sb.append(Constants.RIGHT_BRACKET_ONLY);
        throw new CharConversionException(sb.toString());
    }

    private boolean a(int i) throws IOException {
        int i2;
        this.d += this.i - i;
        if (i > 0) {
            int i3 = this.h;
            if (i3 > 0) {
                byte[] bArr = this.e;
                System.arraycopy(bArr, i3, bArr, 0, i);
                this.h = 0;
            }
            this.i = i;
        } else {
            this.h = 0;
            InputStream inputStream = this.j;
            int i4 = inputStream == null ? -1 : inputStream.read(this.e);
            if (i4 < 1) {
                this.i = 0;
                if (i4 < 0) {
                    if (this.g) {
                        c();
                    }
                    return false;
                }
                a();
            }
            this.i = i4;
        }
        while (true) {
            int i5 = this.i;
            if (i5 >= 4) {
                return true;
            }
            InputStream inputStream2 = this.j;
            if (inputStream2 == null) {
                i2 = -1;
            } else {
                byte[] bArr2 = this.e;
                i2 = inputStream2.read(bArr2, i5, bArr2.length - i5);
            }
            if (i2 < 1) {
                if (i2 < 0) {
                    if (this.g) {
                        c();
                    }
                    a(this.i, 4);
                }
                a();
            }
            this.i += i2;
        }
    }

    private void c() {
        byte[] bArr = this.e;
        if (bArr != null) {
            this.e = null;
            this.c.b(bArr);
        }
    }

    private void b(char[] cArr, int i, int i2) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + i2 + "), cbuf[" + cArr.length + "]");
    }

    private void a() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}
