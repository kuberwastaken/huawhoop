package defpackage;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ptd implements Serializable {
    private static final long serialVersionUID = 6072518949116079534L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16866a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private List<ptv> h;
    private String i;
    private boolean j;
    private int k;
    private String l;
    private String o;

    public int a() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public boolean g() {
        return this.f16866a;
    }

    public void d(boolean z) {
        this.f16866a = z;
    }

    public String i() {
        return this.o;
    }

    public void h(String str) {
        this.o = str;
    }

    public List<ptv> e() {
        return this.h;
    }

    public String j() {
        return this.l;
    }

    public void j(String str) {
        this.l = str;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public int h() {
        return this.k;
    }

    public void c(int i) {
        this.k = i;
    }

    public boolean l() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public boolean f() {
        return this.g;
    }

    public void e(boolean z) {
        this.g = z;
    }

    public void d(String str) {
        this.f = str;
    }

    public void a(String str) {
        this.e = str;
    }

    public String d() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public void a(List<ptv> list) {
        this.h = list;
    }

    public String toString() {
        return "DeclarationBean{mTitle='" + this.l + "', mFeatureId='" + this.d + "', mType=" + this.k + ", mIsStartBox=" + this.j + ", mIsEndBox=" + this.g + ", mVersion='" + this.o + "', mIsChecked=" + this.f16866a + ", mShortVersion='" + this.f + "', mBaseVersion='" + this.e + "', mPrivacyVersion='" + this.i + "', mAgreementVersion='" + this.c + "', mIndex=" + this.b + ", mParts=" + this.h + '}';
    }
}
