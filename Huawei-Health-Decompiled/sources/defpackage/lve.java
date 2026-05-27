package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lve {
    private int c;
    private List<lvc> d = new ArrayList(0);

    public void d(int i) {
        this.c = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<lvc> b() {
        return (List) kqt.e(this.d);
    }

    public void e(List<lvc> list) {
        this.d = (List) kqt.e(list);
    }

    public String toString() {
        return "[StressRecordDetails : ,stressFrameIndex = " + this.c + ",stressRecordDetails = " + this.d.toString() + "]";
    }
}
