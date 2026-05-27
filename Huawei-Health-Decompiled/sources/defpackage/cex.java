package defpackage;

import com.huawei.devicesdk.entity.SimpleDataHead;

/* JADX INFO: loaded from: classes3.dex */
public class cex {
    private byte c;
    private byte d;
    private SimpleDataHead e;
    private byte[] b = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f619a = new byte[2];

    public SimpleDataHead c() {
        return this.e;
    }

    public void d(SimpleDataHead simpleDataHead) {
        this.e = simpleDataHead;
    }

    public void c(byte b) {
        this.d = b;
    }

    public byte e() {
        return this.c;
    }

    public void a(byte b) {
        this.c = b;
    }

    public byte[] a() {
        return this.b;
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    public void b(byte[] bArr) {
        this.f619a = bArr;
    }
}
