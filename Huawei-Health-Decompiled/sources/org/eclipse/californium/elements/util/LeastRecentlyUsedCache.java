package org.eclipse.californium.elements.util;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class LeastRecentlyUsedCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f16498a;
    private final Map<K, e<K, V>> b;
    private volatile int c;
    private final List<EvictionListener<V>> d;
    private volatile boolean e;
    private Collection<V> f;
    private volatile boolean h;
    private e<K, V> j;

    public interface EvictionListener<V> {
        void onEviction(V v);
    }

    public interface Predicate<V> {
        boolean accept(V v);
    }

    public LeastRecentlyUsedCache() {
        this(16, 150000, 1800L, TimeUnit.SECONDS);
    }

    public LeastRecentlyUsedCache(int i, long j) {
        this(Math.min(i, 16), i, j, TimeUnit.SECONDS);
    }

    public LeastRecentlyUsedCache(int i, int i2, long j, TimeUnit timeUnit) {
        this.e = true;
        this.h = true;
        this.d = new LinkedList();
        if (i > i2) {
            throw new IllegalArgumentException("initial capacity must be <= max capacity");
        }
        this.c = i2;
        this.b = new ConcurrentHashMap(i);
        c(j, timeUnit);
        j();
    }

    private void j() {
        e<K, V> eVar = new e<>();
        this.j = eVar;
        ((e) eVar).e = ((e) eVar).c = eVar;
    }

    public void d(EvictionListener<V> evictionListener) {
        if (evictionListener != null) {
            this.d.add(evictionListener);
        }
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public final void c(long j, TimeUnit timeUnit) {
        this.f16498a = timeUnit.toNanos(j);
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.b.size();
    }

    public final int e() {
        return Math.max(0, this.c - this.b.size());
    }

    public final void c() {
        this.b.clear();
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(K k, V v) {
        if (v == null) {
            return false;
        }
        e<K, V> eVar = this.b.get(k);
        if (eVar == null) {
            if (this.b.size() < this.c) {
                a(k, v);
                return true;
            }
            e eVar2 = ((e) this.j).e;
            if (!eVar2.b(this.f16498a)) {
                return false;
            }
            eVar2.a();
            this.b.remove(eVar2.b());
            a(k, v);
            d(eVar2.e());
            return true;
        }
        eVar.a();
        a(k, v);
        return true;
    }

    private void d(V v) {
        Iterator<EvictionListener<V>> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onEviction(v);
        }
    }

    private void a(K k, V v) {
        e<K, V> eVar = new e<>(k, v);
        this.b.put(k, eVar);
        eVar.h(this.j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(K k, V v, long j) {
        if (v == null) {
            return false;
        }
        e<K, V> eVar = this.b.get(k);
        if (eVar == null) {
            if (this.b.size() < this.c) {
                d(k, v, j);
                return true;
            }
            e eVar2 = ((e) this.j).e;
            if (!eVar2.b(this.f16498a) || j - eVar2.b < 0) {
                return false;
            }
            eVar2.a();
            this.b.remove(eVar2.b());
            d(k, v, j);
            d(eVar2.e());
            return true;
        }
        eVar.a();
        d(k, v, j);
        return true;
    }

    private void d(K k, V v, long j) {
        e<K, V> eVar = new e<>(k, v, j);
        this.b.put(k, eVar);
        e<K, V> eVar2 = ((e) this.j).c;
        e<K, V> eVar3 = this.j;
        if (eVar2 != eVar3) {
            while (j - ((e) eVar3).c.b < 0 && (eVar3 = ((e) eVar3).c) != this.j) {
            }
            eVar.h(eVar3);
            return;
        }
        eVar.h(eVar3);
    }

    public final V c(K k) {
        e<K, V> eVar;
        if (k == null || (eVar = this.b.get(k)) == null) {
            return null;
        }
        return c((e) eVar, (Iterator) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final V c(e<K, V> eVar, Iterator<e<K, V>> it) {
        if (!this.e || this.f16498a <= 0 || !eVar.b(this.f16498a)) {
            if (this.h) {
                eVar.i(this.j);
            }
            return (V) eVar.e();
        }
        if (it != null) {
            it.remove();
        } else {
            this.b.remove(eVar.b());
        }
        eVar.a();
        d(eVar.e());
        return null;
    }

    public final boolean b(K k) {
        e<K, V> eVar;
        if (k == null || (eVar = this.b.get(k)) == null) {
            return false;
        }
        eVar.i(this.j);
        return true;
    }

    public final V a(K k) {
        e<K, V> eVarRemove;
        if (k == null || (eVarRemove = this.b.remove(k)) == null) {
            return null;
        }
        eVarRemove.a();
        return (V) eVarRemove.e();
    }

    public final V c(K k, V v) {
        e<K, V> eVar;
        if (k == null || (eVar = this.b.get(k)) == null || eVar.e() != v) {
            return null;
        }
        this.b.remove(k);
        eVar.a();
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int e(int i) {
        int i2 = 0;
        while (true) {
            if (i != 0 && i2 >= i) {
                break;
            }
            e<K, V> eVar = ((e) this.j).e;
            if (this.j == eVar || !eVar.b(this.f16498a)) {
                break;
            }
            eVar.a();
            this.b.remove(eVar.b());
            d(eVar.e());
            i2++;
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V c(Predicate<V> predicate, boolean z) {
        if (predicate == 0) {
            return null;
        }
        Iterator<e<K, V>> it = this.b.values().iterator();
        while (it.hasNext()) {
            e<K, V> next = it.next();
            if (predicate.accept(next.e())) {
                V vC = c((e) next, (Iterator) it);
                if (z || vC != null) {
                    return vC;
                }
            }
        }
        return null;
    }

    public final Iterator<V> f() {
        return b(true);
    }

    public final Iterator<V> b(final boolean z) {
        final Iterator<e<K, V>> it = this.b.values().iterator();
        return new Iterator<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUsedCache.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private e<K, V> f16499a;
            private boolean c;

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
            
                r5.f16499a = r0;
             */
            @Override // java.util.Iterator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean hasNext() {
                /*
                    r5 = this;
                    boolean r0 = r5.c
                    r1 = 1
                    if (r0 != 0) goto L36
                    r0 = 0
                    r5.f16499a = r0
                L8:
                    java.util.Iterator r0 = r2
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L34
                    java.util.Iterator r0 = r2
                    java.lang.Object r0 = r0.next()
                    org.eclipse.californium.elements.util.LeastRecentlyUsedCache$e r0 = (org.eclipse.californium.elements.util.LeastRecentlyUsedCache.e) r0
                    boolean r2 = r3
                    if (r2 == 0) goto L32
                    org.eclipse.californium.elements.util.LeastRecentlyUsedCache r2 = org.eclipse.californium.elements.util.LeastRecentlyUsedCache.this
                    monitor-enter(r2)
                    org.eclipse.californium.elements.util.LeastRecentlyUsedCache r3 = org.eclipse.californium.elements.util.LeastRecentlyUsedCache.this     // Catch: java.lang.Throwable -> L2f
                    java.util.Iterator r4 = r2     // Catch: java.lang.Throwable -> L2f
                    java.lang.Object r3 = org.eclipse.californium.elements.util.LeastRecentlyUsedCache.b(r3, r0, r4)     // Catch: java.lang.Throwable -> L2f
                    if (r3 == 0) goto L2d
                    r5.f16499a = r0     // Catch: java.lang.Throwable -> L2f
                    monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
                    goto L34
                L2d:
                    monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
                    goto L8
                L2f:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
                    throw r0
                L32:
                    r5.f16499a = r0
                L34:
                    r5.c = r1
                L36:
                    org.eclipse.californium.elements.util.LeastRecentlyUsedCache$e<K, V> r0 = r5.f16499a
                    if (r0 == 0) goto L3b
                    goto L3c
                L3b:
                    r1 = 0
                L3c:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: org.eclipse.californium.elements.util.LeastRecentlyUsedCache.AnonymousClass3.hasNext():boolean");
            }

            @Override // java.util.Iterator
            public V next() {
                hasNext();
                this.c = false;
                e<K, V> eVar = this.f16499a;
                if (eVar == null) {
                    throw new NoSuchElementException();
                }
                return (V) ((e) eVar).f16500a;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public final Collection<V> i() {
        Collection<V> collection = this.f;
        if (collection != null) {
            return collection;
        }
        AbstractCollection<V> abstractCollection = new AbstractCollection<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUsedCache.4
            @Override // java.util.AbstractCollection, java.util.Collection
            public final int size() {
                return LeastRecentlyUsedCache.this.b.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final boolean contains(final Object obj) {
                return LeastRecentlyUsedCache.this.c((Predicate) new Predicate<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUsedCache.4.4
                    @Override // org.eclipse.californium.elements.util.LeastRecentlyUsedCache.Predicate
                    public boolean accept(V v) {
                        return v.equals(obj);
                    }
                }, false) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public final Iterator<V> iterator() {
                return LeastRecentlyUsedCache.this.f();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final boolean add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final void clear() {
                throw new UnsupportedOperationException();
            }
        };
        this.f = abstractCollection;
        return abstractCollection;
    }

    public final Iterator<d<V>> d() {
        return new Iterator<d<V>>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUsedCache.1
            final int b;
            int c;
            e<K, V> d;

            {
                this.b = LeastRecentlyUsedCache.this.b.size();
                this.d = LeastRecentlyUsedCache.this.j;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return ((e) this.d).e != LeastRecentlyUsedCache.this.j && this.c < this.b;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public d<V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.c++;
                e<K, V> eVar = ((e) this.d).e;
                this.d = eVar;
                return eVar.d();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    static class e<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final V f16500a;
        private long b;
        private e<K, V> c;
        private final K d;
        private e<K, V> e;

        private e() {
            this.d = null;
            this.f16500a = null;
            this.b = -1L;
        }

        private e(K k, V v) {
            this(k, v, ClockUtil.b());
        }

        private e(K k, V v, long j) {
            this.d = k;
            this.f16500a = v;
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public d<V> d() {
            return new d<>(this.f16500a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public K b() {
            return this.d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public V e() {
            return this.f16500a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(long j) {
            return ClockUtil.b() - this.b >= j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(e<K, V> eVar) {
            a();
            this.b = ClockUtil.b();
            h(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(e<K, V> eVar) {
            this.e = eVar;
            e<K, V> eVar2 = eVar.c;
            this.c = eVar2;
            eVar2.e = this;
            this.e.c = this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            e<K, V> eVar = this.c;
            eVar.e = this.e;
            this.e.c = eVar;
        }

        public String toString() {
            return "CacheEntry [key: " + this.d + ", last access: " + this.b + "]";
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public static final class d<V> {
        private final V d;
        private final long e;

        public d(V v, long j) {
            this.d = v;
            this.e = j;
        }

        public V a() {
            return this.d;
        }

        public long c() {
            return this.e;
        }

        public int hashCode() {
            long j = this.e;
            int i = (int) (j ^ (j >>> 32));
            V v = this.d;
            return v != null ? i + v.hashCode() : i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.e != dVar.e) {
                return false;
            }
            V v = this.d;
            if (v == null) {
                return dVar.d == null;
            }
            return v.equals(dVar.d);
        }

        public String toString() {
            return this.e + ": " + this.d;
        }
    }
}
