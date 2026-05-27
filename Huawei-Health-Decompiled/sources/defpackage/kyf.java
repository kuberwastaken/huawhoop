package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class kyf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14997a;
    private List<Integer> b;
    private int e;

    public void a(int i) {
        this.f14997a = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void d(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<Integer> b() {
        return (List) kqt.e(this.b);
    }

    public void b(List<Integer> list) {
        this.b = (List) kqt.e(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("folderIndex: ");
        sb.append(this.f14997a);
        sb.append(" folderMusicAssociationFrameIndex: ");
        sb.append(this.e);
        sb.append(" musicIndexList: [");
        Iterator<Integer> it = this.b.iterator();
        while (it.hasNext()) {
            sb.append(it.next().intValue());
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
