package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lvd {
    private int c;
    private List<Integer> d = new ArrayList(16);

    public List<Integer> a() {
        return (List) kqt.e(this.d);
    }

    public void a(List<Integer> list) {
        this.d = (List) kqt.e(list);
    }

    public int e() {
        return ((Integer) kqt.e(Integer.valueOf(this.c))).intValue();
    }

    public void a(int i) {
        this.c = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "[RelaxRecordIndexList :,relaxFrameCount = " + this.c + ",relaxFrameIndex = " + this.d.toString() + "]";
    }
}
