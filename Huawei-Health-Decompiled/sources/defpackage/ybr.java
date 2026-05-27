package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes8.dex */
public class ybr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19227a;
    private Map<Character, ybr> b;
    private final ybr c;
    private ybr d;
    private Set<String> e;

    public ybr() {
        this(0);
    }

    public ybr(int i) {
        this.b = new HashMap();
        this.d = null;
        this.e = null;
        this.f19227a = i;
        this.c = i == 0 ? this : null;
    }

    private ybr e(Character ch, boolean z) {
        ybr ybrVar;
        ybr ybrVar2 = this.b.get(ch);
        return (z || ybrVar2 != null || (ybrVar = this.c) == null) ? ybrVar2 : ybrVar;
    }

    public ybr e(Character ch) {
        return e(ch, false);
    }

    public ybr b(Character ch) {
        return e(ch, true);
    }

    public ybr c(Character ch) {
        ybr ybrVarB = b(ch);
        if (ybrVarB != null) {
            return ybrVarB;
        }
        ybr ybrVar = new ybr(this.f19227a + 1);
        this.b.put(ch, ybrVar);
        return ybrVar;
    }

    public void a(String str) {
        if (this.e == null) {
            this.e = new TreeSet();
        }
        this.e.add(str);
    }

    public void d(Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public Collection<String> b() {
        Set<String> set = this.e;
        return set == null ? Collections.emptyList() : set;
    }

    public ybr a() {
        return this.d;
    }

    public void c(ybr ybrVar) {
        this.d = ybrVar;
    }

    public Collection<ybr> d() {
        return this.b.values();
    }

    public Collection<Character> e() {
        return this.b.keySet();
    }
}
