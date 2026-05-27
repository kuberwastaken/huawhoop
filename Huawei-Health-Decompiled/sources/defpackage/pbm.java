package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class pbm {

    @SerializedName("modify_timestamp")
    private long b;

    @SerializedName("switch")
    private String c;

    public long b() {
        return this.b;
    }

    public void b(long j) {
        this.b = j;
    }

    public String a() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof pbm)) {
            return false;
        }
        pbm pbmVar = (pbm) obj;
        return Objects.equals(this.c, pbmVar.c) && pbmVar.b == this.b;
    }

    public int hashCode() {
        return Objects.hash(this.c, Long.valueOf(this.b));
    }

    public String toString() {
        return "SportSwitchBean{mModifiedTime='" + this.b + "', mSwitch=" + this.c + '}';
    }
}
