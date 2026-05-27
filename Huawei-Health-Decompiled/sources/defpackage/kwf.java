package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class kwf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14956a;
    private int b;
    private int c;
    private int d;

    public void d(int i) {
        this.f14956a = i;
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(int i) {
        this.c = i;
    }

    public void e(int i) {
        this.d = i;
    }

    public int b() {
        return this.f14956a;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public int a() {
        return this.d;
    }

    public static List<kwf> c(int i) {
        kwf kwfVar = new kwf();
        kwfVar.d(1);
        kwfVar.a(3);
        kwfVar.b(500);
        kwfVar.e(2);
        ArrayList arrayList = new ArrayList(16);
        arrayList.add(kwfVar);
        kwf kwfVar2 = new kwf();
        kwfVar2.d(3);
        kwfVar2.a(3);
        kwfVar2.b(100);
        kwfVar2.e(2);
        arrayList.add(kwfVar2);
        kwf kwfVar3 = new kwf();
        kwfVar3.d(4);
        kwfVar3.a(3);
        if (i != 1 && i == 6) {
            kwfVar3.b(21600);
        } else {
            kwfVar3.b(3600);
        }
        kwfVar3.e(2);
        arrayList.add(kwfVar3);
        kwf kwfVar4 = new kwf();
        kwfVar4.d(5);
        kwfVar4.a(3);
        kwfVar4.b(250);
        kwfVar4.e(2);
        arrayList.add(kwfVar4);
        return arrayList;
    }

    public String toString() {
        return "DeviceReportThroshold{dataType=" + this.f14956a + ", valueType=" + this.b + ", value=" + this.c + ", action=" + this.d + '}';
    }
}
