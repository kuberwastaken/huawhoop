package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lji {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15238a;
    private int b;
    private byte[] d;
    private int e;
    private byte[] f;
    private byte[] h;
    private int i;
    private int j;
    private byte[] k;
    private int l;
    private String m;
    private int c = 209715200;
    private int g = -1;

    public int e() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int i() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
    }

    public byte[] f() {
        byte[] bArr = this.f;
        return bArr != null ? bArr : new byte[0];
    }

    public void d(byte[] bArr) {
        this.f = bArr;
    }

    public byte[] h() {
        byte[] bArr = this.h;
        return bArr != null ? bArr : new byte[0];
    }

    public void e(byte[] bArr) {
        if (bArr != null) {
            this.h = bArr;
        } else {
            this.h = null;
        }
    }

    public int g() {
        return this.i;
    }

    public byte[] m() {
        byte[] bArr = this.k;
        return bArr != null ? bArr : new byte[0];
    }

    public void c(byte[] bArr) {
        this.k = bArr;
    }

    public int l() {
        return this.l;
    }

    public void j(int i) {
        this.l = i;
    }

    public byte[] a() {
        byte[] bArr = this.d;
        return bArr != null ? bArr : new byte[0];
    }

    public void a(byte[] bArr) {
        this.d = bArr;
    }

    public int c() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public void e(int i) {
        this.i = i;
    }

    public int j() {
        return this.j;
    }

    public void h(int i) {
        this.j = i;
    }

    public String o() {
        return this.m;
    }

    public void b(String str) {
        this.m = str;
    }

    public String b() {
        return this.f15238a;
    }

    public void c(String str) {
        this.f15238a = str;
    }

    public int d() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }
}
