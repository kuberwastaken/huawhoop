package defpackage;

import defpackage.yen;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes8.dex */
public class yep<T extends yen<?>> implements Iterable<T> {
    private final ConcurrentMap<String, T> b;
    private final String c;

    public yep(String str) {
        this.b = new ConcurrentHashMap();
        this.c = str;
    }

    public yep(yep<T> yepVar) {
        this(yepVar.d(), yepVar);
    }

    public yep(String str, yep<T> yepVar) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.b = concurrentHashMap;
        this.c = str;
        concurrentHashMap.putAll(yepVar.b);
    }

    public String d() {
        return this.c;
    }

    public yep<T> d(T t) {
        yen yenVarB = b(t);
        if (yenVarB == null || yenVarB == t) {
            return this;
        }
        throw new IllegalArgumentException(this.c + " already contains " + t.getKey() + "!");
    }

    public T b(T t) {
        t.getClass();
        return this.b.putIfAbsent(t.getKey(), t);
    }

    public boolean c(T t) {
        return t == c(t.getKey());
    }

    public T c(String str) {
        return this.b.get(str);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.b.values().iterator();
    }
}
