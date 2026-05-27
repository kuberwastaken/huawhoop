package org.eclipse.californium.elements.util;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes8.dex */
public class LeastRecentlyUpdatedCache<K, V> {
    public static final long e = TimeUnit.MINUTES.toSeconds(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<EvictionListener<V>> f16493a;
    private volatile long b;
    private volatile int c;
    private final ConcurrentMap<K, a<K, V>> d;
    private final a<K, V> g;
    private final ReentrantReadWriteLock i;
    private Collection<V> j;

    public interface EvictionListener<V> {
        void onEviction(V v);
    }

    public interface Predicate<V> {
        boolean accept(V v);
    }

    public LeastRecentlyUpdatedCache() {
        this(16, 150000, e, TimeUnit.SECONDS);
    }

    public LeastRecentlyUpdatedCache(int i, long j, TimeUnit timeUnit) {
        this(Math.min(i, 16), i, j, timeUnit);
    }

    public LeastRecentlyUpdatedCache(int i, int i2, long j, TimeUnit timeUnit) {
        this.i = new ReentrantReadWriteLock();
        this.g = new a<>();
        this.f16493a = new LinkedList();
        if (i > i2) {
            throw new IllegalArgumentException("initial capacity must be <= max capacity");
        }
        this.c = i2;
        this.d = new ConcurrentHashMap(i);
        c(j, timeUnit);
    }

    public final ReentrantReadWriteLock.ReadLock d() {
        return this.i.readLock();
    }

    public final ReentrantReadWriteLock.WriteLock i() {
        return this.i.writeLock();
    }

    public void a(EvictionListener<V> evictionListener) {
        if (evictionListener != null) {
            this.f16493a.add(evictionListener);
        }
    }

    public final long a(TimeUnit timeUnit) {
        return timeUnit.convert(this.b, TimeUnit.NANOSECONDS);
    }

    public final void c(long j, TimeUnit timeUnit) {
        this.b = timeUnit.toNanos(j);
    }

    public final int b() {
        return this.c;
    }

    public final int g() {
        return this.d.size();
    }

    public final int c() {
        return Math.max(0, this.c - this.d.size());
    }

    public final void e() {
        this.i.writeLock().lock();
        try {
            this.d.clear();
            a<K, V> aVar = this.g;
            if (aVar != ((a) aVar).e && ((a) this.g).e != null) {
                ((a) this.g).e.d = null;
            }
            a<K, V> aVar2 = this.g;
            if (aVar2 != ((a) aVar2).d && ((a) this.g).d != null) {
                ((a) this.g).d.e = null;
            }
            a<K, V> aVar3 = this.g;
            ((a) aVar3).e = ((a) aVar3).d = aVar3;
        } finally {
            this.i.writeLock().unlock();
        }
    }

    private final void a(V v) {
        if (v == null || this.f16493a.isEmpty()) {
            return;
        }
        Iterator<EvictionListener<V>> it = this.f16493a.iterator();
        while (it.hasNext()) {
            it.next().onEviction(v);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c(K k, V v) {
        Object objE;
        if (v == null) {
            return false;
        }
        this.i.writeLock().lock();
        try {
            a<K, V> aVar = this.d.get(k);
            if (aVar == null) {
                if (this.d.size() < this.c) {
                    b(k, v);
                } else {
                    a aVar2 = ((a) this.g).e;
                    if (aVar2.a(this.b)) {
                        aVar2.b();
                        this.d.remove(aVar2.c());
                        b(k, v);
                        objE = aVar2.e();
                    } else {
                        objE = null;
                    }
                    if (objE == null) {
                        return false;
                    }
                    a(objE);
                    return true;
                }
            } else {
                aVar.b();
                b(k, v);
            }
            return true;
        } finally {
            this.i.writeLock().unlock();
        }
    }

    private final void b(K k, V v) {
        a<K, V> aVar = new a<>(k, v);
        this.d.put(k, aVar);
        aVar.m(this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(K k, V v, long j) {
        Object objE;
        if (v == null) {
            return false;
        }
        this.i.writeLock().lock();
        try {
            a<K, V> aVar = this.d.get(k);
            if (aVar == null) {
                if (this.d.size() < this.c) {
                    b(k, v, j);
                } else {
                    a aVar2 = ((a) this.g).e;
                    if (!aVar2.a(this.b) || j - aVar2.c < 0) {
                        objE = null;
                    } else {
                        aVar2.b();
                        this.d.remove(aVar2.c());
                        b(k, v, j);
                        objE = aVar2.e();
                    }
                    if (objE == null) {
                        return false;
                    }
                    a(objE);
                    return true;
                }
            } else {
                aVar.b();
                b(k, v, j);
            }
            return true;
        } finally {
            this.i.writeLock().unlock();
        }
    }

    private final void b(K k, V v, long j) {
        a<K, V> aVar = new a<>(k, v, j);
        this.d.put(k, aVar);
        a<K, V> aVar2 = ((a) this.g).d;
        a<K, V> aVar3 = this.g;
        if (aVar2 != aVar3) {
            while (j - ((a) aVar3).d.c < 0 && (aVar3 = ((a) aVar3).d) != this.g) {
            }
            aVar.m(aVar3);
            return;
        }
        aVar.m(aVar3);
    }

    private final a<K, V> d(K k) {
        if (k == null) {
            return null;
        }
        return this.d.get(k);
    }

    public final boolean b(K k) {
        a<K, V> aVarD = d(k);
        if (aVarD == null) {
            return false;
        }
        return aVarD.a(this.b);
    }

    public final V e(K k) {
        a<K, V> aVarD = d(k);
        if (aVarD == null) {
            return null;
        }
        return (V) aVarD.e();
    }

    public final V c(K k) {
        if (k == null) {
            return null;
        }
        this.i.writeLock().lock();
        try {
            a<K, V> aVar = this.d.get(k);
            if (aVar == null) {
                return null;
            }
            aVar.k(this.g);
            return (V) aVar.e();
        } finally {
            this.i.writeLock().unlock();
        }
    }

    public final V a(K k, V v) {
        if (k == null) {
            return null;
        }
        this.i.writeLock().lock();
        try {
            a<K, V> aVar = this.d.get(k);
            if (aVar == null || aVar.e() != v) {
                return null;
            }
            this.d.remove(k);
            aVar.b();
            return v;
        } finally {
            this.i.writeLock().unlock();
        }
    }

    public final V e(Predicate<V> predicate) {
        if (predicate == null) {
            return null;
        }
        Iterator<a<K, V>> it = this.d.values().iterator();
        while (it.hasNext()) {
            V v = (V) it.next().e();
            if (predicate.accept(v)) {
                return v;
            }
        }
        return null;
    }

    public final Iterator<V> f() {
        return new Iterator<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUpdatedCache.2
            private volatile boolean b;
            private volatile a<K, V> c;
            private final Iterator<a<K, V>> d;

            {
                this.d = LeastRecentlyUpdatedCache.this.d.values().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (!this.b) {
                    this.c = null;
                    if (this.d.hasNext()) {
                        this.c = this.d.next();
                    }
                    this.b = true;
                }
                return this.c != null;
            }

            @Override // java.util.Iterator
            public V next() {
                hasNext();
                this.b = false;
                if (this.c == null) {
                    throw new NoSuchElementException();
                }
                return (V) ((a) this.c).i;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.c != null && !this.b) {
                    try {
                        LeastRecentlyUpdatedCache.this.i.writeLock().lock();
                        this.d.remove();
                        this.c.b();
                        LeastRecentlyUpdatedCache.this.i.writeLock().unlock();
                        this.c = null;
                        return;
                    } catch (Throwable th) {
                        LeastRecentlyUpdatedCache.this.i.writeLock().unlock();
                        throw th;
                    }
                }
                throw new IllegalStateException("next() must be called before remove()!");
            }
        };
    }

    public final Collection<V> j() {
        Collection<V> collection = this.j;
        if (collection != null) {
            return collection;
        }
        AbstractCollection<V> abstractCollection = new AbstractCollection<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUpdatedCache.5
            @Override // java.util.AbstractCollection, java.util.Collection
            public final int size() {
                return LeastRecentlyUpdatedCache.this.d.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public final boolean contains(final Object obj) {
                return LeastRecentlyUpdatedCache.this.e((Predicate) new Predicate<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUpdatedCache.5.2
                    @Override // org.eclipse.californium.elements.util.LeastRecentlyUpdatedCache.Predicate
                    public boolean accept(V v) {
                        return v.equals(obj);
                    }
                }) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public final Iterator<V> iterator() {
                return LeastRecentlyUpdatedCache.this.f();
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
        this.j = abstractCollection;
        return abstractCollection;
    }

    public final Iterator<V> a() {
        return new Iterator<V>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUpdatedCache.3
            final Iterator<a<K, V>> c;

            {
                this.c = new e();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.c.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return (V) ((a) this.c.next()).i;
            }

            @Override // java.util.Iterator
            public void remove() {
                this.c.remove();
            }
        };
    }

    public final Iterator<d<V>> h() {
        return new Iterator<d<V>>() { // from class: org.eclipse.californium.elements.util.LeastRecentlyUpdatedCache.4
            final Iterator<a<K, V>> b;

            {
                this.b = new e();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d<V> next() {
                return this.b.next().a();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.b.remove();
            }
        };
    }

    class e implements Iterator<a<K, V>> {
        a<K, V> b;
        a<K, V> d;

        private e() {
            this.b = null;
            this.d = b(LeastRecentlyUpdatedCache.this.g);
        }

        public a<K, V> b(a<K, V> aVar) {
            return LeastRecentlyUpdatedCache.this.d((a) aVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a<K, V> aVar;
            while (this.d != LeastRecentlyUpdatedCache.this.g && (aVar = this.d) != null && aVar.d()) {
                this.d = b(this.d);
            }
            a<K, V> aVar2 = this.d;
            return (aVar2 == null || aVar2.d()) ? false : true;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a<K, V> next() {
            this.b = this.d;
            if (hasNext()) {
                this.b = this.d;
            } else {
                a<K, V> aVar = this.b;
                if (aVar == null || aVar == LeastRecentlyUpdatedCache.this.g) {
                    throw new NoSuchElementException();
                }
            }
            this.d = b(this.d);
            hasNext();
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            a<K, V> aVar = this.b;
            if (aVar == null) {
                throw new IllegalStateException("next() must be called before remove()!");
            }
            LeastRecentlyUpdatedCache.this.a(((a) aVar).f16497a, ((a) this.b).i);
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a<K, V> d(a<K, V> aVar) {
        try {
            this.i.readLock().lock();
            return ((a) aVar).e;
        } finally {
            this.i.readLock().unlock();
        }
    }

    static class a<K, V> {
        private static long b = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f16497a;
        private volatile long c;
        private a<K, V> d;
        private a<K, V> e;
        private final V i;

        private a() {
            this.f16497a = null;
            this.i = null;
            this.c = b;
            this.e = this;
            this.d = this;
        }

        private a(K k, V v) {
            this(k, v, ClockUtil.b());
        }

        private a(K k, V v, long j) {
            this.f16497a = k;
            this.i = v;
            this.c = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final d<V> a() {
            return new d<>(this.i, this.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final K c() {
            return this.f16497a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final V e() {
            return this.i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean a(long j) {
            return ClockUtil.b() - this.c >= j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean k(a<K, V> aVar) {
            if (!b()) {
                return false;
            }
            this.c = ClockUtil.b();
            m(aVar);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void m(a<K, V> aVar) {
            this.e = aVar;
            a<K, V> aVar2 = aVar.d;
            this.d = aVar2;
            aVar2.e = this;
            this.e.d = this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            if (this.d == null || this.e == null) {
                return false;
            }
            this.c = b;
            a<K, V> aVar = this.d;
            aVar.e = this.e;
            this.e.d = aVar;
            this.d = null;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d() {
            return this.c == b;
        }

        public String toString() {
            return "CacheEntry [key: " + this.f16497a + ", last access: " + this.c + "]";
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    public static final class d<V> {
        private final long b;
        private final V e;

        public d(V v, long j) {
            this.e = v;
            this.b = j;
        }

        public final V a() {
            return this.e;
        }

        public final long d() {
            return this.b;
        }

        public int hashCode() {
            long j = this.b;
            int i = (int) (j ^ (j >>> 32));
            V v = this.e;
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
            if (this.b != dVar.b) {
                return false;
            }
            V v = this.e;
            if (v == null) {
                return dVar.e == null;
            }
            return v.equals(dVar.e);
        }

        public String toString() {
            return this.b + ": " + this.e;
        }
    }
}
