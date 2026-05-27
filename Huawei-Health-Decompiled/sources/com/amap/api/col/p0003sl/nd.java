package com.amap.api.col.p0003sl;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class nd {
    private static volatile nd g;
    private static Object h = new Object();
    private Object e = new Object();
    private Object f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LongSparseArray<a> f1294a = new LongSparseArray<>();
    private LongSparseArray<a> b = new LongSparseArray<>();
    private LongSparseArray<a> c = new LongSparseArray<>();
    private LongSparseArray<a> d = new LongSparseArray<>();

    public static nd a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new nd();
                }
            }
        }
        return g;
    }

    private nd() {
    }

    final void a(List<nc> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.e) {
            a(list, this.f1294a, this.b);
            LongSparseArray<a> longSparseArray = this.f1294a;
            this.f1294a = this.b;
            this.b = longSparseArray;
            longSparseArray.clear();
        }
    }

    final short a(long j) {
        return a(this.f1294a, j);
    }

    final void b(List<nc> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f) {
            a(list, this.c, this.d);
            LongSparseArray<a> longSparseArray = this.c;
            this.c = this.d;
            this.d = longSparseArray;
            longSparseArray.clear();
        }
    }

    final short b(long j) {
        return a(this.c, j);
    }

    private static void a(List<nc> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long jB = b();
        byte b = 0;
        if (longSparseArray.size() == 0) {
            for (nc ncVar : list) {
                a aVar = new a(b);
                aVar.f1295a = ncVar.b();
                aVar.b = jB;
                aVar.c = false;
                longSparseArray2.put(ncVar.a(), aVar);
            }
            return;
        }
        for (nc ncVar2 : list) {
            long jA = ncVar2.a();
            a aVar2 = longSparseArray.get(jA);
            if (aVar2 == null) {
                aVar2 = new a(b);
                aVar2.f1295a = ncVar2.b();
                aVar2.b = jB;
                aVar2.c = true;
            } else if (aVar2.f1295a != ncVar2.b()) {
                aVar2.f1295a = ncVar2.b();
                aVar2.b = jB;
                aVar2.c = true;
            }
            longSparseArray2.put(jA, aVar2);
        }
    }

    private static short a(LongSparseArray<a> longSparseArray, long j) {
        synchronized (longSparseArray) {
            a aVar = longSparseArray.get(j);
            if (aVar == null) {
                return (short) 0;
            }
            short sMax = (short) Math.max(1L, Math.min(32767L, (b() - aVar.b) / 1000));
            if (!aVar.c) {
                sMax = (short) (-sMax);
            }
            return sMax;
        }
    }

    private static long b() {
        return SystemClock.elapsedRealtime();
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1295a;
        long b;
        boolean c;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }
}
