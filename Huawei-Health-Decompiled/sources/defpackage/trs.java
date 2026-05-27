package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class trs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("kiloCalorie")
    private float f18126a;

    @SerializedName("index")
    private int b;

    @SerializedName("modifiedTime")
    private long c;

    @SerializedName("eatTime")
    private long d;

    @SerializedName("foodDescriptors")
    private List<trj> e;

    @SerializedName("setTime")
    private long f;

    @SerializedName("timeZone")
    private String g;

    @SerializedName("sugRange")
    private int[] i;

    @SerializedName("whichMeal")
    private int j;

    public trs(int i, long j, int i2, List<trj> list) {
        this.j = i;
        this.d = j;
        this.f18126a = i2;
        this.e = new ArrayList(list);
    }

    public void c(String str) {
        this.g = str;
    }

    public void l() {
        if (String.valueOf(this.d).matches("\\d{13}")) {
            this.d /= 1000;
        }
        if (mgx.d(this.e)) {
            return;
        }
        Iterator<trj> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    public void m() {
        if (String.valueOf(this.d).matches("\\d{10}")) {
            this.d *= 1000;
        }
        if (mgx.d(this.e)) {
            return;
        }
        Iterator<trj> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    public long g() {
        return this.f;
    }

    public void d(long j) {
        this.f = j;
    }

    public int c() {
        return this.b;
    }

    public int f() {
        return this.j;
    }

    public long a() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public long h() {
        return this.c;
    }

    public void b(long j) {
        this.c = j;
    }

    public float e() {
        return this.f18126a;
    }

    public void d(float f) {
        this.f18126a = f;
    }

    public List<trj> b() {
        return this.e;
    }

    public int[] i() {
        return this.i;
    }

    public void a(int[] iArr) {
        this.i = iArr;
    }

    public float d() {
        float fH = 0.0f;
        if (mgx.d(this.e)) {
            return 0.0f;
        }
        Iterator<trj> it = this.e.iterator();
        while (it.hasNext()) {
            fH += it.next().h();
        }
        return fH;
    }

    public String j() {
        return this.g;
    }

    public int hashCode() {
        if (f() != 0) {
            return Integer.valueOf(f()).hashCode() + Integer.valueOf(c()).hashCode();
        }
        return Long.valueOf(a()).hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof trs)) {
            return false;
        }
        trs trsVar = (trs) obj;
        return f() != 0 ? f() == trsVar.f() && c() == trsVar.c() : a() == trsVar.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Meal{whichMeal=");
        sb.append(this.j);
        sb.append(", eatTime=");
        sb.append(this.d);
        sb.append(", timeZone =");
        sb.append(this.g);
        sb.append(", setTime=");
        sb.append(this.f);
        sb.append(", index=");
        sb.append(this.b);
        sb.append(", kcal=");
        sb.append(this.f18126a);
        sb.append(", modifiedTime=");
        sb.append(this.c);
        sb.append(", sugRange=");
        sb.append(this.i);
        sb.append(", foodDescriptors=");
        List<trj> list = this.e;
        sb.append(list == null ? new ArrayList() : list.toString());
        sb.append('}');
        return sb.toString();
    }
}
