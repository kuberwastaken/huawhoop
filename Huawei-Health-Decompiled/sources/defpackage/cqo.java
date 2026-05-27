package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cqo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("recordDays")
    private List<Long> f11989a;

    @SerializedName("id")
    private long c;

    @SerializedName("status")
    private int d;

    @SerializedName("completeValue")
    private double e;

    public void e(long j) {
        this.c = j;
    }

    public void e(double d) {
        this.e = d;
    }

    public void c(List<Long> list) {
        this.f11989a = list;
    }

    public void c(int i) {
        this.d = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("UpdateGoalBean{id=");
        stringBuffer.append(this.c);
        stringBuffer.append(", completeValue=").append(this.e);
        stringBuffer.append(", recordDays=").append(this.f11989a);
        stringBuffer.append(", status=").append(this.d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
