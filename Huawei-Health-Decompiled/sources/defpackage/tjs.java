package defpackage;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes11.dex */
public class tjs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<stc> f18014a;
    private int b;
    private boolean c;
    private boolean d;
    private Date e;
    private double j;

    public CopyOnWriteArrayList<stc> a() {
        return this.f18014a;
    }

    public void a(CopyOnWriteArrayList<stc> copyOnWriteArrayList) {
        this.f18014a = copyOnWriteArrayList;
    }

    public boolean d() {
        return this.d;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public double c() {
        return this.j;
    }

    public void b(double d) {
        this.j = d;
    }

    public boolean j() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public Date e() {
        return (Date) kqt.e(this.e);
    }

    public void b(Date date) {
        this.e = (Date) kqt.e(date);
    }

    public int b() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }
}
