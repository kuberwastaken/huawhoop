package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class ldf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15105a;
    private String b;
    private String c;
    private long d;
    private byte[] e;
    private int f;
    private int h;

    public String d() {
        return this.b;
    }

    public int h() {
        return this.f;
    }

    public long e() {
        return this.d;
    }

    public int f() {
        return this.h;
    }

    public String a() {
        return this.f15105a;
    }

    public String c() {
        return this.c;
    }

    public byte[] b() {
        byte[] bArr = this.e;
        return bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    public void a(String str) {
        this.b = str;
    }

    public void c(int i) {
        this.f = i;
    }

    public void d(long j) {
        this.d = j;
    }

    public void a(int i) {
        this.h = i;
    }

    public void c(String str) {
        this.f15105a = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public void c(byte[] bArr) {
        if (bArr != null) {
            this.e = (byte[]) bArr.clone();
        }
    }

    public String toString() {
        return "FaqMessageInfo{mMessageId='" + this.b + "', mMessageType=" + this.f + ", mMessageExpireTime=" + this.d + ", mMotorEnable=" + this.h + ", mMessageTitle='" + this.f15105a + "', mMessageContext='" + this.c + "', mMessageIcon=" + Arrays.toString(this.e) + '}';
    }
}
