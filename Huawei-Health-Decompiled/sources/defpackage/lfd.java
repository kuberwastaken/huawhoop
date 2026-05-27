package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lfd {
    private int b;
    private int c;
    private int d;
    private int e;

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.c = i;
    }

    public void e(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public int e() {
        return this.b;
    }

    public int a() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public static List<lfd> a(int i) {
        lfd lfdVar = new lfd();
        lfdVar.c(1);
        lfdVar.d(3);
        lfdVar.e(500);
        lfdVar.b(2);
        ArrayList arrayList = new ArrayList(16);
        arrayList.add(lfdVar);
        lfd lfdVar2 = new lfd();
        lfdVar2.c(3);
        lfdVar2.d(3);
        lfdVar2.e(100);
        lfdVar2.b(2);
        arrayList.add(lfdVar2);
        lfd lfdVar3 = new lfd();
        lfdVar3.c(4);
        lfdVar3.d(3);
        if (i != 1 && i == 6) {
            lfdVar3.e(21600);
        } else {
            lfdVar3.e(3600);
        }
        lfdVar3.b(2);
        arrayList.add(lfdVar3);
        lfd lfdVar4 = new lfd();
        lfdVar4.c(5);
        lfdVar4.d(3);
        lfdVar4.e(250);
        lfdVar4.b(2);
        arrayList.add(lfdVar4);
        return arrayList;
    }

    public String toString() {
        return "DeviceReportThroshold{dataType=" + this.b + ", valueType=" + this.c + ", value=" + this.d + ", action=" + this.e + '}';
    }
}
