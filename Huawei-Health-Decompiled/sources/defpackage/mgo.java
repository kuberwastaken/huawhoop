package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgo implements Serializable, TimeSequence {
    private static final long serialVersionUID = -2003020627619347417L;

    @SerializedName("mAltitude")
    private double b;

    @SerializedName("mTime")
    private long d;

    public mgo(long j, double d) {
        this.d = j;
        this.b = d;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.d;
    }

    public double c() {
        return this.b;
    }

    public String toString() {
        return this.d + ":" + this.b;
    }
}
