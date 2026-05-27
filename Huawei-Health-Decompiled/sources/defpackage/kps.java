package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class kps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14827a;
    private String b;
    private int c;
    private ArrayList<kpp> d;
    private ArrayList<kpu> e;

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.f14827a))).intValue();
    }

    public void a(int i) {
        this.f14827a = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public ArrayList<kpu> d() {
        return (ArrayList) kqt.e(this.e);
    }

    public void a(ArrayList<kpu> arrayList) {
        this.e = (ArrayList) kqt.e(arrayList);
    }

    public void b(ArrayList<kpp> arrayList) {
        this.d = (ArrayList) kqt.e(arrayList);
    }

    public int a() {
        return ((Integer) kqt.e(Integer.valueOf(this.c))).intValue();
    }

    public void d(int i) {
        this.c = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String e() {
        return (String) kqt.e(this.b);
    }

    public void a(String str) {
        this.b = (String) kqt.e(str);
    }
}
