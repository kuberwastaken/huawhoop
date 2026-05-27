package defpackage;

import java.util.Arrays;
import org.eclipse.californium.elements.util.StandardCharsets;

/* JADX INFO: loaded from: classes8.dex */
public final class yii extends ygc {
    public static final yii c = new yii("");
    private String b;
    private boolean e;

    private yii(byte[] bArr) {
        this(new String(bArr, StandardCharsets.UTF_8), bArr);
    }

    public yii(String str) {
        super(str == null ? null : str.getBytes(StandardCharsets.UTF_8), 65535, false);
        this.b = str;
        this.e = true;
    }

    public yii(String str, byte[] bArr) {
        super(bArr, 65535, false);
        this.b = str;
        this.e = Arrays.equals(bArr, str.getBytes(StandardCharsets.UTF_8));
    }

    public String e() {
        return this.b;
    }

    @Override // defpackage.ygc
    public String toString() {
        if (this.e) {
            return this.b;
        }
        return this.b + "/" + d();
    }

    public static yii c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return c;
        }
        return new yii(bArr);
    }
}
