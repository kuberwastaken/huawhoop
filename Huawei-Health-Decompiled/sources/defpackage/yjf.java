package defpackage;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public class yjf extends GeneralSecurityException {
    private static final long serialVersionUID = 1;
    private final byte[] d;
    private final byte[] e;

    public yjf() {
        this("MAC validation failed");
    }

    public yjf(String str) {
        super(str);
        this.e = ygc.d;
        this.d = ygc.d;
    }

    public yjf(byte[] bArr, byte[] bArr2) {
        super("MAC validation failed");
        this.e = Arrays.copyOf(bArr, bArr.length);
        this.d = Arrays.copyOf(bArr2, bArr2.length);
    }
}
