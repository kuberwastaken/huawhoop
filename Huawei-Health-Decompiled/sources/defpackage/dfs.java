package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class dfs {
    private byte[] b;
    private byte[] d;
    private float i;
    private int e = 0;
    private int c = 0;
    private int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12212a = -1;

    public int b() {
        return this.e;
    }

    public void e(int i) {
        this.e = i;
    }

    public int d() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public int a() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public byte[] e() {
        byte[] bArr = this.b;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public void b(byte[] bArr) {
        if (bArr != null) {
            this.b = (byte[]) bArr.clone();
        }
    }

    public byte[] j() {
        byte[] bArr = this.d;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public void e(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        this.d = (byte[]) bArr.clone();
    }

    public float h() {
        return this.i;
    }

    public void b(float f) {
        this.i = f;
    }

    public int c() {
        return this.f12212a;
    }

    public void b(int i) {
        this.f12212a = i;
    }

    public String toString() {
        return "ConstructionsUserBean{height=" + this.e + ", age=" + this.c + ", sex=" + this.f + ", huids=" + Arrays.toString(this.b) + ", uids=" + Arrays.toString(this.d) + ", weight=" + this.i + ", mouths=" + this.f12212a + '}';
    }
}
