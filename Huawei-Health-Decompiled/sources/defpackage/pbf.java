package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class pbf {

    @SerializedName(ParsedFieldTag.GOAL)
    private int b;

    @SerializedName("modifiedTime")
    private long c;

    public long b() {
        return this.c;
    }

    public void e(long j) {
        this.c = j;
    }

    public int e() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof pbf)) {
            return false;
        }
        pbf pbfVar = (pbf) obj;
        return pbfVar.b == this.b && pbfVar.c == this.c;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.b), Long.valueOf(this.c));
    }

    public String toString() {
        return "CircleGoalBean{mModifiedTime='" + this.c + "', mGoalValue=" + this.b + '}';
    }
}
