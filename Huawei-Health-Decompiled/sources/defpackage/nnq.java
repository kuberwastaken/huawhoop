package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes6.dex */
public class nnq<V> extends FutureTask<V> implements Comparable<Runnable> {
    public Runnable e;

    public nnq(Callable<V> callable) {
        super(callable);
    }

    public nnq(Runnable runnable, V v) {
        super(runnable, v);
        this.e = runnable;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Runnable runnable) {
        Runnable runnable2 = this.e;
        nno nnoVar = runnable2 instanceof nno ? (nno) runnable2 : null;
        if (nnoVar != null) {
            return nnoVar.compareTo(runnable);
        }
        return 0;
    }
}
