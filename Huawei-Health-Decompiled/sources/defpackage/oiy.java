package defpackage;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class oiy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ghu f16406a;
    private boolean b = false;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private List<Integer> h;
    private List<irt> i;
    private List<irt> j;
    private int k;
    private String l;
    private String m;
    private String o;

    public oiy(String str, int i, boolean z, String str2, String str3, String str4, List<irt> list, String str5) {
        this.d = str;
        this.k = i;
        this.g = z;
        this.c = str3;
        this.o = str2;
        this.l = str4;
        this.j = list;
        this.m = str5;
    }

    public int j() {
        return this.k;
    }

    public boolean l() {
        return this.g;
    }

    public String m() {
        return this.o;
    }

    public boolean n() {
        return this.b;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public String a() {
        return this.c;
    }

    public String o() {
        return this.l;
    }

    public String i() {
        return this.f;
    }

    public void d(String str) {
        this.f = str;
    }

    public List<irt> h() {
        return this.j;
    }

    public List<irt> f() {
        return this.i;
    }

    public void c(List<irt> list) {
        this.i = list;
    }

    public List<Integer> e() {
        return this.h;
    }

    public void e(List<Integer> list) {
        this.h = list;
    }

    public String g() {
        return this.m;
    }

    public String d() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public ghu b() {
        return this.f16406a;
    }

    public void c(ghu ghuVar) {
        this.f16406a = ghuVar;
    }

    public String c() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof oiy) {
            return Objects.equals(c(), ((oiy) obj).c());
        }
        return false;
    }
}
