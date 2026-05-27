package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class kop {
    private double c;
    private Map<String, Object> d;
    private int e;

    public Map<String, Object> b() {
        return this.d;
    }

    public void b(Map<String, Object> map) {
        this.d = map;
    }

    public void e(double d) {
        this.c = d;
    }

    public double e() {
        return this.c;
    }

    public void b(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public String toString() {
        return "AtmosphereInfo{pressure=" + this.c + ", pressureUnit=" + this.e + ", hagReportBiMap=" + this.d + '}';
    }
}
