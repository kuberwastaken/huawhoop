package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class tyj {

    @SerializedName("mFollowStatus")
    private int b;

    @SerializedName("mHuid")
    private long e;

    public long b() {
        return this.e;
    }

    public int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tyj)) {
            return false;
        }
        tyj tyjVar = (tyj) obj;
        return b() == tyjVar.b() && e() == tyjVar.e();
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(b()), Integer.valueOf(e()));
    }
}
