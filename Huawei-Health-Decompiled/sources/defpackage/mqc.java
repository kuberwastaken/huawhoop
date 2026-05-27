package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class mqc {

    @SerializedName("endTime")
    private long b;

    @SerializedName("startTime")
    private long d;

    private static boolean a(long j, long j2) {
        return j / 1000 == j2 / 1000;
    }

    public mqc(long j, long j2) {
        this.d = j;
        this.b = j2;
    }

    public long c() {
        return this.b;
    }

    public boolean c(long j, long j2) {
        return a(j, this.d) && a(j2, this.b);
    }

    public boolean e(long j, long j2) {
        return this.d == j && this.b == j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        mqc mqcVar = (mqc) obj;
        return this.d == mqcVar.d && this.b == mqcVar.b;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.d), Long.valueOf(this.b));
    }
}
