package defpackage;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class fec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fdz[] f12930a;
    private int d;

    public int e() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public fdz[] c() {
        return this.f12930a;
    }

    public void a(fdz[] fdzVarArr) {
        this.f12930a = fdzVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fec fecVar = (fec) obj;
        return this.d == fecVar.d && Arrays.equals(this.f12930a, fecVar.f12930a);
    }

    public int hashCode() {
        return (Objects.hash(Integer.valueOf(this.d)) * 31) + Arrays.hashCode(this.f12930a);
    }
}
