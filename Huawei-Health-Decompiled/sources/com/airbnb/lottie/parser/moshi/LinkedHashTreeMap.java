package com.airbnb.lottie.parser.moshi;

import defpackage.iv;
import defpackage.iw;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> g = new Comparator<Comparable>() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.3
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c<K, V>[] f729a;
    Comparator<? super K> b;
    int c;
    final c<K, V> d;
    int e;
    private LinkedHashTreeMap<K, V>.b f;
    private LinkedHashTreeMap<K, V>.e i;
    int j;

    private static int d(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 ^ (i2 >>> 7)) ^ (i2 >>> 4);
    }

    LinkedHashTreeMap() {
        this(null);
    }

    LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.c = 0;
        this.e = 0;
        this.b = comparator == null ? g : comparator;
        this.d = new c<>();
        this.f729a = new c[16];
        this.j = 12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        c<K, V> cVarD = d(obj);
        if (cVarD != null) {
            return cVarD.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        c<K, V> cVarC = c((Object) k, true);
        V v2 = cVarC.h;
        cVarC.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.f729a, (Object) null);
        this.c = 0;
        this.e++;
        c<K, V> cVar = this.d;
        c<K, V> cVar2 = cVar.f731a;
        while (cVar2 != cVar) {
            c<K, V> cVar3 = cVar2.f731a;
            cVar2.j = null;
            cVar2.f731a = null;
            cVar2 = cVar3;
        }
        cVar.j = cVar;
        cVar.f731a = cVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        c<K, V> cVarB = b(obj);
        if (cVarB != null) {
            return cVarB.h;
        }
        return null;
    }

    c<K, V> c(K k, boolean z) {
        int iCompare;
        c<K, V> cVar;
        Comparator<? super K> comparator = this.b;
        c<K, V>[] cVarArr = this.f729a;
        int iD = d(k.hashCode());
        int length = (cVarArr.length - 1) & iD;
        c<K, V> cVar2 = cVarArr[length];
        if (cVar2 != null) {
            Comparable comparable = comparator == g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    iCompare = comparable.compareTo(cVar2.c);
                } else {
                    iCompare = comparator.compare(k, cVar2.c);
                }
                if (iCompare == 0) {
                    return cVar2;
                }
                c<K, V> cVar3 = iCompare < 0 ? cVar2.e : cVar2.g;
                if (cVar3 == null) {
                    break;
                }
                cVar2 = cVar3;
            }
        } else {
            iCompare = 0;
        }
        c<K, V> cVar4 = cVar2;
        int i = iCompare;
        if (!z) {
            return null;
        }
        c<K, V> cVar5 = this.d;
        if (cVar4 == null) {
            if (comparator == g && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            cVar = new c<>(cVar4, k, iD, cVar5, cVar5.j);
            cVarArr[length] = cVar;
        } else {
            cVar = new c<>(cVar4, k, iD, cVar5, cVar5.j);
            if (i < 0) {
                cVar4.e = cVar;
            } else {
                cVar4.g = cVar;
            }
            b((c) cVar4, true);
        }
        int i2 = this.c;
        this.c = i2 + 1;
        if (i2 > this.j) {
            d();
        }
        this.e++;
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    c<K, V> d(Object obj) {
        if (obj != 0) {
            try {
                return c(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    c<K, V> d(Map.Entry<?, ?> entry) {
        c<K, V> cVarD = d(entry.getKey());
        if (cVarD == null || !b(cVarD.h, entry.getValue())) {
            return null;
        }
        return cVarD;
    }

    private boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void c(c<K, V> cVar, boolean z) {
        int i;
        if (z) {
            cVar.j.f731a = cVar.f731a;
            cVar.f731a.j = cVar.j;
            cVar.j = null;
            cVar.f731a = null;
        }
        c<K, V> cVar2 = cVar.e;
        c<K, V> cVar3 = cVar.g;
        c<K, V> cVar4 = cVar.i;
        int i2 = 0;
        if (cVar2 != null && cVar3 != null) {
            c<K, V> cVarE = cVar2.d > cVar3.d ? cVar2.e() : cVar3.b();
            c((c) cVarE, false);
            c<K, V> cVar5 = cVar.e;
            if (cVar5 != null) {
                i = cVar5.d;
                cVarE.e = cVar5;
                cVar5.i = cVarE;
                cVar.e = null;
            } else {
                i = 0;
            }
            c<K, V> cVar6 = cVar.g;
            if (cVar6 != null) {
                i2 = cVar6.d;
                cVarE.g = cVar6;
                cVar6.i = cVarE;
                cVar.g = null;
            }
            cVarE.d = Math.max(i, i2) + 1;
            e(cVar, cVarE);
            return;
        }
        if (cVar2 != null) {
            e(cVar, cVar2);
            cVar.e = null;
        } else if (cVar3 != null) {
            e(cVar, cVar3);
            cVar.g = null;
        } else {
            e(cVar, null);
        }
        b((c) cVar4, false);
        this.c--;
        this.e++;
    }

    c<K, V> b(Object obj) {
        c<K, V> cVarD = d(obj);
        if (cVarD != null) {
            c((c) cVarD, true);
        }
        return cVarD;
    }

    private void e(c<K, V> cVar, c<K, V> cVar2) {
        c<K, V> cVar3 = cVar.i;
        cVar.i = null;
        if (cVar2 != null) {
            cVar2.i = cVar3;
        }
        if (cVar3 != null) {
            if (cVar3.e == cVar) {
                cVar3.e = cVar2;
                return;
            } else {
                cVar3.g = cVar2;
                return;
            }
        }
        int i = cVar.b;
        this.f729a[i & (r0.length - 1)] = cVar2;
    }

    private void b(c<K, V> cVar, boolean z) {
        while (cVar != null) {
            c<K, V> cVar2 = cVar.e;
            c<K, V> cVar3 = cVar.g;
            int i = cVar2 != null ? cVar2.d : 0;
            int i2 = cVar3 != null ? cVar3.d : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                c<K, V> cVar4 = cVar3.e;
                c<K, V> cVar5 = cVar3.g;
                int i4 = (cVar4 != null ? cVar4.d : 0) - (cVar5 != null ? cVar5.d : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    a(cVar);
                } else {
                    b((c) cVar3);
                    a(cVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                c<K, V> cVar6 = cVar2.e;
                c<K, V> cVar7 = cVar2.g;
                int i5 = (cVar6 != null ? cVar6.d : 0) - (cVar7 != null ? cVar7.d : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    b((c) cVar);
                } else {
                    a(cVar2);
                    b((c) cVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                cVar.d = i + 1;
                if (z) {
                    return;
                }
            } else {
                cVar.d = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            cVar = cVar.i;
        }
    }

    private void a(c<K, V> cVar) {
        c<K, V> cVar2 = cVar.e;
        c<K, V> cVar3 = cVar.g;
        c<K, V> cVar4 = cVar3.e;
        c<K, V> cVar5 = cVar3.g;
        cVar.g = cVar4;
        if (cVar4 != null) {
            cVar4.i = cVar;
        }
        e(cVar, cVar3);
        cVar3.e = cVar;
        cVar.i = cVar3;
        cVar.d = Math.max(cVar2 != null ? cVar2.d : 0, cVar4 != null ? cVar4.d : 0) + 1;
        cVar3.d = Math.max(cVar.d, cVar5 != null ? cVar5.d : 0) + 1;
    }

    private void b(c<K, V> cVar) {
        c<K, V> cVar2 = cVar.e;
        c<K, V> cVar3 = cVar.g;
        c<K, V> cVar4 = cVar2.e;
        c<K, V> cVar5 = cVar2.g;
        cVar.e = cVar5;
        if (cVar5 != null) {
            cVar5.i = cVar;
        }
        e(cVar, cVar2);
        cVar2.g = cVar;
        cVar.i = cVar2;
        cVar.d = Math.max(cVar3 != null ? cVar3.d : 0, cVar5 != null ? cVar5.d : 0) + 1;
        cVar2.d = Math.max(cVar.d, cVar4 != null ? cVar4.d : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.b bVar = this.f;
        if (bVar != null) {
            return bVar;
        }
        LinkedHashTreeMap<K, V>.b bVar2 = new b();
        this.f = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.e eVar = this.i;
        if (eVar != null) {
            return eVar;
        }
        LinkedHashTreeMap<K, V>.e eVar2 = new e();
        this.i = eVar2;
        return eVar2;
    }

    public static final class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c<K, V> f731a;
        final int b;
        public final K c;
        int d;
        c<K, V> e;
        c<K, V> g;
        V h;
        c<K, V> i;
        c<K, V> j;

        c() {
            this.c = null;
            this.b = -1;
            this.j = this;
            this.f731a = this;
        }

        c(c<K, V> cVar, K k, int i, c<K, V> cVar2, c<K, V> cVar3) {
            this.i = cVar;
            this.c = k;
            this.b = i;
            this.d = 1;
            this.f731a = cVar2;
            this.j = cVar3;
            cVar3.f731a = this;
            cVar2.j = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.c;
                if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                    V v = this.h;
                    if (v != null ? v.equals(entry.getValue()) : entry.getValue() == null) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.c;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.h;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        public String toString() {
            return this.c + "=" + this.h;
        }

        public c<K, V> b() {
            c<K, V> cVar = this;
            for (c<K, V> cVar2 = this.e; cVar2 != null; cVar2 = cVar2.e) {
                cVar = cVar2;
            }
            return cVar;
        }

        public c<K, V> e() {
            c<K, V> cVar = this;
            for (c<K, V> cVar2 = this.g; cVar2 != null; cVar2 = cVar2.g) {
                cVar = cVar2;
            }
            return cVar;
        }
    }

    private void d() {
        c<K, V>[] cVarArrD = d((c[]) this.f729a);
        this.f729a = cVarArrD;
        this.j = (cVarArrD.length / 2) + (cVarArrD.length / 4);
    }

    static <K, V> c<K, V>[] d(c<K, V>[] cVarArr) {
        int length = cVarArr.length;
        c<K, V>[] cVarArr2 = new c[length * 2];
        d dVar = new d();
        a aVar = new a();
        a aVar2 = new a();
        for (int i = 0; i < length; i++) {
            c<K, V> cVar = cVarArr[i];
            if (cVar != null) {
                dVar.a(cVar);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    c<K, V> cVarD = dVar.d();
                    if (cVarD == null) {
                        break;
                    }
                    if ((cVarD.b & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                aVar.d(i2);
                aVar2.d(i3);
                dVar.a(cVar);
                while (true) {
                    c<K, V> cVarD2 = dVar.d();
                    if (cVarD2 == null) {
                        break;
                    }
                    if ((cVarD2.b & length) == 0) {
                        aVar.b(cVarD2);
                    } else {
                        aVar2.b(cVarD2);
                    }
                }
                cVarArr2[i] = i2 > 0 ? aVar.a() : null;
                cVarArr2[i + length] = i3 > 0 ? aVar2.a() : null;
            }
        }
        return cVarArr2;
    }

    static class d<K, V> {
        private c<K, V> c;

        d() {
        }

        void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            while (cVar != null) {
                cVar.i = cVar2;
                cVar2 = cVar;
                cVar = cVar.e;
            }
            this.c = cVar2;
        }

        public c<K, V> d() {
            c<K, V> cVar = this.c;
            if (cVar == null) {
                return null;
            }
            c<K, V> cVar2 = cVar.i;
            cVar.i = null;
            for (c<K, V> cVar3 = cVar.g; cVar3 != null; cVar3 = cVar3.e) {
                cVar3.i = cVar2;
                cVar2 = cVar3;
            }
            this.c = cVar2;
            return cVar;
        }
    }

    static final class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c<K, V> f730a;
        private int b;
        private int c;
        private int e;

        a() {
        }

        void d(int i) {
            this.e = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.b = 0;
            this.c = 0;
            this.f730a = null;
        }

        void b(c<K, V> cVar) {
            cVar.g = null;
            cVar.i = null;
            cVar.e = null;
            cVar.d = 1;
            int i = this.e;
            if (i > 0) {
                int i2 = this.b;
                if ((i2 & 1) == 0) {
                    this.b = i2 + 1;
                    this.e = i - 1;
                    this.c++;
                }
            }
            cVar.i = this.f730a;
            this.f730a = cVar;
            int i3 = this.b;
            int i4 = i3 + 1;
            this.b = i4;
            int i5 = this.e;
            if (i5 > 0 && (i4 & 1) == 0) {
                this.b = i3 + 2;
                this.e = i5 - 1;
                this.c++;
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.b & i7) != i7) {
                    return;
                }
                int i8 = this.c;
                if (i8 == 0) {
                    c<K, V> cVar2 = this.f730a;
                    c<K, V> cVar3 = cVar2.i;
                    c<K, V> cVar4 = cVar3.i;
                    cVar3.i = cVar4.i;
                    this.f730a = cVar3;
                    cVar3.e = cVar4;
                    cVar3.g = cVar2;
                    cVar3.d = cVar2.d + 1;
                    cVar4.i = cVar3;
                    cVar2.i = cVar3;
                } else if (i8 == 1) {
                    c<K, V> cVar5 = this.f730a;
                    c<K, V> cVar6 = cVar5.i;
                    this.f730a = cVar6;
                    cVar6.g = cVar5;
                    cVar6.d = cVar5.d + 1;
                    cVar5.i = cVar6;
                    this.c = 0;
                } else if (i8 == 2) {
                    this.c = 0;
                }
                i6 *= 2;
            }
        }

        c<K, V> a() {
            c<K, V> cVar = this.f730a;
            if (cVar.i == null) {
                return cVar;
            }
            throw new IllegalStateException();
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        c<K, V> lastReturned = null;
        c<K, V> next;

        public LinkedTreeMapIterator() {
            this.next = LinkedHashTreeMap.this.d.f731a;
            this.expectedModCount = LinkedHashTreeMap.this.e;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != LinkedHashTreeMap.this.d;
        }

        protected final c<K, V> nextNode() {
            c<K, V> cVar = this.next;
            if (cVar == LinkedHashTreeMap.this.d) {
                throw new NoSuchElementException();
            }
            if (LinkedHashTreeMap.this.e != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.next = cVar.f731a;
            this.lastReturned = cVar;
            return cVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            c<K, V> cVar = this.lastReturned;
            if (cVar == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.c((c) cVar, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedHashTreeMap.this.e;
        }
    }

    public final class b extends AbstractSet<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new iw(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.d((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            c<K, V> cVarD;
            if (!(obj instanceof Map.Entry) || (cVarD = LinkedHashTreeMap.this.d((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.c((c) cVarD, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    public final class e extends AbstractSet<K> {
        e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new iv(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
