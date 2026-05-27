package defpackage;

import java.util.Comparator;
import org.ahocorasick.interval.Intervalable;

/* JADX INFO: loaded from: classes8.dex */
public class ybp implements Comparator<Intervalable> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Intervalable intervalable, Intervalable intervalable2) {
        int size = intervalable2.size() - intervalable.size();
        return size == 0 ? intervalable.getStart() - intervalable2.getStart() : size;
    }
}
