package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dst {
    private long d = -1;
    private long e = -1;
    private long b = -1;
    private List<dtc> c = new ArrayList(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f12408a = null;

    public long b() {
        return this.b;
    }

    public void c(long j) {
        this.b = j;
    }

    public long a() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public long c() {
        return this.e;
    }

    public void e(long j) {
        this.e = j;
    }

    public List<dtc> e() {
        return this.c;
    }

    public void a(List<dtc> list) {
        this.c = list;
    }

    public byte[] d() {
        return this.f12408a;
    }

    public void c(byte[] bArr) {
        this.f12408a = bArr;
    }

    private String i() {
        List<dtc> list = this.c;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(5);
        Iterator<dtc> it = this.c.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(", ");
        }
        return sb.toString();
    }

    public String toString() {
        return "SamplePoint{mModifyTime=" + this.b + ", mStartTime=" + this.d + ", mEndTime=" + this.e + ", mDataInfoList=" + i() + ", mMetaData=" + chk.e(chj.b(this.f12408a)) + '}';
    }
}
