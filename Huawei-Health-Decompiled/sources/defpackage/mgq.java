package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgq implements Serializable, TimeSequence {
    private static final long serialVersionUID = -1245764951606553008L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mSpo2")
    private int f15625a;

    @SerializedName("mTime")
    private long d;

    public mgq(long j, int i) {
        this.d = j;
        this.f15625a = i;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.d;
    }

    public int c() {
        return this.f15625a;
    }
}
