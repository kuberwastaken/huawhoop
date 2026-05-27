package defpackage;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

/* JADX INFO: loaded from: classes8.dex */
public class yjt implements AlgorithmParameterSpec, Destroyable {
    private final byte[] b;
    private boolean c;

    public yjt(yjt yjtVar) {
        if (yjtVar == null) {
            throw new NullPointerException("IV missing");
        }
        byte[] bArr = yjtVar.b;
        this.b = Arrays.copyOf(bArr, bArr.length);
    }

    public yjt(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("IV missing");
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("IV is empty");
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException("len is negative");
        }
        if (bArr.length - i < i2) {
            throw new IllegalArgumentException("Invalid offset/length combination");
        }
        this.b = Arrays.copyOfRange(bArr, i, i2 + i);
    }

    public int b() {
        return this.b.length;
    }

    public void e(ygf ygfVar) {
        ygfVar.d(this.b);
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() throws DestroyFailedException {
        ygc.e(this.b);
        this.c = true;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.c;
    }
}
