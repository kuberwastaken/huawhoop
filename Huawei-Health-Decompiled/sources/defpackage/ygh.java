package defpackage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes8.dex */
public class ygh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected byte f19295a;
    protected final InputStream c;
    protected int d;

    protected static class a extends ByteArrayInputStream {
        protected a(byte[] bArr) {
            super(bArr);
        }

        protected a(byte[] bArr, int i, int i2) {
            super(bArr, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a d(int i) {
            int i2 = this.pos;
            long j = i;
            long jSkip = skip(j);
            if (jSkip < j) {
                throw new IllegalArgumentException("requested " + i + " bytes exceeds available " + jSkip + " bytes.");
            }
            return new a(this.buf, i2, i);
        }
    }

    public ygh(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("byte stream must not be null!");
        }
        this.c = inputStream;
        this.f19295a = (byte) 0;
        this.d = -1;
    }

    public void e() {
        try {
            this.c.close();
        } catch (IOException unused) {
        }
        this.f19295a = (byte) 0;
        this.d = -1;
    }

    public long b(long j) {
        int i;
        int i2 = this.d;
        int i3 = 0;
        if (i2 >= 0) {
            i = i2 + 1;
            j -= (long) i;
            this.d = -1;
        } else {
            i = 0;
        }
        int i4 = (int) (7 & j);
        long j2 = j / 8;
        long jD = d(j2);
        if (jD < 0) {
            return i;
        }
        if (jD >= j2) {
            try {
                d();
                this.d -= i4;
                i3 = i4;
            } catch (IllegalArgumentException unused) {
            }
        }
        return (jD * 8) + ((long) i3) + ((long) i);
    }

    public long a(int i) {
        if (i < 0 || i > 64) {
            throw new IllegalArgumentException("bits must be in range 0 ... 64!");
        }
        long jC = 0;
        if (this.d >= 0 || (i & 7) != 0) {
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                if (this.d < 0) {
                    d();
                }
                byte b = this.f19295a;
                int i2 = this.d;
                if (((b >> i2) & 1) != 0) {
                    jC |= 1 << i;
                }
                this.d = i2 - 1;
            }
        } else {
            for (int i3 = 0; i3 < i; i3 += 8) {
                jC = (jC << 8) | ((long) c());
            }
        }
        return jC;
    }

    public int c(int i) {
        if (i < 0 || i > 32) {
            throw new IllegalArgumentException("bits must be in range 0 ... 32!");
        }
        int iC = 0;
        if (this.d >= 0 || (i & 7) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (this.d < 0) {
                    d();
                }
                byte b = this.f19295a;
                int i3 = this.d;
                if (((b >> i3) & 1) != 0) {
                    iC |= 1 << i2;
                }
                this.d = i3 - 1;
            }
        } else {
            for (int i4 = 0; i4 < i; i4 += 8) {
                iC = (iC << 8) | c();
            }
        }
        return iC;
    }

    public byte[] d(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Count " + i + " must not be negative!");
        }
        if (i == 0) {
            return ygc.d;
        }
        byte[] bArr = new byte[i];
        if (this.d >= 0) {
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) c(8);
            }
        } else {
            c(bArr, 0, i, true);
        }
        return bArr;
    }

    public byte b() {
        int iC;
        if (this.d >= 0) {
            iC = c(8);
        } else {
            iC = c();
        }
        return (byte) iC;
    }

    public byte[] j(int i) {
        int iD = ygf.d(i);
        int iE = ygf.e(iD);
        int iC = c(iD);
        if (iC == iE) {
            return null;
        }
        return d(iC);
    }

    public ygg e(int i) {
        return new ygg(b(i));
    }

    public ByteArrayInputStream b(int i) {
        if (this.d > 0) {
            throw new IllegalStateException(this.d + " bits unread!");
        }
        InputStream inputStream = this.c;
        if (inputStream instanceof a) {
            return ((a) inputStream).d(i);
        }
        byte[] bArr = new byte[i];
        c(bArr, 0, i, true);
        return new a(bArr);
    }

    private long d(long j) {
        try {
            return this.c.skip(j);
        } catch (IOException unused) {
            return -1L;
        }
    }

    private void d() {
        this.f19295a = (byte) c();
        this.d = 7;
    }

    private int c() {
        try {
            int i = this.c.read();
            if (i >= 0) {
                return i;
            }
            throw new IllegalArgumentException("requested byte exceeds available bytes!");
        } catch (IOException e) {
            throw new IllegalArgumentException("request byte fails!", e);
        }
    }

    private int c(byte[] bArr, int i, int i2, boolean z) {
        int i3 = 0;
        int i4 = i2;
        while (i2 > 0) {
            try {
                int i5 = this.c.read(bArr, i + i3, i4);
                if (i5 <= 0) {
                    break;
                }
                i3 += i5;
                i4 -= i5;
                if (!z) {
                    break;
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("request bytes fails!", e);
            }
        }
        if (i3 >= i2) {
            return i3;
        }
        throw new IllegalArgumentException("requested " + i2 + " bytes exceeds available " + i3 + " bytes.");
    }
}
