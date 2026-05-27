package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class oqy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16466a;
    private String b;
    private int c;
    private String d;
    private byte[] e;

    public String c() {
        return this.f16466a;
    }

    public void d(String str) {
        this.f16466a = str;
    }

    public int e() {
        return this.c;
    }

    public void e(int i) {
        this.c = i;
    }

    public String b() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public byte[] a() {
        byte[] bArr = this.e;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.e = (byte[]) bArr.clone();
        } else {
            this.e = null;
        }
    }

    public String toString() {
        return "CommonDataType{key='" + this.f16466a + "', type=" + this.c + ", value='" + this.b + "', iconBytes=" + Arrays.toString(this.e) + ", iconType='" + this.d + "'}";
    }
}
