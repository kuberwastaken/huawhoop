package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lvh {
    private List<Integer> c = new ArrayList(16);
    private int e;

    public List<Integer> a() {
        return (List) kqt.e(this.c);
    }

    public void e(List<Integer> list) {
        this.c = (List) kqt.e(list);
    }

    public int d() {
        return ((Integer) kqt.e(Integer.valueOf(this.e))).intValue();
    }

    public void b(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "[StressRecordIndexList :,stressFrameCount = " + this.e + ",stressFrameIndexList = " + this.c.toString() + "]";
    }
}
