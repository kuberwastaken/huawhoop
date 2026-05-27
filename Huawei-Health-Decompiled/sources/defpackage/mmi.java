package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mmi {
    private List<Float> d;
    private int e;

    public mmi(List<Float> list, int i) {
        this.d = list;
        this.e = i;
    }

    public int e() {
        return this.e;
    }

    public List<Float> c() {
        return this.d;
    }

    public String toString() {
        return "mStatusNum = " + this.e + " mSignalList = " + this.d.toString();
    }
}
