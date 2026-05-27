package defpackage;

import com.huawei.operation.utils.Constants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class gi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f13466a;
    private final int[] b;

    public gi(float[] fArr, int[] iArr) {
        this.f13466a = fArr;
        this.b = iArr;
    }

    public float[] b() {
        return this.f13466a;
    }

    public int[] a() {
        return this.b;
    }

    public int d() {
        return this.b.length;
    }

    public void d(gi giVar, gi giVar2, float f) {
        int[] iArr;
        if (giVar.equals(giVar2)) {
            a(giVar);
            return;
        }
        if (f <= 0.0f) {
            a(giVar);
            return;
        }
        if (f >= 1.0f) {
            a(giVar2);
            return;
        }
        if (giVar.b.length != giVar2.b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + giVar.b.length + " vs " + giVar2.b.length + Constants.RIGHT_BRACKET_ONLY);
        }
        int i = 0;
        while (true) {
            iArr = giVar.b;
            if (i >= iArr.length) {
                break;
            }
            this.f13466a[i] = jb.a(giVar.f13466a[i], giVar2.f13466a[i], f);
            this.b[i] = iz.b(f, giVar.b[i], giVar2.b[i]);
            i++;
        }
        int length = iArr.length;
        while (true) {
            float[] fArr = this.f13466a;
            if (length >= fArr.length) {
                return;
            }
            int[] iArr2 = giVar.b;
            fArr[length] = fArr[iArr2.length - 1];
            int[] iArr3 = this.b;
            iArr3[length] = iArr3[iArr2.length - 1];
            length++;
        }
    }

    public gi c(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = c(fArr[i]);
        }
        return new gi(fArr, iArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gi giVar = (gi) obj;
        return Arrays.equals(this.f13466a, giVar.f13466a) && Arrays.equals(this.b, giVar.b);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f13466a) * 31) + Arrays.hashCode(this.b);
    }

    private int c(float f) {
        int iBinarySearch = Arrays.binarySearch(this.f13466a, f);
        if (iBinarySearch >= 0) {
            return this.b[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.b[0];
        }
        int[] iArr = this.b;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f13466a;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return iz.b((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }

    private void a(gi giVar) {
        int i = 0;
        while (true) {
            int[] iArr = giVar.b;
            if (i >= iArr.length) {
                return;
            }
            this.f13466a[i] = giVar.f13466a[i];
            this.b[i] = iArr[i];
            i++;
        }
    }
}
