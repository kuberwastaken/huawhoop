package defpackage;

import com.huawei.hwcommonmodel.fitnessdatatype.DataTotalMotion;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetect;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lnu {
    private int b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<DataTotalMotion> f15340a = new ArrayList(16);
    private HeartRateDetect c = new HeartRateDetect();

    public int e() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public List<DataTotalMotion> d() {
        return this.f15340a;
    }

    public void c(HeartRateDetect heartRateDetect) {
        this.c = heartRateDetect;
    }
}
