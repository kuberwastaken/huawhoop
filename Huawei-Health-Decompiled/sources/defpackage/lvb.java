package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lvb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<lvf> f15494a = new ArrayList(0);
    private int d;

    public void a(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<lvf> a() {
        return (List) kqt.e(this.f15494a);
    }

    public void a(List<lvf> list) {
        this.f15494a = (List) kqt.e(list);
    }

    public String toString() {
        return "[RelaxRecordDetails : ,relaxFrameIndex = " + this.d + ",relaxRecordDetails = " + this.f15494a.toString() + "]";
    }
}
