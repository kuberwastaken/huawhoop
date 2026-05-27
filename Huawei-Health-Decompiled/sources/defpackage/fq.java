package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class fq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f13083a;
    private final String b;
    private final char c;
    private final String d;
    private final List<gp> e;
    private final double i;

    public static int d(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public fq(List<gp> list, char c, double d, double d2, String str, String str2) {
        this.e = list;
        this.c = c;
        this.f13083a = d;
        this.i = d2;
        this.d = str;
        this.b = str2;
    }

    public List<gp> e() {
        return this.e;
    }

    public double d() {
        return this.i;
    }

    public int hashCode() {
        return d(this.c, this.b, this.d);
    }
}
