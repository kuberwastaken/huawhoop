package defpackage;

import com.huawei.openalliance.ad.constant.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class ddg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12184a;
    private int b;
    private int c;
    private float d;
    private boolean e = false;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float k;
    private int l;

    public boolean o() {
        return ((Boolean) dne.b(Boolean.valueOf(this.e))).booleanValue();
    }

    public void a(boolean z) {
        this.e = ((Boolean) dne.b(Boolean.valueOf(z))).booleanValue();
    }

    public float d() {
        return ((Float) dne.b(Float.valueOf(this.d))).floatValue();
    }

    public void d(float f) {
        this.d = ((Float) dne.b(Float.valueOf(f))).floatValue();
    }

    public float h() {
        return ((Float) dne.b(Float.valueOf(this.k))).floatValue();
    }

    public void e(float f) {
        this.k = ((Float) dne.b(Float.valueOf(f))).floatValue();
    }

    public int i() {
        return ((Integer) dne.b(Integer.valueOf(this.j))).intValue();
    }

    public void e(int i) {
        this.j = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public int f() {
        return ((Integer) dne.b(Integer.valueOf(this.l))).intValue();
    }

    public void g(int i) {
        this.l = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public int b() {
        return ((Integer) dne.b(Integer.valueOf(this.g))).intValue();
    }

    public void b(int i) {
        this.g = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public int a() {
        return ((Integer) dne.b(Integer.valueOf(this.c))).intValue();
    }

    public void d(int i) {
        this.c = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public int e() {
        return ((Integer) dne.b(Integer.valueOf(this.f12184a))).intValue();
    }

    public void c(int i) {
        this.f12184a = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public int c() {
        return ((Integer) dne.b(Integer.valueOf(this.b))).intValue();
    }

    public void a(int i) {
        this.b = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public int j() {
        return ((Integer) dne.b(Integer.valueOf(this.i))).intValue();
    }

    public void f(int i) {
        this.i = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public void j(int i) {
        this.h = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public String g() {
        return (String) dne.b(this.f);
    }

    public void a(String str) {
        this.f = (String) dne.b(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append("fat measure test result.test time:");
        stringBuffer.append(this.l).append(Constants.LINK).append(this.g).append(Constants.LINK).append(this.c);
        stringBuffer.append(" ").append(this.f12184a).append(":").append(this.b).append(":").append(this.i);
        return stringBuffer.toString();
    }
}
