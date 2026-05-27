package defpackage;

import health.compact.a.util.LogUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class dvx {
    private byte[] b;
    private int e = 0;
    private int d = 0;
    private HashMap<Integer, byte[]> h = new HashMap<>();
    private boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12460a = 0;

    public void e(int i) {
        this.d = i;
    }

    public void d(boolean z) {
        this.c = z;
    }

    public int c() {
        return this.f12460a;
    }

    public void b(int i) {
        this.f12460a = i;
    }

    public HashMap<Integer, byte[]> a() {
        return this.h;
    }

    public byte[] b() {
        return this.b;
    }

    public void e(byte[] bArr) {
        this.b = bArr;
    }

    public boolean e(int i, byte[] bArr) {
        this.h.put(Integer.valueOf(i), bArr);
        return this.c && this.h.size() == this.f12460a;
    }

    public void d() {
        HashMap<Integer, byte[]> mapA = a();
        int iC = c();
        byte[] bArrC = new byte[0];
        for (int i = 0; i < iC; i++) {
            byte[] bArr = mapA.get(Integer.valueOf(i));
            if (bArr == null) {
                return;
            }
            bArrC = c(bArrC, bArr);
        }
        e(bArrC);
    }

    private byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    protected dhh e(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        dhh dhhVar = new dhh();
        dhhVar.e(dwe.d(bArr, 18, i));
        dhhVar.b(dwe.d(bArr, 18, i + 2));
        dhhVar.c(dwe.d(bArr, 18, i + 4));
        dhhVar.a(dwe.d(bArr, 18, i + 6));
        LogUtil.b("PDROPE_DataPackets", "RopeDataCharacteristic", dhhVar.toString());
        return dhhVar;
    }

    public boolean e(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            i3 += bArr[i];
            i++;
        }
        return bArr[i2] == ((byte) (i3 & 255));
    }
}
