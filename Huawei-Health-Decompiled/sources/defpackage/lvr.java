package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lvr {
    private List<lvw> b;
    private int e;

    public void e(int i) {
        this.e = i;
    }

    public List<lvw> e() {
        return this.b;
    }

    public void c(List<lvw> list) {
        this.b = list;
    }

    public String toString() {
        return "BloodOxygenDownRemind{mBloodOxygenDownRemindIndex=" + this.e + ", mBloodOxygenDownStructs=" + this.b + '}';
    }
}
