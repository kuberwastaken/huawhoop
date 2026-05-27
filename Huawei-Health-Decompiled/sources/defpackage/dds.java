package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dds {
    private long b;
    private List<Integer> c;
    private long d;

    public long b() {
        return ((Long) kqt.e(Long.valueOf(this.b))).longValue();
    }

    public void d(long j) {
        this.b = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public long d() {
        return ((Long) kqt.e(Long.valueOf(this.d))).longValue();
    }

    public void a(long j) {
        this.d = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public List<Integer> e() {
        return (List) kqt.e(this.c);
    }

    public void b(List<Integer> list) {
        this.c = (List) kqt.e(list);
    }
}
