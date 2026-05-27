package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class mko {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15694a;
    private ArrayList<mkl> b = new ArrayList<>();

    public mko(String str) {
        this.f15694a = str;
    }

    public String b() {
        return this.f15694a;
    }

    public ArrayList<mkl> e() {
        return this.b;
    }

    public void c(mkl mklVar) {
        this.b.add(mklVar);
    }

    public void a() {
        ArrayList<mkl> arrayList = this.b;
        if (arrayList != null) {
            arrayList.clear();
            this.b = new ArrayList<>();
        }
    }
}
