package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ozl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("daysNeed")
    private int f16574a;

    @SerializedName("item")
    private String c;
    private int d;

    public int a() {
        return this.f16574a;
    }

    public String d() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || this.c == null) {
            return false;
        }
        ozl ozlVar = (ozl) obj;
        return this.f16574a == ozlVar.a() && this.c.equals(ozlVar.d());
    }

    public String toString() {
        return "DayRemains{daysNeed=" + this.f16574a + ", item='" + this.c + "'}";
    }
}
