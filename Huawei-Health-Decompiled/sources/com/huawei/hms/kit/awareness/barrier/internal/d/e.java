package com.huawei.hms.kit.awareness.barrier.internal.d;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes10.dex */
public class e extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f5058a = 180.0d;
    private static final double b = -180.0d;
    private static final double c = 90.0d;
    private static final double d = -90.0d;
    private static final double e = 50.0d;
    private static final int f = 1000;
    private static final int l = 1000;
    private static final String m = "#";
    private final double g;
    private final double h;
    private final double i;
    private final long j;
    private final com.huawei.hms.kit.awareness.barrier.internal.type.g k;
    private double q;
    private int r;
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.huawei.hms.kit.awareness.barrier.internal.d.e.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return e.b(new e(parcel));
        }
    };
    private static final DecimalFormat n = new DecimalFormat("#.#######");
    private static final DecimalFormat o = new DecimalFormat("##");
    private static final ConcurrentHashMap<String, e> p = new ConcurrentHashMap<>();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.g);
        parcel.writeDouble(this.h);
        parcel.writeDouble(this.i);
        parcel.writeLong(this.j);
        parcel.writeString(this.k.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = n;
        sb.append(decimalFormat.format(this.g));
        sb.append("#");
        sb.append(decimalFormat.format(this.h));
        sb.append("#");
        sb.append(o.format(this.i));
        sb.append("#");
        sb.append(this.j);
        sb.append("#");
        sb.append(this.k);
        return new String(com.huawei.hms.kit.awareness.barrier.internal.f.a.a(sb.toString().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

    public int i() {
        return this.r;
    }

    public int hashCode() {
        return (int) (Math.round(this.g * 1000.0d) + Math.round(this.h * 1000.0d));
    }

    public double h() {
        return this.q;
    }

    @Override // com.huawei.hms.kit.awareness.barrier.internal.d.f
    public boolean g() {
        double d2 = this.g;
        if (d2 <= f5058a && d2 >= b) {
            double d3 = this.h;
            if (d3 <= c && d3 >= d && this.i > 0.0d && this.j >= 0) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        p.remove(toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (eVar.e() != e()) {
            return false;
        }
        double dA = com.huawei.hms.kit.awareness.b.a.e.a(eVar.a(), eVar.b(), this.g, this.h) * 1000.0d;
        int i = AnonymousClass2.f5059a[eVar.e().ordinal()];
        if (i == 1) {
            return Math.abs(eVar.c() - this.i) < e && dA < e && eVar.d() == this.j;
        }
        if (i == 2 || i == 3) {
            return Math.abs(eVar.c() - this.i) < e && dA < e;
        }
        return false;
    }

    public com.huawei.hms.kit.awareness.barrier.internal.type.g e() {
        return this.k;
    }

    public long d() {
        return this.j;
    }

    public double c() {
        return this.i;
    }

    public double b() {
        return this.h;
    }

    public void a(Location location) {
        if (location == null) {
            return;
        }
        double dA = com.huawei.hms.kit.awareness.b.a.e.a(a(), b(), location.getLongitude(), location.getLatitude()) * 1000.0d;
        com.huawei.hms.kit.awareness.barrier.internal.type.g gVarE = e();
        com.huawei.hms.kit.awareness.barrier.internal.type.g gVar = com.huawei.hms.kit.awareness.barrier.internal.type.g.EXITING;
        double dC = c();
        a((gVarE != gVar ? dA < dC : dA >= dC) ? 1 : 0);
    }

    public void a(int i) {
        this.r = i;
    }

    public void a(double d2) {
        this.q = d2;
    }

    public double a() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e b(e eVar) {
        e eVarPutIfAbsent = p.putIfAbsent(eVar.toString(), eVar);
        return eVarPutIfAbsent != null ? eVarPutIfAbsent : eVar;
    }

    public static e a(String str) {
        return p.get(str);
    }

    public static e a(double d2, double d3, double d4, long j, com.huawei.hms.kit.awareness.barrier.internal.type.g gVar) {
        return b(new e(d2, d3, d4, j, gVar));
    }

    private e(Parcel parcel) {
        this.g = parcel.readDouble();
        this.h = parcel.readDouble();
        this.i = parcel.readDouble();
        this.j = parcel.readLong();
        this.k = com.huawei.hms.kit.awareness.barrier.internal.type.g.valueOf(parcel.readString());
    }

    /* JADX INFO: renamed from: com.huawei.hms.kit.awareness.barrier.internal.d.e$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5059a;

        static {
            int[] iArr = new int[com.huawei.hms.kit.awareness.barrier.internal.type.g.values().length];
            f5059a = iArr;
            try {
                iArr[com.huawei.hms.kit.awareness.barrier.internal.type.g.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5059a[com.huawei.hms.kit.awareness.barrier.internal.type.g.EXITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5059a[com.huawei.hms.kit.awareness.barrier.internal.type.g.ENTERING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private e(double d2, double d3, double d4, long j, com.huawei.hms.kit.awareness.barrier.internal.type.g gVar) {
        this.g = d2;
        this.h = d3;
        this.i = d4;
        this.j = j;
        this.k = gVar;
    }
}
