package com.huawei.hms.scankit.p;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes10.dex */
public class u6 implements Parcelable {
    public static final Parcelable.Creator<u6> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f6078a;
    private final float b;
    private int c;
    private boolean d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String toString() {
        return Constants.LEFT_BRACKET_ONLY + this.f6078a + ',' + this.b + com.huawei.hms.network.embedded.g4.l;
    }

    public u6(float f, float f2) {
        this.c = 0;
        this.d = false;
        this.f6078a = f;
        this.b = f2;
    }

    public final float b() {
        return this.f6078a;
    }

    public final float c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u6) {
            u6 u6Var = (u6) obj;
            if (Math.abs(this.f6078a - u6Var.f6078a) < 1.0E-4d && Math.abs(this.b - u6Var.b) < 1.0E-4d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f6078a) * 31) + Float.floatToIntBits(this.b);
    }

    public u6(float f, float f2, int i) {
        this.d = false;
        this.f6078a = f;
        this.b = f2;
        this.c = i;
    }

    public u6(float f, float f2, boolean z) {
        this.c = 0;
        this.f6078a = f;
        this.b = f2;
        this.d = z;
    }

    private static float a(u6 u6Var, u6 u6Var2, u6 u6Var3) {
        float f = u6Var2.f6078a;
        float f2 = u6Var2.b;
        return ((u6Var3.f6078a - f) * (u6Var.b - f2)) - ((u6Var3.b - f2) * (u6Var.f6078a - f));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f6078a);
        parcel.writeFloat(this.b);
    }

    class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u6[] newArray(int i) {
            return new u6[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u6 createFromParcel(Parcel parcel) {
            return new u6(parcel);
        }

        a() {
        }
    }

    public static float a(u6 u6Var, u6 u6Var2) {
        return s4.a(u6Var.f6078a, u6Var.b, u6Var2.f6078a, u6Var2.b);
    }

    protected u6(Parcel parcel) {
        this.c = 0;
        this.d = false;
        this.f6078a = parcel.readFloat();
        this.b = parcel.readFloat();
    }

    public int a() {
        return this.c;
    }

    public static void a(u6[] u6VarArr) {
        float fA = a(u6VarArr[0], u6VarArr[1]);
        float fA2 = a(u6VarArr[1], u6VarArr[2]);
        float fA3 = a(u6VarArr[0], u6VarArr[2]);
        int[] iArrA = a(fA2, fA, fA3);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int i3 = iArrA[2];
        u6 u6Var = u6VarArr[i];
        u6 u6Var2 = u6VarArr[i2];
        u6 u6Var3 = u6VarArr[i3];
        float[] fArr = {fA2, fA3, fA};
        if (r3.j % 2 == 0) {
            float f = fArr[i2];
            float f2 = fArr[i];
        }
        if (a(u6Var2, u6Var, u6Var3) < 0.0f) {
            u6Var2 = u6Var3;
            u6Var3 = u6Var2;
        }
        u6VarArr[0] = u6Var2;
        u6VarArr[1] = u6Var;
        u6VarArr[2] = u6Var3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
    
        if (r6 > r7) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        r5 = r3;
        r3 = 2;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
    
        r5 = r2;
        r2 = 2;
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if (r7 > r8) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] a(float r6, float r7, float r8) {
        /*
            int r0 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 < 0) goto L10
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L10
            int r6 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r6 <= 0) goto L1d
            goto L22
        L10:
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 < 0) goto L26
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 < 0) goto L26
            r5 = r3
            r3 = r2
            r2 = r5
            if (r0 <= 0) goto L22
        L1d:
            r5 = r3
            r3 = r1
            r1 = r2
        L20:
            r2 = r5
            goto L2e
        L22:
            r5 = r2
            r2 = r1
            r1 = r5
            goto L2e
        L26:
            int r6 = (r6 > r6 ? 1 : (r6 == r6 ? 0 : -1))
            if (r6 <= 0) goto L2b
            goto L2e
        L2b:
            r5 = r3
            r3 = r2
            goto L20
        L2e:
            int[] r6 = new int[]{r1, r2, r3}
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.u6.a(float, float, float):int[]");
    }
}
