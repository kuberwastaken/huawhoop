package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class ixv implements Serializable {
    private static final long serialVersionUID = 484486622498584045L;

    @SerializedName("spKey")
    private String b;

    @SerializedName("spIntervalKm")
    private int c;

    public ixv(String str, int i) {
        this.b = str;
        this.c = i;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.b, ((ixv) obj).b);
    }

    public int hashCode() {
        return Objects.hash(this.b, Integer.valueOf(this.c));
    }
}
