package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.ahocorasick.interval.IntervalNode;
import org.ahocorasick.interval.Intervalable;

/* JADX INFO: loaded from: classes8.dex */
public class ybt {
    private IntervalNode c;

    public ybt(List<Intervalable> list) {
        this.c = null;
        this.c = new IntervalNode(list);
    }

    public List<Intervalable> b(List<Intervalable> list) {
        Collections.sort(list, new ybp());
        TreeSet treeSet = new TreeSet();
        for (Intervalable intervalable : list) {
            if (!treeSet.contains(intervalable)) {
                treeSet.addAll(c(intervalable));
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            list.remove((Intervalable) it.next());
        }
        Collections.sort(list, new ybs());
        return list;
    }

    public List<Intervalable> c(Intervalable intervalable) {
        return this.c.b(intervalable);
    }
}
