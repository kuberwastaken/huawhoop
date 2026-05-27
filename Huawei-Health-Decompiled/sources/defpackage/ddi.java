package defpackage;

import com.huawei.health.device.kit.hwch.ch18.bean.WeightCmd;

/* JADX INFO: loaded from: classes4.dex */
public class ddi<T> {
    private int e = 0;
    private byte[] d = null;
    private T c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeightCmd f12186a = null;

    public int c() {
        return ((Integer) dne.b(Integer.valueOf(this.e))).intValue();
    }

    public void d(int i) {
        this.e = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public byte[] e() {
        byte[] bArr = this.d;
        return (bArr == null || bArr.length == 0) ? new byte[0] : (byte[]) bArr.clone();
    }

    public void d(byte[] bArr) {
        this.d = bArr == null ? null : (byte[]) bArr.clone();
    }

    public T a() {
        return (T) dne.b(this.c);
    }

    public void d(T t) {
        this.c = (T) dne.b(t);
    }

    public WeightCmd b() {
        return this.f12186a;
    }

    public void c(WeightCmd weightCmd) {
        this.f12186a = weightCmd;
    }
}
