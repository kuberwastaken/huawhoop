package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgi implements Serializable, TimeSequence {
    private static final long serialVersionUID = -2532163149055420122L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mTime")
    private long f15622a;

    @SerializedName("mSlope")
    private int b;

    public mgi() {
    }

    public mgi(long j, int i) {
        this.f15622a = j;
        this.b = i;
    }

    public int d() {
        return this.b;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.f15622a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof mgi) && ((mgi) obj).f15622a == this.f15622a;
    }
}
