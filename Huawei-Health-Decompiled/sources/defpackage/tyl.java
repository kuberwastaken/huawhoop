package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class tyl {

    @SerializedName("huid")
    private long b;

    @SerializedName("createTime")
    private long c;

    @SerializedName("memberStatus")
    private int e;

    public void c(long j) {
        this.b = j;
    }

    public long e() {
        return this.b;
    }

    public void c(int i) {
        this.e = i;
    }

    public int b() {
        return this.e;
    }

    public long d() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tyl)) {
            return false;
        }
        tyl tylVar = (tyl) obj;
        return e() == tylVar.e() && b() == tylVar.b() && d() == tylVar.d();
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(e()), Integer.valueOf(b()), Long.valueOf(d()));
    }
}
