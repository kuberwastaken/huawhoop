package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class dam implements Serializable {
    private static final long serialVersionUID = -5599807658382352185L;
    private int b;
    private int c;
    private int g;
    private int h;
    private int i;
    private int o;
    private String j = "";
    private int d = 1;
    private String f = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12126a = 1;
    private List<dah> e = new ArrayList(2);

    public int h() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public int j() {
        return this.i;
    }

    public void d(int i) {
        this.i = i;
    }

    public String g() {
        return this.j;
    }

    public void e(String str) {
        this.j = str;
    }

    public int d() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int a() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public int f() {
        return this.o;
    }

    public void f(int i) {
        this.o = i;
    }

    public int e() {
        return this.d;
    }

    public void e(int i) {
        this.d = i;
    }

    public String b() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public void h(int i) {
        this.f12126a = i;
    }

    public int i() {
        return this.f12126a;
    }

    public List<dah> c() {
        return this.e;
    }

    public int o() {
        return this.g;
    }

    public void j(int i) {
        this.g = i;
    }

    public void c(dah dahVar) {
        this.e.add(dahVar);
    }

    public String toString() {
        return "PageModuleObject{mName='" + this.j + "', mLayout='" + this.b + "', mModuleType='" + this.c + "', mPageType='" + this.i + "', pageModuleId='" + this.h + "', mDisplay = " + this.d + "', mTextPosition ='" + this.g + "', mMoreInfoUrl ='" + this.f + "', mCardItemList='" + this.e.toString() + "'}";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && (obj instanceof dam) && this.h == ((dam) obj).h;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.h));
    }
}
