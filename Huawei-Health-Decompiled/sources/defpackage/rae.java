package defpackage;

import java.util.Comparator;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class rae implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
    }
}
