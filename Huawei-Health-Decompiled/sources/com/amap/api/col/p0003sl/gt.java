package com.amap.api.col.p0003sl;

import com.huawei.hms.network.embedded.k;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class gt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile gt f1005a;
    private HashMap<String, gu> b = new HashMap<>();

    public static gt a() {
        if (f1005a == null) {
            synchronized (gt.class) {
                if (f1005a == null) {
                    f1005a = new gt();
                }
            }
        }
        return f1005a;
    }

    public final gu a(String str) {
        gu guVar;
        synchronized (this) {
            guVar = this.b.get(str);
        }
        return guVar;
    }

    public final void a(String str, gu guVar) {
        synchronized (this) {
            this.b.put(str, guVar);
        }
    }

    public final c a(b bVar) {
        c cVarA;
        if (bVar == null) {
            return null;
        }
        for (gu guVar : this.b.values()) {
            if (guVar != null && (cVarA = guVar.a(bVar)) != null) {
                return cVarA;
            }
        }
        return null;
    }

    public final void a(b bVar, Object obj) {
        for (gu guVar : this.b.values()) {
            if (guVar != null) {
                guVar.a(bVar, obj);
            }
        }
    }

    public final boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (gu guVar : this.b.values()) {
            if (guVar != null && guVar.b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        for (gu guVar : this.b.values()) {
            if (guVar != null) {
                guVar.a(aVar);
            }
        }
    }

    public final void a(String str, a aVar) {
        gu guVar;
        if (str == null || aVar == null || (guVar = this.b.get(str)) == null) {
            return;
        }
        guVar.a(aVar);
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f1008a;
        boolean b;

        public c(Object obj, boolean z) {
            this.f1008a = obj;
            this.b = z;
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1007a;
        Object b;

        b() {
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.f1007a;
                if (str == null) {
                    return bVar.f1007a == null && this.b == bVar.b;
                }
                if (str.equals(bVar.f1007a) && this.b == bVar.b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f1007a;
            int iHashCode = str == null ? 0 : str.hashCode();
            Object obj = this.b;
            return ((iHashCode + 31) * 31) + (obj != null ? obj.hashCode() : 0);
        }
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1006a = true;
        private long b = k.b.m;
        private int c = 10;
        private double d = 0.0d;

        a() {
        }

        public final boolean a() {
            return this.f1006a;
        }

        public final void a(boolean z) {
            this.f1006a = z;
        }

        public final long b() {
            return this.b;
        }

        public final void a(long j) {
            this.b = j;
        }

        public final int c() {
            return this.c;
        }

        public final void a(int i) {
            this.c = i;
        }

        public final double d() {
            return this.d;
        }

        public final void a(double d) {
            this.d = d;
        }
    }
}
