package defpackage;

import defpackage.epb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class epg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static epg f12712a;
    private String c;
    private int d;
    private ArrayList<epb> f;
    private ArrayList<epb> b = new ArrayList<>();
    private ArrayList<epb> g = new ArrayList<>();
    private ArrayList<epc> e = new ArrayList<>();

    private epg() {
    }

    public static epg d() {
        epg epgVar;
        synchronized (epg.class) {
            if (f12712a == null) {
                f12712a = new epg();
            }
            epgVar = f12712a;
        }
        return epgVar;
    }

    public int b() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public ArrayList<epb> a() {
        return i();
    }

    public ArrayList<epb> h() {
        return g();
    }

    public ArrayList<epb> j() {
        return this.f;
    }

    public void a(ArrayList<epb> arrayList) {
        this.f = arrayList;
    }

    public ArrayList<epc> e() {
        return this.e;
    }

    public void c(ArrayList<epc> arrayList) {
        this.e = arrayList;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    private ArrayList<epb> i() {
        epb epbVarE = e(0, 90, 0, 60, 0, 0);
        epbVarE.a(0);
        epb epbVarE2 = e(91, 119, 61, 79, 1, 0);
        epbVarE2.a(1);
        epb epbVarE3 = e(120, 139, 80, 89, 2, 1);
        epbVarE3.a(2);
        epb epbVarF = f();
        epbVarF.a(3);
        this.b.clear();
        this.b.add(epbVarE);
        this.b.add(epbVarE2);
        this.b.add(epbVarE3);
        this.b.add(epbVarF);
        return this.b;
    }

    private epb f() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        epb.a aVar = new epb.a();
        epb.a aVar2 = new epb.a();
        epb.a aVar3 = new epb.a();
        epb epbVar = new epb();
        arrayList7.clear();
        arrayList.add(140);
        arrayList.add(159);
        arrayList2.add(90);
        arrayList2.add(99);
        aVar.b(0);
        aVar.e(3);
        aVar.a(1);
        aVar.b(arrayList);
        aVar.a(arrayList2);
        arrayList7.add(0, aVar);
        arrayList3.add(160);
        arrayList3.add(179);
        arrayList4.add(100);
        arrayList4.add(109);
        aVar2.b(1);
        aVar2.e(4);
        aVar2.a(1);
        aVar2.b(arrayList3);
        aVar2.a(arrayList4);
        arrayList7.add(1, aVar2);
        arrayList5.add(180);
        arrayList5.add(999);
        arrayList6.add(110);
        arrayList6.add(999);
        aVar3.b(2);
        aVar3.e(5);
        aVar3.a(1);
        aVar3.b(arrayList5);
        aVar3.a(arrayList6);
        arrayList7.add(2, aVar3);
        epbVar.c(arrayList7);
        return epbVar;
    }

    private epb e(int i, int i2, int i3, int i4, int i5, int i6) {
        ArrayList arrayList = new ArrayList();
        epb.a aVar = new epb.a();
        epb epbVar = new epb();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        arrayList.clear();
        arrayList2.clear();
        arrayList3.clear();
        arrayList2.add(Integer.valueOf(i));
        arrayList2.add(Integer.valueOf(i2));
        arrayList3.add(Integer.valueOf(i3));
        arrayList3.add(Integer.valueOf(i4));
        aVar.b(0);
        aVar.e(i5);
        aVar.a(i6);
        aVar.a(arrayList3);
        aVar.b(arrayList2);
        arrayList.add(aVar);
        epbVar.c(arrayList);
        return epbVar;
    }

    private ArrayList<epb> g() {
        epb epbVarE = e(0, 90, 0, 60, 0, 0);
        epbVarE.a(0);
        epb epbVarE2 = e(91, 129, 61, 84, 1, 2);
        epbVarE2.a(1);
        epb epbVarE3 = e(130, 139, 85, 89, 2, 2);
        epbVarE3.a(2);
        epb epbVarF = f();
        epbVarF.a(3);
        this.g.clear();
        this.g.add(epbVarE);
        this.g.add(epbVarE2);
        this.g.add(epbVarE3);
        this.g.add(epbVarF);
        return this.g;
    }
}
