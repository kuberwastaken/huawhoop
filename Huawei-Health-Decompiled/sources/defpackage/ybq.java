package defpackage;

import org.ahocorasick.interval.Intervalable;

/* JADX INFO: loaded from: classes8.dex */
public class ybq extends ybl implements Intervalable {
    private final String d;

    public ybq(int i, int i2, String str) {
        super(i, i2);
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    @Override // defpackage.ybl
    public String toString() {
        return super.toString() + "=" + this.d;
    }
}
