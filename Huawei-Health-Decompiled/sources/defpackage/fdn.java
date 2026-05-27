package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fdn extends fdh {
    private String b;
    private List<fdk> d = new ArrayList();
    private List<fdl> e = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<fdh> f12914a = new ArrayList();
    private int c = -1;

    public int j() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public String e() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public List<fdk> i() {
        return this.d;
    }

    public void c(fdk fdkVar) {
        if (fdkVar == null || !fdkVar.f()) {
            return;
        }
        this.d.add(fdkVar);
        this.f12914a.add(fdkVar);
    }

    public void c(fdl fdlVar) {
        if (fdlVar == null || !fdlVar.h()) {
            return;
        }
        this.e.add(fdlVar);
        this.f12914a.add(fdlVar);
    }

    public List<fdl> h() {
        return this.e;
    }

    public List<fdh> d() {
        return this.f12914a;
    }

    public void b() {
        this.d.clear();
        this.e.clear();
        this.f12914a.clear();
        this.b = "";
    }
}
