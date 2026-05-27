package defpackage;

import androidx.media3.extractor.ts.PsExtractor;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.huawei.operation.utils.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: classes9.dex */
public final class xl extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xb f19036a;
    private byte[] b;
    private int c = 0;
    private OutputStream d;
    private final int e;
    private int h;

    public xl(xb xbVar, OutputStream outputStream) {
        this.f19036a = xbVar;
        this.d = outputStream;
        this.b = xbVar.b();
        this.e = r1.length - 4;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.d;
        if (outputStream != null) {
            int i = this.c;
            if (i > 0) {
                outputStream.write(this.b, 0, i);
                this.c = 0;
            }
            OutputStream outputStream2 = this.d;
            this.d = null;
            byte[] bArr = this.b;
            if (bArr != null) {
                this.b = null;
                this.f19036a.a(bArr);
            }
            outputStream2.close();
            int i2 = this.h;
            this.h = 0;
            if (i2 > 0) {
                a(i2);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this.d;
        if (outputStream != null) {
            int i = this.c;
            if (i > 0) {
                outputStream.write(this.b, 0, i);
                this.c = 0;
            }
            this.d.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        if (i2 < 2) {
            if (i2 == 1) {
                write(cArr[i]);
                return;
            }
            return;
        }
        if (this.h > 0) {
            i2--;
            write(c(cArr[i]));
            i++;
        }
        int i3 = this.c;
        byte[] bArr = this.b;
        int i4 = this.e;
        int i5 = i2 + i;
        while (i < i5) {
            if (i3 >= i4) {
                this.d.write(bArr, 0, i3);
                i3 = 0;
            }
            int i6 = i + 1;
            char c = cArr[i];
            if (c < 128) {
                int i7 = i3 + 1;
                bArr[i3] = (byte) c;
                int i8 = i5 - i6;
                int i9 = i4 - i7;
                int i10 = i8 > i9 ? i9 : i8;
                i = i6;
                i3 = i7;
                while (i < i10 + i6) {
                    int i11 = i + 1;
                    c = cArr[i];
                    if (c >= 128) {
                        i6 = i11;
                    } else {
                        bArr[i3] = (byte) c;
                        i = i11;
                        i3++;
                    }
                }
            }
            if (c < 2048) {
                int i12 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | PsExtractor.AUDIO_STREAM);
                i3 += 2;
                bArr[i12] = (byte) ((c & '?') | 128);
            } else if (c < 55296 || c > 57343) {
                bArr[i3] = (byte) ((c >> '\f') | 224);
                bArr[i3 + 1] = (byte) (((c >> 6) & 63) | 128);
                bArr[i3 + 2] = (byte) ((c & '?') | 128);
                i3 += 3;
            } else {
                if (c > 56319) {
                    this.c = i3;
                    a(c);
                }
                this.h = c;
                if (i6 >= i5) {
                    break;
                }
                i = i6 + 1;
                int iC = c(cArr[i6]);
                if (iC > 1114111) {
                    this.c = i3;
                    a(iC);
                }
                bArr[i3] = (byte) ((iC >> 18) | 240);
                bArr[i3 + 1] = (byte) (((iC >> 12) & 63) | 128);
                int i13 = i3 + 3;
                bArr[i3 + 2] = (byte) (((iC >> 6) & 63) | 128);
                i3 += 4;
                bArr[i13] = (byte) ((iC & 63) | 128);
            }
            i = i6;
        }
        this.c = i3;
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        int i2;
        if (this.h > 0) {
            i = c(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                a(i);
            }
            this.h = i;
            return;
        }
        int i3 = this.c;
        if (i3 >= this.e) {
            this.d.write(this.b, 0, i3);
            this.c = 0;
        }
        if (i < 128) {
            byte[] bArr = this.b;
            int i4 = this.c;
            this.c = i4 + 1;
            bArr[i4] = (byte) i;
            return;
        }
        int i5 = this.c;
        if (i < 2048) {
            byte[] bArr2 = this.b;
            int i6 = i5 + 1;
            bArr2[i5] = (byte) ((i >> 6) | PsExtractor.AUDIO_STREAM);
            i2 = i5 + 2;
            bArr2[i6] = (byte) ((i & 63) | 128);
        } else if (i <= 65535) {
            byte[] bArr3 = this.b;
            bArr3[i5] = (byte) ((i >> 12) | 224);
            bArr3[i5 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i5 + 2] = (byte) ((i & 63) | 128);
            i2 = i5 + 3;
        } else {
            if (i > 1114111) {
                a(i);
            }
            byte[] bArr4 = this.b;
            bArr4[i5] = (byte) ((i >> 18) | 240);
            bArr4[i5 + 1] = (byte) (((i >> 12) & 63) | 128);
            int i7 = i5 + 3;
            bArr4[i5 + 2] = (byte) (((i >> 6) & 63) | 128);
            i2 = i5 + 4;
            bArr4[i7] = (byte) ((i & 63) | 128);
        }
        this.c = i2;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        if (i2 < 2) {
            if (i2 == 1) {
                write(str.charAt(i));
                return;
            }
            return;
        }
        if (this.h > 0) {
            i2--;
            write(c(str.charAt(i)));
            i++;
        }
        int i3 = this.c;
        byte[] bArr = this.b;
        int i4 = this.e;
        int i5 = i2 + i;
        while (i < i5) {
            if (i3 >= i4) {
                this.d.write(bArr, 0, i3);
                i3 = 0;
            }
            int i6 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                int i7 = i3 + 1;
                bArr[i3] = (byte) cCharAt;
                int i8 = i5 - i6;
                int i9 = i4 - i7;
                int i10 = i8 > i9 ? i9 : i8;
                i = i6;
                i3 = i7;
                while (i < i10 + i6) {
                    int i11 = i + 1;
                    cCharAt = str.charAt(i);
                    if (cCharAt >= 128) {
                        i6 = i11;
                    } else {
                        bArr[i3] = (byte) cCharAt;
                        i = i11;
                        i3++;
                    }
                }
            }
            if (cCharAt < 2048) {
                int i12 = i3 + 1;
                bArr[i3] = (byte) ((cCharAt >> 6) | PsExtractor.AUDIO_STREAM);
                i3 += 2;
                bArr[i12] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                bArr[i3] = (byte) ((cCharAt >> '\f') | 224);
                bArr[i3 + 1] = (byte) (((cCharAt >> 6) & 63) | 128);
                bArr[i3 + 2] = (byte) ((cCharAt & '?') | 128);
                i3 += 3;
            } else {
                if (cCharAt > 56319) {
                    this.c = i3;
                    a(cCharAt);
                }
                this.h = cCharAt;
                if (i6 >= i5) {
                    break;
                }
                i = i6 + 1;
                int iC = c(str.charAt(i6));
                if (iC > 1114111) {
                    this.c = i3;
                    a(iC);
                }
                bArr[i3] = (byte) ((iC >> 18) | 240);
                bArr[i3 + 1] = (byte) (((iC >> 12) & 63) | 128);
                int i13 = i3 + 3;
                bArr[i3 + 2] = (byte) (((iC >> 6) & 63) | 128);
                i3 += 4;
                bArr[i13] = (byte) ((iC & 63) | 128);
            }
            i = i6;
        }
        this.c = i3;
    }

    protected int c(int i) throws IOException {
        int i2 = this.h;
        this.h = 0;
        if (i >= 56320 && i <= 57343) {
            return ((i2 - GeneratorBase.SURR1_FIRST) << 10) + 65536 + (i - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
    }

    protected static void a(int i) throws IOException {
        throw new IOException(e(i));
    }

    protected static String e(int i) {
        if (i > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627";
        }
        if (i < 55296) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output";
        }
        if (i <= 56319) {
            return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + Constants.RIGHT_BRACKET_ONLY;
        }
        return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + Constants.RIGHT_BRACKET_ONLY;
    }
}
